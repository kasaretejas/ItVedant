-- there are mainly 3 types of joins exists in sql : inner, left, right
-- there are other joins also but those are derivered joins : self, outer,full

create database t231;
use t231;

create table doctor (id int primary key, name varchar(20));
create table demo_patient(id int primary key, patient_name varchar(20), doctor_id int);

insert into doctor(id, name) values (48,"dr munna"), (72,"dr suman"), (39,"dr asthana");


insert into demo_patient
(id,patient_name , doctor_id) 
values
(1, "raju", 12), (2, "sham", 72);

-- in above demo_patient table there is entry of doctor_id 12, but there is no doctor withid 12
-- therefore we have to use FK!

create table patient 
(id int primary key, patient_name varchar(20), doctor_id int,
foreign key(doctor_id) references doctor(id));


insert into patient(id, patient_name, doctor_id) values(1, "raju", 12); -- error
insert into patient(id, patient_name, doctor_id) values(1, "raju", 48); -- correct

select * from doctor;
select * from patient;

insert into patient
(id, patient_name, doctor_id) values
(2, "sham", null), (3, "amit", 72), (4, "raj", 72), (5, "sumit", 48), (6, "rani", null);

select * from doctor; 
select * from patient;


-- show  name of the patients along with the doctor name who treated them
-- the patient name and doctor name are present in different table, but to establish
-- connection between those tables, we have id in doctor table and doctor_id in patient table
-- so we have to connet/join those tables using doctor.id and patinet.doctor_id

-- join syntax 
-- select column_names_from_given_tables
-- from table_name_1
-- inner/left/right join table_name_2
-- on common_columns_in_given_table

-- show  name of the patients along with the doctor name who treated them

select name, patient_name
from doctor
inner join patient
on doctor.id = patient.doctor_id;


select name as doctor_name, patient_name
from doctor
inner join patient
on doctor.id = patient.doctor_id;

select doctor.id, name as doctor_name, patient.id,patient_name
from doctor
inner join patient
on doctor.id = patient.doctor_id;

select doctor.id as doctor_id, name as doctor_name, patient.id as patient_id,patient_name
from doctor
inner join patient
on doctor.id = patient.doctor_id;


-- show all patients name
select patient_name from patient;
-- show all patients name along with doctor name who treated them
select patient_name, name as doctor_name
from patient
left join doctor
on patient.doctor_id=doctor.id;

-- show all doctors name
select name from doctor;

-- show all doctors name along with patient name who got treatment from them
select name , patient_name
from patient
right join doctor
on doctor.id = patient.doctor_id; 


-- self join
create table employee(id int primary key,name varchar(20),manager_id int);

insert into employee(id,name,manager_id)
values
(1, "raj",4),
(2, "amit",1),
(3, "sumit",1),
(4, "rani",null);

select * from employee;
-- show emplooyee name along with their manager name
-- conside employee table as employee and employee table as manager
select employee.name as employee_name, manager.name as manager_name
from employee 
inner join employee as manager
on employee.manager_id = manager.id;

drop database t231;












