CREATE DATABASE webdb;

CREATE USER 'webuser'@'%' IDENTIFIED BY 'webuser';

webdbGRANT ALL PRIVILEGES ON webdb.* TO 'webuser'@'%';