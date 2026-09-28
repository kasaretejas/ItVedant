-- action and event
-- we can say action is a query going to be execute on table
-- when some event(insert, update, delete) occurs on another table
-- there are total 6 events : before - insert,update,delete
                  --        : after  - insert,update, delete
-- when an even occurs, we want to execute query automatically, we create TRIGGERS
-- TRIGGERS are sql queies that executes when an event occurs

-- it is not necessary that those table are in relationship

-- generally used when we want to perform action on one table when there
-- is action in another table

-- examples
-- remove items from cart as soon as we place order

-- event on one table, action on another table


use t223;

drop table employee;

create table employee 
(id int primary key, name varchar(10), age int, salary float);

create table employee_avg(avg_age float, avg_salary float);

insert into employee(id, name, age, salary)
values
(1, "raj",32, 32000),
(2, "amit",25, 25000);

select * from employee;

insert into employee_avg
(avg_age, avg_salary)
values
((select avg(age) from employee),(select avg(salary) from employee));

select * from employee_avg;


-- 
insert into employee(id, name, age, salary)values(3, "rani",34, 34000);
select * from employee;
select * from employee_avg;

-- due to above insdert query, the avg age and salary will not be chanaged inside employee_avg table
-- to do so, we have to create TRIGGERS 

-- syntax:

-- CREATE TRIGGER trigger_name
-- BEFORE/AFTER INSERT/UPDATE/DELETE ON table_name
-- FOR EACH ROM
-- sql_query;

create trigger trigger_after_insert_on_employee
after insert on employee
for each row
update employee_avg set avg_age=(select avg(age) from employee),
avg_salary=(select avg(salary) from employee);


insert into employee(id, name, age, salary)values(4, "sumit",54, 54000);

select * from employee;
select * from employee_avg;
-- ---------------------------------------------------------------
insert into employee(id, name, age, salary)values(5, "om",33, 33000);
select * from employee;
select * from employee_avg;

-- after update
create trigger trigger_after_update_on_employee
after update on employee
for each row
update employee_avg set avg_age=(select avg(age) from employee),
avg_salary=(select avg(salary) from employee);

select * from employee;

update employee set age=23, salary=23000 where id=1;
select * from employee;
select * from employee_avg;


-- after delete
create trigger trigger_after_delete_on_employee
after delete on employee
for each row
update employee_avg set avg_age=(select avg(age) from employee),
avg_salary=(select avg(salary) from employee);

select * from employee;
select * from employee_avg;

delete from employee where id=5;
select * from employee;
select * from employee_avg;


-- before delete : backup
create table employee_backup 
(id int primary key, name varchar(10), age int, salary float);


create trigger trigger_before_delete_on_employee
before delete on employee
for each row
insert into employee_backup 
(id,name,age,salary) 
values
(old.id, old.name, old.age, old.salary);

select * from employee;
select * from employee_backup;


delete from employee where id=4;
select * from employee;
select * from employee_backup;

-- before insert
delimiter $$
create trigger trigger_before_insert_on_employee
before insert on employee
for each row
if 
	new.age<18 then set new.age=null;
end if $$

-- to execute above lines select line 26-32 all at once and execute

delimiter ; -- select this line and execute using first symbol

insert into employee(id, name, age, salary)values(7, "punit",12, 12000);
select * from employee;

insert into employee(id, name, age, salary)values(8, "nidhi",25, 25000);
select * from employee;


























