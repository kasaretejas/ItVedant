create database t231;
use t231;
create table student
(
	id int primary key,
    name varchar(20),
    city varchar(20),
    age int
);

-- DML : insert, update, delete
-- insert : 
	-- insert into TABLE_NAME(COLUMN1, COLUMN2...) values(VALUE1, VALUE2....);
	-- 1. one value at a time
    -- 2. multiple values at a time
    -- 3. data from one table into another (views)
-- update :
	-- update TABLENAME set COLUMN=VALUE where PK_COLUMN=VALUE;
	-- 1. one column at time with condition
    -- 2. multiple column at a time with condition
    -- 3. without condition (DO NOT USE)
-- delete :
	-- delete from TABLENAME where PK_COLUMN=VALUE;
	-- 1. one record/row at time with condition
    -- 2. multiple record/row at a time with condition
    -- 3. without condition (DO NOT USE)
-- truncate

-- INSERT : one record at a time
insert into student(id,name,city,age) values(10, "raj","pune",25);
select * from student;

-- INSERT : multiple records at a time
insert into student
(id,name,city,age) 
values
(11, "amit","thane",21),
(12, "sumit","pune",35),
(13, "rani","mumbai",20);

select * from student;

-- update one column at time with condition
-- change name from raj to raju whos id is 10
update student set name="raju" where id=10;
select * from student;

-- update multiple columns at time with condition
-- change name from raju to and and age to 26 whos id is 10
update student set name="aniket", age=26 where id=10;
select * from student;

-- update  without condition (DO NOT USE)
-- change name to pratik
-- update student set name="pratik"; -- this will set all names to pratik

-- why always use PK column with where condition
update student set name="ayush" where city="pune";
select * from student;

-- delete : one record at a time
delete from student where id=11;
select * from student;

-- delete : mutiple records at a time
delete from student where city="pune";
select * from student;

-- delete without condition (DO NOT USE)
delete from student; -- deletes all records from table

select * from student;

-- truncate vs delete
-- in above student table, we do not have auto increment so we will create one simple table
-- with auto increment
create table book(id int primary key auto_increment, name varchar(20));
insert into book(name) values ("java in easy way"),("html for dev"),("sql for dbms");
select * from book;

-- delete all books record using delete
delete from book; -- this delete is without condition, deletes all records
select * from book;

-- delete all books record using truncate
insert into book(name) values ("java in easy way"),("html for dev"),("sql for dbms");
select * from book;
truncate book; -- deletes all records
select * from book;

-- how delete works
insert into book(name) values ("java in easy way"),("html for dev"),("sql for dbms");
select * from book;

delete from book;
select * from book;

insert into book(name) values ("java in easy way"),("html for dev"),("sql for dbms");
select * from book;

-- how truncate works
truncate book;
select * from book;
insert into book(name) values ("java in easy way"),("html for dev"),("sql for dbms");
select * from book;

truncate book;
select * from book;
insert into book(name) values ("java in easy way"),("html for dev"),("sql for dbms");
select * from book;


-- truncate VS delete
-- 1. truncate resets auto increment where as delete continues from last increment value
-- 2. we can write condition with delete but not with truncate

drop database t231;








