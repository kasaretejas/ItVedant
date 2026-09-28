-- 1. primary key  :  - unique and not null
		-- to uniquely identify record
        -- duplicate PK not allowed
        -- null values not allowed
        -- ex : roll no

-- 3. foreign key : not unique, can be null
		-- when PK in one table goes into another table, act as FK
        -- we will understand this in normalization and joint concept
        -- null values allowed (multiple)
        
-- example : doctor and patient
-- Doctor  : id, name 
-- Patient : id, name, doctor_id
use t223;
create table doctor(id int primary key, name varchar(20));

create table patient
(id int primary key, 
name varchar(20), 
doctor_id int, 
constraint fk_doctor_id foreign key(doctor_id) references doctor(id));

insert into doctor
(id,name)
values
(1, "dr munna"),(2, "dr suman"),(3, "dr asthana");

-- now we have 3 pk's in doctor as - 1,2,3
-- if we assign doctor other than given id's for patients then we will get error
insert into patient
(id,name,doctor_id)
values
(10, "raj", 4); 
-- Cannot add or update a child row: a foreign key constraint fails (`t223`.`patient`, CONSTRAINT `fk_doctor_id` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`))

insert into patient
(id,name,doctor_id)
values
(10, "raj", 1),(20, "amit", 1),(30, "rani", 2),
(40, "sumit", 1),(50, "simran", 2),(60, "omkar", null); 

select * from doctor;
select * from patient;



-- joins : sql joins are used to connect tables based on pk and fk
-- type of joins :
	-- 1. inner join
    -- 2. left join
    -- 3. right join
    -- 4. self join 
			-- not practically exist in sql, we derived it when we createte
            -- inner join on one table itself
    -- 5. outer join
			-- not practically exist in sql, we derived it when we
            -- take union on left and right join
            
-- join syntax - consider on table as left side table and other as right
-- SELECT column_names_from_both_table
-- FROM left_table_name
-- INNER/LEFT/RIGHT JOIN right_table_name
-- ON common_column_name_from_both_table

-- show all patients name who got treatment with their doctor name
SELECT patient.id as patient_id,patient.name as patiet_name, doctor.name as doctor_name 
FROM doctor 
INNER JOIN patient 
ON doctor.id = patient.doctor_id;

SELECT p.id as patient_id,p.name as patiet_name, d.name as doctor_name 
FROM doctor d
INNER JOIN patient p
ON d.id = p.doctor_id;

-- how many patients treated by dr.munna?
select id from doctor where name="dr munna";

select count(id) from patient where doctor_id=1;

select count(id) from patient where doctor_id=
(select id from doctor where name="dr munna");

-- name all doctors with their patient name even if they havnt treated 
-- any patient
select * from doctor;
select d.id,d.name,p.name 
from doctor d
left join patient p
on d.id = p.doctor_id;

-- all patient name with doctor ,whether they havew got treatment or not
select * from patient;

select p.id,p.name,d.name
from doctor d
right join patient p
on d.id = p.doctor_id;


-- what is name of dr who treated raj?
select doctor_id from patient where name="raj";
select name from doctor where id = 1;

select name from doctor where id = (select doctor_id from patient where name="raj");

-- self join
-- self join is not exist in sql, it is derived when we take inner join on same table
use t223;
drop table employee;
create table employee(id int primary key, name varchar(10), manager_id int);

insert into employee
(id,name,manager_id)
values
(1,"raj",2),
(2,"amit",4),
(3,"sumit",4),
(4,"pratik",5),
(5,"rani",null);

select * from employee;

select 
		emp.id as employeeID, 
        emp.name as employeeNAME, 
        manager.name as managerName
from employee as emp
inner join employee as manager
on emp.manager_id=manager.id;




























