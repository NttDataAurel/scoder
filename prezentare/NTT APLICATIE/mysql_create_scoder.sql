SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS scoder;
CREATE SCHEMA scoder;
USE scoder;

CREATE TABLE app_config {
	 id INTEGER NOT NULL AUTO_INCREMENT,
	_key VARCHAR(255) NULL,
	_value VARCHAR(255) NULL,
	CONSTRAINT id_pk PRIMARY KEY ( id ),
} ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE phase {
	PHASE_ID INTEGER NOT NULL AUTO_INCREMENT,
	PHASE_NAME VARCHAR(64) NOT NULL,
	PHASE_DESCRIPTION VARCHAR(255) NULL,
	PRIORITY INTEGER NOT NULL,
	CONSTRAINT ID_pk PRIMARY KEY ( PHASE_ID )
}ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user {
	USER_ID	INTEGER NOT NULL AUTO_INCREMENT,
	USER_NAME VARCHAR(128) NOT NULL,
	USER_ADDRESS VARCHAR(255) NOT NULL,
	USER_PHONE INTEGER NOT NULL,
	USER_EMAIL VARCHAR(32) NOT NULL,
	USER_FILENAME VARCHAR(32) NULL,
	USER_STATE VARCHAR(16) NULL,
	PRIORITY INTEGER NOT NULL,
	CONSTRAINT ID_pk PRIMARY KEY ( USER_ID )
}ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_skill {
	USER_SKILL_ID	INTEGER NOT NULL AUTO_INCREMENT,
	USER_ID INTEGER NOT NULL,
	PHASE_ID INTEGER NOT NULL,
	USER_SKILL_NAME VARCHAR(64) NOT NULL,
	USER_SKILL_LEVEL INTEGER NOT NULL,
	USER_SKILL_COMMENTS VARCHAR(255) NULL,
	CONSTRAINT ID_pk PRIMARY KEY ( USER_SKILL_ID )
}ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_phase_results {
	PHASE_RESULTS_ID INTEGER NOT NULL AUTO_INCREMENT,
	USER_ID INTEGER NOT NULL,
	PHASE_ID INTEGER NOT NULL,
	PHASE_COMMENTS VARCHAR(255) NULL,
	PHASE_RANK INTEGER NOT NULL,
	PHASE_PASSED VARCHAR(32) NOT NULL,
	CONSTRAINT ID_pk PRIMARY KEY ( PHASE_RESULTS_ID )
}ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE user_skill ADD CONSTRAINT user_skill_fk_user FOREIGN KEY ( USER_ID ) REFERENCES user ( USER_ID );
ALTER TABLE user_skill ADD CONSTRAINT user_skill_fk_phase FOREIGN KEY ( PHASE_ID ) REFERENCES phase ( PHASE_ID );

ALTER TABLE user_phase_results ADD CONSTRAINT user_phase_results_fk_user FOREIGN KEY ( USER_ID ) REFERENCES user ( USER_ID );
ALTER TABLE user_phase_results ADD CONSTRAINT user_phase_results_fk_phase FOREIGN KEY ( PHASE_ID ) REFERENCES phase ( PHASE_ID );

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;











