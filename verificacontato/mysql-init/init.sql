CREATE TABLE `bancos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_banco` varchar(10) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `data_cadastro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_banco` (`codigo_banco`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

/*
-- Query: SELECT * FROM verificacontato.bancos
LIMIT 0, 1000

-- Date: 2025-06-03 23:48
*/
INSERT INTO `bancos` (`id`,`codigo_banco`,`nome`,`data_cadastro`) VALUES (1,'001','Banco do Brasil','2025-05-29 14:10:14');
INSERT INTO `bancos` (`id`,`codigo_banco`,`nome`,`data_cadastro`) VALUES (2,'104','Caixa Econômica Federal','2025-05-29 14:10:14');
INSERT INTO `bancos` (`id`,`codigo_banco`,`nome`,`data_cadastro`) VALUES (3,'237','Bradesco','2025-05-29 14:10:14');
INSERT INTO `bancos` (`id`,`codigo_banco`,`nome`,`data_cadastro`) VALUES (4,'341','Itaú Unibanco','2025-05-29 14:10:14');


CREATE TABLE `contato_oficial` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `numero_telefone` varchar(255) NOT NULL,
  `codigo_banco` varchar(10) NOT NULL,
  `data_cadastro` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_contato_banco_codigo` (`codigo_banco`),
  CONSTRAINT `fk_contato_banco_codigo` FOREIGN KEY (`codigo_banco`) REFERENCES `bancos` (`codigo_banco`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

/*
-- Query: SELECT * FROM verificacontato.contato_oficial
LIMIT 0, 1000

-- Date: 2025-06-03 23:50
*/
INSERT INTO `contato_oficial` (`id`,`numero_telefone`,`codigo_banco`,`data_cadastro`) VALUES (1,'08007290100','001','2025-05-29 14:13:00');
INSERT INTO `contato_oficial` (`id`,`numero_telefone`,`codigo_banco`,`data_cadastro`) VALUES (2,'400400001','001','2025-05-29 14:13:00');
INSERT INTO `contato_oficial` (`id`,`numero_telefone`,`codigo_banco`,`data_cadastro`) VALUES (3,'08007260104','104','2025-05-29 14:13:00');
INSERT INTO `contato_oficial` (`id`,`numero_telefone`,`codigo_banco`,`data_cadastro`) VALUES (4,'30041044','104','2025-05-29 14:13:00');
INSERT INTO `contato_oficial` (`id`,`numero_telefone`,`codigo_banco`,`data_cadastro`) VALUES (5,'08007027373','237','2025-05-29 14:13:00');
INSERT INTO `contato_oficial` (`id`,`numero_telefone`,`codigo_banco`,`data_cadastro`) VALUES (6,'40020333','237','2025-05-29 14:13:00');
INSERT INTO `contato_oficial` (`id`,`numero_telefone`,`codigo_banco`,`data_cadastro`) VALUES (7,'08007290194','341','2025-05-29 14:13:00');
INSERT INTO `contato_oficial` (`id`,`numero_telefone`,`codigo_banco`,`data_cadastro`) VALUES (8,'40040303','341','2025-05-29 14:13:00');



CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `senha` varchar(255) NOT NULL,
  `data_cadastro` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci