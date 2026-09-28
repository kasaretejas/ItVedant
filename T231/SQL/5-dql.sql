create database t231;

use t231;

create table employee(
id int primary key, 
name varchar(20),
perday int,
leaves int, 
bonus int);

insert into employee
(id, name, perday, leaves, bonus)
values
(1,"raj", 1200, 10, 200),
(2, "amit", 900, 1, 500),
(3, "rani", 1500, 15, 100);

-- select all columns
select * from employee;
-- select perticular columns
select id, name from employee;

-- ARITHMATIC OPERATIONS IN DQL
-- show total salary for 30 days
select perday*30 from employee;
select perday*30 as salary from employee; -- aliasing : temp column name

-- show total salary and salary with bonus 
select perday*30 as salary, perday*30+bonus as bonus_salary  from employee;

-- show salary after deducting leaves
select id, name, (30-leaves)*perday as deducted_salary from employee;

-- COMPARISION OPERATOR IN DQL : >,<,>=,<=, !=, =
-- show employee whos perday is exactly 1200
select * from employee where perday=1200;

-- show employees who took leaves more than 10 days
select * from employee where leaves > 10;

-- show employees who got bonus less than 500
select * from employee where bonus<500;

-- show employees who took leaves exactly 10 days or more
select * from employee where leaves >= 10;

-- show employees whos perday is not 1200
select * from employee where perday != 1200;


-- STRING COMPARISION OPERATOS
-- show employees whos name starts with r
select * from employee where name like "r%"; -- % means any characters with any number

-- show employee whos name ends with i
select * from employee where name like "%i";

-- show employee whos name starts with r but has exactly 2 letters after r
select * from employee where name like "r__"; -- _ means any characters with eaxct number

-- and , or  operator in DQL
select * from employee;
-- show we employees whos name starts with r have exactly 1200 perday
select * from employee where name like "r%";
select * from employee where name like "r%" and perday=1200;

-- show we employees whos name either starts with a or have bonus less than 400
select * from employee where name like "a%";
select * from employee where name like "a%" or bonus<400;


-- not, in, not in Opertors in DQL
-- show me employees whos names are not ending with i
select * from employee where name like "%i"; 
select * from employee where name not like "%i"; 

-- show employees whos perday are - 1200, 1500, 1800
select * from employee where perday=1200 or perday=1500 or perday=1800;
select * from employee where perday in(1200,1500,1800);

-- show employees whos perday are not - 1200, 1500, 1800
select * from employee where perday not in(1200,1500,1800);

-- between, not beetween, 
-- show employee who get perday in range of 700-1400
select * from employee where perday between 700 and 1400;

-- show employee who not get perday in range of 700-1400
select * from employee where perday not between 700 and 1400;

-- order by, 
select * from employee order by perday;
select * from employee order by perday desc;

select * from employee order by name;


-- limit, offset, 
select * from employee;
select * from employee limit 2; -- top 2
select * from employee limit 2 offset 1; -- select 2 records and skip first one
select * from employee limit 2 offset 2; 

-- employee with highest bonus
select * from employee;
select * from employee order by bonus desc;
select * from employee order by bonus desc limit 1;
-- employee with second highest bonus
select * from employee;
select * from employee order by bonus desc;
select * from employee order by bonus desc limit 1 offset 1;
-- employee with third highest bonus
select * from employee order by bonus desc limit 1 offset 2;
-- employee with lowest bonus
select * from employee order by bonus limit 1;
-- employee with second lowest bonus
select * from employee order by bonus limit 1 offset 1;


-- aggregate functions - min, max, sum, avg, count, 
-- show me what is min perday
select min(perday) from employee;
-- show me what is max perday
select max(perday) from employee;
-- show me what is total perday
select sum(perday) from employee;
-- show me what is avg perday
select avg(perday) from employee;
-- show me how many employees are there
select count(id) from employee;




-- aggregate function in advanced
-- who is getting max perday (employee who is getting max perday)

select max(perday) from employee;

select * from employee where perday=1500;

select * from employee where perday=(select max(perday) from employee); -- subquery

select name, max(perday) from employee; 

-- name the employee who is getting bonus more than avg bonus
-- name, bonus columns present in one table
-- avg(bonus) ----> agg
select name from employee where bonus > (select avg(bonus) from employee);

-- subqueries : 
-- if there are multiple tables and we have to fetch data from those multiple tables,
-- better to use joins

-- when we have to fetch data from one table but sometimes output of one query act as
-- input to another query, we have to use subqueries 
	-- ex : name the employee getting max per day
		-- in above question, we dont know what is excacly max per day so first we have to find that
		-- then we will get name of that employee
        
-- name the employee getting 1200 per day
select name from employee where perday=1200;

-- name the employee getting max per day
select name from employee where perday=max per day;
select max(perday) from employee;

select name from employee where perday=(select max(perday) from employee);

-- what is count of employees whos name starts with r 
select * from employee where name like "r%";
select count(id) from employee;

select count(id) from employee where name like "r%";

-- name the employee who are gettting paid less than avg perday
select name from employee;
select avg(perday) from employee;

select name from employee where perday < (select avg(perday) from employee);

-- what is count of employees, taken less than 10 days leaves
select count(id) from employee;
select count(id) from employee where leaves<10;

drop database t231;


























