use classicmodels;

create view customer_views as
select  customerNumber, customerName, phone

FROM  customers;

select * from customer_views;

-- --
create or replace view customer_views  as
select  customerNumber, customerName, contactFirstName, contactLastName, phone

FROM customers
where city='Nantes';

-- --
DROP VIEW customer_views;