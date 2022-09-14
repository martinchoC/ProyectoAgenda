CREATE TABLE `auto` (
  `patente` varchar(7) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `tipoMotor` varchar(7) NOT NULL,
  `persona_dni` int NOT NULL,
  PRIMARY KEY (`patente`),
  KEY `fk_auto_persona1_idx` (`persona_dni`),
  CONSTRAINT `fk_auto_persona1` FOREIGN KEY (`persona_dni`) REFERENCES `persona` (`dni`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `historial` (
  `id_servicio` int NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `autopatente` varchar(7) NOT NULL,
  `servicio_tipo` int NOT NULL,
  PRIMARY KEY (`id_servicio`,`autopatente`),
  KEY `fk_historial_auto_idx` (`autopatente`),
  KEY `fk_historial_servicio1_idx` (`servicio_tipo`),
  CONSTRAINT `fk_historial_auto` FOREIGN KEY (`autopatente`) REFERENCES `auto` (`patente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_historial_servicio1` FOREIGN KEY (`servicio_tipo`) REFERENCES `servicio` (`tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `persona` (
  `dni` int NOT NULL,
  `nombre` varchar(16) NOT NULL,
  `apellido` varchar(16) NOT NULL,
  `cantServicios` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `servicio` (
  `tipo` int NOT NULL,
  `precio` int NOT NULL,
  `descripcion_servicio` varchar(45) NOT NULL,
  PRIMARY KEY (`tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
