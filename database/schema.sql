CREATE TABLE business (id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
                      username VARCHAR(80),
                      email     VARCHAR(80),
                      password  VARCHAR(256),
                      name      VARCHAR(80));
                              
CREATE TABLE customer (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       name       VARCHAR(80),
                       email      VARCHAR(80),
                       mobile     VARCHAR(20));                            
                       
                       