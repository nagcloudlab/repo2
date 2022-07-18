

create database mypaydb;
use mypaydb;
drop table accounts;
create table accounts(
	number varchar(12) primary key,
	balance double
);
insert into accounts(number,balance) values ('1',1000.00);
insert into accounts(number,balance) values ('2',1000.00);
select * from accounts;
create table  transactions (
	id int primary key auto_increment,
	amount double,
    date timestamp,
    type varchar(10),
    acc_number varchar(12) references accounts(number)
);
select * from transactions;
