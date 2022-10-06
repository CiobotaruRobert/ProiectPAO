-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema proiectpao
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema proiectpao
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `proiectpao` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `proiectpao` ;

-- -----------------------------------------------------
-- Table `proiectpao`.`distribuitor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proiectpao`.`distribuitor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `denumire` VARCHAR(45) NULL DEFAULT NULL,
  `adresa` VARCHAR(100) NULL DEFAULT NULL,
  `cod_postal` VARCHAR(45) NULL DEFAULT NULL,
  `numar_telefon` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `proiectpao`.`distribuitor_import`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proiectpao`.`distribuitor_import` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `denumire` VARCHAR(45) NULL DEFAULT NULL,
  `adresa` VARCHAR(45) NULL DEFAULT NULL,
  `cod_postal` VARCHAR(45) NULL DEFAULT NULL,
  `numar_telefon` VARCHAR(45) NULL DEFAULT NULL,
  `cod_eori` VARCHAR(45) NULL DEFAULT NULL,
  `certificat_origine` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `proiectpao`.`produse_bauturi_alcoolice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proiectpao`.`produse_bauturi_alcoolice` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `denumire` VARCHAR(45) NULL DEFAULT NULL,
  `cantitate` INT NULL DEFAULT NULL,
  `descriere` VARCHAR(250) NULL DEFAULT NULL,
  `plante_provenienta` VARCHAR(200) NULL DEFAULT NULL,
  `procentaj_alcool` DECIMAL(4,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `proiectpao`.`produse_bauturi_nealcoolice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proiectpao`.`produse_bauturi_nealcoolice` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `denumire` VARCHAR(45) NULL DEFAULT NULL,
  `cantitate` INT NULL DEFAULT NULL,
  `descriere` VARCHAR(250) NULL DEFAULT NULL,
  `contine_indulcitori_artificiali` TINYINT NULL DEFAULT NULL,
  `carbogazoasa` TINYINT NULL DEFAULT NULL,
  `naturala` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `proiectpao`.`produse_carne`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proiectpao`.`produse_carne` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `denumire` VARCHAR(45) NULL DEFAULT NULL,
  `cantitate` INT NULL DEFAULT NULL,
  `descriere` VARCHAR(250) NULL DEFAULT NULL,
  `prelucrata` TINYINT NULL DEFAULT NULL,
  `tratata_chimic` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `proiectpao`.`produse_cereale`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proiectpao`.`produse_cereale` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `denumire` VARCHAR(45) NULL DEFAULT NULL,
  `cantitate` VARCHAR(45) NULL DEFAULT NULL,
  `descriere` VARCHAR(250) NULL DEFAULT NULL,
  `contine_gluten` TINYINT NULL DEFAULT NULL,
  `alergeni` VARCHAR(250) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `proiectpao`.`produse_fructe_legume`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proiectpao`.`produse_fructe_legume` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `denumire` VARCHAR(45) NULL DEFAULT NULL,
  `cantitate` VARCHAR(45) NULL DEFAULT NULL,
  `descriere` VARCHAR(250) NULL DEFAULT NULL,
  `bio` TINYINT NULL DEFAULT NULL,
  `romanesc` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `proiectpao`.`produse_lactate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proiectpao`.`produse_lactate` (
  `id_produse_lactate` INT NOT NULL AUTO_INCREMENT,
  `denumire` VARCHAR(45) NULL DEFAULT NULL,
  `cantitate` INT NULL DEFAULT NULL,
  `descriere` VARCHAR(250) NULL DEFAULT NULL,
  `procentaj_grasime` DECIMAL(4,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id_produse_lactate`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
