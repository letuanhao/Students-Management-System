USE master
GO
IF EXISTS
(
	SELECT * 
	FROM   master..sysdatabases 
	WHERE  name = N'QL_hoc_sinh'
)
DROP DATABASE QL_hoc_sinh
GO

CREATE DATABASE QL_hoc_sinh
ON
(
	NAME		= 'QL_hoc_sinh',
	FILENAME	= 'D:\doan_QL_hoc_sinh\Database\QL_hoc_sinh.MDF',
	SIZE		= 20,
	MAXSIZE		= UNLIMITED,
	FILEGROWTH	= 5
)
GO

Use QL_hoc_sinh
Go
--Dân tộc
CREATE TABLE DanToc(
MaDanToc VARchar(10) primary key,
TenDanToc nvarchar(20) not null
)
--Tôn giáo
CREATE TABLE TonGiao(
MaTonGiao VARchar(10) primary key,
TenTonGiao nvarchar(20) not null
)
--Diện chính sách
CREATE TABLE DienChinhSach(
MaChinhSach VARChar(10) NOT NULL Primary Key,
TenChinhSach NVARChar(10) NOT NULL ,
MucHoTro int check(MucHoTro>=0) default (0)
);
--Học sinh
CREATE TABLE  HocSinh(
MaHS VARChar(10) NOT NULL Primary Key,
SoHieu VARChar(15) not null unique,
HoTenHS NVarChar(40) NOT NULL,
MaDanToc VARchar(10) not null FOREIGN KEY REFERENCES DanToc(MaDanToc),
MaChinhSach VARchar(10) not null FOREIGN KEY REFERENCES DienChinhSach(MaChinhSach),
MaTonGiao varchar(10) not null FOREIGN KEY REFERENCES TonGiao(MaTonGiao),
GioiTinh NVarChar(5) NOT NULL,
DiaChi NVarChar(200) NOT NULL,
DienThoai NVarchar(20) ,
Ghichu NVarChar(200), 
trangthai nvarchar(20)
);
--Giáo viên
CREATE TABLE GiaoVien(
MaGV VARChar(10) Primary Key,
HoTenGV NVarChar(40) NOT NULL,
GioiTinh NVarChar(5) NOT NULL,
DiaChi NVarChar(200) NOT NULL,
ChuyenMon NVarChar(25) NOT NULL,
TrinhDo nvarchar(25) NOT NULL,
DienThoai NVarchar(20) ,
GhiChu nvarchar(200),
);
--Môn học
CREATE TABLE MonHoc(
MaMonHoc VARChar(10) NOT NULL Primary Key,
TenMonHoc NVarChar(20) NOT NULL ,
heso int not null default(1)
);
--Năm học
CREATE TABLE NamHoc(
MaNamHoc VARChar(10) NOT NULL Primary Key,
Namhoc VARChar(20) NOT NULL unique
);
--Học kì
CREATE TABLE HocKi(
MaHocKi VARChar(5) NOT NULL Primary Key,
HocKi NVARChar(10) NOT NULL,
heso int not null default(1)
);
--Lớp
CREATE TABLE Lop(
Malop VARChar(5) NOT NULL Primary Key,
Tenlop NVARChar(10) NOT NULL
);
--Điểm chi tiết
CREATE TABLE DiemChiTiet(
MaDiem VARChar(5) NOT NULL Primary Key,
DiemChiTiet nvarchar(20) not null unique,
heso int not null default(1)
);
--học phí
CREATE TABLE HocPhi(
MaHocPhi VARChar(10) NOT NULL Primary Key,
HocPhi float check (HocPhi>=0)
);
--Năm học học kì
create table NamHocki(
MaNamHocki int not null primary key identity(1,1),
MaNamHoc VARChar(10) NOT NULL FOREIGN KEY REFERENCES NamHoc(MaNamHoc),
MaHocKi VARChar(5) NOT NULL FOREIGN KEY REFERENCES HocKi(MaHocKi),
constraint unique_namhoc_hocki unique(MaNamHoc,MaHocKi)
)
--Đóng học phí
create table DongHocPhi
(
MaHocPhi VARChar(10) NOT NULL FOREIGN KEY REFERENCES HocPhi(MaHocPhi),
MaNamHocki int NOT NULL FOREIGN KEY REFERENCES NamHocki(MaNamHocki),
MaHS VARChar(10) NOT NULL FOREIGN KEY REFERENCES HocSinh(MaHS),
HocPhi float check (HocPhi>=0),
DaDongTien BIT,
primary key(MaHS,MaNamHocki,MaHocPhi)
);
--Điểm học sinh
create table DiemHocSinh
(
STT int primary key identity(1,1),
MaHS VARChar(10) NOT NULL FOREIGN KEY REFERENCES HocSinh(MaHS),
MaMonHoc VARChar(10) NOT NULL FOREIGN KEY REFERENCES MonHoc(MaMonHoc),
MaNamHocki int NOT NULL FOREIGN KEY REFERENCES NamHocki(MaNamHocki),
MaDiem VARChar(5) not null foreign key references DiemChiTiet(MaDiem),
DiemSo decimal(4,2)
);
--Học sinh thuộc lớp
create table HocSinhLop
(
MaHS VARChar(10) NOT NULL FOREIGN KEY REFERENCES HocSinh(MaHS),
MaNamHocki int NOT NULL FOREIGN KEY REFERENCES NamHocki(MaNamHocki),
Malop VARChar(5) NOT NULL FOREIGN KEY REFERENCES LOP(Malop),
primary key(MaHS,MaNamHocki,Malop)
);
--Tổng kết môn học
create table TongKetMon(
MaHS VARChar(10) NOT NULL FOREIGN KEY REFERENCES HocSinh(MaHS),
MaNamHocki int NOT NULL FOREIGN KEY REFERENCES NamHocki(MaNamHocki),
MaMonHoc VARChar(10) NOT NULL FOREIGN KEY REFERENCES MonHoc(MaMonHoc),
DiemTongKet decimal(4,2) not null check(DiemTongKet>=0),
TS_buoi_hoc int not null CHECK(TS_buoi_hoc>=0),
TS_buoi_P int NOT NULL CHECK(TS_buoi_P>=0),
TS_buoi_KP int NOT NULL CHECK (TS_buoi_KP>=0)
primary key(MaHS,MaNamHocki,MaMonHoc)
);
--Đánh giá Học sinh
Create table DanhGiaHocSinh(
MaHS VARChar(10) NOT NULL FOREIGN KEY REFERENCES HocSinh(MaHS),
MaNamHocki int NOT NULL FOREIGN KEY REFERENCES NamHocki(MaNamHocki),
HanhKiem Nvarchar (10) NOT NULL,
HocLuc NVARCHAR (10) NOT NULL,
DiemTB_HK DECIMAL(4,2) NOT NULL CHECK(DiemTB_HK>=0)
primary key(MaHS,MaNamHocki)
);
--Giáo viên chủ nhiệm
create table GVCN
(
MaGV VARChar(10) NOT NULL FOREIGN KEY REFERENCES GiaoVien(MaGV),
MaNamHocki int NOT NULL FOREIGN KEY REFERENCES NamHocki(MaNamHocki),
Malop VARChar(5) NOT NULL FOREIGN KEY REFERENCES LOP(Malop)
primary key(MaGV,MaNamHocki,Malop)
)
--Giáo viên bộ môn
create table GiaoVienBoMon(
Malop VARChar(5) NOT NULL FOREIGN KEY REFERENCES LOP(Malop),
MaNamHocki int NOT NULL FOREIGN KEY REFERENCES NamHocki(MaNamHocki),
MaGV VARChar(10) not null FOREIGN KEY REFERENCES GiaoVien(MaGV),
MaMonHoc VARChar(10) NOT NULL FOREIGN KEY REFERENCES MonHoc(MaMonHoc),
primary key(Malop,MaNamHocki,MaGV,MaMonHoc)
)

