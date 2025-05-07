CREATE DATABASE coffee_store;
USE coffee_store;

CREATE TABLE product(
id INT auto_increment PRIMARY KEY,
name VARCHAR(40),
price DECIMAL(3,2)

);

CREATE TABLE customers(
id INT auto_increment PRIMARY KEY,
first_name VARCHAR(40),
last_name VARCHAR(40),
gender ENUM('M','F'),
phone_number varchar(10)

);
/*
changing a data type of a column
*/
alter table customers 
modify phone_number varchar(11);

CREATE TABLE orders(
id int auto_increment PRIMARY KEY,
product_id int,
customers_id int ,
order_time DATETIME,
FOREIGN KEY(product_id) REFERENCES product(id),
FOREIGN KEY(customers_id) REFERENCES customers(id)

);
/*
changing name of  a column
*/
alter table orders
change customers_id customer_id int;

show tables;
/*
adding a new column
*/
alter table product
add column coffee_origin varchar(40);

select * from product;

insert into product(name, price, coffee_origin)
values('Espresso','4.32','Brazil'),('Mocchiato','5.2','Brazil'),('Cappuchino','5.2','Costa Rica'),
      ('Latte','6.0', 'Indonesia'),('Americano','8.0','Brazil'),('Flat White','8.1','Indonesia'),('Filter','5.8','India');
/*
adding and deleting a  column
*/

alter table product 
drop column coffee_origin;

alter table product
add column coffee_origin varchar(40);
/*
By default sql only safe the changes made using primary key column in the table, so to disable that feature 
so that we can make the changes using other column names we use the below code
*/

set SQL_SAFE_UPDATES =0;


select * from product;

update product
set coffee_origin='Sri Lanka'
where name='Filter';

update product
set price='7.5', coffee_origin='Colombia'
where name='Americano';

select * from product;
Delete from product
where name='Filter';

insert into product(name, price, coffee_origin)
values('Filter','4.4','Sri Lanka');

update product
set id='7'
where name='Filter';
 /*
 inserting items into the customers table
 */
 INSERT INTO customers (first_name, last_name, gender, phone_number) 
 VALUES ('Chris','Martin','M','01123147789'),('Emma','Law','F','01123439899'),
 ('Mark','Watkins','M','01174592013'),('Daniel','Williams','M',NULL),('Sarah','Taylor','F','01176348290'),
 ('Katie','Armstrong','F','01145787353'),('Michael','Bluth','M','01980289282'),('Kat','Nash','F','01176987789'),
 ('Buster','Bluth','M','01173456782'),('Charlie',NULL,'F','01139287883'),('Lindsay','Bluth','F','01176923804'),
 ('Harry','Johnson','M',NULL),('John','Smith','M','01174987221'),('John','Taylor','M',NULL),
 ('Emma','Smith','F','01176984116'),('Gob','Bluth','M','01176985498'),('George','Bluth','M','01176984303'),
 ('Lucille','Bluth','F','01198773214'),('George','Evans','M','01174502933'),
 ('Emily','Simmonds','F','01899284352'),('John','Smith','M','01144473330'),
 ('Jennifer',NULL,'F',NULL),('Toby','West','M','01176009822'),('Paul','Edmonds','M','01966947113');
 
 select * from customers;
 /*
 inserting items into the orders table
 */
 INSERT INTO orders (product_id,customer_id,order_time)
 VALUES (1,1,'2017-01-01 08:02:11'),(1,2,'2017-01-01 08:05:16'),(5,12,'2017-01-01 08:44:34'),
 (3,4,'2017-01-01 09:20:02'),(1,9,'2017-01-01 11:51:56'),(6,22,'2017-01-01 13:07:10'),
 (1,1,'2017-01-02 08:03:41'),(3,10,'2017-01-02 09:15:22'),(2,2,'2017-01-02 10:10:10'),
 (3,13,'2017-01-02 12:07:23'),(1,1,'2017-01-03 08:13:50'),(7,16,'2017-01-03 08:47:09'),
 (6,21,'2017-01-03 09:12:11'),(5,22,'2017-01-03 11:05:33'),(4,3,'2017-01-03 11:08:55'),
 (3,11,'2017-01-03 12:02:14'),(2,23,'2017-01-03 13:41:22'),(1,1,'2017-01-04 08:08:56'),
 (3,10,'2017-01-04 11:23:43'),(4,12,'2017-01-05 08:30:09'),(7,1,'2017-01-06 09:02:47'),
 (3,18,'2017-01-06 13:23:34'),(2,16,'2017-01-07 09:12:39'),(2,14,'2017-01-07 11:24:15'),
 (4,5,'2017-01-08 08:54:11'),(1,1,'2017-01-09 08:03:11'),(6,20,'2017-01-10 10:34:12'),
 (3,3,'2017-01-10 11:02:11'),(4,24,'2017-01-11 08:39:11'),(4,8,'2017-01-12 13:20:13'),
 (1,1,'2017-01-14 08:27:10'),(4,15,'2017-01-15 08:30:56'),(1,7,'2017-01-16 10:02:11'),
 (2,10,'2017-01-17 09:50:05'),(1,1,'2017-01-18 08:22:55'),(3,9,'2017-01-19 09:00:19'),
 (7,11,'2017-01-19 11:33:00'),(6,12,'2017-01-20 08:02:21'),(3,14,'2017-01-21 09:45:50'),
 (5,2,'2017-01-22 10:10:34'),(6,24,'2017-01-23 08:32:19'),(6,22,'2017-01-23 08:45:12'),
 (6,17,'2017-01-23 12:45:30'),(2,11,'2017-01-24 08:01:27'),(1,1,'2017-01-25 08:05:13'),
 (6,11,'2017-01-26 10:49:10'),(7,3,'2017-01-27 09:23:57'),(7,1,'2017-01-27 10:08:16'),
 (3,18,'2017-01-27 10:13:09'),(4,19,'2017-01-27 11:02:40'),(3,10,'2017-01-28 08:03:21'),
 (1,2,'2017-01-28 08:33:28'),(1,12,'2017-01-28 11:55:33'),(1,13,'2017-01-29 09:10:17'),
 (6,6,'2017-01-30 10:07:13'),(1,1,'2017-02-01 08:10:14'),(2,14,'2017-02-02 10:02:11'),
 (7,10,'2017-02-02 09:43:17'),(7,20,'2017-02-03 08:33:49'),(4,21,'2017-02-04 09:31:01'),
 (5,22,'2017-02-05 09:07:10'),(3,23,'2017-02-06 08:15:10'),(2,24,'2017-02-07 08:27:26'),
 (1,1,'2017-02-07 08:45:10'),(6,11,'2017-02-08 10:37:10'),(3,13,'2017-02-09 08:58:18'),
 (3,14,'2017-02-10 09:12:40'),(5,4,'2017-02-10 11:05:34'),(1,2,'2017-02-11 08:00:38'),
 (3,8,'2017-02-12 08:08:08'),(7,20,'2017-02-12 09:22:10'),(1,1,'2017-02-13 08:37:45'),
 (5,2,'2017-02-13 12:34:56'),(4,3,'2017-02-14 08:22:43'),(5,4,'2017-02-14 09:12:56'),
 (3,5,'2017-02-15 08:09:10'),(6,7,'2017-02-15 09:05:12'),(1,8,'2017-02-15 09:27:50'),
 (2,9,'2017-02-16 08:51:12'),(3,10,'2017-02-16 13:07:46'),(4,11,'2017-02-17 08:03:55'),
 (4,12,'2017-02-17 09:12:11'),(5,10,'2017-02-17 11:41:17'),(6,18,'2017-02-17 13:05:56'),
 (7,19,'2017-02-18 08:33:27'),(1,17,'2017-02-19 08:12:31'),(1,1,'2017-02-20 09:50:17'),
 (3,5,'2017-02-20 09:51:29'),(4,6,'2017-02-20 10:43:39'),(3,1,'2017-02-21 08:32:17'),
 (1,1,'2017-02-21 10:30:11'),(3,2,'2017-02-21 11:08:45'),(4,3,'2017-02-22 11:46:32'),
 (2,15,'2017-02-22 13:35:16'),(6,13,'2017-02-23 08:34:48'),(4,24,'2017-02-24 08:32:03'),
 (2,13,'2017-02-25 08:03:12'),(7,17,'2017-02-25 09:34:23'),(7,23,'2017-02-25 11:32:54'),
 (5,12,'2017-02-26 11:47:34'),(6,4,'2017-02-27 12:12:34'),(1,1,'2017-02-28 08:59:22');
 
 select * from orders;
 
 select * from customers;
 
 /*
 now going to learn how to select specific items from a table
 */
 select last_name, phone_number from customers;
 
 select * from product;
 
 select * from product
 where price=5.20;
 
 select * from product
 where price=5.20
 and coffee_origin= 'Brazil';
 
 select * from product
 where price=5.20
 or coffee_origin= 'Brazil';
 
  select * from product
 where price>=5.20;
 
  select * from customers
 where phone_number is null;
 
 
  select * from customers
 where phone_number is not null;
 -- from the customers table, select firt name and phone numbers of all the females whose last name is Bluth
 
 select * from customers;
 
 select first_name, phone_number from customers
 where gender='F'
 and last_name='Bluth';
 
 -- how many male customers do not have there phone number entered in the table
 select * from customers
 where gender='M'
 and phone_number is null;
 -- Now lets learn how to use 'in' and 'not in' :
 -- select customers whose last name is either or them Bluth, Armstrong, Taylor
 
 select * from customers 
 where last_name in('Bluth','Armstrong','Taylor');
 
 -- select customers where first name is neither of them:katie, John, George
 
 
 select * from customers 
 where last_name not in('Katie','John','George');
 
 -- using between keyword
 
 -- select all deltails of orders for customer id between 5 and 10
 
 select product_id, customer_id, order_time from orders
 where customer_id between 5 and 10;
 
 select * from orders;
 -- note that both varchar and DateTime values will go inside inverted commas
 select product_id, customer_id, order_time from orders
 where order_time  between '2017-01-01' and '2017-01-07';
 
 -- using the like keyword
 -- letter followed by % means any number of characters after it
 -- % followed by letter which is then followed by % means any numbers of characters before and after the mentioned letter  
 select * from customers
 where last_name like 'W%';
 
 
 select * from customers
 where first_name like '%O%';
 
 -- underscore ie _ means only one character so _o means name where there is only one character before o 
 -- and _o_ means there is only one character before and after o 
 
 select * from customers;
 select * from customers
 where last_name like '_a';
 -- using order by clause to arrange items
 select * from product
 order by price asc;
 
 select * from customers;
 
 select * from customers
 order by first_name desc;
 
 select * from orders;
 
 select * from orders
 -- select the order details of customer with id 1 in ascending order of his order time
 where customer_id=1
 order by order_time asc;
 
 -- from the products table, select the name and price of all products of coffee origin of colombia or
 -- indonesia and order by name from a to z
 
 select name , price from product
 where coffee_origin in( 'colombia','indonesia')
 order by name asc;
 -- from the orders table, select all the orders from feb 2017 for customers with id: 2,4,6, 8
 
 select * from orders
 where customer_id in (2,4,6,8)
 and order_time between '2017-02-01' and '2017-02-28';
 
 -- from the customers table, select the first name and phone number of all the customers whose last name
 -- contain the pattern 'ar'
 
 select first_name, phone_number, last_name from customers
 where last_name like '%ar%';
 select * from customers
 where last_name like '_p_';
 
 -- how to use limit , limit clause ensures that only the specified nummber of data is selected
 
 select * from customers
 limit 6;
 
 -- offset means while selecting the data from the table leave the number of secified data so in below ex 
 -- we are selecting 10 items but only after leaving the first 7
 select * from customers
 limit 10 offset 7;
 
 -- alias clause allows us to select and display a column by a different name but remember that it does not 
 -- change the original name in the db
 select * from product;
 select name as coffee, coffee_origin as country from product;
 
 -- from the customer table , select distinct last names and order them alphabatically from a-z
 select distinct last_name from customers
order by last_name asc;

-- from the orders table , select the first 3 orders placed by customer with id 1, in feb 2017

select * from orders
where customer_id=1 and order_time between '2017-02-01' and '2017-02-28'
limit 3 ;
 /*
 the below code is the one which I created to create a new db to use for one to one bidirectional mapping
 */
 create database hb_02_one_to_one_bi;
/*in the name of the database dash sign cannot come, the sign created before would be created in the past,but
in this version of sql dash sign cannot be used
*/
use hb_02_one_to_one_bi;
create table instructor_detail(
id int   auto_increment primary key,
youtube_channel varchar(40),
hobby varchar(40)
);
create table instructor(
id int   auto_increment primary key,
first_name varchar(40),
last_name varchar(40),
email varchar(40),
instructor_detail_id int ,
foreign key(instructor_detail_id) references instructor_detail(id)
);