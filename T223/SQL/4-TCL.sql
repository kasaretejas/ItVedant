use t223;
drop table employee;
create table employee(id int primary key auto_increment, name varchar(10));
start transaction;
insert into employee(name) values("raj"),("rani"),("sumit"),("amit");
savepoint insertion_step;
select * from employee;

update employee set name="raju" where id=1;
select * from employee;
rollback to insertion_step;
select * from employee;

delete from employee where id=1;
select * from employee;
rollback to insertion_step;
select * from employee;


delete from employee where id=1;
commit; -- all savepints will be deleted!
select * from employee;
rollback to insertion_step; -- SAVEPOINT insertion_step does not exist
