create database ECommercedb;
use ECommercedb;
create table ProdutList (prod_id int , prod_name varchar(255), details varchar(255), price int, quantity int );
select *from ECommercedb.ProdutList;
describe ProdutList;
insert into ProdutList (prod_id,prod_name, details,price,quantity) values
 (101, 'OPPO F-11 Pro', '8GB RAM, 256GB ROM with FAST CHARGER 32 Watt', 19599,6),
 (102, 'BAJAJ MIXER','WITH 3 EXTRA JARS', 1559,4),
 (103, 'SWEATER', 'MATERIAL- PURE SOFT WOOLEN, COLOUR-BLACK',1202,4),
 (104, 'SHOES', 'FOR WOKWOUT',1336,6),
 (105, 'PERFUME','LONG LASTING',153,7),
 (106, 'WATCH','DIGITAL- SMARTWATCH',2001,3),
 (107, 'HEADPHONES', 'WITH EXTRA BASS, NOICE CANCELLATION', 654,15),
 (108, 'T-SHIRTS','PURE COTTON', 299, 12),
 (109, 'SUNGLASSES', 'HIGH UV PROTECTION',1107,2),
 (110, 'ROTI MAKER','LOW ELECTRICITY CONSUMPTION',2488,6);
 
 SELECT * FROM ProdutList;
 
