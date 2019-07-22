-- procedimientos almacenados

-- crear una cuenta
delimiter //
create procedure sp_nuevacuenta(cuencodigo char(8), monecodigo integer, sucucodigo integer, emplcreacuenta integer, cliecodigo integer, cuensaldo decimal)
begin
	declare fechahoy date;
    set fechahoy = now();
	insert into 
		cuenta 
	values 
		(cuencodigo, monecodigo, sucucodigo, emplcreacuenta, cliecodigo, cuensaldo, fechahoy, 'ACTIVO', 0, '123456');
end
//

-- hacer transferencia

-- deposito en cuenta propia --considera convertir a procedimiento almacenado (dos movimientos, uno de entrada y otro de salida de dinero)
delimiter //
create procedure sp_depositoencuentapropia(cuentaorigen char(8), cuentadestino char(8), emplcodigo integer, tipocodigo integer, importe decimal)
begin
	insert into 
end
//

delimiter //
create trigger t_depositoencuentapropia
after insert on movimiento
for each row
begin
    select @nromovimientos = count(cuencodigo) 
    from movimiento 
    where cuencodigo = new.cuencodigo 
    group by cuencodigo;
    
    select @emplcodigo = e.emplcodigo
    from empleado e join
		asignado a
        on e.emplcodigo = a.emplcodigo
        join
		sucursal s 
        on a.sucucodigo = s.sucucodigo 
        join
        usuario u
        on u.usuaid = e.usuaid
        join cuenta c
        on c.sucucodigo = s.sucucodigo
        where u.usuatipo = 'admin' and
		c.cuencodigo = new.cuencodigo;
    
    select @monecodigo = c.monecodigo
    from cuenta c
    where c.cuencodigo = new.cuencodigo;
    
    select @cargo = cm.costoimporte
    from costomovimiento cm
    join moneda m
    on cm.monecodigo = m.monecodigo
    where m.monecodigo = @monecodigo;
    
    select @cuensaldoorigen = c.cuensaldo
    from cuenta c 
    where c.cuencodigo = new.cuencodigo;
    
    select @cuensaldodestino = c.cuensaldo
    from cuenta c
    where c.cuencodigo = new.cuenreferencia;
    
    start transaction;
    
    if @nromovimientos > 15 and new.tipocodigo = 9 then
		insert into movimiento(cuencodigo, movifecha, emplcodigo, tipocodigo, moviimporte, cuenreferencia)
        values (new.cuencodigo, now(), @emplcodigo, 10, @cargo, null);
	end if;
    
    update cuenta set cuensaldo = @cuesaldoorigen - new.moviimporte where cuencodigo = @cuensaldoorigen;
    update cuenta set cuensaldo = @cuesaldodestino + new.moviimporte where cuencodigo = @cuensaldodestino;
    
end
//

delimiter //
create procedure sp_depositoencuentapropia()
begin
	
end
//

-- deposito en ventanilla
delimiter //
create procedure sp_depositoencuentapropia()
begin

end
//

-- retiro
delimiter //
create procedure sp_depositoencuentapropia()
begin

end
//

-- consultar cuenta
delimiter //
create procedure sp_depositoencuentapropia()
begin

end
//

-- historial de movimientos
delimiter //
create procedure sp_depositoencuentapropia()
begin

end
//

-- agregar cliente
delimiter //
create procedure sp_depositoencuentapropia()
begin

end
//

-- modifcar cliente
delimiter //
create procedure sp_depositoencuentapropia()
begin

end
//

-- buscar cliente
delimiter //
create procedure sp_depositoencuentapropia()
begin

end
//

-- eliminar cliente
delimiter //
create procedure sp_depositoencuentapropia()
begin

end
//

-- consultar cuentas del cliente (numero de cuenta, moneda, estado, fecha de creación)
delimiter //
create procedure sp_depositoencuentapropia()
begin

end
//

-- detalle de las cuentas (numero de cuenta, numero de movimientos, historial de movimientos)
delimiter //
create procedure sp_depositoencuentapropia()
begin

end
//

-- historial de movimientos (tipo de movimiento, depósitos, retiros, intereses, cobros, etc.), monto
delimiter //
create procedure sp_depositoencuentapropia()
begin

end
//