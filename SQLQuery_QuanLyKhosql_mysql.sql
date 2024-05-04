-- Cơ sở dữ liệu: quanlikho
DROP DATABASE IF EXISTS quanlikho;
CREATE DATABASE quanlikho;
USE quanlikho;

SET @@session.sql_mode='';
SET @@default_storage_engine=INNODB;

CREATE TABLE Account (
  TenDangNhap VARCHAR(100) NOT NULL,
  HovaTen NVARCHAR(100) NOT NULL,
  Email NVARCHAR(100) ,
  Password NVARCHAR(100) NOT NULL,
  Role NVARCHAR(10) NOT NULL,
  Enable INT NOT NULL , 
  PRIMARY KEY (TenDangNhap)
);

INSERT INTO Account (TenDangNhap, HovaTen, Email, Password, Role, Enable) VALUES
('admin', N'Họ và Tên 1', N'', '123', 'Admin', 1),
('nhaphang', N'Họ và Tên 2', N'', '123', 'NhapHang', 1),
('xuathang', N'Họ và Tên 3', N'', '123', 'XuatHang', 1),
('QLK', N'Họ và Tên 4', N'', '123', 'QuanLyKho', 1);

CREATE TABLE NhaCungCap(
    MaNCC VARCHAR(10) NOT NULL PRIMARY KEY , 
    TenNCC NVARCHAR(100) NOT NULL,
    DiaChiNCC NVARCHAR(100) NOT NULL , 
    SDTNCC NVARCHAR(20) NOT NULL , 
    GhiChu NVARCHAR(1000) 
);

INSERT INTO NhaCungCap(MaNCC , TenNCC , DiaChiNCC , SDTNCC , GhiChu ) VALUES
('NCC1' ,  N'NCC TP Đà Nẵng', N'Đà Nẵng', '123123123 ',N'Nhà Cung Cấp Số 1'),
('NCC2' ,  N'NCC TP Hà Nội', N'Hà Nội', '123123123  ',N'Nhà Cung Cấp Số 2'),
('NCC3' ,  N'NCC TP Hồ Chí Minh', N'Hồ Chí Minh', '123123123  ',N'Nhà Cung Cấp Số 3'),
('NCC4' ,  N'NCC TP Nha Trang', N'Nha Trang', '123123123  ',N'Nhà Cung Cấp Số 4'),
('NCC5' ,  N'NCC TP Huế', N'Huế', '123123123  ',N'Nhà Cung Cấp Số 5');

CREATE TABLE NhaSanXuat(
    MaNSX VARCHAR(10) NOT NULL PRIMARY KEY , 
    TenNSX NVARCHAR(100) NOT NULL 
);

INSERT INTO NhaSanXuat(MaNSX , TenNSX) VALUES
('NSX1', N'Việt Nam'),
('NSX2', N'Hàn Quốc'),
('NSX3', N'Trung Quốc'),
('NSX4', N'Thái Lan'),
('NSX5', N'Nhật Bản'),
('NSX6', N'Singapo');

CREATE Table Loai(
    MaLoai VARCHAR(10) NOT NULL PRIMARY KEY , 
    TenLoai NVARCHAR(100) NOT NULL 
);

INSERT INTO Loai(MaLoai , TenLoai) VALUES
('L1', N'Đàn Piano'),
('L2', N'Đàn Violin'),
('L3', N'Đàn Organ'),
('L4', N'Kèn-Sáo'),
('L5', N'Trống'),
('L6', N'Đàn Guitar');


CREATE TABLE SanPham(
    MaSP VARCHAR(10) NOT NULL PRIMARY KEY , 
    TenSP NVARCHAR(100) NOT NULL , 
    SoLuong INT NOT NULL , 
    Gia INT NOT NULL , 
    MaLoai VARCHAR(10) NOT NULL ,
    MaNSX VARCHAR(10) NOT NULL , 
    GhiChu NVARCHAR(1000),
    Enable int NOT NULL ,
    CONSTRAINT FK_SanPham_NhaSanXuat FOREIGN KEY (MaNSX) REFERENCES NhaSanXuat(MaNSX),
    CONSTRAINT FK_SanPham_Loai FOREIGN KEY (MaLoai) REFERENCES Loai(MaLoai)
);

INSERT INTO SanPham(MaSP , TenSP , SoLuong, Gia , MaLoai , MaNSX , GhiChu ,Enable ) VALUES
('SP1', N'Đàn Piano Apollo A8',21,550300 ,'L1', 'NSX1', N'Đàn guitar acoustic AZMUSIC J260 có hai 2 chất liệu sơn bóng và sơn mờ tạo ra sự lựa chọn với phân khúc guitar tầm trung.- Với chất liệu gỗ nguyên tấm, mặt trước được làm từ gỗ thông ( Spruce ) và lưng hông được làm từ gỗ ...' , 1),
('SP2', N'Đàn Violin Antonius Braun',11,252000 , 'L2', 'NSX1',  N'Đàn guitar acoustic AZMUSIC J260 có hai 2 chất liệu sơn bóng và sơn mờ tạo ra sự lựa chọn với phân khúc guitar tầm trung.- Với chất liệu gỗ nguyên tấm, mặt trước được làm từ gỗ thông ( Spruce ) và lưng hông được làm từ gỗ ...', 1),
('SP3', N'Đàn Violin Azmusic AZV130',15,155040 , 'L2', 'NSX5',   N'Đàn guitar acoustic AZMUSIC J260 có hai 2 chất liệu sơn bóng và sơn mờ tạo ra sự lựa chọn với phân khúc guitar tầm trung.- Với chất liệu gỗ nguyên tấm, mặt trước được làm từ gỗ thông ( Spruce ) và lưng hông được làm từ gỗ ...', 1),
('SP4', N'Đàn Violin Kapok V182',27,512400 , 'L2', 'NSX1',  N'Đàn guitar acoustic AZMUSIC J260 có hai 2 chất liệu sơn bóng và sơn mờ tạo ra sự lựa chọn với phân khúc guitar tầm trung.- Với chất liệu gỗ nguyên tấm, mặt trước được làm từ gỗ thông ( Spruce ) và lưng hông được làm từ gỗ ...', 1),
('SP5', N'Đàn Piano01',21,557000 , 'L1', 'NSX1',  N'Đàn guitar acoustic AZMUSIC J260 có hai 2 chất liệu sơn bóng và sơn mờ tạo ra sự lựa chọn với phân khúc guitar tầm trung.- Với chất liệu gỗ nguyên tấm, mặt trước được làm từ gỗ thông ( Spruce ) và lưng hông được làm từ gỗ ...', 1),
('SP6', N'Đàn Piano Yamaha W106',21,552000 , 'L1', 'NSX3',   N'Đàn guitar acoustic AZMUSIC J260 có hai 2 chất liệu sơn bóng và sơn mờ tạo ra sự lựa chọn với phân khúc guitar tầm trung.- Với chất liệu gỗ nguyên tấm, mặt trước được làm từ gỗ thông ( Spruce ) và lưng hông được làm từ gỗ ...', 1),
('SP7', N'Đàn Violin Kapok V188',1,525000 , 'L2', 'NSX1',  N'Đàn guitar acoustic AZMUSIC J260 có hai 2 chất liệu sơn bóng và sơn mờ tạo ra sự lựa chọn với phân khúc guitar tầm trung.- Với chất liệu gỗ nguyên tấm, mặt trước được làm từ gỗ thông ( Spruce ) và lưng hông được làm từ gỗ ...', 1),
('SP8', N'Đàn Guitar Acoustic J260',31,155000 , 'L6', 'NSX2',   N'Đàn guitar acoustic AZMUSIC J260 có hai 2 chất liệu sơn bóng và sơn mờ tạo ra sự lựa chọn với phân khúc guitar tầm trung.- Với chất liệu gỗ nguyên tấm, mặt trước được làm từ gỗ thông ( Spruce ) và lưng hông được làm từ gỗ ...', 1);

CREATE TABLE PhieuNhap(
    MaPN VARCHAR(10) NOT NULL PRIMARY KEY , 
    MaNCC VARCHAR(10) NOT NULL ,  
    NgayNhap DATE NOT NULL ,  
    TenDangNhap VARCHAR(100) NOT NULL,
        TongTien INT NOT NULL  , 
    CONSTRAINT FK_PhieuNhapHang_Account FOREIGN KEY (TenDangNhap) REFERENCES Account(TenDangNhap),
    CONSTRAINT FK_PhieuNhapHang_NhaCungCap FOREIGN KEY (MaNCC) REFERENCES NhaCungCap(MaNCC)
);

INSERT INTO PhieuNhap(MaPN , MaNCC ,NgayNhap,TenDangNhap ,TongTien ) VALUES 
('PN0001' , 'NCC2' ,  '2024-03-27' , 'admin' , 2751500 ),
('PN0002' , 'NCC2' ,  '2024-03-27' , 'admin' , 8136500),
('PN0003' , 'NCC5' , '2024-03-27'  , 'admin', 1260000);

CREATE TABLE ChiTietPN(
    MaSP VARCHAR(10) NOT NULL, 
    MaPN VARCHAR(10) NOT NULL,
    DonGiaNhap INT NOT NULL , 
    SoLuong INT NOT NULL , 
    PRIMARY KEY (MaSP, MaPN),
    CONSTRAINT FK_ChiTietPN_SanPham FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP),
    CONSTRAINT FK_ChiTietPN_PhieuNhap FOREIGN KEY (MaPN) REFERENCES PhieuNhap(MaPN)
);


INSERT INTO ChiTietPN(MaSP , MaPN , DonGiaNhap , SoLuong   ) VALUES
('SP1' , 'PN0001' , 550300 , 5  ),
('SP1' , 'PN0002' , 550300 , 5  ),
('SP6' , 'PN0002' , 552000 , 5  ),
('SP7' , 'PN0002' , 525000 , 5  ),
('SP2' , 'PN0003' , 252000 , 5  );



CREATE TABLE DaiLi(
    MaDL VARCHAR(10) NOT NULL PRIMARY KEY,
    TenDL VARCHAR(100) NOT NULL,
    SDT VARCHAR(100) NOT NULL,
    DiaChi VARCHAR(100) NOT NULL,
    Enable int NOT NULL 
);
INSERT INTO DaiLi(MaDL , TenDL , SDT , DiaChi , Enable ) VALUES
('DL1' , N'Đại Lí Hà Nội' , N'0384475805' , N'Hà Nội' , 1  ),
('DL2' , N'Đại Lí Đà Nẵng' , N'0384475805' , N'Đà Nẵng'  , 1),
('DL3' , N'Đại Lí Nha Trang' ,N'0384475805' , N'Nha Trang' , 1  ),
('DL4' , N'Đại Lí Hồ Chí Minh' ,N'0384475805' , N'Hồ Chí Minh' , 1   );


CREATE TABLE PhieuXuat(
    MaPX VARCHAR(10) NOT NULL PRIMARY KEY , 
    MaNCC VARCHAR(10) NOT NULL,
    ThoiGianTao DATE NOT NULL , 
    TenDangNhap VARCHAR(100) NOT NULL,
    MaDL VARCHAR(10) NOT NULL ,
    TongTien INT NOT NULL ,
    CONSTRAINT FK_PhieuXuat_Account FOREIGN KEY (TenDangNhap) REFERENCES Account(TenDangNhap),
    CONSTRAINT FK_PhieuXuat_NhaCungCap FOREIGN KEY (MaNCC) REFERENCES NhaCungCap(MaNCC),
    CONSTRAINT FK_PhieuXuat_DaiLi FOREIGN KEY (MaDL) REFERENCES DaiLi(MaDL)
);

INSERT INTO PhieuXuat(MaPX , MaNCC ,ThoiGianTao,TenDangNhap , MaDL  , TongTien) VALUES 
('PX0001' , 'NCC2' ,  '2024-03-27' , 'admin' ,  'DL1' , 3251500),
('PX0002' , 'NCC2' ,  '2024-03-27' , 'admin',  'DL3' , 9636500),
('PX0003' , 'NCC5' , '2024-03-27'  , 'admin',  'DL1' , 3260000);

CREATE TABLE ChiTietPX(
    MaSP VARCHAR(10) NOT NULL, 
    MaPX VARCHAR(10) NOT NULL,
    DonGiaXuat INT NOT NULL ,  
    SoLuong INT NOT NULL ,
    PRIMARY KEY (MaSP, MaPX),
    CONSTRAINT FK_ChiTietPX_SanPham FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP),
    CONSTRAINT FK_ChiTietPX_PhieuXuat FOREIGN KEY (MaPX) REFERENCES PhieuXuat(MaPX)
);

INSERT INTO ChiTietPX(MaSP , MaPX , DonGiaXuat , SoLuong   ) VALUES
('SP1' , 'PX0002' , 650300 , 5 ),
('SP1' , 'PX0001' , 650300 , 5 ),
('SP2' , 'PX0003' , 652000 , 5  ),
('SP6' , 'PX0002' , 652000 , 5 ),
('SP7' , 'PX0002' , 625000 , 5 );

