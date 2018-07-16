CREATE TABLE `user_phase_result` (
	`ID` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`_DATE` DATE NOT NULL,
	`USER_ID` BIGINT(20) UNSIGNED NOT NULL,
	`PHASE_ID` BIGINT(20) UNSIGNED NOT NULL,
	`COMMENTS` VARCHAR(1024) NULL DEFAULT NULL,
	`RANKING` SMALLINT(6) NULL DEFAULT NULL,
	`PASSED` VARCHAR(16) NOT NULL,
	PRIMARY KEY (`ID`),
	INDEX `FK_PHASE_ID` (`PHASE_ID`),
	INDEX `FK_USER_ID` (`USER_ID`),
	CONSTRAINT `FK_PHASE_ID` FOREIGN KEY (`PHASE_ID`) REFERENCES `phase` (`id`),
	CONSTRAINT `FK_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`id`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
AUTO_INCREMENT=2
;
