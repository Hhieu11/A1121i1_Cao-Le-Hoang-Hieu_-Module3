create database if not exists quan_ly_ban_hang;
use quan_ly_ban_hang;

create table customer(
c_id int primary key auto_increment not null,
c_name varchar(30) not null,
c_age int
);
create table product(
p_id int primary key auto_increment not null,
p_name varchar(30),
p_price int 
);


create table `order`(
o_id int primary key auto_increment not null,
c_id int not null,
o_date datetime,
o_total_price decimal,
foreign key (c_id)references customer(c_id)
);

create table order_detail(
o_id int not null ,
p_id int not null,
od_qty int,
primary key(o_id, p_id),
foreign key(o_id)references `order`(o_id),
foreign key(p_id)references product(p_id)
);



