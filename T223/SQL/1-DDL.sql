-- create, drop, use, alter, show, describe
create database t223;
show databases;

-- create table TABLE_NAME(COLUMN1_NAME datatype([size]) [constraints]));

-- datatypes
-- category of data : numeric, character, date, time, datetime
-- according to above categories of data, following datatypes available in SQL
-- numeric : int, float -----> no need to define size
-- characters : varchar, char ---> we have to define size - how many characters
-- date, time, datetime -----> no need to define size
-- ---------------------------------------------------------------------
-- constraints : are rules applied on columns so we will get data integrity(purity)
-- what are constraints/rules avaliable in SQL
-- 1. primary key  : 
		-- to uniquely identify record
        -- duplicate PK not allowed
        -- null values not allowed
        -- ex : roll no
-- 2. auto increment
		-- automatically increasing int value
        -- only applicable on PK
-- 3. foreign key
		-- when PK in one table goes into another table, act as FK
        -- we will understand this in normalization and joint concept
-- 4. check
		-- to check value before entering into table
        -- whether it matches given condition
        -- ex: age>18
-- 5. default
		-- if we are not passing any value, the default value will be inserted
        -- marks default 0
-- 6. null
		-- null means not pointing to anywhere
        -- null does not mean empty , null itself is a value
-- 7. not null
		-- null values not allowed
        -- we are making compulsory to enter a value 
-- 8. enum
		-- allow to select only one value from given set of values
        -- if any value added other than goven set of values, then error!
        -- ex: select gender (male or female)
-- 9. set
		-- allow to select mutiple values from given set of values
        -- if any value added other than goven set of values, then error!
        -- ex : select certificates (HTML, CSS, REACT, SQL, JAVA)
-- 10. unique
		-- value can not be duplicate
        
-- ---------------------------------------------
use t223;
create table student(rollNo int);
show tables;

drop table student;
show tables;

create table employee(id int, name varchar(10));
select * from employee;
insert into employee(id, name) values(10, "raj");
select * from employee;

drop table employee;

-- alter : 
	-- to add new column into table (at first, after specific column)
    -- to change column data type/size
    -- to rename column
    -- remove column
    -- to rename table
 
create table employee(name varchar(20));
describe employee;

alter table employee add column age int;
describe employee;

alter table employee add column rollNo int primary key first;
describe employee;

alter table employee add column salary float after name;
describe employee;

alter table employee modify column name varchar(30);
describe employee;

alter table employee modify column salary varchar(20);
describe employee;

alter table employee drop column salary;
describe employee;

alter table employee rename column name to fullName;
describe employee;

alter table employee rename to new_employee;













