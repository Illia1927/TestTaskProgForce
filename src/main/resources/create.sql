1 step:
CREATE TABLE good(
good_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
title VARCHAR(30) NOT NULL ,
price DOUBLE NOT NULL,
status varchar(30) NOT NULL
);


2 step:
CREATE TABLE category(
category_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
name VARCHAR(100) NOT NULL UNIQUE,
good_id INT NOT NULL,
  FOREIGN KEY (good_id) REFERENCES good(good_id)
);

3 step:
CREATE TABLE market(
  market_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(50) NOT NULL,
  category_id INT NOT NULL,
  FOREIGN KEY (category_id) REFERENCES category(category_id)
);

4 step:
CREATE TABLE status(
  status_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(50) NOT NULL
);

next: insert data
1 step:
INSERT INTO good (title, price)
