-- procedimientos almacenados

-- funcion que devuelve el administrador de una sucursal (se le pasa por parámetro el código de la sucursal

delimiter //
create function fn_getidadministrador(sucursal integer)
	returns integer
begin
	declare admincodigo integer;
    
	select 
		e.emplcodigo
	into 
		admincodigo
    from 
		empleado e join asignado a
        on e.emplcodigo = a.emplcodigo
        join sucursal s 
        on a.sucucodigo = s.sucucodigo 
        join usuario u
        on u.usuaid = e.usuaid
	where 
		u.usuatipo = 'admin' and s.sucucodigo = sucursal;
        
	return admincodigo;
end;
// -- implemented

delimiter //
create function fn_administradordelempleado(emplcodigo integer)
	returns integer
begin
	declare admincodigo integer;
    declare sucucodigo integer;
    
    select s.sucucodigo
    into sucucodigo
    from sucursal s
    join asignado a
    on s.sucucodigo = a.sucucodigo
    join empleado e
    on a.emplcodigo = e.emplcodigo
    where e.emplcodigo = emplcodigo;
    
	set admincodigo = fn_getidadministrador(sucucodigo);
    
    return admincodigo;
end;
// -- implemented

-- función que cuenta el número de movimientos de una cuenta, se le pasa el numero de cuenta por parámetro
delimiter //
create function fn_numerodemovimientosdelacuenta(cuencodigo char(8))
	returns integer
begin
	declare nromovimientos integer;
    
	select count(cuencodigo)
    into nromovimientos
    from movimiento m
    where 
		m.cuencodigo = cuencodigo and (m.tipocodigo = 3 or m.tipocodigo = 4 or m.tipocodigo = 9)
    group by cuencodigo;
    
	return nromovimientos;
end;
// -- implemented

delimiter //
create function fn_obtenersaldodecuenta(cuencodigo char(8))
	returns decimal
begin
	declare saldocuenta integer;
    
    select c.cuensaldo
    into saldocuenta
    from cuenta c 
    where c.cuencodigo = cuencodigo;
    
    return saldocuenta;
end;
// -- implemented

-- calcula el cargo a cobrar en una cuenta
delimiter //
create function fn_calcularcargo(cuencodigo char(8))
	returns decimal
begin
	declare cargo decimal;
    declare nromovimientos integer;
    declare maxtransacciones integer;
    declare monecodigo integer;
    
    set cargo = 0;
    set nromovimientos = fn_numerodemovimientosdelacuenta(cuencodigo);
    set maxtransacciones = fn_obtenertransaccionesmax();
	
    if nromovimientos > maxtransacciones then
		select c.monecodigo
        into monecodigo
		from cuenta c
		where c.cuencodigo = cuencodigo;
			
		select cm.costoimporte
		into cargo
		from costomovimiento cm
		join moneda m
		on cm.monecodigo = m.monecodigo
		where m.monecodigo = monecodigo;
        
    end if;
    
    return cargo;
end;
// -- implemented

delimiter //
create function fn_obteneritf()
	returns decimal
begin
	declare itf decimal;
    
    select convert(paravalor, decimal(6,2))
    into itf
    from parametro
    where paracodigo = 1;
    
    return itf;
end;
// -- implemented

delimiter //
create function fn_obtenertransaccionesmax()
	returns integer
begin
	declare maxtransacciones integer;
    
	select convert(paravalor, unsigned)
    into maxtransacciones
    from parametro
    where paracodigo = 2;
    
    return maxtransacciones;
end;
// -- implemented

delimiter //
create procedure sp_nuevomovimento(cuencodigo char(8))
begin
	declare cuentamovimientos integer;
    
	select c.cuencontmov
    into cuentamovimientos
    from cuenta c
    where c.cuencodigo = cuencodigo;
    
    set cuentamovimientos = cuentamovimientos + 1;
    update cuenta c set cuencontmov = cuentamovimientos
    where c.cuencodigo = cuencodigo;
    
end;
// -- implemented

-- deposito en cuenta propia --considera convertir a procedimiento almacenado (dos movimientos, uno de entrada y otro de salida de dinero)
delimiter //
create procedure sp_transaccionbancaria(cuentaorigen char(8), cuentadestino char(8), emplcodigo integer, importe decimal)
begin
    declare cargo decimal;
    declare saldoorigen decimal;
    declare saldodestino decimal;
    declare fechahoy date;
    declare admincodigo integer;
    declare montoitf decimal;
    
    set cargo = fn_calcularcargo(cuentaorigen);
    set saldoorigen = fn_obtenersaldodecuenta(cuentaorigen);
    set saldodestino = fn_obtenersaldodecuenta(cuentadestino);
    set fechahoy = now();
    set admincodigo = fn_administradordelempleado(emplcodigo);
    set montoitf = importe * fn_obteneritf();
    
    start transaction;
    
    insert into movimiento(cuencodigo, movifecha, emplcodigo, tipocodigo, moviimporte, cuenreferencia)
    values (cuentaorigen, fechahoy, emplcodigo, 9, importe, cuentadestino);
    
    call sp_nuevomovimento(cuentaorigen);
    
    insert into movimiento(cuencodigo, movifecha, emplcodigo, tipocodigo, moviimporte, cuenreferencia)
    values (cuentadestino, fechahoy, emplcodigo, 8, importe - montoitf, cuentaorigen); -- a la cuenta destino llega solo el 99.92% del importe enviado
    
    insert into movimiento(cuencodigo, movifecha, emplcodigo, tipocodigo, moviimporte, cuenreferencia)
    values (cuentaorigen, fechahoy, admincodigo, 10, cargo, null);
    
    insert into movimiento(cuencodigo, movifecha, emplcodigo, tipocodigo, moviimporte, cuenreferencia)
    values (cuentaorigen, fechahoy, admincodigo, 7, montoitf, null);
    
    update cuenta set cuensaldo = saldoorigen - importe - cargo where cuencodigo = cuentaorigen;
    update cuenta set cuensaldo = saldoorigen + importe - montoitf where cuencodigo = cuentadestino;
    
    if saldoorigen - importe - cargo < 0 then
		rollback;
    else
		commit;
	end if;
	
    commit;
end;
// -- implemented

delimiter //
create procedure sp_deposito(cuentadestino char(8), importe decimal, emplcodigo integer)
begin
	declare cargo decimal;
    declare saldoinicial decimal;
    declare admincodigo integer;
    declare fechahoy date;
    
    set fechahoy = now();
    set cargo = fn_calcularcargo(cuentadestino);
    set admincodigo = fn_administradordelempleado(emplcodigo);
    set saldoinicial = fn_obtenersaldodecuenta(cuentadestino);
    
    start transaction;
    
    insert into movimiento(cuencodigo, movifecha, emplcodigo, tipocodigo, moviimporte, cuenreferencia)
    values (cuentadestino, fechahoy, emplcodigo, 3, importe, null);
    call sp_nuevomovimento(cuentadestino);
    
    if cargo > 0 then
		insert into movimiento(cuencodigo, movifecha, emplcodigo, tipocodigo, moviimporte, cuenreferencia)
		values (cuentadestino, fechahoy, admincodigo, 10, cargo, null);
	end if;
    
    update cuenta set cuensaldo = saldoinicial + importe - cargo where cuencodigo = cuentadestino;
    
    if saldoinicial + importe - cargo < 0 then
		rollback;
    else
		commit;
	end if;
end;
// -- implemented

-- retiro
delimiter //
create procedure sp_retiro(cuentaorigen char(8), importe decimal, emplcodigo integer)
begin
	declare cargo decimal;
    declare saldoinicial decimal;
    declare admincodigo integer;
    declare fechahoy date;
    
    set fechahoy = now();
    set cargo = fn_calcularcargo(cuentaorigen);
    set admincodigo = fn_administradordelempleado(emplcodigo);
    set saldoinicial = fn_obtenersaldocuenta(cuentaorigen);
    
    start transaction;
    
    insert into movimiento(cuencodigo, movifecha, emplcodigo, tipocodigo, moviimporte, cuenreferencia)
    values (cuentaorigen, fechahoy, emplcodigo, 4, importe, null);
    call sp_nuevomovimiento(cuentaorigen);
    
    insert into movimiento(cuencodigo, movifecha, emplcodigo, tipocodigo, moviimporte, cuenreferencia)
    values (cuentaorigen, fechahoy, admincodigo, 10, cargo, null);
    
    update cuenta set cuensaldo = saldoinicial - importe - cargo where cuencodigo = cuentaorigen;
    
    if saldoinicial - importe - cargo < 0 then
		rollback;
    else
		commit;
	end if;
end;
// -- implemented

-- consultar cuenta
delimiter //
create procedure sp_cuentacliente(cliecodigo integer)
begin
	select cuencodigo, monedescripcion, cuensaldo, cuenestado, cuenfechacreacion, cuencontmov
    from cuenta c
    join moneda m
    on c.monecodigo = m.monecodigo
    where c.cliecodigo = cliecodigo;
end;
// -- implemented

-- historial de movimientos
delimiter //
create procedure sp_historialdemovimientos(cuencodigo char(8))
begin
	select cuencodigo, movifecha, tipodescripcion, moviimporte, cuenreferencia 
    from movimiento m join
	tipomovimiento tm
    on m.tipocodigo = tm.tipocodigo
	where m.cuencodigo = cuencodigo;
end;
// -- implemented

-- nueva cuenta
delimiter //
create procedure sp_nuevacuenta(cuencodigo char(8), cliecodigo integer, monedescripcion varchar(20), emplcodigo integer, importe decimal)
begin
	declare sucucodigo integer;
    declare fechahoy date;
    declare monecodigo integer;
    
    select m.monecodigo
    into monecodigo
    from moneda m
    where m.monedescripcion = monedescripcion;
    
    set fechahoy = now();
    select s.sucucodigo
    into sucucodigo
    from empleado e
    join asignado a
    on e.emplcodigo = a.emplcodigo
    join sucursal s on 
    a.sucucodigo = s.sucucodigo
    where e.emplcodigo = emplcodigo;
    
	insert into cuenta values (cuencodigo, monecodigo, sucucodigo, emplcodigo, cliecodigo, importe, fechahoy, 'ACTIVO', 0, '123456');
    insert into movimiento(cuencodigo, movifecha, emplcodigo, tipocodigo, moviimporte, cuenreferencia) values (cuencodigo, fechahoy, emplcodigo, 1, importe, null);
end;
// -- implemented

-- buscar cliente
delimiter //
create procedure sp_buscarcliente(str varchar(50))
begin
	declare pattern varchar(52);
    set pattern = concat('%', str, '%');
	select * from cliente 
    where 
		cliepaterno like pattern or cliematerno like pattern or clienombre like pattern or
        cliedni like pattern;
end;
// -- implemented
-- eliminar cliente
delimiter //
create procedure sp_eliminarcliente(codigo integer)
begin
	delete from cliente where cliecodigo = codigo;
end;
// -- implemented

delimiter //
create function fn_verificarusuario(login varchar(100), upassword varchar(60))
	returns boolean
begin -- implemented
	declare flaglogin boolean;
    declare flagpassword boolean;
    declare loginencontrado varchar(100);
    declare passwordencontrado varchar(60);
    
    set flaglogin = false;
    set flagpassword = false;
    
    select usualogin, usuapassword 
    into loginencontrado, passwordencontrado
    from usuario 
    where usualogin = login;
    
    if loginencontrado is not null then
		set flaglogin = 1;
        if passwordencontrado = upassword then
			set flagpassword = 1;
		end if;
	end if;
    
    return flaglogin and flagpassword;
end;
//

delimiter //
create procedure sp_obtenerTipo(login varchar(100))
begin
	select usuatipo from usuario where login = login;
end;
//
alter table sucursal
drop column sucucontcuenta;

delimiter //
create procedure sp_obtenerusuario(login varchar(100), upassword varchar(60))
begin
	select * from usuario where usualogin = login and usuapassword = upassword;
end;
// -- implemented



