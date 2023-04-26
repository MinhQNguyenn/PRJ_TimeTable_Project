create database Project
use Project

create table Course(
	CourseID int,
	Semester int,
	Name nvarchar(30),
	primary key(CourseID, Semester)
)

create table Class(
	Name nvarchar(30) primary key,
	Semester int,
	CourseID int, 
	Foreign key(CourseID, Semester) references Course(CourseID, Semester)
)

create table Student(
	StudentID int primary key,
	Name nvarchar(30) not null,
	Password nvarchar(30),
	Email nvarchar(30),
	DOB date,
	Gender nvarchar(10),
	Class nvarchar(30) references Class(Name),
	Facility nvarchar(20),
	Semester int 	
)

ALTER TABLE Student
ADD CHECK (Email like '%@fpt.edu.vn');
 
 create table Subject(
	Name nvarchar(15),
	Day int,
	Slot int,
	CourseID int,
	Semester int,
	Class nvarchar(30) references Class(Name),
	Foreign key(CourseID, Semester) references Course(CourseID, Semester),
	Primary key(name, day, slot)
 )
 
 create table Admin(
	Name nvarchar(15) primary key,
	Email nvarchar(30),
	Password nvarchar(30), 
	Facility nvarchar(20)
)


--INSERT THE DATA
--Insert admin
Insert into Admin 
values ('admin', 'admin@fpt.edu.vn', '123','hola')

--Insert course
select * from Course
Insert into Course
values
(1, 1, 'Software Engineering'),
(1, 2, 'Software Engineering'),
(1, 3, 'Software Engineering'),
(1, 4, 'Software Engineering'),
(1, 5, 'Software Engineering'),
(1, 6, 'Software Engineering'),
(2, 1, 'Artificial Intelligent'),
(2, 2, 'Artificial Intelligent'),
(2, 3, 'Artificial Intelligent'),
(2, 4, 'Artificial Intelligent'),
(2, 5, 'Artificial Intelligent'),
(2, 6, 'Artificial Intelligent'),
(3, 1, 'Information Assurance'),
(3, 2, 'Information Assurance'),
(3, 3, 'Information Assurance'),
(3, 4, 'Information Assurance'),
(3, 5, 'Information Assurance'),
(3, 6, 'Information Assurance')

--Insert to class
select * from Class
Insert into Class
values('SE1701', 3, 1),
('SE1512', 6, 1),
('AI1605', 5, 2),
('IS1701', 2, 3)


--Insert into Student
select * from Student
Insert into Student
values
(1, N'Nguyễn Văn A', '1234', 'anv12@fpt.edu.vn', '2003-01-16','Male', 'SE1701', 'Hola', 3),
(2, N'Đặng Quang B', '2345', 'bdq234@fpt.edu.vn', '2003-07-23','Male', 'SE1701', 'Hola', 3),
(3, N'Phạm Hồng C', '3456', 'cph345@fpt.edu.vn', '2002-2-24','Female', 'AI1605', 'Hola', 5),
(4, N'Đào Anh D', '4567', 'dad456@fpt.edu.vn', '2001-01-04', 'Female', 'SE1512', 'Xavalo', 6),
(5, N'Nguyễn Đắc E', '5678', 'edn567@fpt.edu.vn', '2003-10-23','Male', 'IS1701', 'Hovilo', 2)


--Insert into Subject
select * from subject
Insert into Subject
values
('PRO-192', 1, 1, 3, 2, 'IS1701'),
('PRO-192', 3, 2, 3, 2, 'IS1701'),
('MAD-101', 1, 2, 3, 2, 'IS1701'),
('MAD-101', 3, 1, 3, 2, 'IS1701'),
('SSG-103', 2, 1, 3, 2, 'IS1701'),
('SSG-103', 4, 2, 3, 2, 'IS1701'),
('OSG-103', 2, 2, 3, 2, 'IS1701'),
('OSG-103', 4, 1, 3, 2, 'IS1701'),

('LAB-211', 1, 3, 1, 2, 'SE1701'),
('LAB-211', 3, 4, 1, 2, 'SE1701'),
('JPD-111', 1, 4, 1, 2, 'SE1701'),
('JPD-111', 3, 3, 1, 2, 'SE1701'),
('CSD-201', 2, 3, 1, 2, 'SE1701'),
('CSD-201', 4, 4, 1, 2, 'SE1701'),
('DBI-202', 2, 4, 1, 2, 'SE1701'),
('DBI-202', 4, 3, 1, 2, 'SE1701'),

('AIL-302m', 1, 3, 1, 5, 'AI1605'),
('AIL-302m', 3, 4, 1, 5, 'AI1605'),
('CSD-301', 1, 4, 1, 5, 'AI1605'),
('CSD-301', 3, 3, 1, 5, 'AI1605'),
('ITE302', 2, 3, 1, 5, 'AI1605'),
('ITE302', 4, 4, 1, 5, 'AI1605'),
('DGT-301', 2, 4, 1, 5, 'AI1605'),
('DGT-301', 4, 3, 1, 5, 'AI1605')

