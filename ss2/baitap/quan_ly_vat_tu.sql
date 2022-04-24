create database if not exists quan_ly_vat_lieu;
use quan_ly_vat_lieu;

create table nha_cung_cap(
ma_ncc varchar(20) primary key not null,
ten_ncc varchar(30),
dia_chi varchar(50),
sdt varchar(20) 
);


create table phieu_xuat(
so_px int primary key not null,
ngay_xuat datetime


);
create table phieu_nhap(
so_pn int primary key not null,
ngay_nhap datetime


);

create table don_dh(
so_dh int primary key not null,
ngay_dh datetime,
ma_ncc varchar(20),
foreign key (ma_ncc) references nha_cung_cap(ma_ncc)


);

create table vat_tu(
ma_vtu varchar(20) primary key not null,
ten_vtu varchar(30) 


);

create table phieu_xuat_vat_tu(
phieu_xuat_so_px int ,
vat_tu_ma_vtu varchar(20),
dg_xuat varchar(20),
sl_xuat varchar(20),
primary key(phieu_xuat_so_px,vat_tu_ma_vtu),
foreign key (phieu_xuat_so_px) references phieu_xuat(so_px),
foreign key(vat_tu_ma_vtu) references vat_tu(ma_vtu)

);
create table phieu_nhap_vat_tu(
phieu_nhap_so_pn int ,
vat_tu_ma_vtu varchar(20),
dg_nhap varchar (20),
sl_nhap varchar (20),
primary key (phieu_nhap_so_pn, vat_tu_ma_vtu),
foreign key (phieu_nhap_so_pn) references phieu_nhap(so_pn),
foreign key(vat_tu_ma_vtu)references vat_tu(ma_vtu)

);
create table don_dh_vat_tu(
don_dh_so_dh int ,
vat_tu_ma_vtu varchar(20),
primary key(don_dh_so_dh,vat_tu_ma_vtu ),
foreign key (don_dh_so_dh) references don_dh(so_dh),
foreign key(vat_tu_ma_vtu)references vat_tu(ma_vtu)

);
