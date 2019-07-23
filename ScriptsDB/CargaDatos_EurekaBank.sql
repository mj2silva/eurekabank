/*
Empresa        :  EurekaBank
Software       :  Sistema de Cuentas de Ahorro
DBMS           :  MySQL Server
Base de Datos  :  eurekabank
Script         :  Inserta datos en las tablas de la Base de Datos
*/


-- =============================================
-- Seleccionar la Base de Datos
-- =============================================
use eurekabank;

-- =============================================
-- Cargar Datos de Prueba
-- =============================================

-- Tabla: Moneda

insert into moneda (monedescripcion) values ( 'Soles' );
insert into moneda (monedescripcion) values ( 'Dolares' );

-- Tabla: CargoMantenimiento

insert into cargomantenimiento values (1, 3500.00, 7.00 );
insert into cargomantenimiento values (2, 1200.00, 2.50 );

-- Tabla: CargoMovimiento

insert into CostoMovimiento values (1, 2.00 );
insert into CostoMovimiento values (2, 0.60 );

-- Tabla: InteresMensual

insert into InteresMensual values (1, 0.70 );
insert into InteresMensual values (2, 0.60 );

-- Tabla: TipoMovimiento

insert into TipoMovimiento(tipodescripcion, tipoaccion, tipoestado) values( 'Apertura de Cuenta', 'INGRESO', 'ACTIVO' );
insert into TipoMovimiento(tipodescripcion, tipoaccion, tipoestado) values( 'Cancelar Cuenta', 'SALIDA', 'ACTIVO' );
insert into TipoMovimiento(tipodescripcion, tipoaccion, tipoestado) values( 'Deposito', 'INGRESO', 'ACTIVO' );
insert into TipoMovimiento(tipodescripcion, tipoaccion, tipoestado) values( 'Retiro', 'SALIDA', 'ACTIVO' );
insert into TipoMovimiento(tipodescripcion, tipoaccion, tipoestado) values( 'Interes', 'INGRESO', 'ACTIVO' );
insert into TipoMovimiento(tipodescripcion, tipoaccion, tipoestado) values( 'Mantenimiento', 'SALIDA', 'ACTIVO' );
insert into TipoMovimiento(tipodescripcion, tipoaccion, tipoestado) values( 'ITF', 'SALIDA', 'ACTIVO' );
insert into TipoMovimiento(tipodescripcion, tipoaccion, tipoestado) values( 'Transferencia', 'INGRESO', 'ACTIVO' );
insert into TipoMovimiento(tipodescripcion, tipoaccion, tipoestado) values( 'Transferencia', 'SALIDA', 'ACTIVO' );
insert into TipoMovimiento(tipodescripcion, tipoaccion, tipoestado) values( 'Cargo por Movimiento', 'SALIDA', 'ACTIVO' );

-- Tabla: Sucursal

insert into sucursal(sucunombre, sucuciudad, sucudireccion, sucucontcuenta) values( 'Sipan', 'Chiclayo', 'Av. Balta 1456', 2 );
insert into sucursal(sucunombre, sucuciudad, sucudireccion, sucucontcuenta) values( 'Chan Chan', 'Trujillo', 'Jr. Independencia 456', 3 );
insert into sucursal(sucunombre, sucuciudad, sucudireccion, sucucontcuenta) values( 'Los Olivos', 'Lima', 'Av. Central 1234', 0 );
insert into sucursal(sucunombre, sucuciudad, sucudireccion, sucucontcuenta) values( 'Pardo', 'Lima', 'Av. Pardo 345 - Miraflores', 0 );
insert into sucursal(sucunombre, sucuciudad, sucudireccion, sucucontcuenta) values( 'Misti', 'Arequipa', 'Bolivar 546', 0 );
insert into sucursal(sucunombre, sucuciudad, sucudireccion, sucucontcuenta) values( 'Machupicchu', 'Cusco', 'Calle El Sol 534', 0 );
insert into sucursal(sucunombre, sucuciudad, sucudireccion, sucucontcuenta) values( 'Grau', 'Piura', 'Av. Grau 1528', 0 );


-- Tabla: Empleado

CALL sp_insertarempleado ('Romero', 'Castillo', 'Carlos Alberto', 'Trujillo', 'Call1 1 Nro. 456', 'ccastillo@eurekabank.com' );
CALL sp_insertarempleado ('Castro', 'Vargas', 'Lidia', 'Lima', 'Federico Villarreal 456 - SMP', 'lcastro@eurekabank.com');
CALL sp_insertarempleado ('Reyes', 'Ortiz', 'Claudia', 'Lima', 'Av. Aviacion 3456 - San Borja', 'creyes@eurekabank.com' );
CALL sp_insertarempleado ('Ramos', 'Garibay', 'Angelica', 'Chiclayo', 'Calle Barcelona 345', 'aramos@eurekabank.com' );
CALL sp_insertarempleado ('Ruiz', 'Zabaleta', 'Claudia', 'Cusco', 'Calle Cruz Verde 364', 'cruiz@eurekabank.com' );
CALL sp_insertarempleado ('Cruz', 'Tarazona', 'Ricardo', 'Areguipa', 'Calle La Gruta 304', 'rcruz@eurekabank.com');
CALL sp_insertarempleado ('Diaz', 'Flores', 'Edith', 'Lima', 'Av. Pardo 546', 'ediaz@eurekabank.com' );
CALL sp_insertarempleado ('Sarmiento', 'Bellido', 'Claudia Rocio', 'Areguipa', 'Calle Alfonso Ugarte 1567', 'csarmiento@eurekabank.com' );
CALL sp_insertarempleado ('Pachas', 'Sifuentes', 'Luis Alberto', 'Trujillo', 'Francisco Pizarro 1263', 'lpachas@eurekabank.com' );
CALL sp_insertarempleado ('Tello', 'Alarcon', 'Hugo Valentin', 'Cusco', 'Los Angeles 865', 'htello@eurekabank.com'  );
CALL sp_insertarempleado ('Carrasco', 'Vargas', 'Pedro Hugo', 'Chiclayo', 'Av. Balta 1265', 'pcarrasco@eurekabank.com' );

-- Asignado

insert into Asignado (sucucodigo, emplcodigo, asigfechaalta, asigfechabaja) values( 1,  04, '20071115', null );
insert into Asignado (sucucodigo, emplcodigo, asigfechaalta, asigfechabaja) values( 2,  01, '20071120', null );
insert into Asignado (sucucodigo, emplcodigo, asigfechaalta, asigfechabaja) values( 3,  02, '20071128', null );
insert into Asignado (sucucodigo, emplcodigo, asigfechaalta, asigfechabaja) values( 4,  03, '20071212', '20080325' );
insert into Asignado (sucucodigo, emplcodigo, asigfechaalta, asigfechabaja) values( 5,  06, '20071220', null );
insert into Asignado (sucucodigo, emplcodigo, asigfechaalta, asigfechabaja) values( 6,  05, '20080105', null );
insert into Asignado (sucucodigo, emplcodigo, asigfechaalta, asigfechabaja) values( 4,  07, '20080107', null );
insert into Asignado (sucucodigo, emplcodigo, asigfechaalta, asigfechabaja) values( 5,  08, '20080107', null );
insert into Asignado (sucucodigo, emplcodigo, asigfechaalta, asigfechabaja) values( 1,  11, '20080108', null );
insert into Asignado (sucucodigo, emplcodigo, asigfechaalta, asigfechabaja) values( 2,  09, '20080108', null );
insert into Asignado (sucucodigo, emplcodigo, asigfechaalta, asigfechabaja) values( 6,  10, '20080108', null );

-- Tabla: Parametro

insert into Parametro values( '001', 'ITF - Impuesto a la Transacciones Financieras', '0.08', 'ACTIVO' );
insert into Parametro values( '002', 'Numero de Operaciones Sin Costo', '15', 'ACTIVO' );

-- Tabla: Cliente

CALL sp_insertarcliente('VALENCIA', 'MORALES', 'PEDRO HUGO', '01576173', 'LIMA', 'MAGDALENA', '924-7834', 'pvalencia@terra.com.pe' );
CALL sp_insertarcliente('MARCELO', 'VILLALOBOS', 'RICARDO', '10762367', 'LIMA', 'LINCE', '993-62966', 'ricardomarcelo@hotmail.com' );
CALL sp_insertarcliente('CORONEL', 'CASTILLO', 'ERIC GUSTAVO', '06914897', 'LIMA', 'LOS OLIVOS', '9666-4457', 'gcoronel@viabcp.com' );
CALL sp_insertarcliente('ROMERO', 'CASTILLO', 'CARLOS ALBERTO', '06531983', 'LIMA', 'LOS OLIVOS', '865-84762', 'c.romero@hotmail.com' );
CALL sp_insertarcliente('ARANDA', 'LUNA', 'ALAN ALBERTO', '10875611', 'LIMA', 'SAN ISIDRO', '834-67125', 'a.aranda@hotmail.com' );
CALL sp_insertarcliente('AYALA', 'PAZ', 'JORGE LUIS', '10679245', 'LIMA', 'SAN BORJA', '963-34769', 'j.ayala@yahoo.com' );
CALL sp_insertarcliente('CHAVEZ', 'CANALES', 'EDGAR RAFAEL', '10145693', 'LIMA', 'MIRAFLORES', '999-96673', 'e.chavez@gmail.com' );
CALL sp_insertarcliente('FLORES', 'CHAFLOQUE', 'ROSA LIZET', '10773456', 'LIMA', 'LA MOLINA', '966-87567', 'r.florez@hotmail.com' );
CALL sp_insertarcliente('FLORES', 'CASTILLO', 'CRISTIAN RAFAEL', '10346723', 'LIMA', 'LOS OLIVOS', '978-43768', 'c.flores@hotmail.com' );
CALL sp_insertarcliente('GONZALES', 'GARCIA', 'GABRIEL ALEJANDRO', '10192376', 'LIMA', 'SAN MIGUEL', '945-56782', 'g.gonzales@yahoo.es' );
CALL sp_insertarcliente('LAY', 'VALLEJOS', 'JUAN CARLOS', '10942287', 'LIMA', 'LINCE', '956-12657', 'j.lay@peru.com' );
CALL sp_insertarcliente('MONTALVO', 'SOTO', 'DEYSI LIDIA', '10612376', 'LIMA', 'SURCO', '965-67235', 'd.montalvo@hotmail.com' );
CALL sp_insertarcliente('RICALDE', 'RAMIREZ', 'ROSARIO ESMERALDA', '10761324', 'LIMA', 'MIRAFLORES', '991-23546', 'r.ricalde@gmail.com' );
CALL sp_insertarcliente('RODRIGUEZ', 'FLORES', 'ENRIQUE MANUEL', '10773345', 'LIMA', 'LINCE', '976-82838', 'e.rodriguez@gmail.com' );
CALL sp_insertarcliente('ROJAS', 'OSCANOA', 'FELIX NINO', '10238943', 'LIMA', 'LIMA', '962-32158', 'f.rojas@yahoo.com' );
CALL sp_insertarcliente('TEJADA', 'DEL AGUILA', 'TANIA LORENA', '10446791', 'LIMA', 'PUEBLO LIBRE', '966-23854', 't.tejada@hotmail.com' );
CALL sp_insertarcliente('VALDEVIESO', 'LEYVA', 'LIDIA ROXANA', '10452682', 'LIMA', 'SURCO', '956-78951', 'r.valdivieso@terra.com.pe' );
CALL sp_insertarcliente('VALENTIN', 'COTRINA', 'JUAN DIEGO', '10398247', 'LIMA', 'LA MOLINA', '921-12456', 'j.valentin@terra.com.pe' );
CALL sp_insertarcliente('YAURICASA', 'BAUTISTA', 'YESABETH', '10934584', 'LIMA', 'MAGDALENA', '977-75777', 'y.yauricasa@terra.com.pe' );
CALL sp_insertarcliente('ZEGARRA', 'GARCIA', 'FERNANDO MOISES', '10772365', 'LIMA', 'SAN ISIDRO', '936-45876', 'f.zegarra@hotmail.com' );

-- Tabla: Cuenta
insert into cuenta values('00200001',01,002,0001,00008,7000,'20080105','ACTIVO',15,'123456');
insert into cuenta values('00200002',01,002,0001,00001,6800,'20080109','ACTIVO',3,'123456');
insert into cuenta values('00200003',02,002,0001,00007,6000,'20080111','ACTIVO',6,'123456');
insert into cuenta values('00100001',01,001,0004,00005,6900,'20080106','ACTIVO',7,'123456');
insert into cuenta values('00100002',02,001,0004,00005,4500,'20080108','ACTIVO',4,'123456');

-- Tabla: Movimiento
insert into movimiento values('00100002',01,'20080108',0004,001,1800,null);
insert into movimiento values('00100002',02,'20080125',0004,004,1000,null);
insert into movimiento values('00100002',03,'20080213',0004,003,2200,null);
insert into movimiento values('00100002',04,'20080308',0004,003,1500,null);

insert into movimiento values('00100001',01,'20080106',0004,001,2800,null);
insert into movimiento values('00100001',02,'20080115',0004,003,3200,null);
insert into movimiento values('00100001',03,'20080120',0004,004,0800,null);
insert into movimiento values('00100001',04,'20080214',0004,003,2000,null);
insert into movimiento values('00100001',05,'20080225',0004,004,0500,null);
insert into movimiento values('00100001',06,'20080303',0004,004,0800,null);
insert into movimiento values('00100001',07,'20080315',0004,003,1000,null);

insert into movimiento values('00200003',01,'20080111',0001,001,2500,null);
insert into movimiento values('00200003',02,'20080117',0001,003,1500,null);
insert into movimiento values('00200003',03,'20080120',0001,004,0500,null);
insert into movimiento values('00200003',04,'20080209',0001,004,0500,null);
insert into movimiento values('00200003',05,'20080225',0001,003,3500,null);
insert into movimiento values('00200003',06,'20080311',0001,004,0500,null);

insert into movimiento values('00200002',01,'20080109',0001,001,3800,null);
insert into movimiento values('00200002',02,'20080120',0001,003,4200,null);
insert into movimiento values('00200002',03,'20080306',0001,004,1200,null);

insert into movimiento values('00200001',01,'20080105',0001,001,5000,null);
insert into movimiento values('00200001',02,'20080107',0001,003,4000,null);
insert into movimiento values('00200001',03,'20080109',0001,004,2000,null);
insert into movimiento values('00200001',04,'20080111',0001,003,1000,null);
insert into movimiento values('00200001',05,'20080113',0001,003,2000,null);
insert into movimiento values('00200001',06,'20080115',0001,004,4000,null);
insert into movimiento values('00200001',07,'20080119',0001,003,2000,null);
insert into movimiento values('00200001',08,'20080121',0001,004,3000,null);
insert into movimiento values('00200001',09,'20080123',0001,003,7000,null);
insert into movimiento values('00200001',10,'20080127',0001,004,1000,null);
insert into movimiento values('00200001',11,'20080130',0001,004,3000,null);
insert into movimiento values('00200001',12,'20080204',0001,003,2000,null);
insert into movimiento values('00200001',13,'20080208',0001,004,4000,null);
insert into movimiento values('00200001',14,'20080213',0001,003,2000,null);
insert into movimiento values('00200001',15,'20080219',0001,004,1000,null);

--  Tabla: Contador

insert into Contador Values( 'Moneda', 2, 2 );
insert into Contador Values( 'TipoMovimiento', 10, 3 );
insert into Contador Values( 'Sucursal', 7, 3 );
insert into Contador Values( 'Empleado', 11, 4 );
insert into Contador Values( 'Asignado', 11, 6 );
insert into Contador Values( 'Parametro', 2, 3 );
insert into Contador Values( 'Cliente', 21, 5 );

call sp_insertarAdmin('Silva', 'Guevara', 'Manuel', 'Trujillo', 'Trujillo', 'msilva@eurekabank', 1);
call sp_insertarAdmin('Serin', 'Nery', 'Eliasib', 'Trujillo', 'Trujillo', 'eserin@eurekabank', 2);
call sp_insertarAdmin('Reyes', 'Julca', 'Steven', 'Trujillo', 'Trujillo', 'sreyes@eurekabank', 3);
call sp_insertarAdmin('Zavaleta', 'Cortez', 'Jeyson', 'Trujillo', 'Trujillo', 'jzavaleta@eurekabank', 4);