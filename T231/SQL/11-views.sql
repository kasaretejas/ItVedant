-- view : are replica of a table with required colums
-- views are virtual table
-- views has 2 types:
	-- 1. simple view : view created without using joins, subqueries, group by, aggregate function
					-- if we perform DML on simple view then its result will be reflected on OG table
    -- 2. complex view : view created  using joins, subqueries, group by, aggregate function
					-- if we perform DML on complex view then its result will not reflected on OG table

create database t231;
use t231;

create table department(id int primary key auto_increment,name varchar(20));


create table employee(
id int primary key auto_increment,
name varchar(20),
age int,
city varchar(20),
salary float,
doj date,
dept_id int,
foreign key(dept_id) references department(id));


insert into department(name)values("IT"),("Sales"),("HR");
select * from department;

insert into employee
(name,age,city,salary,doj,dept_id)
values
("amit",27,"pune",43900,"2026-02-18",2),
("sumit",32,"thane",32900,"2025-10-18",3),
("raj",43,"pune",93900,"2026-09-18",1),
("rani",24,"mumbai",44500,"2024-03-18",1);


select * from employee;

-- i want a table which has id,name and salary from employee table
create view employeeView as select id,name,salary from employee;
select * from employeeView;
update employeeView set salary=44000 where id=1;

select * from employeeView;
select * from employee;

-- create view with employee id,name and department name

select employee.id as employeeId, employee.name as employeeName, department.name as departmentName
from employee
inner join department
on employee.dept_id = department.id;

create view employeeDepartmentView as select employee.id as employeeId, employee.name as employeeName, department.name as departmentName
from employee
inner join department
on employee.dept_id = department.id;

select * from employeeDepartmentView;
update employeeDepartmentView set departmentName="HR" where employeeid=4;
select * from employeeDepartmentView;
select * from employee;




















