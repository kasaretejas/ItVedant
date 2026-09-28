-- views : are replica of table used to work with min colunms as table
-- types of views : 
	-- 1. simple view : created without using joins, subquery, group by or aggregate function
					--  if we perform operation on simple view, then those chnages will be refleced in Original table
    -- 2. complex view : created using above complex queries
					-- changes in complex will not be reflected in original table
use t223;
drop table employee;

create table department(id int primary key,name varchar(20));
insert into department
(id,name) 
values
(101,"HR"),(102,"Teacher"),(103,"Manager");

create table employee(
id int primary key,
name varchar(20),
doj date,
age int,
salary float,
city varchar(20),
dept_id int, 
constraint fkdeptid foreign key(dept_id) references department(id));





insert into employee
(id,name,doj,age,salary,city,dept_id)
values
(10, "raj", "2024-10-15", 25, 35000, "pune",101),
(20, "rani", "2023-12-09", 28, 39000, "pune",102),
(30, "amit", "2024-09-15", 35, 45000, "thane",103),
(40, "sumit", "2025-08-17", 39, 15000, "thane",101),
(50, "komal", "2024-07-15", 31, 25000, "mumbai",102);


select * from employee;

-- i want new table as a replica of employee table with 3 column - id,name and salary
select id,name,salary from employee;
-- creating simple view : thi view can be updatable
create view employeeView as
select id,name,salary from employee;

select * from employee;
select * from employeeView;

update employeeView set salary = 35500 where id = 10;

select * from employee;
select * from employeeView;



-- display id, name, department name, salary
select employee.id, employee.name as empName, 
	   department.name as deptName, employee.salary
from employee
inner join department
on employee.dept_id=department.id;

-- complex view using join
create view employeeDepartment as
select employee.id, employee.name as empName, 
	   department.name as deptName, employee.salary
from employee
inner join department
on employee.dept_id=department.id;


select * from employeeDepartment;
update employeeDepartment set salary=35000 where id=10;

select * from employee;
select * from employeeDepartment;

-- display id, name, department name and salary only for Teachers!

select employee.id, employee.name as empName, 
	   department.name as deptName, employee.salary
from employee
inner join department
on employee.dept_id=department.id
where department.name = "Teacher";

-- filtered view : 

create view teacherView as
select employee.id, employee.name as empName, 
	   department.name as deptName, employee.salary
from employee
inner join department
on employee.dept_id=department.id
where department.name = "Teacher";

select * from teacherView;

-- show dept wise avg salary
-- dept name and dept wise avg salary

select department.name as deptName, avg(employee.salary) as avgSalary
from employee
left join department
on department.id=employee.dept_id
group by department.name;

-- ept id, dept name and dept wise avg salary
select department.id, department.name as deptName, avg(employee.salary) as avgSalary
from employee
left join department
on department.id=employee.dept_id
group by department.name, department.id;

create view deptWiseAvgSalary as
select department.id, 
       department.name as deptName, 
       avg(employee.salary) as avgSalary
from employee
left join department
on department.id=employee.dept_id
group by department.name, department.id;

select * from deptWiseAvgSalary;

update deptWiseAvgSalary set avgSalary=28000 where id=101;


































