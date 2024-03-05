/*
 Navicat Premium Data Transfer

 Source Server         : MSQL BENCH
 Source Server Type    : MySQL
 Source Server Version : 50744
 Source Host           : localhost:3306
 Source Schema         : empresatours

 Target Server Type    : MySQL
 Target Server Version : 50744
 File Encoding         : 65001

 Date: 05/03/2024 16:52:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for buses
-- ----------------------------
DROP TABLE IF EXISTS `buses`;
CREATE TABLE `buses`  (
  `idBus` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `marcaBus` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `modelo` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `placaBus` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `idConductor` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`idBus`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of buses
-- ----------------------------
INSERT INTO `buses` VALUES ('B0001', 'BMW', 'Tour', 'ASD123', 'CO001');
INSERT INTO `buses` VALUES ('B0002', 'Toyota', 'Bus', 'AAA111', 'CO002');
INSERT INTO `buses` VALUES ('B0003', 'Toyota', 'Bus', 'GJS334', 'CO003');
INSERT INTO `buses` VALUES ('B0004', 'Hyundai', 'Bus', 'ADH424', 'CO004');

-- ----------------------------
-- Table structure for clientes
-- ----------------------------
DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes`  (
  `idCliente` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `nomCliente` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `apeCliente` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `docIdentidad` int(11) NOT NULL,
  `direccion` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `telefono` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `correo` varchar(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `password` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `nacionalidad` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`idCliente`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clientes
-- ----------------------------
INSERT INTO `clientes` VALUES ('C0001', 'Facundo', 'Saravia', 45882144, 'Av Petit Thuoars 4256', '954224466', 'fsavedra@gmail.com', '123abc', 'Peruana');
INSERT INTO `clientes` VALUES ('C0002', 'Victor', 'Quiroz', 72260606, 'Av Petit Thuoars 4256', '953251822', 'vquiroz@ssnegocios.com', '123abc', 'Colombiana');
INSERT INTO `clientes` VALUES ('C0003', 'Diego', 'Fiestas', 49987054, 'Av Petit Thuoars 4256', '998877665', 'dfiestas@gmail.com', '123abc', 'Americana');
INSERT INTO `clientes` VALUES ('C0004', 'Carla', 'Jemima', 23455426, 'Av Petit Thuoars 4256', '987654321', 'cjemima@tours.com', '123abc', 'Argentina');

-- ----------------------------
-- Table structure for conductores
-- ----------------------------
DROP TABLE IF EXISTS `conductores`;
CREATE TABLE `conductores`  (
  `idConductor` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `nomConductor` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `docIdentidad` int(11) NOT NULL,
  `telefono` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `correo` varchar(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`idConductor`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of conductores
-- ----------------------------
INSERT INTO `conductores` VALUES ('CO001', 'Diego Torres Leon', 45124578, '985475154', 'dtorres@tours.com');
INSERT INTO `conductores` VALUES ('CO002', 'Jose Perez', 23524353, '985545444', 'jperez@tours.com');
INSERT INTO `conductores` VALUES ('CO003', 'Luis Gomez', 42154541, '996445123', 'lgomez@tours.com');
INSERT INTO `conductores` VALUES ('CO004', 'Pepito Perez', 23455426, '987654321', 'pperez@tours.com');

-- ----------------------------
-- Table structure for destinos
-- ----------------------------
DROP TABLE IF EXISTS `destinos`;
CREATE TABLE `destinos`  (
  `idDestino` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `destino` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `departamento` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `provincia` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`idDestino`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of destinos
-- ----------------------------
INSERT INTO `destinos` VALUES ('D0001', 'Caral', 'Lima', 'Barranca');
INSERT INTO `destinos` VALUES ('D0002', 'Huacachina', 'Ica', 'Ica');
INSERT INTO `destinos` VALUES ('D0003', 'Mancora', 'Piura', 'Mancora');
INSERT INTO `destinos` VALUES ('D0004', 'Ticlio', 'Lima', 'Chicla');

-- ----------------------------
-- Table structure for formapago
-- ----------------------------
DROP TABLE IF EXISTS `formapago`;
CREATE TABLE `formapago`  (
  `idfpago` varchar(2) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `descripcion` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`idfpago`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of formapago
-- ----------------------------
INSERT INTO `formapago` VALUES ('P1', 'Efectivo');
INSERT INTO `formapago` VALUES ('P2', 'Deposito');
INSERT INTO `formapago` VALUES ('P3', 'Tarjeta');
INSERT INTO `formapago` VALUES ('P4', 'Transferencia');

-- ----------------------------
-- Table structure for guias
-- ----------------------------
DROP TABLE IF EXISTS `guias`;
CREATE TABLE `guias`  (
  `idGuia` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `nomGuia` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `docIdentidad` int(11) NOT NULL,
  `telefono` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `correo` varchar(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `idioma` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`idGuia`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of guias
-- ----------------------------
INSERT INTO `guias` VALUES ('G0001', 'Juan Cavero', 44514565, '995457445', 'jcavero@tours.com', 'Ingles');
INSERT INTO `guias` VALUES ('G0002', 'Roberto Tito', 45112545, '997444125', 'rtito@tours.com', 'Ingles');
INSERT INTO `guias` VALUES ('G0003', 'Frank Rodriguez', 66454144, '954554125', 'frodriguez@tours.com', 'Ingles');
INSERT INTO `guias` VALUES ('G0004', 'Sebastian Lopez', 72245144, '987445131', 'slopez@tours.com', 'Ingles');

-- ----------------------------
-- Table structure for hoteles
-- ----------------------------
DROP TABLE IF EXISTS `hoteles`;
CREATE TABLE `hoteles`  (
  `idHotel` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `nomHotel` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `nEstrellas` int(11) DEFAULT NULL,
  `direccion` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `telefono` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `contacto` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`idHotel`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hoteles
-- ----------------------------
INSERT INTO `hoteles` VALUES ('H0001', 'Hotel Terrazas', 4, 'Huaral', '4557214', 'Juan');
INSERT INTO `hoteles` VALUES ('H0002', 'Hotel Huacachina Sunset', 3, 'Huacachina', '1225445', 'Ezequiel');
INSERT INTO `hoteles` VALUES ('H0003', 'Hotel El Sol', 3, 'Lima', '994577712', 'Jose Leon');
INSERT INTO `hoteles` VALUES ('H0004', 'Estancia Los Aguacates', 4, 'Piura', '964554211', 'Hans Loechle');

-- ----------------------------
-- Table structure for servicios
-- ----------------------------
DROP TABLE IF EXISTS `servicios`;
CREATE TABLE `servicios`  (
  `idServicio` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `idTour` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `idCliente` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `idfPago` varchar(2) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`idServicio`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of servicios
-- ----------------------------
INSERT INTO `servicios` VALUES ('S0001', 'T0001', 'C0001', 'P1');

-- ----------------------------
-- Table structure for tours
-- ----------------------------
DROP TABLE IF EXISTS `tours`;
CREATE TABLE `tours`  (
  `idTour` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `descripcion` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `idDestino` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `idBus` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `idGuia` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `idHotel` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `tarifa` decimal(10, 0) DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  PRIMARY KEY (`idTour`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tours
-- ----------------------------
INSERT INTO `tours` VALUES ('T0001', 'Tour Caral', 'D0001', 'B0001', 'G0001', 'H0001', 131, '2022-06-10', '2022-06-30');
INSERT INTO `tours` VALUES ('T0002', 'FEBRERO CON AMOR', 'D0003', 'B0003', 'G0003', 'H0003', 2500, '2024-02-26', '2024-02-29');

-- ----------------------------
-- Table structure for usuarios
-- ----------------------------
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios`  (
  `idUsuario` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `nomUsuario` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `apeUsuario` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `docIdentidad` int(11) NOT NULL,
  `telefono` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `correo` varchar(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `fecNacimiento` date DEFAULT NULL,
  `password` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`idUsuario`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usuarios
-- ----------------------------
INSERT INTO `usuarios` VALUES ('U0001', 'Juan', 'Cardozo', 14500454, '922201112', 'jcardozo@tours.com', '2022-06-10', '123456');
INSERT INTO `usuarios` VALUES ('U0002', 'Pamela', 'Figueroa', 1294421, '996461224', 'pfigueroa@tours.com', '2022-06-10', '123456');
INSERT INTO `usuarios` VALUES ('U0003', 'Juan', 'Gallardayo', 69878985, '915822454', 'jgallarday@tours.com', '2022-06-10', '123456');

-- ----------------------------
-- Procedure structure for adiBus
-- ----------------------------
DROP PROCEDURE IF EXISTS `adiBus`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `adiBus`(marca VARCHAR(20), modelo VARCHAR(20), placa VARCHAR(20), idConductor VARCHAR(5))
begin
declare cuenta int;
declare cod char(5);
select right(max(idBus),4)+1 into cuenta from buses;
set cod=concat('B',Lpad(cuenta,4,'0'));
insert into buses values(cod,marca,modelo,placa, idConductor);

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for adiCliente
-- ----------------------------
DROP PROCEDURE IF EXISTS `adiCliente`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `adiCliente`(nombre VARCHAR(45), ape VARCHAR(45), documento INT, direccion VARCHAR(100), telf VARCHAR(10), correo VARCHAR(60), pass VARCHAR(20), nacion VARCHAR(20))
begin
declare cuenta int;
declare cod char(5);
select right(max(idCliente),4)+1 into cuenta from clientes;
set cod=concat('C',Lpad(cuenta,4,'0'));
insert into clientes values(cod,nombre,ape,documento,direccion,telf,correo,pass,nacion);

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for adiConductor
-- ----------------------------
DROP PROCEDURE IF EXISTS `adiConductor`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `adiConductor`(nombre VARCHAR(45), documento INT, telf VARCHAR(10), correo VARCHAR(60))
begin
declare cuenta int;
declare cod char(5);
select right(max(idConductor),3)+1 into cuenta from conductores;
set cod=concat('CO',Lpad(cuenta,3,'0'));
insert into conductores values(cod,nombre,documento,telf,correo);

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for adiDestino
-- ----------------------------
DROP PROCEDURE IF EXISTS `adiDestino`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `adiDestino`(destino VARCHAR(45), depart VARCHAR(45), prov VARCHAR(45))
begin
declare cuenta int;
declare cod char(5);
select right(max(idDestino),4)+1 into cuenta from destinos;
set cod=concat('D',Lpad(cuenta,4,'0'));
insert into destinos values(cod,destino,depart,prov);

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for adiFormaPago
-- ----------------------------
DROP PROCEDURE IF EXISTS `adiFormaPago`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `adiFormaPago`(descripcion VARCHAR(20))
begin
declare cuenta int;
declare cod char(2);
select right(max(idfpago),1)+1 into cuenta from formapago;
set cod=concat('P',cuenta);
insert into formapago values(cod,descripcion);

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for adiGuia
-- ----------------------------
DROP PROCEDURE IF EXISTS `adiGuia`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `adiGuia`(nombre VARCHAR(45), documento INT, telf VARCHAR(10), correo VARCHAR(60),idioma VARCHAR(20))
begin
declare cuenta int;
declare cod char(5);
select right(max(idGuia),4)+1 into cuenta from guias;
set cod=concat('G',Lpad(cuenta,4,'0'));
insert into guias values(cod,nombre,documento,telf,correo,idioma);

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for adiHotel
-- ----------------------------
DROP PROCEDURE IF EXISTS `adiHotel`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `adiHotel`(nomhotel VARCHAR(45), estrellas INT, direccion VARCHAR(100), telefono VARCHAR(10),contacto VARCHAR(50))
begin
declare cuenta int;
declare cod char(5);
select right(max(idHotel),4)+1 into cuenta from hoteles;
set cod=concat('H',Lpad(cuenta,4,'0'));
insert into hoteles values(cod,nomhotel,estrellas,direccion,telefono,contacto);

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for adiServicio
-- ----------------------------
DROP PROCEDURE IF EXISTS `adiServicio`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `adiServicio`(
    tour VARCHAR(5),
    cliente VARCHAR(5),
    pago VARCHAR(5)
)
BEGIN
    DECLARE
        cuenta INT ;
        DECLARE cod CHAR(5) ;
    SELECT
        RIGHT(MAX(idServicio),
        4) +1
    INTO cuenta
FROM
    servicios ;
SET
    cod = CONCAT('S', LPAD(cuenta, 4, '0')) ;
INSERT INTO servicios
VALUES(
    cod,
   tour,
    cliente,
    pago
) ;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for adiServicio2
-- ----------------------------
DROP PROCEDURE IF EXISTS `adiServicio2`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `adiServicio2`(
    tour VARCHAR(5),
    cliente VARCHAR(5),
    pago VARCHAR(5)
)
BEGIN
    DECLARE cod CHAR(5);
    -- Calculate the new idServicio
    IF (SELECT COUNT(*) FROM servicios) = 0 THEN
        SET cod = 'S0001';
    ELSE
        SELECT CONCAT('S', LPAD(MAX(RIGHT(idServicio, 4)) + 1, 4, '0')) INTO cod FROM servicios;
    END IF;

    -- Insert the new record
    INSERT INTO servicios (idServicio, idTour, idCliente, idfPago)
    VALUES (cod, tour, cliente, pago);
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for adiTours
-- ----------------------------
DROP PROCEDURE IF EXISTS `adiTours`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `adiTours`(
    descrip VARCHAR(45),
    destino VARCHAR(5),
    bus VARCHAR(5),
    guia VARCHAR (5),
    hotel VARCHAR(5),
    tarifa decimal(10,0),
    fechain date,
    fechafin date
)
BEGIN
    DECLARE
        cuenta INT ;
        DECLARE cod CHAR(5) ;
    SELECT
        RIGHT(MAX(idTour),
        4) +1
    INTO cuenta
FROM
    tours ;
SET
    cod = CONCAT('T', LPAD(cuenta, 4, '0')) ;
INSERT INTO tours
VALUES(
   cod,
   descrip,
   destino,
   bus,
    guia,
    hotel,
    tarifa,
    fechain,
    fechafin
) ;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for adiUsuario
-- ----------------------------
DROP PROCEDURE IF EXISTS `adiUsuario`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `adiUsuario`(nombre VARCHAR(45), ape VARCHAR(45), documento INT, telf VARCHAR(10), correo VARCHAR(60),fecnac DATE, pass VARCHAR(20))
begin
declare cuenta int;
declare cod char(5);
select right(max(idUsuario),4)+1 into cuenta from usuarios;
set cod=concat('U',Lpad(cuenta,4,'0'));
insert into usuarios values(cod,nombre,ape,documento,telf,correo,fecnac,pass);

end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for delBus
-- ----------------------------
DROP PROCEDURE IF EXISTS `delBus`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delBus`(cod VARCHAR(5))
DELETE FROM buses where idBus = cod
;;
delimiter ;

-- ----------------------------
-- Procedure structure for delCliente
-- ----------------------------
DROP PROCEDURE IF EXISTS `delCliente`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delCliente`(cod VARCHAR(5))
DELETE FROM clientes where idCliente = cod
;;
delimiter ;

-- ----------------------------
-- Procedure structure for delConductor
-- ----------------------------
DROP PROCEDURE IF EXISTS `delConductor`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delConductor`(cod VARCHAR(5))
DELETE FROM conductores where idConductor = cod
;;
delimiter ;

-- ----------------------------
-- Procedure structure for delDestino
-- ----------------------------
DROP PROCEDURE IF EXISTS `delDestino`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delDestino`(cod VARCHAR(5))
DELETE FROM destinos where idDestino = cod
;;
delimiter ;

-- ----------------------------
-- Procedure structure for delFormaPago
-- ----------------------------
DROP PROCEDURE IF EXISTS `delFormaPago`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delFormaPago`(cod VARCHAR(2))
DELETE FROM formapago where idfpago = cod
;;
delimiter ;

-- ----------------------------
-- Procedure structure for delGuia
-- ----------------------------
DROP PROCEDURE IF EXISTS `delGuia`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delGuia`(cod VARCHAR(5))
DELETE FROM guias where idGuia = cod
;;
delimiter ;

-- ----------------------------
-- Procedure structure for delHotel
-- ----------------------------
DROP PROCEDURE IF EXISTS `delHotel`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delHotel`(cod VARCHAR(5))
DELETE FROM hoteles where idHotel = cod
;;
delimiter ;

-- ----------------------------
-- Procedure structure for delServicio
-- ----------------------------
DROP PROCEDURE IF EXISTS `delServicio`;
delimiter ;;
CREATE DEFINER=`root@localhost`@`%` PROCEDURE `delServicio`(cod VARCHAR(5))
DELETE FROM servicios where idServicio=cod
;;
delimiter ;

-- ----------------------------
-- Procedure structure for delUsuario
-- ----------------------------
DROP PROCEDURE IF EXISTS `delUsuario`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delUsuario`(cod VARCHAR(5))
DELETE FROM usuarios where idUsuario = cod
;;
delimiter ;

-- ----------------------------
-- Procedure structure for editBus
-- ----------------------------
DROP PROCEDURE IF EXISTS `editBus`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `editBus`(cod VARCHAR(5), marca VARCHAR(20), modelo VARCHAR(20), placa VARCHAR(20), idConductor VARCHAR(5))
UPDATE buses SET marcaBus = marca, modelo = modelo, placaBus = placa, idConductor = idConductor WHERE idBus = cod
;;
delimiter ;

-- ----------------------------
-- Procedure structure for editCliente
-- ----------------------------
DROP PROCEDURE IF EXISTS `editCliente`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `editCliente`(cod VARCHAR(5), nombre VARCHAR(45), apellido VARCHAR(45), docIdentidad INTEGER, direccion VARCHAR(100), telefono VARCHAR(10), correo VARCHAR(60), password VARCHAR(20), nacion VARCHAR(20))
UPDATE clientes SET nomCliente = nombre, apeCliente = apellido, docIdentidad = docIdentidad, direccion = direccion, telefono = telefono, correo = correo, password = password, nacionalidad = nacion WHERE idCliente = cod
;;
delimiter ;

-- ----------------------------
-- Procedure structure for editConductor
-- ----------------------------
DROP PROCEDURE IF EXISTS `editConductor`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `editConductor`(cod VARCHAR(5), nombre VARCHAR(45), docIdentidad INTEGER, telefono VARCHAR(10), correo VARCHAR(60))
UPDATE conductores SET nomGuia = nombre, docIdentidad = docIdentidad, telefono = telefono, correo = correo WHERE idConductor = cod
;;
delimiter ;

-- ----------------------------
-- Procedure structure for editDestino
-- ----------------------------
DROP PROCEDURE IF EXISTS `editDestino`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `editDestino`(cod VARCHAR(5), dest VARCHAR(45), depart VARCHAR(45), prov VARCHAR(45))
UPDATE destinos SET destino = dest, departamento = depart, provincia = prov WHERE idDestino = cod
;;
delimiter ;

-- ----------------------------
-- Procedure structure for editfpago
-- ----------------------------
DROP PROCEDURE IF EXISTS `editfpago`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `editfpago`(cod VARCHAR(2), descripcion VARCHAR(20))
UPDATE formapago SET descripcion = descripcion WHERE idfpago = cod
;;
delimiter ;

-- ----------------------------
-- Procedure structure for editGuia
-- ----------------------------
DROP PROCEDURE IF EXISTS `editGuia`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `editGuia`(cod VARCHAR(5), nombre VARCHAR(45), docIdentidad INTEGER, telefono VARCHAR(10), correo VARCHAR(60), idioma VARCHAR(20))
UPDATE guias SET nomGuia = nombre, docIdentidad = docIdentidad, telefono = telefono, correo = correo, idioma = idioma WHERE idGuia = cod
;;
delimiter ;

-- ----------------------------
-- Procedure structure for editHotel
-- ----------------------------
DROP PROCEDURE IF EXISTS `editHotel`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `editHotel`(cod VARCHAR(5), nomhot VARCHAR(45), estrellas INTEGER, direccion VARCHAR(100), telefono VARCHAR(10), contacto VARCHAR(50))
UPDATE hoteles SET nomHotel = nomhot, nEstrellas = estrellas, direccion = direccion, telefono = telefono, contacto = contacto WHERE idHotel = cod
;;
delimiter ;

-- ----------------------------
-- Procedure structure for editTour
-- ----------------------------
DROP PROCEDURE IF EXISTS `editTour`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `editTour`(cod VARCHAR(5), descrip VARCHAR(45),
destino VARCHAR(5), bus VARCHAR(5), guia VARCHAR (5), hotel VARCHAR(5),tarifa decimal(10,0),
fechain date, fechafin date)
UPDATE tours SET descripcion = descrip, idDestino = destino,
idBus = bus, idGuia = guia, idHotel = hotel,tarifa=tarifa, fechaInicio=fechain, fechaFin=fechafin
 WHERE idTour = cod
;;
delimiter ;

-- ----------------------------
-- Procedure structure for editUsuario
-- ----------------------------
DROP PROCEDURE IF EXISTS `editUsuario`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `editUsuario`(cod VARCHAR(5), nombre VARCHAR(45), apellido VARCHAR(45), docIdentidad INTEGER, telefono VARCHAR(10), correo VARCHAR(60), fecnac DATE,password VARCHAR(20))
UPDATE usuarios SET nomUsuario = nombre, apeUsuario = apellido, docIdentidad = docIdentidad, telefono = telefono, correo = correo, fecNacimiento = fecnac, password = password WHERE idUsuario = cod
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
