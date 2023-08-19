
DROP TABLE IF EXISTS user_description;
CREATE TABLE user_description
(
    id        int PRIMARY KEY AUTO_INCREMENT,
    firstName varchar(25) NOT NULL CHECK (firstName REGEXP '^([A-Za-z]{2,25})$'
) ,
lastName varchar(25) NOT NULL CHECK(lastName REGEXP   '^([A-Za-z]{2,25})$'),
email varchar(70) NOT NULL UNIQUE,
city varchar(25) NOT NULL CHECK(city REGEXP  '^([A-Za-z\- \']{2,25})$'),
address varchar(70) NOT NULL
);


DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    id       int PRIMARY KEY AUTO_INCREMENT,
    username varchar(50) NOT NULL UNIQUE CHECK (username REGEXP '^([a-zA-Z_0-9\-_\.]{5,68})$'
) ,
                     password varchar(68) NOT NULL,
                     is_active boolean NOT NULL DEFAULT true,
                     user_description int NOT NULL UNIQUE,
                     CONSTRAINT user_description_fk FOREIGN KEY(user_description) REFERENCES user(id) ON DELETE CASCADE
);