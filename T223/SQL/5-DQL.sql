use t223;
drop table employee;

create table 
employee
(id int primary key, name varchar(20), perday int, leaves int, bonus int);

insert into employee values
(1,"raj",1200,10,200),
(2,"rani",900,1,500),
(3,"ajay",1500,15,100);

-- getting all columns with all records from table
select * from employee; -- * means all columns

-- getting perticular columns with all records from table
select id, name from employee;

-- show name and gross salary of each employee (for 30 days)
select name, perday*30 from employee;
select name, perday*30 as salary from employee;

-- show name, salary and incremented salary after bonus
select name, perday*30 as salary, perday*30+bonus as bonus_salary from employee;

-- show name, salary after deducting leaves
select name, perday*(30-leaves) as salary from employee;
-- make groass salary half due to COVID
select name, perday*(15) as deducted_salary from employee;
-- -------------------------------------------------------

-- select using comparision operator : >,<,=, >=, <=, != ==
-- show employees who took leaves more than 10 days
select * from employee where leaves>10;
-- show employees getting salary more than 30K
select id, name, (perday*30) as salary from employee where (perday*30) >30000;
-- show employees getting salary less than 30K
select id, name, (perday*30) as salary from employee where (perday*30) < 30000;
-- show employees getting perday more than 1000
select * from employee where perday>1000;
-- show employees getting perday 900
select * from employee where perday=900;
-- show employees who are not getting perday 900
select * from employee where perday!=900;

-- string comparision
-- show employee whos name starts with r
select * from employee where name like "r%";

-- show employee whos name ends with i
select * from employee where name like "%i";

-- show employee whos name starts with r and has exactly 2 charcters after r
select * from employee where name like "r__";


-- and or not LOGICAL OPERATORS
-- show employees whos name starts with r and has perday more than 1000
select * from employee where name like "r%" and perday>1000;

-- show employees whos name either starts with r or has perday more than 1000
select * from employee where name like "r%" or perday>1000;

-- show me all employees excluding those whos name starts with a
select * from employee where name not like "a%";


-- MULTIPLE OR use in
-- show me enployees who per day either 1200 or 900 or 1500
select * from employee where perday=1200 or perday=900 or perday=1500;
-- solve above query using in
select * from employee where perday in(1200,900,1500);
select * from employee where perday in(1200,1500) or name="rani";
select * from employee where perday not in(1200,900);

-- getting recods by given range
-- get all employees whos leaves are in range 1-10
select * from employee where leaves between 1 and 10; -- here 1 and 10 will be included

-- get all employees whos leaves are not in range 1-10
select * from employee where leaves not between 1 and 10;

-- ordering entire data 
select * from employee order by perday; -- ascending
select * from employee order by perday desc; -- descnding
select * from employee order by name;

-- limiting data with offset
select * from employee limit 2;
select * from employee order by bonus limit 2;
select * from employee order by bonus limit 1;

-- show me employee who got highest bonus
select * from employee order by bonus desc;
select * from employee order by bonus desc limit 1;

-- offset : number of records to be skiped
select * from employee limit 2;
select * from employee limit 2 offset 1;
select * from employee limit 1 offset 1;

-- get employee who got second higherst bonus
select * from employee order by bonus desc;
select * from employee order by bonus desc limit 2 offset 1;
select * from employee order by bonus desc limit 1 offset 1;

select * from employee order by bonus desc limit 20;





