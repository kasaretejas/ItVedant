-- aggregate : performs operation on ONE COLUMN and gives aggrigate value 
-- ex : sum/avg/min/max of entire column, count on column
-- there are 5 aggr functions available : sum(), min(), max(), avg(), count()
-- always use aggr functions with select
		-- ex : select min(salary) from employee
        -- there must be select to the left aggrt function
        
use t223;

-- how many records available in table
select count(id) from employee; -- always use PK with count()

-- what is highest bonus given to the employee
select max(bonus) from employee;

-- what is lowest bonus given to the employee
select min(bonus) from employee;

-- what is avg bonus given to the employee
select avg(bonus) from employee;

-- what is total per day given in single day
select sum(perday) from employee;

-- how many employee getting per day ore than avg per day
select avg(perday) from employee;
select count(id) from employee where perday>1200;
select count(id) from employee where perday>(select avg(perday) from employee);














