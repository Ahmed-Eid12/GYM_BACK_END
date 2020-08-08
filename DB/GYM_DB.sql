DROP SCHEMA IF EXISTS `BackGYM`;

CREATE SCHEMA `BackGYM`;

use `BackGYM`;

SET FOREIGN_KEY_CHECKS = 0;
# ------------------------------- -------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` long,
  `is_admin` int(11) default 0,
  `user_name` varchar(50) NOT NULL ,
  `email` varchar(50) NOT NULL,
  `password` varchar(150) NOT NULL,
  `date_modify` datetime ,
  `modified_by` int(11) ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
# ------------------------------- -------------------

DROP TABLE IF EXISTS `sys_privelages`;

CREATE TABLE `sys_privelages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` long ,
  `pre_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
# ------------------------------- -------------------

DROP TABLE IF EXISTS `user_privelage`;

CREATE TABLE `user_privelage` (
  `user_id` int(11) NOT NULL,
  `privelage_id` int(11) NOT NULL,
  
  PRIMARY KEY (`user_id`,`privelage_id`),
  
  KEY `FK_user_idx` (`user_id`),
  KEY `FK_pre_idx` (`privelage_id`),
  
  CONSTRAINT `FK_User_05` FOREIGN KEY (`user_id`) 
  REFERENCES `users` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_Privelage` FOREIGN KEY (`privelage_id`) 
  REFERENCES `sys_privelages` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
# ------------------------------- -------------------

DROP TABLE IF EXISTS `players`;

CREATE TABLE `players` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` long,
  `player_name` varchar(100) NOT NULL ,
  `email` varchar(70),
  `address` varchar(150) NOT NULL,
  `passport_number` int(50) ,
  `card_number` int(20) ,
  `phone` int(20) NOT NULL,
  `player_image` varchar(100) NOT NULL ,
  `player_championships` varchar(800),
  `amount_paid` int(50) ,
  `date_modify` datetime ,
  `modified_by` int(11) ,
  `subtype_id` int(11) ,
  `exercise_type_id` int(11) ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

ALTER TABLE `players` MODIFY `passport_number` VARCHAR(20);
ALTER TABLE `players` MODIFY `card_number` VARCHAR(14);
ALTER TABLE `players` MODIFY `phone` VARCHAR(11);

ALTER TABLE `players`
ADD CONSTRAINT `FK_subtype` FOREIGN KEY (`subtype_id`)
    REFERENCES `sys_subtype`(`id`);
    
ALTER TABLE `players`
ADD CONSTRAINT `FK_exercise_type` FOREIGN KEY (`exercise_type_id`)
    REFERENCES `sys_exercise_type`(`id`);
    
ALTER TABLE `players` ADD COLUMN `subscription_no` INT DEFAULT 0;

ALTER TABLE `players` ADD COLUMN `gender_id` INT (11);

ALTER TABLE `players`
ADD CONSTRAINT `FK_gender` FOREIGN KEY (`gender_id`)
    REFERENCES `sys_gender`(`id`);

ALTER TABLE `players` DROP COLUMN `modified_by`;
ALTER TABLE `players` ADD COLUMN `modified_by_id` INT (11);
ALTER TABLE `players`
ADD CONSTRAINT `FK_sys_users` FOREIGN KEY (`modified_by_id`)
    REFERENCES `users`(`id`);
    
ALTER TABLE `players` ADD COLUMN `height` INT (11);
ALTER TABLE `players` ADD COLUMN `weight` INT (11);
ALTER TABLE `players` ADD COLUMN `age` INT (11);
ALTER TABLE `players` ADD COLUMN `amount_rest` INT (11);

ALTER TABLE `players` ADD COLUMN `hulf_month_no` INT (11) default (0);

# ---------------------------------------------------------------

DROP TABLE IF EXISTS `sys_subtype`;

CREATE TABLE `sys_subtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` long ,
  `subtype_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# ------------------------------------------------------------------------

DROP TABLE IF EXISTS `sys_exercise_type`;

CREATE TABLE `sys_exercise_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` long ,
  `exercise_type_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

# ------------------------------------------------------------------------

DROP TABLE IF EXISTS `sys_gender`;

CREATE TABLE `sys_gender` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` long ,
  `gender` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
  

  
  
  
  