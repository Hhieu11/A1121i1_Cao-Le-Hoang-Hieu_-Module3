use quan_ly_ban_hang;
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order --
select `order`.o_id,o_date,o_total_price
from `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách --
select distinct customer.*
from `order`
inner join customer  on `order`.c_id= customer.c_id;
-- union
-- select distinct customer.*


--  Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào --
select distinct customer.*
from `order`
right join customer  on `order`.c_id= customer.c_id








