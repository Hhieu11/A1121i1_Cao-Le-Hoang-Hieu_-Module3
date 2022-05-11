use furama_manager;


-- 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” và
-- đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.


create view v_nhan_vien  as 
select nhan_vien.ma_nhan_vien,ho_ten,dia_chi
from nhan_vien
inner join hop_dong on nhan_vien.ma_nhan_vien=hop_dong.ma_hop_dong
where nhan_vien.dia_chi like"%Hải Châu%" and date_format(hop_dong.ngay_lam_hop_dong,'%d%m%y');

-- 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
SET SQL_SAFE_UPDATES = 0;
update v_nhan_vien
set dia_chi="%Liên Chiểu%";

-- 23.	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó với ma_khach_hang được 
-- truyền vào như là 1 tham số của sp_xoa_khach_hang
delimiter //
create procedure sp_xoa_khach_hang(p_key int )
begin
delete from khach_hang where ma_khach_hang=p_key;
end
// delimiter 
sET FOREIGN_KEY_CHECKS=0;
call sp_xoa_khach_hang(2);
SET FOREIGN_KEY_CHECKS=1;

-- 24.Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong
-- phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.

delimiter //
create procedure  sp_them_moi_hop_dong(IN ma_hop_dong_in int, ngay_lam_hop_dong_in datetime, ngay_ket_thuc_in datetime,
 tien_dat_coc_in double,ma_nhan_vien_in int,ma_khach_hang_in int,ma_dich_vu_in int)
 begin
 set ma_hop_dong_in = (select  max(ma_hop_dong)from hop_dong) + 1;
 insert into hop_dong(ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ma_nhan_vien, ma_khach_hang, ma_dich_vu)
 value ( ma_hop_dong_in, ngay_lam_hop_dong_in, ngay_ket_thuc_in, tien_dat_coc_in, ma_nhan_vien_in, ma_khach_hang_in, ma_dich_vu_in);
 
 end
// delimiter 
sET FOREIGN_KEY_CHECKS=0;
call sp_them_moi_hop_dong(@id, '2022-07-22', '2022-08-21', 200000, 1,2,3);
sET FOREIGN_KEY_CHECKS=1;



-- 25 	Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì hiển thị tổng số lượng bản ghi
--  còn lại có trong bảng hop_dong ra giao diện console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.

delimiter //
create trigger tr_xoa_hop_dong 
after delete on hop_dong for each row
begin
declare so_hop_dong int ;
declare `error` varchar(50);
set so_hop_dong=(select count(hop_dong.ma_hop_dong)from (select * from hop_dong)as hd);
set `error` = (select concat('so hop dong con lai la: ', so_hop_dong));
 SELECT `error` AS LOG INTO OUTFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/log.txt';

end

// delimiter 

delete from hop_dong
where hop_dong.ma_hop_dong = 2;










