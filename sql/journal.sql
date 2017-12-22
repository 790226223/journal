CREATE TABLE daily_record
(
	id INT (11) NOT NULL AUTO_INCREMENT ,
	day_time DATE NOT NULL ,
	title VARCHAR (100) NOT NULL ,
	descript VARCHAR (6144) ,
	user_id INT (11) NOT NULL ,
	sport_id INT (11) NOT NULL ,
	PRIMARY KEY (id)
);

CREATE TABLE sport_info(
  id INT(11) NOT NULL AUTO_INCREMENT ,
  things VARCHAR (100) NOT NULL ,
  count INT (11) ,
	units VARCHAR (10) ,
	start_time TIME ,
	end_time TIME ,
	PRIMARY KEY (id)
);

CREATE TABLE record_type(
 id INT (11) NOT NULL AUTO_INCREMENT,
 record_id INT (11) NOT NULL ,
 type_id INT (11) NOT NULL ,
 PRIMARY KEY (id)
);

CREATE TABLE daily_type(
	id INT (11) NOT NULL AUTO_INCREMENT ,
	type_name VARCHAR (100) NOT NULL ,
	descript VARCHAR (1024) ,
	PRIMARY KEY (id)
);

CREATE TABLE journal_user(
	id INT (11) NOT NULL AUTO_INCREMENT ,
	user_name VARCHAR (50) NOT NULL ,
	password VARCHAR (512) NOT NULL ,
	primary key (id)
);

CREATE TABLE user_info(
  id INT (11) NOT NULL AUTO_INCREMENT ,
  user_id INT (11) NOT NULL ,
  default_type INT (11) NOT NULL ,
  primary key (id)
);