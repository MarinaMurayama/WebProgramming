CREATE DATABASE usermanagement DEFAULT CHARACTER SET utf8;


CREATE TABLE user(
	id SERIAL,
	login_id varchar(255) UNIQUE NOT NULL,
	name varchar(255) NOT NULL,
	birth_date DATE NOT NULL,
	password varchar(255) NOT NULL,
	create_date DATETIME NOT NULL,
	update_date DATETIME NOT NULL
);


insert into user(login_id,name,birth_date,password,create_date,update_date)values ('admin', 'ä«óùé“','1988-12-10','password',now(),now());


SELECT * FROM user;
