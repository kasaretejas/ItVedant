-- string, math, date, aggrigate
use t223;

drop table employee;

create table employee
(id int primary key,fname varchar(20),lname varchar(20),
age int,salary float,doj date);

insert into employee (id,fname,lname,age,salary,doj)
values
(10,"raj","kumar",23, 23000, "2024-12-20"),
(20,"rani","sharma",35, 35000, "2023-10-20"),
(30,"amit","shukla",28, 28000, "2022-06-15"),
(40,"pratik","singh",31, 31000, "2026-07-23");

-- aggregate : min, max, avg, sum, count
select min(age) from employee;
select sum(salary) from employee;
select avg(age) from employee;
select count(id) from employee;
select max(salary) from employee;

-- string : upper , lower, concat, sustring, lenght, insert, trim, 
--          replace,
select fname, upper(fname) from employee; -- convert text to upper case
select fname, lower(fname) from employee;
select concat(fname, lname) from employee; -- join given data
select concat(fname,"  ", lname) from employee;
select concat(fname,"--", lname) from employee;
select concat(fname,"--", lname,"--") from employee;
select fname, substring(fname, 1,2) from employee; 
select fname, length(fname) from employee;
select fname, insert(fname,1,2,"*") from employee; 
-- from position 1 to 2, insert *
select fname, replace(fname, "a","-") from employee; 
-- in fname, replace a with -
select trim("    raj"); -- to remove spaces

-- math : abs, ceil, floor, round, power, rand, sqrt, greatest, least
select abs(-12);

select ceil(12.23);
select ceil(12.99);

select floor(12.23);
select floor(12.99);

select round(13.51);
select round(13.41);

select power(4,2);

select rand();

select sqrt(49);
select sqrt(63);

select greatest(10,5,20);
select least(10,5,20);


-- date : curdate, now, year, month, monthname, day, weekday, last_day, date_diff, date format

select curdate();
select now();

select year("2027-12-30");
select year(curdate());

select month(curdate());
select monthname(curdate());

select fname, monthname(doj) as joining_month from employee;

select day(curdate());
select weekday(curdate());
select week(curdate());

select last_day(curdate());

select datediff("2026-12-31","2026-02-20");
select datediff("2026-02-20", "1995-08-14")/365;


select date_format(curdate(),"%Y");
select date_format(curdate(),"%y");
select date_format(curdate(),"%M");
select date_format(curdate(),"%b"); -- month name with first 3 characters
select date_format(curdate(),"%m");
select date_format(curdate(),"%D");
select date_format(curdate(),"%d");
select date_format(curdate(),"%W");
select date_format(curdate(),"%w");

select date_format("1995-08-14", "%D/%M/%Y");
































