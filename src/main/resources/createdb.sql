/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Usuario
 * Created: 18/09/2018
 */

create database agenda;

CREATE TABLE `agenda`.`contacto` (
  `id_contacto` INT NOT NULL,
  `razon_social` VARCHAR(45) NULL,
  `domicilio` VARCHAR(45) NULL,
  `pagina_web` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `fax` VARCHAR(45) NULL,
  PRIMARY KEY (`id_contacto`));
