CREATE TABLE IF NOT EXISTS `questionnaire` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `start` DATE NOT NULL,
  `end` DATE NOT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE IF NOT EXISTS `question` (
  `seq` INT NOT NULL AUTO_INCREMENT,
  `questionnaire_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `answer` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`seq`));
  
  CREATE TABLE IF NOT EXISTS `record` (
  `seq` INT NOT NULL AUTO_INCREMENT,
  `questionnaire_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `age` VARCHAR(45) NOT NULL,
  `answer` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`seq`));