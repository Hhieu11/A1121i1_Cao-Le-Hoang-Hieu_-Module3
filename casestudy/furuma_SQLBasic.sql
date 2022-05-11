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

select dich_vu.ma_dich_vu,ten_dich_vu,dien_tich,so_nguoi_toi_da,chi_phi_thue,loai_dich_vu.ten_loai_dich_vu
from dich_vu inner join loai_dich_vu on dich_vu.ma_loai_dich_vu=loai_dich_vu.ma_loai_dich_vu
inner join hop_dong on dich_vu.ma_dich_vu =hop_dong.ma_dich_vu where dich_vu.ma_dich_vu in
(select ma_dich_vu from hop_dong
where year(ngay_lam_hop_dong)=2020 and ma_dich_vu not in
(select ma_dich_vu from hop_dong
where year( ngay_lam_hop_dong)=2021)
group by ma_dich_vu)
group by dich_vu.ma_dich_vu;

-- 8. Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.--
select distinct ho_ten
from khach_hang;
-- group by ho_ten

-- 9. Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi
-- tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

select month(ngay_lam_hop_dong)as thang, count(month(ngay_lam_hop_dong))as so_luong
from hop_dong
where year(ngay_lam_hop_dong)=2021
group by month(ngay_lam_hop_dong)
order by month(ngay_lam_hop_dong);

-- 10. Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu
-- dịch vụ đi kèm. Kết quả hiển thị bao gồm ma_hop_dong,
-- ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc,
-- so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).

select hop_dong.ma_hop_dong,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,sum(hop_dong_chi_tiet.so_luong) as so_luong
from hop_dong
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
group by hop_dong.ma_hop_dong;



-- câu 11 Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách
-- hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.

select dich_vu_di_kem.ma_dich_vu_di_kem , ten_dich_vu_di_kem
from hop_dong
inner join khach_hang on hop_dong.ma_khach_hang=khach_hang.ma_khach_hang
inner join loai_khach on khach_hang.ma_loai_khach=loai_khach.ma_loai_khach
inner join hop_dong_chi_tiet on hop_dong.ma_hop_dong=hop_dong_chi_tiet.ma_hop_dong
inner join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem=dich_vu_di_kem.ma_dich_vu_di_kem
where loai_khach.ten_loai_khach like"%Diamond%" 
and khach_hang.dia_chi like "%Vinh%"
or  khach_hang.dia_chi like "%Quảng Ngãi%";

-- 12. Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách_hàng), so_dien_thoai (khách hàng), ten_dich_vu,so_luong_dich_vu_di_kem
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ đã từng được
-- khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021

 select hop_dong.ma_hop_dong,nhan_vien.ho_ten,khach_hang.ho_ten,khach_hang.so_dien_thoai,dich_vu.ten_dich_vu, sum(hop_dong_chi_tiet.so_luong) as so_luong,
 hop_dong.tien_dat_coc
 from hop_dong
 inner join nhan_vien on hop_dong.ma_nhan_vien=nhan_vien.ma_nhan_vien
 inner join khach_hang on hop_dong.ma_khach_hang=khach_hang.ma_khach_hang
 inner join dich_vu on hop_dong.ma_dich_vu=dich_vu.ma_dich_vu
 left join hop_dong_chi_tiet on hop_dong.ma_hop_dong=hop_dong_chi_tiet.ma_hop_dong
 -- inner join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem=dich_vu_di_kem.ma_dich_vu_di_kem

 where year(ngay_lam_hop_dong)=2020 and month(ngay_lam_hop_dong)>=9 and month(ngay_lam_hop_dong)<=12 and hop_dong.ma_hop_dong not in
 (select ma_hop_dong from hop_dong
 where year(ngay_lam_hop_dong)=2021 and month(ngay_lam_hop_dong)>=1 and month(ngay_lam_hop_dong)<=6)
 group by hop_dong.ma_hop_dong;

 -- 13 Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các
-- Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).4


CREATE VIEW v_dv_max AS
SELECT 
		dvdk.ma_dich_vu_di_kem,
        ten_dich_vu_di_kem,
		SUM(hdct.so_luong) AS so_luong
FROM
		hop_dong_chi_tiet as hdct 
INNER JOIN		dich_vu_di_kem as dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
GROUP BY ma_dich_vu_di_kem;

SELECT 
    *
FROM
    v_dv_max
WHERE
    so_luong = (SELECT MAX(so_luong) FROM v_dv_max);
    
 -- cach 2 --
 
Select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) as so_luong_dich_vu_di_kem
from dich_vu_di_kem dvdk
inner join hop_dong_chi_tiet hdct on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by hdct.ma_dich_vu_di_kem
order by so_luong_dich_vu_di_kem desc
limit 2;

-- 14 Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm ma_hop_dong,
-- ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).

select * from (
select hop_dong.ma_hop_dong,loai_dich_vu.ten_loai_dich_vu,dich_vu_di_kem.ten_dich_vu_di_kem,count(dich_vu_di_kem.ma_dich_vu_di_kem) as so_lan_su_dung
from hop_dong 
inner join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
inner join loai_dich_vu on dich_vu.ma_loai_dich_vu=loai_dich_vu.ma_loai_dich_vu
inner join hop_dong_chi_tiet on hop_dong.ma_hop_dong=hop_dong_chi_tiet.ma_hop_dong
inner join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem= dich_vu_di_kem.ma_dich_vu_di_kem

group by dich_vu_di_kem.ma_dich_vu_di_kem) as h

where so_lan_su_dung=1
order by ma_hop_dong;


-- 15. Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được
-- tối đa 3 hợp đồng từ năm 2020 đến 2021.

select nhan_vien.ma_nhan_vien,nhan_vien.ho_ten,trinh_do.ten_trinh_do,bo_phan.ma_bo_phan,nhan_vien.so_dien_thoai,nhan_vien.dia_chi
from nhan_vien 
inner join hop_dong on nhan_vien.ma_nhan_vien=hop_dong.ma_nhan_vien
inner join trinh_do on nhan_vien.ma_trinh_do=trinh_do.ma_trinh_do
inner join bo_phan on nhan_vien.ma_bo_phan=bo_phan.ma_bo_phan
group by nhan_vien.ma_nhan_vien
having count(hop_dong.ma_hop_dong)<=3;

-- 16. Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.--
SET SQL_SAFE_UPDATES = 0;
delete from nhan_vien where ma_nhan_vien
not in 
(select nhan_vien.ma_nhan_vien from (select * from nhan_vien ) as nv
inner join hop_dong on nv.ma_nhan_vien= hop_dong.ma_nhan_vien
where year(ngay_lam_hop_dong) in ("2019","2020","2021"));

-- 17 Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với
-- Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
 
 
update 	khach_hang
    set 	ma_loai_khach = 1
    where 	ma_khach_hang in (
					select 	kh.ma_khach_hang 
                    from 	(select * from khach_hang) as kh
					inner join (
							select 	ma_khach_hang, sum(dich_vu.chi_phi_thue) as tong_thanh_toan 
                            from 	hop_dong
							inner join 	dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
							where 	year(ngay_ket_thuc) = 2021
							group by	 ma_khach_hang
                            ) as hello
					on hello.ma_khach_hang = kh.ma_khach_hang
					where 	kh.ma_loai_khach = 2 
							and hello.tong_thanh_toan >= 10000000
					);


-- 18 Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).

sET FOREIGN_KEY_CHECKS=0;
delete from khach_hang where ma_khach_hang in(
select ma_khach_hang from hop_dong
where year(ngay_ket_thuc)<2021);
SET FOREIGN_KEY_CHECKS=1;


-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi. --

UPDATE dich_vu_di_kem 
SET 
    gia = gia * 2
WHERE
    ma_dich_vu_di_kem IN (SELECT 
            h.ma_dich_vu_di_kem
        FROM
            (SELECT 
                *
            FROM
                dich_vu_di_kem) AS dich_vu_di_kem
                JOIN
            (SELECT 
                hop_dong_chi_tiet.ma_dich_vu_di_kem,
                    SUM(hop_dong_chi_tiet.so_luong) AS so_lan
            FROM
                hop_dong
            INNER JOIN hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
            WHERE
                YEAR(ngay_lam_hop_dong) = 2020
            GROUP BY hop_dong_chi_tiet.ma_hop_dong_chi_tiet) AS h ON dich_vu_di_kem.ma_dich_vu_di_kem = h.ma_dich_vu_di_kem
        WHERE
            h.so_lan >= 10);

-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.--

select 	ma_nhan_vien as id, ho_ten
			, email, so_dien_thoai, ngay_sinh, dia_chi  
	from 	nhan_vien 
    union all
    select 	ma_khach_hang, ho_ten, email
			, so_dien_thoai, ngay_sinh, dia_chi 
	from khach_hang
    











