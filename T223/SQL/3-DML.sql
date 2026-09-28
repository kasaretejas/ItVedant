-- DML
-- 1. instert : insert into .....
	-- one record at a time
    -- multiple records at a time
-- 2. update  : update TABLENAME set ......
	-- always use primary in condition
	-- one row at a time with condition
    -- mutiple records at a time with condition
    -- without condition
-- 3. delete  : delete from TABLENAME .....
	-- always use primary in condition
	-- one row at a time with condition
    -- mutiple records at a time with condition
    -- all records using truncate 
    -- without condition
use t223;
create table employee(id int primary key, name varchar(10), salary float, city varchar(10));

-- insert one record
insert into employee(id, name, salary, city) values (10,"raj",27000, "pune");
select * from employee;

-- insert mutiple records
insert into employee
(id, name, salary, city) 
values 
(20,"rani",87000, "thane"),
(60,"aniket",24000, "pune"),
(34,"rajat",56700, "thane");

select * from employee;

-- update one row at a time with condition
-- update name to raju whos id is 10
update employee set name="raju" where id=10;
select * from employee;

-- update mutiple records at a time with condition
-- chanage salary to 95000 for those who lived in thane
update employee set salary=95000 where city="thane";
select * from employee;

-- update without condition
update employee set salary = 20000;
select * from employee;

-- delete one row at a time with condition
delete from employee where id=10;
select * from employee;

-- delete mutiple records at a time with condition
delete from employee where city = "thane" and id=50; -- extra
delete from employee where city = "thane";
select * from employee;

-- delete all records using truncate 
truncate employee;
select * from employee;

-- delete without condition
-- before deleteing, go and execute above mutiple insert command
delete from employee;
select * from employee;

-- truncate VS delete
-- 1. we can write condition with delete, not with truncate
-- 2. if there is auto increment then truncate will restart from 1, delete will continue from last value
--    in simple way we can say, truncate resets auto increment

drop table employee;

create table employee(id int primary key auto_increment, name varchar(10));

insert into employee(name) values("raj"), ("rani"),("amit");
select * from employee;
delete from employee;
select * from employee;
insert into employee(name) values("raj"), ("rani"),("amit");
select * from employee;

truncate employee;
select * from employee;
insert into employee(name) values("raj"), ("rani"),("amit");
select * from employee;


-- DONE!





