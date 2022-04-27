use furama_manager;

-- 2 .Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là
-- một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select * from nhan_vien 
where SUBSTRING(ho_ten,1,1) = 'H' or SUBSTRING(ho_ten,1,1) = 'T' or SUBSTRING(ho_ten,1,1) = 'K' and  length(ho_ten) <= 15;

-- 3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và
-- có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khach_hang
where (YEAR(CURDATE()) - YEAR(ngay_sinh)) >=18 and (YEAR(CURDATE()) - YEAR(ngay_sinh)) <=50 and dia_chi like "%Đà Nẵng%" or dia_chi like "%Quảng Trị%";

-- 4. Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu
-- lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của
-- khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select khach_hang.ma_khach_hang,ho_ten,count(khach_hang.ho_ten) as so_lan_dat_phong
from khach_hang inner join loai_khach
on khach_hang.ma_loai_khach=loai_khach.ma_loai_khach
inner join hop_dong
on khach_hang.ma_khach_hang=hop_dong.ma_khach_hang
where loai_khach.ten_loai_khach="Diamond"
group by khach_hang.ho_ten
order by so_lan_dat_phong ;

-- 5.Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong,
-- ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien (Với
-- tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng *
-- Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem,
-- hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những
-- khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

select khach_hang.ma_khach_hang,khach_hang.ho_ten,loai_khach.ten_loai_khach,hop_dong.ma_hop_dong,
dich_vu.ten_dich_vu,hop_dong.ngay_lam_hop_dong,hop_dong.ngay_ket_thuc, dich_vu.chi_phi_thue+hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia as tong_tien
from khach_hang inner join loai_khach on khach_hang.ma_loai_khach=loai_khach.ma_loai_khach
inner join hop_dong on khach_hang.ma_khach_hang=hop_dong.ma_khach_hang
inner join dich_vu on hop_dong.ma_dich_vu= dich_vu.ma_dich_vu
inner join hop_dong_chi_tiet on hop_dong.ma_hop_dong=hop_dong_chi_tiet.ma_hop_dong
inner join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem=dich_vu_di_kem.ma_dich_vu_di_kem
order by ma_khach_hang asc;

-- 6.Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue,
-- ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng
-- thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).

Select distinct dv.ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu 
from dich_vu dv  inner join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
where dv.ma_dich_vu not in (Select dv.ma_dich_vu 
from dich_vu dv inner join hop_dong hd on hd.ma_dich_vu = dv.ma_dich_vu

 where Year(ngay_lam_hop_dong) = 2021 and (month(ngay_lam_hop_dong) = 1 or month(ngay_lam_hop_dong) = 2 or month(ngay_lam_hop_dong) = 3));
 
 -- 7. Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich,
-- so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại
-- dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng
-- chưa từng được khách hàng đặt phòng trong năm 2021.


select 









