create database t231;

use t231;

create table employee(
id int primary key auto_increment,
name varchar(20), 
gender varchar(20), 
salary float, 
city varchar(20), 
age int);

describe employee;

insert into employee
(name, gender, salary, city, age)
 values
("raj","male",25000,"thane",28),
("amit","male",35000,"pune",45),
("ankita","female",42000,"thane",23),
("rajat","male",29000,"pune",31),
("ankita","female",48000,"pune",20);

select * from employee;

-- show all cities
select city from employee; -- duplicate city names

select city from employee group by(city); -- grouping employees by city

-- how many employees are there in each city
select count(id) from employee;
select count(id) from employee group by(city);
select city, count(id) from employee group by(city);
select city, count(id) as empCount from employee group by(city);

-- what are gender wise employees count
select gender, count(id) from employee group by(gender);

-- what is avg salary given to each city
select city, avg(salary) from employee group by(city);

-- what is higest salary given to male and female
select gender, max(salary) from employee group by(gender);



-- multiple column group by
-- city wise gender count
select city, count(id) from employee group by(city);
select gender, count(id) from employee group by(gender);
select city, gender, count(id) from employee group by city, gender;

-- condition in group by : using having
-- when we have to put condition on single row use where, and when we have to 
-- put condition on group of rows, use having

-- show me city wise avg age of employee
select city, avg(age) from employee group by city;

-- show me city name if the avg age of employee is more than 30
select city, avg(age) from employee group by city;
select city, avg(age) from employee group by city having avg(age)>30;

-- who is getting more salary? male or female?
select gender, sum(salary) from employee group by gender 
order by sum(salary) desc limit 1;

-- which city has younger employees?
select city, avg(age) from employee group by city order by avg(age) limit 1;

drop database t231;


 
 
 
 
 
 
 
 
 
 
 
 
 












