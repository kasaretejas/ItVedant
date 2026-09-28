use t223;
-- PK, AUTO INC, (FK), NULL, NOT NULL, CHECK, DEFAULT, UNIQUE, ENUM, SET
-- employee
-- id, id, designation, name, age, salary, phone, gender, skill
create table employee(
id int primary key auto_increment,
name varchar(10) not null,
designation varchar(10) null,
age int check(age>=18),
salary float default 0,
phone varchar(12) unique,
gender enum("male", "female"),
skill set("java", "sql", "react")
);

desc employee;

insert into 
employee
(name, designation,age,salary,phone,gender,skill)
values
("raj","hr",25, 34000,"8789865456","male","java,sql");

select * from employee;

-- violeting PK : Error Code: 1062. Duplicate entry '1' for key 'employee.PRIMARY'

insert into 
employee
(id,name, designation,age,salary,phone,gender,skill)
values
(1,"raj","hr",25, 34000,"8789865456","male","java,sql");

-- not null on name : Error Code: 1048. Column 'name' cannot be null
insert into 
employee
(name, designation,age,salary,phone,gender,skill)
values
(null,"hr",25, 34000,"8789865456","male","java,sql");

-- Error Code: 1364. Field 'name' doesn't have a default value
insert into 
employee
(designation,age,salary,phone,gender,skill)
values
("hr",25, 34000,"8789865456","male","java,sql");


-- age check : Error Code: 3819. Check constraint 'employee_chk_1' is violated.
insert into 
employee
(name, designation,age,salary,phone,gender,skill)
values
("amit","teacher",15, 34000,"8789865456","male","java,sql");


-- salary : default
insert into 
employee
(name, designation,age,phone,gender,skill)
values
("pratik","manager",35,"8789865490","male","java,sql");

select * from employee;


-- phone - unique : Error Code: 1062. Duplicate entry '8789865456' for key 'employee.phone'
insert into 
employee
(name, designation,age,salary,phone,gender,skill)
values
("sumit","lead",45, 85000,"8789865456","male","java,sql");


-- enum on gender
insert into 
employee
(name, designation,age,salary,phone,gender,skill)
values
("rani","boss",25, 34000,"8789865477","Male","java,sql"); -- no error

select * from employee;

-- Error Code: 1265. Data truncated for column 'gender' at row 1

insert into 
employee
(name, designation,age,salary,phone,gender,skill)
values
("omkar","hr",25, 34000,"8789865488","hello","java,sql");

-- set : Error Code: 1265. Data truncated for column 'skill' at row 1
insert into 
employee
(name, designation,age,salary,phone,gender,skill)
values
("rakesh","teacher",25, 34000,"8789865890","male","java,python");


drop table employee;



