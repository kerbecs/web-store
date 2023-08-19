CREATE TABLE orders(
                       id int PRIMARY KEY AUTO_INCREMENT,
                       produce_id varchar(40) NOT NULL,
                       user_id int NOT NULL,
                       time_order DATETIME NOT NULL
);