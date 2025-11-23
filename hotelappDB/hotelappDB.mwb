-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hotelapp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hotelapp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hotelapp` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `hotelapp` ;

-- -----------------------------------------------------
-- Table `hotelapp`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelapp`.`customers` (
  `customer_id` BIGINT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `mobile_number` VARCHAR(255) NULL DEFAULT NULL,
  `pwd` VARCHAR(255) NULL DEFAULT NULL,
  `role` VARCHAR(255) NULL DEFAULT NULL,
  `create_dt` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE INDEX `email` (`email` ASC) VISIBLE,
  INDEX `email_2` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hotelapp`.`authorities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelapp`.`authorities` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(255) NULL DEFAULT NULL,
  `customer_id` BIGINT NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_authority_customer` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `fk_authority_customer`
    FOREIGN KEY (`customer_id`)
    REFERENCES `hotelapp`.`customers` (`customer_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hotelapp`.`hotels`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelapp`.`hotels` (
  `hotel_id` BIGINT NOT NULL AUTO_INCREMENT,
  `hotel_name` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  `city` VARCHAR(255) NULL DEFAULT NULL,
  `state` VARCHAR(255) NULL DEFAULT NULL,
  `zip_code` VARCHAR(255) NULL DEFAULT NULL,
  `phone_number` VARCHAR(255) NULL DEFAULT NULL,
  `create_dt` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`hotel_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hotelapp`.`rooms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelapp`.`rooms` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `room_number` VARCHAR(255) NULL DEFAULT NULL,
  `room_type` VARCHAR(255) NULL DEFAULT NULL,
  `price_per_night` DOUBLE NULL DEFAULT NULL,
  `status` VARCHAR(255) NULL DEFAULT NULL,
  `hotel_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_room_hotel` (`hotel_id` ASC) VISIBLE,
  CONSTRAINT `fk_room_hotel`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `hotelapp`.`hotels` (`hotel_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hotelapp`.`bookings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelapp`.`bookings` (
  `booking_id` BIGINT NOT NULL AUTO_INCREMENT,
  `customer_id` BIGINT NOT NULL,
  `room_id` BIGINT NOT NULL,
  `hotel_id` BIGINT NOT NULL,
  `check_in_date` DATETIME NULL DEFAULT NULL,
  `check_out_date` DATETIME NULL DEFAULT NULL,
  `total_price` DOUBLE NULL DEFAULT NULL,
  `booking_status` VARCHAR(255) NULL DEFAULT NULL,
  `create_dt` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  INDEX `fk_booking_customer` (`customer_id` ASC) VISIBLE,
  INDEX `fk_booking_room` (`room_id` ASC) VISIBLE,
  INDEX `fk_booking_hotel` (`hotel_id` ASC) VISIBLE,
  CONSTRAINT `fk_booking_customer`
    FOREIGN KEY (`customer_id`)
    REFERENCES `hotelapp`.`customers` (`customer_id`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_booking_hotel`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `hotelapp`.`hotels` (`hotel_id`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_booking_room`
    FOREIGN KEY (`room_id`)
    REFERENCES `hotelapp`.`rooms` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hotelapp`.`contacts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelapp`.`contacts` (
  `contact_id` INT NOT NULL AUTO_INCREMENT,
  `contact_name` VARCHAR(255) NULL DEFAULT NULL,
  `contact_email` VARCHAR(255) NULL DEFAULT NULL,
  `subject_of_message` VARCHAR(255) NULL DEFAULT NULL,
  `message` VARCHAR(255) NULL DEFAULT NULL,
  `create_dt` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`contact_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hotelapp`.`notice_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelapp`.`notice_details` (
  `notice_id` BIGINT NOT NULL,
  `notice_summary` VARCHAR(255) NULL DEFAULT NULL,
  `notice_details` VARCHAR(255) NULL DEFAULT NULL,
  `notic_beg_dt` DATE NULL DEFAULT NULL,
  `notic_end_dt` DATE NULL DEFAULT NULL,
  `create_dt` DATE NULL DEFAULT NULL,
  `update_dt` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`notice_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hotelapp`.`payments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelapp`.`payments` (
  `payment_id` BIGINT NOT NULL AUTO_INCREMENT,
  `booking_id` BIGINT NOT NULL,
  `amount` DOUBLE NOT NULL,
  `payment_date` DATETIME NULL DEFAULT NULL,
  `payment_method` VARCHAR(255) NULL DEFAULT NULL,
  `payment_status` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  INDEX `fk_payment_booking` (`booking_id` ASC) VISIBLE,
  CONSTRAINT `fk_payment_booking`
    FOREIGN KEY (`booking_id`)
    REFERENCES `hotelapp`.`bookings` (`booking_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `hotelapp`.`reviews`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotelapp`.`reviews` (
  `review_id` BIGINT NOT NULL AUTO_INCREMENT,
  `customer_id` BIGINT NOT NULL,
  `hotel_id` BIGINT NOT NULL,
  `rating` INT NULL DEFAULT NULL,
  `review_comment` VARCHAR(255) NULL DEFAULT NULL,
  `review_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`review_id`),
  INDEX `fk_review_customer` (`customer_id` ASC) VISIBLE,
  INDEX `fk_review_hotel` (`hotel_id` ASC) VISIBLE,
  CONSTRAINT `fk_review_customer`
    FOREIGN KEY (`customer_id`)
    REFERENCES `hotelapp`.`customers` (`customer_id`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_review_hotel`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `hotelapp`.`hotels` (`hotel_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
