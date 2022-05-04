use classicmodels;

delimiter //
create procedure find_all_customers()
begin
select * from customers;
end ;

// delimiter 
call find_all_customers;

-- -- 


DELIMITER //
DROP PROCEDURE IF EXISTS `findAllCustomers`//

CREATE PROCEDURE findAllCustomers()

BEGIN

SELECT * FROM customers where customerNumber = 175;

END;

// delimiter 
