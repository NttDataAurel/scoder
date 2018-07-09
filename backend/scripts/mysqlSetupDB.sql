use scoderdb;

CREATE TABLE if not exists APP_CONFIG
( ID MEDIUMINT NOT NULL AUTO_INCREMENT,
  _KEY VARCHAR(255) NOT NULL,
  _VALUE VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY(ID)
);

INSERT INTO `app_config` (`_KEY`, `_VALUE`) VALUES
   ('PHASE_PRIO_0', '0'),
   ('PHASE_PRIO_1', '4'),
   ('PHASE_PRIO_2', '4'),
	('SKILL_1', 'JAVA'),
	('SKILL_2', 'JAVA_EE'),
	('SKILL_3', 'JAVASCRIPT'),
	('SKILL_4', 'ANGULAR_JS');