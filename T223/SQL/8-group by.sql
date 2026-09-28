use t223;
-- how many employees are there in each city
select count(id) from employee group by city;
select city, count(id) from employee group by city;

-- RULE 1 : only column name that we erite with group by is allowed with select
-- RULE 2 : we always use column for group by who is having duplicate data
-- what is avg age of employees in each city
select avg(age) from employee group by city;

-- name the city having more than 2 employee
select count(id) from employee group by city;
select city, count(id) from employee group by city;
select city, count(id) from employee group by city where count(id)>2;
select city, count(id) from employee group by city having count(id)>2;

-- name the city where employees are getting salary more than avg salary
select city, avg(salary) from employee group by city;


select city, avg(salary) from employee group by city 
having avg(salary)>(select avg(salary) from employee);

-- RULE : in having we always use aggrt function

select * from employee;
-- employee who has same name but diff salary
select name, count(id) from employee group by name having count(id)>1;
select name from employee group by name having count(salary)>1;
select name from employee group by name having count(distinct salary)>1;
select distinct salary from employee;
select count(distinct salary) >1 from employee;
-- belog to same city and have same age























