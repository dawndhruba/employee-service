create table employee (
	id bigint not null,
	name varchar(255) not null,
	role varchar(255) not null,
	department varchar(255) not null,
	mobile_no varchar(255) not null,
	primary key(id)
);

create table address (
	id bigint not null,
	type varchar(255) not null,
	street varchar(255) not null,
	pincode bigint not null,
	country varchar(255) not null,
	primary key(id)
);