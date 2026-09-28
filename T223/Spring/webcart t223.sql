create database webcart;
use webcart;
show tables;
select * from category;
select * from sub_category;

show tables;
desc vendor;

insert into vendor(id,address,company_name,email,phone)
values
(98, "pune", "d-mart","dmart@gmail.com","9845673564"),
(91, "thane", "relience smart","relience@gmail.com","9845673589"),
(92, "mumbai", "big-bazar","bb@gmail.com","9845673514");

select * from vendor;
select * from product;