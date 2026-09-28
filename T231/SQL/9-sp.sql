create database t231;
use t231;

create table employee(
id int primary key auto_increment,
name varchar(20),
city varchar(20),
age int,
salary float);

insert into employee
(name, city, age, salary)
values
("raj","pune",25, 48900),("amit","thane",45, 87100),("rani","pune",31, 54090);

select * from employee;
-- simple SP
call getAllEmployees();

-- passing input parameter to SP
call getEmployeeById(3);

-- creating variable in sp
call empCountVariable();

-- SP with output parameter
call empCountOutParameter(@empCount);
select @empCount;

-- SP with in and out parameter
call inAndOut("thane", @totalEmp);
select @totalEmp;

-- conditional statements in SP
call conditionalSP(11);


drop database t231;

