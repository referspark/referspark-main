CREATE DATABASE referspark;
USE referspark;
 

drop table business;
drop table customer;
drop table user;

-- User of the system. Different from business
CREATE TABLE user (userid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                   username VARCHAR(80),
                      email     VARCHAR(80),
                      password  VARCHAR(256),
                      firstname      VARCHAR(50),
                      lastname      VARCHAR(50),
                      mobile     VARCHAR(20));
                      
-- An user can have multiple businesses                       
CREATE TABLE business (businessid       INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
                      userid   INT,                     
                      name      VARCHAR(80),
                      FOREIGN KEY (userid) REFERENCES user(userid));

-- Customers of small businesses                              
CREATE TABLE customer (id        INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       name       VARCHAR(80),
                       email      VARCHAR(80),
                       mobile     VARCHAR(20));
-- To Track Email access                              
CREATE TABLE trackemail (id        INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       ipaddress       VARCHAR(80),
                       couponcode       VARCHAR(200),
                       time      VARCHAR(80)
                       ); 
                       
                       