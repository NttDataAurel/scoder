drop table if exists phase;

CREATE TABLE `phase` (
	`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(60) NOT NULL,
	`description` TEXT NOT NULL,
	`priority` INT(4) NOT NULL,
	PRIMARY KEY (`id`)
)
ENGINE=InnoDB;

INSERT INTO `phase` (`id`, `name`, `description`, `priority`) VALUES
	(1, 'Human Resources', 'resurse umane', '1'),
	(2, 'Tehnic', 'personalul de la tehnic', '2'),
	(3, 'Clienti', 'interviu cu posibili clienti ai firmei', '3');

