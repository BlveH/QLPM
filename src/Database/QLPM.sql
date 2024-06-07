/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  HL94NVT
 * Created: Jun 18, 2020
 */


create database QLPM;
use QLPM;
create table accounts
(
	id int primary key auto_increment,
    magiaovien nchar(5) unique,
    passwords varchar(20),
    roles varchar(10)
);
insert into accounts values(1,'GV1','123456','ADMIN'),
(2,'GV2','123456','GIAOVIEN')
create table phanmem(
	maphanmem char(5) not null primary key,
    tenphanmem nvarchar(20) not null
);

create table may(
	mamay char(5) not null primary key,
	
    cauhinhmay nvarchar(20) not null,
	tinhtrangmay nvarchar(10) not null,
    maphanmem char(5),
    constraint FK_may_phanmem foreign key (maphanmem) references phanmem(maphanmem)
);

create table phongmay(
	maphongmay char(5) not null primary key,
    vitri nvarchar(20) not null,
    mamay char(5) not null, 
	constraint FK_phongmay_may foreign key (mamay) references may(mamay)
);

create table giaovien(
	magiaovien char(5) not null primary key,
    tengiaovien nvarchar(20) not null,
    hocvi nvarchar(20),
    ngaycong int
);

create table monhoc(
	mamonhoc char(5) not null primary key,
    tenmonhoc nvarchar(20) not null,
    cauhinhmay nvarchar(20),
    maphanmem char(5) not null,
    constraint FK_monhoc_phanmem foreign key (maphanmem) references phanmem(maphanmem)
);
create table lichtruc(
    magiaovien char(5) not null,
    ngaytruc date, 
    ghichu nvarchar(255),
    
    constraint primary key ( ngaytruc),
    constraint fk_ligiaovien foreign key (magiaovien) references giaovien(magiaovien)
);
create table dangkysudung(
	madangky char(5) not null primary key,
	maphongmay char(5) not null,
    magiaovien char(5) not null,
    mamonhoc char(5) not null,
    batdau date not null,
    ketthuc date not null,
    constraint FK_lichtruc_phongmay foreign key (maphongmay) references phongmay(maphongmay),
    constraint FK_lichtruc_giaovien foreign key (magiaovien) references giaovien(magiaovien),
    constraint FK_lichtrgiaovienuc_monhoc foreign key (mamonhoc) references monhoc(mamonhoc)
);
insert into phanmem
    values	('PM12','netbean'),
			('PM13','coccoc'),
            ('PM14','word'),
            ('PM15','execl'),
            ('PM16','powerpoint'),
            ('PM17','chrome'),
	 ('PM18','sql sever');
	insert into may
    values  ('MM1','corei5','Tot','PM12'),
	    ('MM2','corei7','Tot','PM14'),
            ('MM3','corei5','Tot','PM16'),
            ('MM4','corei7','Tot','PM13'),
            ('MM5','corei5','Tot','PM15'),
            ('MM6','corei5','Tot','PM17'),
            ('MM7','corei7','Tot','PM18');
    insert into phongmay
    values 	('P1a','Tang1','MM1'),
                ('P4a','Tang1','MM1'),
                ('P4b','Tang1','MM2'),
		('P1b','Tang1','MM2'),
            ('P1c','Tang1','MM3'),
            ('P3a','Tang3','MM4'),
            ('P3b','Tang3','MM5'),
            ('P2a','Tang2','MM6'),
            ('P2b','Tang2','MM7');
	insert into giaovien
    values 	('GV1','Nguyen Thi A','Thac Si',0),
			('GV2','Nguyen Van C','Thac Si',0),
            ('GV3','Nguyen Van B','Thac Si',0),
            ('GV4','Nguyen Thi C','Thac Si',0),
            ('GV5','Nguyen Thi T','Thac Si',0),
            ('GV6','Nguyen Van D','Thac Si',0),
            ('GV7','Nguyen Thi F','Thac Si',0);
	insert into monhoc
    values 	('Mon1','JAVA','corei5','PM12'),
			('Mon2','SQL','corei7','PM18'),
            ('Mon3','XML','corei5','PM16'),
            ('Mon4','Nhap mon tin hoc','corei7','PM14'),
            ('Mon5','Quan Li Du An','corei5','PM15'),
            ('Mon6','Mang May Tinh','corei7','PM13'),
            ('Mon7','Tieng ANH CNTT','corei5','PM17');

insert into dangkysudung
    values 	('LT1','P1a','GV1','mon1','2020-06-03','2020-06-03'),
			('LT2','P1b','GV2','mon4','2020-06-04','2020-06-04'),
            ('LT3','P1c','GV3','mon3','2020-06-05','2020-06-05'),
            ('LT4','P2a','GV4','mon7','2020-06-06','2020-06-06'),
            ('LT5','P2b','GV5','mon2','2020-06-07','2020-06-07'),
            ('LT6','P3a','GV6','mon6','2020-06-03','2020-06-03'),
            ('LT7','P3b','GV7','mon5','2020-06-03','2020-06-03');
            insert into lichtruc values('GV3', '2020-06-04', N'Buổi trực đầu tiên');
drop database qlpm;
select * from monhoc;
select * from lichtruc;
select * from giaovien;
select * from phongmay;
select * from may;
select * from dangkysudung;
SET SQL_SAFE_UPDATES = 0;
delete from lichtruc where batdau='0000-00-00 00:00:00';

delete from dangkysudung;

insert into lichtruc
    values 	('LT8','P1a','GV1','mon1','2020-06-03 20:20:20','2020-06-03 20:20:20'),
CREATE TRIGGER `trigger_delete_phongmay_delete_lichdk` BEFORE DELETE ON `phongmay`
 FOR EACH ROW DELETE from dangkysudung WHERE maphongmay=OLD.maphongmay

 CREATE TRIGGER `trigger_delete_giaovien_delete_lichsudung` BEFORE DELETE ON `giaovien`
 FOR EACH ROW DELETE from dangkysudung WHERE magiaovien=OLD.magiaovien
 CREATE TRIGGER `trigger_delete_giaovien_delete_lichtruc1` BEFORE DELETE ON `giaovien`
 FOR EACH ROW DELETE from lichtruc WHERE magiaovien=OLD.magiaovien
 drop trigger trigger_delete_phongmay_delete_lichsudung;
    