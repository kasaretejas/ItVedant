create database t231;
use t231;

create table employee(
id int primary key auto_increment,
firstName varchar(20),
lastName varchar(20),
age int,
city varchar(20),
salary float,
doj date);


insert into employee
(firstName, lastName,age,city,salary,doj)
values
("amit","kumar",27,"pune",43900,"2026-02-18"),
("sumit","sharma",32,"thane",32900,"2025-10-18"),
("raj","patil",43,"pune",93900,"2026-09-18"),
("rani","varma",24,"mumbai",44500,"2024-03-18");

select * from employee;
-- 1. function compulsory returns a value, SP depends on out
-- 2. function returns only one value at a time, SP as many out as
-- 3. we execute function using select, SP using call.
select empCountFunction();

-- SQL built in functions
-- aggregate functions
select min(age) from employee;
select max(age) from employee;
select avg(age) from employee;
select count(id) from employee;
select sum(salary) from employee;

-- string functions
select concat(firstName," ",lastName) as  fullName from employee;
select concat(firstName," ",lastName) as  fullName,age from employee;
select concat_ws("-",firstName,lastName) as  fullName from employee;
select upper(firstName) from employee;
select lower(firstName) from employee;
select firstName, length(firstName) from employee;
select insert(firstName, 1,2,"-") from employee; -- at position 1 to 2 (first 2 characters of firstName) will be -


-- math functions
select abs(-89);

select ceil(13.19);
select ceil(13.99);

select floor(13.19);
select floor(13.99);

select round(13.49);
select round(13.50);

select sqrt(49);

select power(4,2);

select rand();
select rand()*10;
select ceil(rand()*10);


-- date function
select curdate();
select now();

select year(curdate());
select year('2025-09-14');

select month(curdate());
select monthname(curdate());

-- show me employe name and joining month name
select firstName, doj from employee;
select firstName, monthname(doj) from employee;

select day(curdate());
select weekday(curdate());
select weekday("2026-06-23");
select week(curdate());

select last_day(curdate());

select datediff("2026-07-01","2026-06-22");
select datediff("2026-07-01",curdate());
select date_format(curdate(),"%Y");
select date_format(curdate(),"%y");
select date_format(curdate(),"%M");
select date_format(curdate(),"%m");
select date_format(curdate(),"%b");
select date_format(curdate(),"%D");
select date_format(curdate(),"%d");
select date_format(curdate(),"%W");
select date_format(curdate(),"%w");
-- 2026-06-22 ==> 22nd/June/2026
select curdate();
select date_format(curdate(),"%d/%m/%Y");
select date_format(curdate(),"%D/%M/%Y");

drop database t231;





