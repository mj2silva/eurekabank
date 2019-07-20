/*
Empresa        :  EurekaBank
Software       :  Sistema de Cuentas de Ahorro
DBMS           :  MySQL Server
Base de Datos  :  eurekabank
Script         :  Crea la Base de Datos
*/

-- =============================================
-- Creación de la Base de Datos
-- =============================================

CREATE DATABASE IF NOT EXISTS eurekabank;


-- =============================================
-- Seleccionar la Base de Datos
-- =============================================

USE eurekabank;


-- =============================================
-- Eliminar las tablas en caso existan
-- =============================================

DROP TABLE IF EXISTS asignado;
DROP TABLE IF EXISTS contador;
DROP TABLE IF EXISTS parametro;
DROP TABLE IF EXISTS movimiento;
DROP TABLE IF EXISTS tipomovimiento;
DROP TABLE IF EXISTS cuenta;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS empleado;
DROP TABLE IF EXISTS sucursal;
DROP TABLE IF EXISTS interesmensual;
DROP TABLE IF EXISTS costomovimiento;
DROP TABLE IF EXISTS cargomantenimiento;
DROP TABLE IF EXISTS moneda;
DROP TABLE IF EXISTS usuario;

DROP procedure if exists sp_insertarEmpleado;
DROP procedure if exists sp_insertarAdmin;
DROP procedure if exists sp_insertarCliente;


-- =============================================
-- Creación de los Objetos de la Base de Datos
-- =============================================

CREATE TABLE TipoMovimiento (
	tipocodigo       INTEGER AUTO_INCREMENT,
	tipodescripcion  VARCHAR(40) NOT NULL,
	tipoaccion       VARCHAR(10) NOT NULL,
	tipoestado       VARCHAR(15) DEFAULT 'ACTIVO' NOT NULL,
	CONSTRAINT PK_TipoMovimiento 
		PRIMARY KEY (tipocodigo),
	CONSTRAINT tipomovimiento_tipoaccion
		CHECK (tipoaccion IN ('INGRESO', 'SALIDA')),
	CONSTRAINT tipomovimiento_tipoestado
		CHECK (tipoestado IN ('ACTIVO', 'ANULADO', 'CANCELADO'))						
) ENGINE = INNODB ;

CREATE TABLE Sucursal (
	sucucodigo       INTEGER AUTO_INCREMENT,
	sucunombre       VARCHAR(50) NOT NULL,
	sucuciudad       VARCHAR(30) NOT NULL,
	sucudireccion    VARCHAR(50) NULL,
	sucucontcuenta   INTEGER NOT NULL,
	CONSTRAINT PK_Sucursal 
		PRIMARY KEY (sucucodigo)
) ENGINE = INNODB ;

CREATE TABLE Usuario (
	usuaId 			INTEGER AUTO_INCREMENT,
    usuaLogin 		varchar(100) not null,
    usuaPassword 	varchar(60) not null,
    usuaTipo		char(10) not null,
    CONSTRAINT chk_usuaTipo
		CHECK (usuaTipo IN ('cliente', 'empleado', 'administrador')),
	CONSTRAINT PK_Usuario
		PRIMARY KEY (usuaId),
	CONSTRAINT U_Usuario_usuaLogin
		UNIQUE (usuaLogin)
) ENGINE = INNODB ;

CREATE TABLE Empleado (
	emplcodigo       INTEGER AUTO_INCREMENT,
	emplpaterno      VARCHAR(25) NOT NULL,
	emplmaterno      VARCHAR(25) NOT NULL,
	emplnombre       VARCHAR(30) NOT NULL,
	emplciudad       VARCHAR(30) NOT NULL,
	empldireccion    VARCHAR(50),
	emplEmail		 VARCHAR(100) NOT NULL,
	usuaId			 INTEGER,
	CONSTRAINT PK_Empleado 
		PRIMARY KEY (emplcodigo),
	CONSTRAINT fk_empleado_usuario
		FOREIGN KEY (usuaId)
        REFERENCES usuario(usuaId)
        ON UPDATE RESTRICT
        ON DELETE RESTRICT,
	CONSTRAINT U_emplEmail
		UNIQUE (emplEmail)
) ENGINE = INNODB ;

CREATE TABLE Asignado (
	asigcodigo       INTEGER AUTO_INCREMENT,
	sucucodigo       INTEGER NOT NULL,
	emplcodigo       INTEGER NOT NULL,
	asigfechaalta    DATE NOT NULL,
	asigfechabaja    DATE NULL,
	CONSTRAINT PK_Asignado 
		PRIMARY KEY (asigcodigo), 
	KEY idx_asignado01 (emplcodigo),
	CONSTRAINT fk_asignado_empleado
		FOREIGN KEY (emplcodigo)
		REFERENCES Empleado (emplcodigo)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT, 
	KEY idx_asignado02 (sucucodigo),
	CONSTRAINT fk_asignado_sucursal
		FOREIGN KEY (sucucodigo)
		REFERENCES Sucursal (sucucodigo)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT
) ENGINE = INNODB;

CREATE TABLE Cliente (
	cliecodigo       INTEGER AUTO_INCREMENT,
	cliepaterno      VARCHAR(25) NOT NULL,
	cliematerno      VARCHAR(25) NOT NULL,
	clienombre       VARCHAR(30) NOT NULL,
	cliedni          CHAR(8) NOT NULL,
	clieciudad       VARCHAR(30) NOT NULL,
	cliedireccion    VARCHAR(50) NOT NULL,
	clietelefono     VARCHAR(20) NULL,
	clieemail        VARCHAR(50) NULL,
    usuaId			 INTEGER,
	CONSTRAINT PK_Cliente 
		PRIMARY KEY (cliecodigo),
	CONSTRAINT fk_Cliente_usuario
			FOREIGN KEY (usuaId)
            REFERENCES Usuario (usuaId)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT,
	CONSTRAINT U_cliedni
		UNIQUE (cliedni)
) ENGINE = INNODB ;

CREATE TABLE Moneda (
	monecodigo       INTEGER AUTO_INCREMENT,
	monedescripcion  VARCHAR(20) NOT NULL,
	CONSTRAINT PK_Moneda 
		PRIMARY KEY (monecodigo)
) ENGINE = INNODB ;

CREATE TABLE Cuenta (
	cuencodigo       CHAR(8) NOT NULL,
	monecodigo       INTEGER NOT NULL,
	sucucodigo       INTEGER NOT NULL,
	emplcreacuenta   INTEGER NOT NULL,
	cliecodigo       INTEGER,
	cuensaldo        DECIMAL(12,2) NOT NULL,
	cuenfechacreacion DATE NOT NULL,
	cuenestado       VARCHAR(15) DEFAULT 'ACTIVO' NOT NULL,
	cuencontmov      INTEGER NOT NULL,
	cuenclave        CHAR(6) NOT NULL,
	CONSTRAINT cuenta_cuenestado
		CHECK (cuenestado IN ('ACTIVO', 'ANULADO', 'CANCELADO')),
	CONSTRAINT PK_Cuenta 
		PRIMARY KEY (cuencodigo), 
	KEY idx_cuenta01 (cliecodigo),
	CONSTRAINT fk_cuenta_cliente
		FOREIGN KEY (cliecodigo)
		REFERENCES Cliente (cliecodigo)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT, 
	KEY idx_cuenta02 (emplcreacuenta),
	CONSTRAINT fk_cuente_empleado
		FOREIGN KEY (emplcreacuenta)
		REFERENCES Empleado (emplcodigo)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT, 
	KEY idx_cuenta03 (sucucodigo),
	CONSTRAINT fk_cuenta_sucursal
		FOREIGN KEY (sucucodigo)
		REFERENCES Sucursal (sucucodigo)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT, 
	KEY idx_cuenta04 (monecodigo),
	CONSTRAINT fk_cuenta_moneda
		FOREIGN KEY (monecodigo)
		REFERENCES Moneda (monecodigo)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT
) ENGINE = INNODB ;

CREATE TABLE Movimiento (
	cuencodigo       CHAR(8) NOT NULL,
	movinumero       INTEGER NOT NULL,
	movifecha        DATE NOT NULL,
	emplcodigo       INTEGER NOT NULL,
	tipocodigo       INTEGER NOT NULL,
	moviimporte      DECIMAL(12,2) NOT NULL,
	cuenreferencia   CHAR(8) NULL,
	CONSTRAINT Movimiento_importe4
		CHECK (moviimporte >= 0.0),		 
	CONSTRAINT PK_Movimiento 
		PRIMARY KEY (cuencodigo, movinumero), 
	KEY idx_movimiento01 (tipocodigo),
	CONSTRAINT fk_movimiento_tipomovimiento
		FOREIGN KEY (tipocodigo)
		REFERENCES TipoMovimiento (tipocodigo)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT,
	KEY idx_movimiento02 (emplcodigo),
	CONSTRAINT fk_movimiento_empleado
		FOREIGN KEY (emplcodigo)
		REFERENCES Empleado (emplcodigo)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT, 
	KEY idx_movimiento03 (cuencodigo),
	CONSTRAINT fk_movimiento_cuenta
		FOREIGN KEY (cuencodigo)
		REFERENCES Cuenta (cuencodigo)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT
) ENGINE = INNODB ;

CREATE TABLE Parametro (
	paracodigo       INTEGER AUTO_INCREMENT,
	paradescripcion  VARCHAR(50) NOT NULL,
	paravalor        VARCHAR(70) NOT NULL,
	paraestado       VARCHAR(15) DEFAULT 'ACTIVO' NOT NULL,
	CONSTRAINT parametro_paraestado
		CHECK (paraestado IN ('ACTIVO', 'ANULADO', 'CANCELADO')),
	CONSTRAINT PK_Parametro 
		PRIMARY KEY (paracodigo)
) ENGINE = INNODB ;

CREATE TABLE InteresMensual (
	monecodigo       INTEGER AUTO_INCREMENT,
	inteimporte      DECIMAL(12,2) NOT NULL,
	CONSTRAINT PK_InteresMensual 
		PRIMARY KEY (monecodigo), 
	KEY idx_interesmensual01 (monecodigo),
	CONSTRAINT fk_interesmensual_moneda
		FOREIGN KEY (monecodigo)
		REFERENCES Moneda (monecodigo)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT
) ENGINE = INNODB ;

CREATE TABLE CostoMovimiento (
	monecodigo       INTEGER NOT NULL,
	costimporte      DECIMAL(12,2) NOT NULL,
	CONSTRAINT PK_CostoMovimiento 
		PRIMARY KEY (monecodigo), 
	KEY idx_costomovimiento (monecodigo),
	CONSTRAINT fk_costomovimiento_moneda
		FOREIGN KEY (monecodigo)
		REFERENCES Moneda (monecodigo)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT
) ENGINE = INNODB ;

CREATE TABLE CargoMantenimiento (
	monecodigo       INTEGER NOT NULL,
	cargMontoMaximo  DECIMAL(12,2) NOT NULL,
	cargImporte      DECIMAL(12,2) NOT NULL,
	CONSTRAINT PK_CargoMantenimiento 
		PRIMARY KEY (monecodigo), 
	KEY idx_cargomantenimiento01 (monecodigo),
	CONSTRAINT fk_cargomantenimiento_moneda
		FOREIGN KEY (monecodigo)
		REFERENCES Moneda (monecodigo)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT
) ENGINE = INNODB ;

CREATE TABLE Contador (
	conttabla        VARCHAR(30) NOT NULL,
	contitem         INTEGER NOT NULL,
	contlongitud     INTEGER NOT NULL,
	CONSTRAINT PK_Contador 
		PRIMARY KEY (conttabla)
) ENGINE = INNODB ;

-- PROCEDIMIENTOS DE INSERCIÓN

DELIMITER //

CREATE PROCEDURE sp_insertarEmpleado(paterno varchar(25), materno varchar(25), nombre varchar(30), ciudad varchar(30), direccion varchar(50), email varchar(100))
BEGIN
	INSERT INTO empleado(emplpaterno, emplmaterno, emplnombre, emplciudad, empldireccion, emplemail) VALUES (paterno, materno, nombre, ciudad, direccion, email);
	INSERT INTO usuario (usuaLogin, usuaPassword, usuaTipo) values (email, '12345', 'empleado');
END;
//

DELIMITER //
CREATE PROCEDURE sp_insertarAdmin(paterno varchar(25), materno varchar(25), nombre varchar(30), ciudad varchar(30), direccion varchar(50), email varchar(100))
BEGIN
	INSERT INTO empleado(emplpaterno, emplmaterno, emplnombre, emplciudad, empldireccion, emplemail) VALUES (paterno, materno, nombre, ciudad, direccion, email);
	INSERT INTO usuario (usuaLogin, usuaPassword, usuaTipo) values (email, '12345', 'admin');
END;
//

DELIMITER //
CREATE PROCEDURE sp_insertarCliente(paterno varchar(25), materno varchar(25), nombre varchar(30), dni varchar(100), ciudad varchar(30), direccion varchar(50), telefono varchar(20), email varchar(100))
BEGIN
	INSERT INTO cliente(cliepaterno, cliematerno, clienombre, cliedni, clieciudad, cliedireccion, clietelefono, clieemail) VALUES (paterno, materno, nombre, dni, ciudad, direccion, telefono, email);
	INSERT INTO usuario (usuaLogin, usuaPassword, usuaTipo) values (dni, dni, 'cliente');
END;
//

DROP trigger IF EXISTS tr_updateusuariosid;
DELIMITER //
CREATE TRIGGER tr_updateusuariosid AFTER INSERT ON usuario
	FOR EACH ROW
    BEGIN
		DECLARE tipoUsuario char(10);
        DECLARE DNI char(8);
        SET tipoUsuario = NEW.usuaTipo;
        
        IF tipoUsuario = 'cliente' THEN
			UPDATE cliente 
				SET usuaId = NEW.usuaId 
			WHERE
				cliedni = NEW.usuaLogin;
        END IF;
        
        IF tipoUsuario = 'empleado' OR tipoUsuario = 'administrador' THEN
            UPDATE empleado 
				SET usuaId = NEW.usuaId 
            WHERE 
				emplEmail = NEW.usuaLogin;
		END IF;
    END;
    

//