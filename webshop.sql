drop table if exists customers;
drop table if exists bottoms;
drop table if exists toppings;

create table customers (
	id int primary key not null auto_increment,
	name varchar(50) not null,
	password varchar(50) not null,
	balance int not null default 0
);

insert into customers values
	(1, 'test', 'test', 200);

create table bottoms (
	name varchar(50) not null primary key,
	price int not null
);

insert into bottoms values
	('Chocolate', 5.00),
	('Vanilla', 5.00),
	('Nutmeg', 5.00),
	('Pistacio', 6.00),
	('Almond', 7.00);


create table toppings (
	name varchar(50) not null primary key,
	price int not null
);


insert into toppings values
	('Chocolate', 5.00),
	('Blueberry', 5.00),
	('Rasberry', 5.00),
	('Crispy', 6.00),
	('Strawberry', 6.00),
	('Rum/Raisin', 7.00),
	('Orange', 8.00),
	('Lemon', 8.00),
	('Blue cheese', 9.00);


