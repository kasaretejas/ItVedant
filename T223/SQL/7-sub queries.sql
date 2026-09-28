-- sub queries : query inside query
-- type of subqueries :
	-- one row : subqueries that returns only one row
    -- mutiple rows : subqueries that returns  mutiple rows
use t223;
-- what is name of employee who is getting 900 per day
select * from employee where perday=900;

-- what is name of employee who is getting highest perday (using subqury)
-- we get name only when we have highest perday, find highest perday first
select max(perday) from employee; -- 1500
-- no we have highest perday value, now find its name
select name from employee where perday = (select max(perday) from employee);
-- ----------- main query ------------ = --------- subquery ----------------
-- select name from employee where perday = 1500;

drop table employee;
-- employee : id, name, salary, city, age
create table employee(
id int primary key auto_increment,
name varchar(20),
salary float,
city varchar(20),
age int
);

insert into employee 
(name, salary, city, age)
values
("raj",25000,"pune", 36),
("amit",36780,"pune", 24),
("sumit",45920,"thane", 48),
("rani",20000,"thane", 29),
("pratik",18000,"thane", 21),
("raj",18000,"thane", 21),
("amit",36780,"mumbai", 21);

-- what is avg salary given in pune
select avg(salary) from employee where city="pune"; 
-- name the yougest employee in thane
select min(age) from employee where city="thane"; 
select name from employee where age=(select min(age) from employee where city="thane");

-- how many employees get salary more than avg salary
select avg(salary) from employee;
select count(id) from employee where salary >(select avg(salary) from employee);


-- name the employee who is getting highest salary in pune
select max(salary) from employee where city = "pune";
select name from employee where salary = (select max(salary) from employee where city="pune");

-- what is total salary given to thane employees
select sum(salary) from employee where city = "thane";

-- employees having age less than 30 and getting high salary out of them
select name from employee where salary = 10;
select age from employee where age<30;
select max(salary) from employee where age in(select age from employee where age<30);

select * from employee where salary =            -- main query
(select max(salary) from employee where age in   -- subquery
(select age from employee where age<30));        -- nested query








