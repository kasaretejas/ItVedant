-- event & action
-- event : 
		-- DML oprations - insert,update and delete
        -- there are 6 type of events 
			-- before : insert,update and delete
            -- after  : insert,update and delete
-- action
	-- action is sql query

-- trigger -
	-- triggers are SQL queries that get executes automatically when specific 
    -- event occurs
    
-- CREATE TRIGGER trigger_name
-- BEFORE/AFTER INSERT/UPDATE/DELETE ON table_name
-- FOR EACH ROW
-- sql_query

use t224;

drop table employee;

create table employee
(id int primary key,name varchar(20),age int,salary float);

create table avg_employee(avgAge float, avgSalary float);

insert into employee(id,name,age,salary)
values (10,"raj",25,30000);

insert into avg_employee(avgAge, avgSalary) 
values((select avg(age) from employee),(select avg(salary) from employee));

select * from employee;
select * from avg_employee;


create trigger afterInsertEmployee
after insert on employee
for each row
update avg_employee set avgAge=(select avg(age) from employee), 
avgSalary=(select avg(salary) from employee);


insert into employee(id,name,age,salary)
values (20,"rani",35,20000);


select * from employee;
select * from avg_employee;

-- get list of all triggers
show triggers;

-- before delete : take backup of data
create table employee_backup
(id int primary key,name varchar(20),age int,salary float);

select * from employee_backup;

create trigger beforeDeleteEmployee
before delete on employee
for each row
insert into employee_backup(id,name,age,salary)
values(old.id, old.name, old.age, old.salary);

show triggers;

delete from employee where id=20;

select * from employee;
select * from employee_backup;

-- before insert : check age for >=18
DELIMITER $$
create trigger beforeInsertEmployee
before insert on employee
for each row
if new.age<18
	then set new.age=null;
end if $$

DELIMITER ;




insert into employee(id,name,age,salary)
values (30,"aniket",15,20000);

select * from employee;

show triggers;

select * from employee;
insert into employee(id,name,age,salary)
values (40,"puja",28,45000);

-- after delete
create trigger afterDeleteEmployee
after delete on employee
for each row
update avg_employee set 
avgAge=(select avg(age) from employee), 
avgSalary=(select avg(salary) from employee);


delete from employee where id=10;

select * from employee;
select * from avg_employee;


-- after update : change avg age and salary
create trigger afterUpdateEmployee
after update on employee
for each row
update avg_employee set 
avgAge=(select avg(age) from employee), 
avgSalary=(select avg(salary) from employee);


-- change age to 31 whos id is 30

update employee set age=31 where id=30;

select * from employee;
select * from avg_employee;

-- before update

















