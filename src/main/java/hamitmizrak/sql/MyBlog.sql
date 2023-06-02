-- Delete Database
DROP DATABASE `blog`;

     -- Create Database
CREATE SCHEMA `blog` DEFAULT CHARACTER SET utf8 ;

-- Eğer birden fazla DB varsa sadece ilgili DB set
use blog;

     -- Create Table
CREATE TABLE `blog`.`register` (
   `id` INT NOT NULL AUTO_INCREMENT,
   `name` VARCHAR(255) NULL DEFAULT 'Adını girmediniz',
   `surname` VARCHAR(255) NULL DEFAULT 'Soyadını girmediniz',
   `email` VARCHAR(255) NULL DEFAULT 'Email girmediniz',
   `password` VARCHAR(255) NULL DEFAULT 'Şifre girmediniz',
   `created_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`))
 ENGINE = InnoDB;