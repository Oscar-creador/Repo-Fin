-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `biblioteca` DEFAULT CHARACTER SET utf8 ;
USE `biblioteca` ;

-- -----------------------------------------------------
-- Table `biblioteca`.`carreras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`carreras` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(256) NOT NULL,
  `activo` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`alumnos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`alumnos` (
  `matricula` INT NOT NULL,
  `nombre` VARCHAR(256) NOT NULL,
  `apellidos` VARCHAR(256) NOT NULL,
  `genero` VARCHAR(8) NOT NULL,
  `carrera_id` INT NOT NULL,
  `fecha_ingreso` DATE NOT NULL,
  `fecha_nacimiento` DATE NULL,
  PRIMARY KEY (`matricula`),
  INDEX `FK_alumnos_carreras_idx` (`carrera_id` ASC) VISIBLE,
  CONSTRAINT `FK_alumnos_carreras`
    FOREIGN KEY (`carrera_id`)
    REFERENCES `biblioteca`.`carreras` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`editoriales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`editoriales` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(256) NOT NULL,
  `pais` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `activo` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`tipos_recursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`tipos_recursos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(256) NOT NULL,
  `activo` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`libros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`libros` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(512) NOT NULL,
  `tipo_recurso_id` INT NOT NULL,
  `edicion` VARCHAR(128) NULL,
  `editorial_id` INT NULL,
  `autores` VARCHAR(1024) NULL,
  `isbn` VARCHAR(256) NULL,
  `activo` BIT(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_recursos_recursos1_idx` (`tipo_recurso_id` ASC) VISIBLE,
  INDEX `FK_recursos_editoriales_idx` (`editorial_id` ASC) VISIBLE,
  CONSTRAINT `FK_recursos_tipos_recursos`
    FOREIGN KEY (`tipo_recurso_id`)
    REFERENCES `biblioteca`.`tipos_recursos` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_recursos_editoriales`
    FOREIGN KEY (`editorial_id`)
    REFERENCES `biblioteca`.`editoriales` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`libros_inventario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`libros_inventario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `libro_id` INT NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `disponible` BIT(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_inventario_libros_idx` (`libro_id` ASC) VISIBLE,
  CONSTRAINT `FK_inventario_libros`
    FOREIGN KEY (`libro_id`)
    REFERENCES `biblioteca`.`libros` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`prestamos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`prestamos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `libro_inventario_id` INT NOT NULL,
  `alumno_matricula` INT NOT NULL,
  `fecha_prestamo` DATETIME NOT NULL,
  `fecha_devuelto` DATETIME NULL,
  `fecha_debe_devolver` DATETIME NOT NULL,
  `disponible` BIT(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_prestamos_alumnos_idx` (`alumno_matricula` ASC) VISIBLE,
  INDEX `FK_prestamos_libros_inventario_idx` (`libro_inventario_id` ASC) VISIBLE,
  CONSTRAINT `FK_prestamos_alumnos`
    FOREIGN KEY (`alumno_matricula`)
    REFERENCES `biblioteca`.`alumnos` (`matricula`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_prestamos_libros_inventario`
    FOREIGN KEY (`libro_inventario_id`)
    REFERENCES `biblioteca`.`libros_inventario` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
