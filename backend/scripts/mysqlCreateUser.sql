CREATE DATABASE if not exists scoderdb /*!40100 COLLATE 'utf8_general_ci' */;

CREATE USER 'scoder'@'localhost' IDENTIFIED BY 'scoderPass';
GRANT ALL PRIVILEGES ON scoderdb.* TO 'scoder'@'localhost';

FLUSH PRIVILEGES;
