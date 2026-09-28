create database t231;
use t231;

create table employee(id int primary key,name varchar(20),salary int, age int);

create table avg_employee(avg_salary float, avg_age float);

-- triggers : SQL queries, get executes automatically when specific event occurs
-- there are 6 types of events :
	-- 1. after -  insert/update/delete
    -- 2. before - insert/update/delete
    
insert into employee
(id,name,salary,age)
values
(12,"raj",23000, 23),(14,"amit",27000, 27);

select * from employee;
select * from avg_employee;

-- avg salary from employee
select avg(salary) from employee;
-- avg age from employee
select avg(age) from employee;


insert into avg_employee
(avg_salary, avg_age)
values
((select avg(salary) from employee),(select avg(age) from employee));

select * from avg_employee;



-- trigger syntax
-- create trigger triggerName
-- after/before insert/update/delete
-- on tableName
-- for eachrow
-- SQL-QUERY (to be triggered automatically)

-- as soon as i insert new employee, its avg salary and age automatically calculated
create trigger after_insert_employee_trigger
after insert
on employee
for each row
update avg_employee set avg_salary=(select avg(salary) from employee), 
avg_age=(select avg(age) from employee);

insert into employee
(id,name,salary,age)
values
(15,"sumit",40000, 40),(18,"rani",70000, 70),(28,"rajat",26000, 21);

select * from employee;

select * from avg_employee;

-- create after delete trigger when we delete record from employee table
create trigger after_delete_employee_trigger
after delete on employee
for each row
update avg_employee set avg_salary=(select avg(salary) from employee), 
avg_age=(select avg(age) from employee);

select * from employee;
select * from avg_employee;

delete from employee where id=12;

select * from employee;
select * from avg_employee;

-- after update, avg salary and avg age should be updated
create trigger after_update_employee_trigger
after update on employee
for each row
update avg_employee set avg_salary=(select avg(salary) from employee), 
avg_age=(select avg(age) from employee);

select * from employee;
update employee set salary=30000 where id=14;
select * from employee;
select * from avg_employee;


-- before delete
-- before deleteing record, we have to take backup, so we need backup table
create table employee_backup(id int primary key,name varchar(20),salary int, age int);

select * from employee_backup;

create trigger before_delete_employee_trigger
before delete on employee
for each row
insert into employee_backup
(id,name,salary,age)
values
(old.id,old.name,old.salary, old.age);

delete from employee where id=14;

select * from employee;
select * from employee_backup;


-- before update
-- we are going to record timestamp at which the data is updated
-- for this, we required updated_at column in employee table so lets create
alter table employee add column updated_at timestamp default null;
select * from employee;

-- now we will create trigger to store currernt time stamp as soon as i update record
create trigger before_update_employee_trigger
before update on employee
for each row
set new.updated_at = current_timestamp;

select * from employee;

update employee set salary=25000 where id=15;

select * from employee;

update employee set age=35 where id=18;
select * from employee;

drop database t231;









