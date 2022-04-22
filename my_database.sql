create database my_database;
use my_database;
drop  database my_database;

create table Student_Management(
id int primary key  not null,
`name` varchar(45) null,
age int null,
country varchar (45) null

);
create table Class(
id int primary key not null,
`name` varchar(45) null 
);

create table Teacher(
id int primary key not null,
`name` varchar(45) null,
age int null,
country varchar(45) null
);