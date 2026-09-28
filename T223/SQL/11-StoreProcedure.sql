use t223;
drop table employee;
create table employee(id int primary key,name varchar(10),
age int,salary float,city varchar(10));

insert into employee 
(id,name,age,salary,city)
values
(10,"raj",32,32000,"pune"),(20,"rani",21,16000,"pune"),
(30,"amit",23,45000,"pune"),(40,"sumit",45,15000,"thane"),
(50,"pratik",28,20000,"mumbai");


-- Store Procedure to get all employees

-- CREATE PROCEDURE `getAllEmployees`()
-- BEGIN
-- 	select * from employee;
-- END
call getAllEmployees();


-- SP to get employee by id (sp with input parameter)
select * from employee where id=10;

-- CREATE  PROCEDURE `getEmployeeById`(in empId int)
-- BEGIN
-- 	select * from employee where id=empId;
-- END
call getEmployeeById(30);

-- declaring variable in SP

-- CREATE PROCEDURE `variableInStoreProcedure`()
-- BEGIN
-- --  declare empCount int;
-- 	declare empCount int default 0;
--     select count(id) into empCount from employee;
--     select empCount;
-- END
call variableInStoreProcedure();

-- SP to get employee count (sp with output parameter)

-- CREATE PROCEDURE `outputParameter`(out empCount int)
-- BEGIN
-- 	select count(id) into empCount from employee;
-- END
call outputParameter(@empCount);
select @empCount;

-- SP with in and out paramenter
-- how many employees are getting salary more than rani's salary
select salary from employee where name="rani";

select count(id) from employee where salary>
(select salary from employee where name="rani");

-- CREATE  PROCEDURE `inOutParameter`(in empName varchar(10), out empCount int)
-- BEGIN
-- 	select count(id) into empCount from employee where salary>
-- 	(select salary from employee where name=empName);
-- END
call inOutParameter("rani", @empCount);
select @empCount;

-- conditional statemets in SP
select * from employee;
-- display employee count in given city, if there are no employees then
-- display message
select count(id) from employee where city="pune";

-- CREATE PROCEDURE `conditionalSP`(in cityName varchar(20))
-- BEGIN
-- 	declare message varchar(300);
--     declare empCount int default 0;
--     select count(id) into empCount from employee where city=cityName;
--     if empCount>0
-- 		then select empCount;
-- 	else
-- 		set message="there are no employees in given city";
--         select message;
-- 	end if;
-- END

call conditionalSP("delhi");

















