CREATE DATABASE if not exists scoderdb;

CREATE USER 'scoder'@'localhost' IDENTIFIED BY 'scoderPass';
GRANT ALL PRIVILEGES ON scoderdb.* TO 'scoder'@'localhost';

FLUSH PRIVILEGES;
