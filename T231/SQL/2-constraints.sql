    
-- contraints : conditions/rule applied on column for data integrity
		-- ex : age int ---> here we can add age as : -5
	    --      age int check(age>0) --> here we can not add age less than 0
        -- following constraints available
			-- 1. primary key 
					-- only one per table
                    -- can not be duplicate neither null
                    -- only one column with PK allowed in one table
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


create database t231;
use t231;

-- employee : id(pk, ai), name(nn), phone(u), designation(n), 
--            salary(d-0), age(c>18), gender(e), skills(s)

create table employee(
id int primary key auto_increment,
name varchar(20) not null,
phone varchar(20) unique,
designation varchar(20) null,
salary float default 0,
age int check(age>18),
gender enum("male", "female"),
skills set("java","react","sql")
);

-- adding correct record
insert into employee
(name,phone,designation,salary,age,gender,skills)
values
("raj", "9898989898","hr",25000, 29,"male","java,sql");

select * from employee;

-- voileting PK on column id by duplicating PK
insert into employee
(id,name,phone,designation,salary,age,gender,skills)
values
(1,"raj", "9898989898","hr",25000, 29,"male","java,sql");

-- voileting not null on column name
-- we will not pass column name neither its value 
insert into employee
(phone,designation,salary,age,gender,skills)
values
("9898989898","hr",25000, 29,"male","java,sql");

-- solution  : name varchar(20) not null default "NA",


-- verifing default on column salary
-- we will not pass column salary neither its value 
insert into employee
(name, phone,designation,age,gender,skills)
values
("rani","9898989899","hr", 29,"female","java,sql");

select * from employee;



-- violeting unique on column phone
insert into employee
(name,phone,designation,salary,age,gender,skills)
values
("amit", "9898989898","hr",45000, 39,"male","java");

-- verifing null on column designation
insert into employee
(name,phone,salary,age,gender,skills)
values
("puja", "9898989888",95000, 25,"female","sql");

select * from employee;

-- violeting age by passing value<18
insert into employee
(name,phone,designation,salary,age,gender,skills)
values
("nilesh", "9898989877","hr",25000, 15,"male","java,sql");

-- violeting enum on column gender: by passing value which is not provided
insert into employee
(name,phone,designation,salary,age,gender,skills)
values
("nidhi", "9898989800","hr",25000, 29,"xyz","java,sql");

-- violeting set on column skills: by passing value which is not provided
insert into employee
(name,phone,designation,salary,age,gender,skills)
values
("nidhi", "9898989800","hr",25000, 29,"female","java,python");

drop table employee;
drop database t231;


