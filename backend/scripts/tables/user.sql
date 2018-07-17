CREATE TABLE `user` (
	`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(32) NULL DEFAULT NULL,
	`surname` VARCHAR(32) NULL DEFAULT NULL,
	`address` VARCHAR(32) NULL DEFAULT NULL,
	`phone` VARCHAR(50) NULL DEFAULT NULL,
	`email` VARCHAR(64) NULL DEFAULT NULL,
	`filename` VARCHAR(256) NULL DEFAULT NULL,
	`filedata` BLOB NULL,
	`state` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
ENGINE=InnoDB;

