create database Janmeda_Health_Center;

use Janmeda_Health_Center;

-- this is for the adminstrators.
create table System_Admin (
	ID varchar(25) primary key,
	Name varchar(25),
	Password varchar(25),
	Phone varchar(15));
                    


insert into System_Admin values ('Dr101',"Megersa Suraphel","123megersa",'+25900000001')

select * from System_Admin;


-- this is for the Patients
create table Patient(
    ID int primary key auto_increment,
    Name varchar(25) not null,
    Age int(3),
    Gender char(1) check (Gender in ('M', 'F', 'O')),
    Address varchar(25) not null,
    Phone varchar(25) not null,
    Med_Case varchar(50),
	Paid varchar(3) check (Paid in ('yes','no')));
    
drop table Patient;

-- inserting into the patient table just a random data
insert into Patient (Name, Age, Gender, Address, Phone, Med_Case, Paid)
 VALUES
	('Abebe Kebede', 35, 'M', '01 kebele', '+25195551234', 'Broken Leg', 'yes'),
	('Aster Tadesse', 28, 'F', '02 kebele', '+25195555678', 'Flu', 'no'),
	('Yohannes Feyisa', 42, 'M', '12 kebele', '+25195559012', 'Diabetes', 'yes'),
	('Meron Lemma', 19, 'F', 'kebena', '+25195553456', 'Appendicitis', 'yes'),
	('Zerihun Amanuel', 54, 'M', 'arada 07', '+25195557890', 'Hypertension', 'no'),
	('Selamawit Oljira', 24, 'F', 'bole', '+25195552109', 'Tonsillitis', 'yes'),
	('Haile Wondimu', 31, 'M', 'piassa', '+25195556543', 'Broken Arm', 'no'),
	('Tigist Abebe', 27, 'F', '06 kebele', '+25195550987', 'Bronchitis', 'yes'),
	('Dawit Berhanu', 39, 'M', '5 kilo', '+25195554321', 'Arthritis', 'no'),
	('Zahara Kel', 22, 'F', 'megegna', '+25195558765', 'Sprained Ankle', 'yes');

select * from Patient;

-- creating table for medicine

create table Medicine (
  ID int primary key auto_increment,
  Name varchar(25) not null,
  Quantity int,
  Expiration_date date,
  Price int
);

drop table Medicine;
 -- inserting random data to the medicine table
 
 insert into Medicine (Name, Quantity, Expiration_date, Price)
values
  ('Aspirin', 50, '2024-12-31', 5),
  ('Ibuprofen', 75, '2025-06-30', 7),
  ('Paracetamol', 100, '2026-03-15', 4),
  ('Amoxicillin', 30, '2024-09-01', 10),
  ('Cetirizine', 80, '2025-11-20', 6),
  ('Metformin', 45, '2026-02-28', 8),
  ('Atorvastatin', 60, '2025-05-01', 12),
  ('Lisinopril', 25, '2024-08-15', 9),
  ('Simvastatin', 70, '2026-01-31', 11),
  ('Sertraline', 40, '2024-11-10', 14),
  ('Omeprazole', 55, '2025-07-01', 8),
  ('Furosemide', 35, '2024-12-15', 7),
  ('Metoprolol', 65, '2026-04-30', 10),
  ('Amlodipine', 90, '2025-03-31', 6),
  ('Hydrochlorothiazide', 20, '2024-10-20', 5);

select * from Medicine;

-- creating worker data base

create table Worker (
  ID int primary key auto_increment,
  Name varchar(50) not null,
  Phone varchar(20),
  Role varchar(50) not null,
  HireDate varchar(10) not null,
  Salary double(10,2) not null
);

drop table Worker;
-- inserting to the table

insert into Worker (Name, Phone, Role, HireDate, Salary)
values
  ('Abrham Mulugeta', '+251 (911) 123-4567', 'Manager', '2018-02-01', 6000.00),
  ('Mekdes Haile', '+251 (912) 987-6543',  'Head Nurse', '2020-05-15', 5500.00),
  ('Tewodros Getachew', '+251 (913) 456-7890', 'Pharmacist', '2019-09-01', 5000.00),
  ('Selam Bekele', '+251 (914) 123-8765', 'HR Specialist', '2021-03-01', 4800.00),
  ('Dawit Mekonnen', '+251 (915) 987-4321', 'Nurse', '2022-01-15', 4200.00),
  ('Tsion Tesfaye', '+251 (916) 654-7890','Lab Technician', '2020-07-01', 4500.00),
  ('Betelhem Ashenafi', '+251 (917) 123-9876','Radiologist', '2019-11-01', 6200.00),
  ('Lemma Alemayehu', '+251 (918) 987-6543', 'Facility Manager', '2018-06-01', 5000.00),
  ('Chaltu Abebe', '+251 (919) 456-2345', 'Chef', '2021-09-15', 4000.00),
  ('Elias Kassa', '+251 (920) 123-4567', 'IT Support', '2020-03-01', 4800.00);

select * from Worker;

