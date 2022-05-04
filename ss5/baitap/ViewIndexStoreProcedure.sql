create database if not exists product_management;
use product_management;


create table products(
id int primary key auto_increment,
product_code int,
product_name varchar(50),
product_price float,
product_amount int,
product_description varchar(100),
product_status bit
);
insert into products(product_code,product_name,product_price,product_amount,product_description,product_status)
values (4324,'r',3243,324324,'hhh',3),(123,'tt',1234,31231,'hehe',2),(440,'bb',23,55,'hiuhiu',1),(1231,'vv',227,53,'iiuu',2),(1123,'kk',123,11,'vopvop',2);

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create unique index idx_product_code 
on products(product_code);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index idx_name_product
on products(product_name, product_code);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select * from products 
where product_name = 'hiuhiu';


-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products
create view view_products as 
select product_code,product_name,product_price, product_status
from products;

-- Tiến hành sửa đổi view
create or replace view view_products as
select product_code,product_name
from products;

update view_products
set product_name = 'new name'
where product_code = 123;

-- Tiến hành xoá view
drop view view_products;


-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
delimiter //
-- drop procedure if exists view_all//
create procedure view_all()
begin 
select * from products;
end //
delimiter ;

call view_all();

-- Tạo store procedure thêm một sản phẩm mới
delimiter //
-- drop procedure if exists add_product//
create procedure add_product(
pcode int, pname varchar(50), pprice float, pamount int, pdes varchar(100),pstatus bit
)
begin 
insert into products(product_code,product_name,product_price,product_amount,product_description,product_status)
values (pcode,pname,pprice,pamount,pdes,pstatus);
end//
delimiter ;

call add_product(222,'new product',13,12,'hieu',1);

-- Tạo store procedure sửa thông tin sản phẩm theo id
delimiter //
drop procedure if exists edit_by_id//
create procedure edit_by_id(
id int,pcode int, pname varchar(50), pprice float, pamount int, pdes varchar(100),pstatus bit
)
begin 
update products
set product_code = pcode, product_name = pname,product_price = pprice,product_amount = pamount,product_description = pdes,product_status = pstatus
where products.id = id;
end //
delimiter ;

call edit_by_id(12,23,'b',34,56,'edit',0);

-- Tạo store procedure xoá sản phẩm theo id
delimiter //
drop procedure del_by_id//
create procedure del_by_id(
id int
)
begin
delete from products
where products.id = id;
end//
delimiter ;

call del_by_id(4);