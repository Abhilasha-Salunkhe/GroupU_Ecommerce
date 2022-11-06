
use ecommercedb;

create table userAdmin(user_Name varchar(255), admin_Password VARCHAR(255));
    describe userAdmin;
    insert into userAdmin(user_Name , admin_Password ) values ('group_u', '16722');
	select * from userAdmin;