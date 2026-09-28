create database t231;
use t231;
create table employee(id int primary key auto_increment, name varchar(20));

start transaction;

insert into employee(name)values("raj"),("amit"),("rani");

savepoint insertionStep;

select * from employee;

delete from employee where id=3;
select * from employee;
rollback to insertionStep; -- undo
select * from employee;


update employee set name="raju" where id=1;
select * from employee;
rollback to insertionStep;
select * from employee;


delete from employee where id=3;
commit;
rollback to insertionStep;
select * from employee;

drop database t231;