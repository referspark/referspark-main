CREATE DATABASE referspark;
USE referspark;
 

drop table business;
drop table user;
drop table customer;
drop table transaction;

-- User of the system. Different from business
CREATE TABLE user (userid              INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      email            VARCHAR(80),
                      firstname        VARCHAR(50),
                      lastname         VARCHAR(50),
                      mobile           VARCHAR(20)
                     );
                  
-- An user can have multiple businesses                       
CREATE TABLE business (businessid       INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
                      userid            INT,
                      businessname      VARCHAR(150),                     
                      password          VARCHAR(80),
                      city              VARCHAR(80),
                      industry          VARCHAR(200),
                      onboarddate       DATE,
                      hasfullinfo       INT,/*company will have minimum info if it is created from sms channel*/
                      fullinfoenterdate DATE,
                      
                      FOREIGN KEY (userid) REFERENCES user(userid));
ALTER TABLE business AUTO_INCREMENT=1120;                      
                      
-- Customers of small businesses                              
CREATE TABLE customer (customerid   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       name         VARCHAR(80),
                       email        VARCHAR(80),
                       mobile       VARCHAR(20),
                       joindate     DATE);
                       
-- Transactions. Can be rewards or referrals    
CREATE TABLE transaction(transactionid      INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         customerid         INT,
                         businessid         INT,
                         date               DATE,
                         amount             INT,
                         rewardtoken        INT,
                         
                         FOREIGN KEY (customerid) REFERENCES customer(customerid),
                         FOREIGN KEY (businessid) REFERENCES business(businessid));                       
                       
                         
-- To Track Email access                              
CREATE TABLE trackemail (id        INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       ipaddress       VARCHAR(80),
                       couponcode       VARCHAR(200),
                       time      VARCHAR(80)); 
                       
                       
CREATE TABLE unsubscribed_mailinglist (id     INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                       email  VARCHAR(80));
