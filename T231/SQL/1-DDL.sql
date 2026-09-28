-- create db, table, 
-- create table syntax
-- data types, contarints
-- add, update remove column from table
-- renname column and table
-- remove table, db

create database t231;
show databases;
use t231;

create table employee(id int primary key auto_increment, name varchar(20));
show tables;
describe employee;

-- create table real syntax
-- create table tableName(column1Name dataType[(size)] [constraints],
-- 						  column2Name dataType[(size)] [constraints]);

-- datatypes in SQL
	-- numeric values -----> int, float
	-- character values ---> char(size), varchar(size) ---->
		-- char(20)--> this will acquire space for 20 characters and if we used only 5 characters then space of 15 is wasted
        -- varchar(20)this will acquire space for 20 characters and if we used only 5 characters then space of 15 is saved
	-- date values -------> date, time, datetime
    -- yes/no types ------> boolean
    
-- contraints : conditions/rule applied on column for data integrity
		-- ex : age int ---> here we can add age as : -5
	    --      age int check(age>0) --> here we can not add age less than 0
        -- following constraints available
			-- 1. primary key 
					-- only one per table
            -- 2. foreign key
					-- when PK of one table mapped with another table called as FK
            -- 3. unique
					-- can not be duplicate
            -- 4. null
					-- null values allowed
            -- 5. not null
					-- null values not allowed
            -- 6. default
					-- if there is no value, then add default
            -- 7. check
					-- verify the condition then add value
            -- 8. set
					-- selecting multiple from given group of values
            -- 9. enum
					-- selecting only one from given group of values

-- add new column age
alter table employee add column age int;
describe employee;

-- add column salary between name and age
alter table employee add column salary float after name;
describe employee;

-- add column city before all columns/ at the begining
alter table employee add column city varchar(20) first;
describe employee;

-- change size of city from varchar(20) to varchar(30)
alter table employee modify column city varchar(30);
describe employee;

-- change data type of salary from float to int
alter table employee modify column salary int;
describe employee;

-- change name of column city to address
alter table employee rename column city to address;
describe employee;

-- remove column address
alter table employee drop column address;
describe employee;

-- renaming table
rename table employee to emp;

describe employee; -- error
describe emp;

drop table emp;
describe emp; -- error

drop database t231;











