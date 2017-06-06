CREATE TABLE daily_record
(
	id int(11) NOT NULL AUTO_INCREMENT,
	day_time date NOT NULL,
	things varchar(100) NOT NULL,
	descript varchar(1024),
	count int(11),
	units varchar(10),
	start_time time,
	end_time time,
	user_id int(11) NOT NULL,
	type_id int(11),
	primary key (id)
);

CREATE TABLE daily_type(
	id int(11) NOT NULL AUTO_INCREMENT,
	type_name varchar(100) NOT NULL,
	descript varchar(1024),
	primary key (id)
);

CREATE TABLE journal_user(
	id int(11) NOT NULL AUTO_INCREMENT,
	user_name varchar(50) NOT NULL,
	password varchar(512) NOT NULL,
	primary key (id)
);