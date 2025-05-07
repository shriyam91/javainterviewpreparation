/*
JOINS:- joins allow you to retrieve data from multiple tables in a single statement.
- To join two tables there has to be a related column b/w them.
- There are many different kind of joins.
INNER JOIN: It will retrieve only that data which is common in  both tables, ie the data that is present in
both the tables.
LEFT JOIN: It will retrieve all the data from tables1 but only the matching data(the data that is present
in both the tables) from table2.
RIGHT JOIN:It will retrieve all the data from tables2 but only the matching data(the data that is present
in both the tables) from table1.
NOTE: there is no FULL JOIN in mysql
*/
-- Understanding the use of inner join:
 -- select name of product from the product table aand the ordertime from the orders table
 use coffee_store;
 select * from product;
 select * from orders;
 select product.name, orders.order_time from orders
 inner join product on orders.product_id=product.id;
-- doin a query using left join:
select o.id, c.phone_number, c.last_name, o.order_time from orders o
left join customers c on o.customer_id= c.id
limit 10;

select o.id, c.phone_number, c.last_name, o.order_time from orders o
right join customers c on o.customer_id= c.id
limit 10;
-- note: while performing the left and right join we have to be very sure about table1 and table2
 -- joining 3 tables using inner join:
 select p.name, p.price, c.first_name, c.last_name, o.order_time from orders o
 inner join product p on o.product_id= p.id
 inner join customers on o.customer_id= c.id;
 -- in the the above query there is no direct relation b/w product table and the customers table but
 -- is link b/w orders and customers table and orders and product table so we will join the product
 -- and customers table using the orders table
 -- excersice: 1: select the order id and customers phone number for all the orders of product id 4.
use coffee_store;
 select orders.id, customers.phone_number from orders
 inner join customers on orders.customer_id= customers.id
 where orders.product_id = 4;
 -- 2: select the product name and order time and price for all orders from females in jan 2017
 select p.name, p.price, o.order_time from orders o
 inner join product p on o.product_id= p.id
 inner join customers c on o.customer_id=c.id
 where c.gender='F'
 and o.order_time between '2017-01-01' and '2017-01-30 ';
/*
1st normal form: tables are in 1st normal form if:
:there is no repeated rows of data.
:columns only contain a single vlue.
:The table has a primary key.
2nd normal form: tables are in 2nf if:
:they confirm to 1nf.
: every column that is not a primary key of the table is dependent on the whole of the primary key(from whole of
the primary key we mean that we can also have more than one column as primary key.

3rd normal form: a table is in 3rd normal form:
:they confirm to 2nf.
:every column that is not a primary key is only dependent on the whole of the primary key.

RELATIONSHIP: ONE TO ONE RELATIONSHIP:
where a key to one table appears no more than once as the key in another table and vice versa.
ONE TO MANY RELATIONSHIP:  where a primary key of one table can be in multiple rows of a foreign key column
 of another table.
 MANY TO MANY RELATIONSHIP:  where 2 tables can have many instances of each other.
 CONSTRAINTS:
 NOT NULL: a column cannot contain a null value.
 UNIQUE:  a column cannot contain duplicate values of data.
 primary key: a column that uniquly identifies each row of data.
 foreign key: a column which is uniquly related to primary key in another table.
*/ 

create database cinema_booking_system;
use cinema_booking_system;
create table films(
id int primary key auto_increment,
name varchar(50) not null  unique,
length_min int not null
);

create table customers(
id int primary key auto_increment,
first_name varchar(50)   ,
last_name varchar(50)  not null,
email varchar(50)  not null unique
);
describe customers;

create table rooms(
id int primary key auto_increment,
name varchar(50) not null  ,
no_seats int not null
);

create table screeningss(
id int primary key auto_increment,
film_id int not null    ,
room_id  int not null,
start_time  datetime  not null,
foreign key(film_id) references films(id),
foreign key(room_id) references rooms(id)
);
show tables;
rename table screeningss to screenings; 
describe screenings;

create table seats(
id int primary key auto_increment,
row_num char(1) not null   ,
 number int  not null,
room_id int  not null ,
foreign key(room_id) references rooms(id)

);
describe seats;

create table bookings(
id int primary key auto_increment,


screening_id int  not null ,
customer_id int  not null ,
foreign key(screening_id) references screenings(id),
foreign key(customer_id) references customers(id)

);

create table reserved_seat(
id int primary key auto_increment,
booking_id int not null,
seat_id int not null,
foreign key(booking_id) references bookings(id),
foreign key(seat_id) references seats(id)
);
describe bookings;
-- inserting data into films table

INSERT INTO films (name, length_min)
VALUES ('Blade Runner 2049',153),
('Dunkirk',106),
('Geostorm',121),
('Thor: Ragnarok',107),
('Jigsaw',116),
('The Death of Stalin',98),
('The Lego Ninjago Movie',101),
('Murder on the Orient Express',135),
('Paddington 2',88),
('Breathe',117),
('Blade Runner',127),
('Victoria and Abdul',112);
select * from films;
-- inserting data into customers table;
INSERT INTO customers (first_name, last_name, email)
VALUES ('David','May','dmay@gmail.com'),('Theresa','Davis','tdavis@gmail.com'),('Jerry','Martin','jermar@gmail.com'),('John','Smith','smithy@gmail.com'),
('Martin','Watkins','mwatto@gmail.com'),('Emma','Watson','itswingardiumleviosa@gmail.com'),('Javier','Pastore','jp@gmail.com'),('Charlotte','Hare','chare@gmail.com'),
('Mark','Smith','markysmith@gmail.com'),('Emily','Thorne','ethorne@gmail.com'),('David','Paul','davpaul@gmail.com'),('Cherry','Wang','cherryw@gmail.com'),
('Bort','Simpson','mynameisbort@gmail.com'),('Emma','Connor','econ@gmail.com'),('Jonathan','Edwards','jedwards@gmail.com'),('Simon','Davis','sdavis@gmail.com'),
('Sophie','Marshall','sophmarsh@gmail.com'),('Sally','Lam','slam@gmail.com'),('Kenneth','Harrison','kson@gmail.com'),(NULL,'Smith','smith@gmail.com'),
('Harry','Weasley','whatsmyname@gmail.com'),('Ron','Potter','thatsmyname@gmail.com'),('Ray','Wilkinson','wilky@gmail.com'),('Samuel','Windsor','royalty@gmail.com'),
('Jennifer','David','jda@gmail.com'),('Larry','Davis','larryd@gmail.com'),('Bolt','Tin','btin@gmail.com'),('Sarah','Thompson','sthompson1977@gmail.com'),
('Alan','Bennet','thosewerethedays@gmail.com'),('Brian','Apple','bapple101@gmail.com'),('Rob','Bryson','rbry@gmail.com'),('Shelly','Zu','szu@gmail.com'),
('Steve','Shoogan','sshoogan@gmail.com'),('Matthew','Gray','graym@gmail.com'),('Sally','Kramer','kallysramer@gmail.com'),('Peter','Chef','chefp@gmail.com'),
(NULL,'Cooke','nullcooke@gmail.com'),('Marty','Seinfeld','marfeld@gmail.com'),('Carl','Green','creen@gmail.com'),('Emma','Greene','egreene@gmail.com'),
('Michael','Bannon','mbannon@gmail.com'),('Paul','Showman','theshowman1@gmail.com'),('Harry','Goldthistle','hgold@gmail.com'),('Gill','Newton','gnew@gmail.com'),
('Preston','Peters','p2p@gmail.com'),('Simon','Smithson','sismithson@gmail.com'),('Benjamin','Rabbit','brabbit@gmail.com'),('Jerry','David','curb@gmail.com'),
('Olivia','Tulip','otulip@gmail.com'),('Richard','Horne','richhorne@gmail.com'),('Betty','Corbe','bcorbe@gmail.com'),('Anne','Callaway','acway@gmail.com'),
('Yifan','Way','yway@gmail.com'),('Charlie','Cheene','ccheene@gmail.com'),('Ula','Boon','uboon@gmail.com'),('Buster','David','bdavid@gmail.com'),
('Dustin','Beer','beerd@gmail.com'),('John','Sleet','knoweverything@gmail.com'),('August','Summer','asummer@gmail.com'),('Linda','Martins','lmart@gmail.com'),
('Chris','Kay','chkay@gmail.com'),('Christopher','Roberts','croberts@gmail.com'),('Robert','Winston','rwin@gmail.com'),('Daniel','Orbe','dorbe@gmail.com'),
('Joshua','Wells','wellj@gmail.com'),('Fred','Flinton','ff100@gmail.com'),('Paula','Winner','pwinner@gmail.com'),(NULL,'Canter','canter99@gmail.com'),
('Michael','Bassett','mbass@gmail.com'),('Michelle','Martins','mm109@gmail.com'),('Lorna','Brown','lbrown@gmail.com'),('Kerry','Vale','wish1985@gmail.com'),
('Sean','Borne','sborne@gmail.com'),('Craig','Evans','cevans@gmail.com'),('Alex','Sanders','asand@gmail.com'),('George','McNabb','gnabb@gmail.com'),
('Richard','Trout','redtrout@gmail.com'),('Stewart','Dee','sdee@gmail.com'),('Sue','Werkins','swerkins@gmail.com'),('Mel','Wozniack','mwoz@gmail.com'),
('Steve','Dole','sdole@gmail.com'),('Zara','Yelland','zy27@gmail.com'),('Irene','Mellon','mellonirene@gmail.com'),('Karen','Wall','kwall@gmail.com'),
('Lucy','Oak','loak@gmail.com'),('Orson','Young','oyoung@gmail.com'),('Oliver','Daniels','odaniels@gmail.com'),('Queen','Bee','qbee@gmail.com'),
('Vera','Jack','verajack@gmail.com'),('Thomas','Soft','softt@gmail.com'),(NULL,'Blair','nblair@gmail.com'),('Tim','Jones','tjones@gmail.com'),
('Nicola','Jenkins','njenk@gmail.com'),('Olivia','Jones','ojo@gmail.com'),('James','Depp','jdepp@gmail.com'),('Meryl','Steep','msteep@gmail.com'),
('Jake','Portman','jportman@gmail.com'),('Jenny','Appleton','japple@gmail.com'),('Simon','Hoover','shoover@gmail.com'),('Belinda','Marshall','belindam@gmail.com'),
('Stephanie','Watson','swatson@gmail.com'),('Art','Simons','simons@gmail.com'),('Stan','Smith','smithstan@gmail.com'),('Christopher','Roberts','robertsc@gmail.com'),
('Nathan','Gold','engold@gmail.com'),('Alain','Bennet','alainb@gmail.com'),('Lewis','Russelton','lrus@gmail.com'),('Josh','Reynolds','jrey@gmail.com'),
('William','Williams','williamw@gmail.com'),(NULL,'Pointer','apointer@gmail.com'),('Bort','Skinner','mynameisalsobort@gmail.com'),(NULL,'Smith','lonsmith@gmail.com'),
('Susan','Williams','swill@gmail.com'),('Yu','Xi','yuxi@gmail.com'),('Annabelle','Winks','anwinks@gmail.com'),('Andrew','Landhurst','andylandy@gmail.com'),
('Winston','Smith','room101@gmail.com'),('Gemma','Arton','garton@gmail.com'),('Renton','McDonald','rent@gmail.com'),('Maggie','Chu','chuchu@gmail.com');

select * from customers;
-- inserting data into rooms table;
INSERT INTO rooms (name, no_seats) 
VALUES ('Chaplin',72),
('Kubrick',36),
('Coppola',36);

select * from rooms;
-- inserting data into screenings table:
INSERT INTO screenings (film_id, room_id, start_time)
VALUES (2,1,'2017-10-01 13:00:00'),(1,2,'2017-10-01 13:30:00'),(2,3,'2017-10-01 14:00:00'),
(3,1,'2017-10-01 16:00:00'),(6,2,'2017-10-01 16:30:00'),(3,3,'2017-10-01 17:00:00'),
(4,1,'2017-10-01 19:00:00'),(6,2,'2017-10-01 19:30:00'),(4,3,'2017-10-01 20:00:00'),
(1,1,'2017-10-02 16:00:00'),(4,2,'2017-10-02 16:30:00'),(5,3,'2017-10-02 17:00:00'),
(2,1,'2017-10-02 19:00:00'),(1,2,'2017-10-02 19:30:00'),(1,3,'2017-10-02 20:00:00'),
(5,1,'2017-10-03 16:00:00'),(3,2,'2017-10-03 16:30:00'),(2,3,'2017-10-03 17:00:00'),
(1,1,'2017-10-03 19:00:00'),(2,2,'2017-10-03 19:30:00'),(3,3,'2017-10-03 20:00:00'),
(3,1,'2017-10-04 16:00:00'),(1,2,'2017-10-04 16:30:00'),(4,3,'2017-10-04 17:00:00'),
(2,1,'2017-10-04 19:00:00'),(1,2,'2017-10-04 19:30:00'),(5,3,'2017-10-04 20:00:00'),
(3,1,'2017-10-05 16:00:00'),(4,2,'2017-10-05 16:30:00'),(6,3,'2017-10-05 17:00:00'),
(2,1,'2017-10-05 19:00:00'),(6,2,'2017-10-05 19:30:00'),(3,3,'2017-10-05 20:00:00'),
(1,1,'2017-10-06 16:00:00'),(5,2,'2017-10-06 16:30:00'),(2,3,'2017-10-06 17:00:00'),
(4,1,'2017-10-06 19:00:00'),(2,2,'2017-10-06 19:30:00'),(4,3,'2017-10-06 20:00:00'),
(2,1,'2017-10-07 13:00:00'),(1,2,'2017-10-07 13:30:00'),(2,3,'2017-10-07 14:00:00'),
(3,1,'2017-10-07 16:00:00'),(1,2,'2017-10-07 16:30:00'),(1,3,'2017-10-07 17:00:00'),
(3,1,'2017-10-07 19:00:00'),(2,2,'2017-10-07 19:30:00'),(1,3,'2017-10-07 20:00:00'),
(7,1,'2017-10-08 13:00:00'),(1,2,'2017-10-08 13:30:00'),(1,3,'2017-10-08 14:00:00'),
(7,1,'2017-10-08 16:00:00'),(3,2,'2017-10-08 16:30:00'),(2,3,'2017-10-08 17:00:00'),
(2,1,'2017-10-08 19:00:00'),(5,2,'2017-10-08 19:30:00'),(7,3,'2017-10-08 20:00:00'),
(1,1,'2017-10-09 16:00:00'),(7,2,'2017-10-09 16:30:00'),(8,3,'2017-10-09 17:00:00'),
(3,1,'2017-10-09 19:00:00'),(8,2,'2017-10-09 19:30:00'),(9,3,'2017-10-09 20:00:00'),
(1,1,'2017-10-10 16:00:00'),(6,2,'2017-10-10 16:30:00'),(6,3,'2017-10-10 17:00:00'),
(3,1,'2017-10-10 19:00:00'),(9,2,'2017-10-10 19:30:00'),(6,3,'2017-10-10 20:00:00'),
(8,1,'2017-10-11 16:00:00'),(4,2,'2017-10-11 16:30:00'),(5,3,'2017-10-11 17:00:00'),
(9,1,'2017-10-11 19:00:00'),(3,2,'2017-10-11 19:30:00'),(4,3,'2017-10-11 20:00:00'),
(4,1,'2017-10-12 16:00:00'),(7,2,'2017-10-12 16:30:00'),(6,3,'2017-10-12 17:00:00'),
(3,1,'2017-10-12 19:00:00'),(7,2,'2017-10-12 19:30:00'),(7,3,'2017-10-12 20:00:00'),
(5,1,'2017-10-13 16:00:00'),(2,2,'2017-10-13 16:30:00'),(8,3,'2017-10-13 17:00:00'),
(9,1,'2017-10-13 19:00:00'),(2,2,'2017-10-13 19:30:00'),(9,3,'2017-10-13 20:00:00'),
(1,1,'2017-10-14 13:00:00'),(4,2,'2017-10-14 13:30:00'),(6,3,'2017-10-14 14:00:00'),
(2,1,'2017-10-14 16:00:00'),(1,2,'2017-10-14 16:30:00'),(5,3,'2017-10-14 17:00:00'),
(3,1,'2017-10-14 19:00:00'),(7,2,'2017-10-14 19:30:00'),(7,3,'2017-10-14 20:00:00'),
(2,1,'2017-10-15 13:00:00'),(10,2,'2017-10-15 13:30:00'),(11,3,'2017-10-15 14:00:00'),
(2,1,'2017-10-15 16:00:00'),(10,2,'2017-10-15 16:30:00'),(11,3,'2017-10-15 17:00:00'),
(3,1,'2017-10-15 19:00:00'),(10,2,'2017-10-15 19:30:00'),(11,3,'2017-10-15 20:00:00'),
(1,1,'2017-10-16 16:00:00'),(4,2,'2017-10-16 16:30:00'),(4,3,'2017-10-16 17:00:00'),
(4,1,'2017-10-16 19:00:00'),(4,2,'2017-10-16 19:30:00'),(2,3,'2017-10-16 20:00:00'),
(7,1,'2017-10-17 16:00:00'),(5,2,'2017-10-17 16:30:00'),(1,3,'2017-10-17 17:00:00'),
(8,1,'2017-10-17 19:00:00'),(7,2,'2017-10-17 19:30:00'),(7,3,'2017-10-17 20:00:00'),
(9,1,'2017-10-18 16:00:00'),(8,2,'2017-10-18 16:30:00'),(6,3,'2017-10-18 17:00:00'),
(6,1,'2017-10-18 19:00:00'),(3,2,'2017-10-18 19:30:00'),(5,3,'2017-10-18 20:00:00'),
(5,1,'2017-10-19 16:00:00'),(2,2,'2017-10-19 16:30:00'),(9,3,'2017-10-19 17:00:00'),
(3,1,'2017-10-19 19:00:00'),(4,2,'2017-10-19 19:30:00'),(9,3,'2017-10-19 20:00:00'),
(1,1,'2017-10-20 16:00:00'),(1,2,'2017-10-20 16:30:00'),(8,3,'2017-10-20 17:00:00'),
(2,1,'2017-10-20 19:00:00'),(6,2,'2017-10-20 19:30:00'),(4,3,'2017-10-20 20:00:00'),
(1,1,'2017-10-21 13:00:00'),(9,2,'2017-10-21 13:30:00'),(7,3,'2017-10-21 14:00:00'),
(2,1,'2017-10-21 16:00:00'),(8,2,'2017-10-21 16:30:00'),(2,3,'2017-10-21 17:00:00'),
(3,1,'2017-10-21 19:00:00'),(7,2,'2017-10-21 19:30:00'),(1,3,'2017-10-21 20:00:00'),
(3,1,'2017-10-22 13:00:00'),(11,2,'2017-10-22 13:30:00'),(10,3,'2017-10-22 14:00:00'),
(2,1,'2017-10-22 16:00:00'),(11,2,'2017-10-22 16:30:00'),(10,3,'2017-10-22 17:00:00'),
(4,1,'2017-10-22 19:00:00'),(11,2,'2017-10-22 19:30:00'),(10,3,'2017-10-22 20:00:00'),
(6,1,'2017-10-23 16:00:00'),(6,2,'2017-10-23 16:30:00'),(9,3,'2017-10-23 17:00:00'),
(12,1,'2017-10-23 19:00:00'),(6,2,'2017-10-23 19:30:00'),(9,3,'2017-10-23 20:00:00'),
(5,1,'2017-10-24 16:00:00'),(9,2,'2017-10-24 16:30:00'),(9,3,'2017-10-24 17:00:00'),
(12,1,'2017-10-24 19:00:00'),(8,2,'2017-10-24 19:30:00'),(8,3,'2017-10-24 20:00:00'),
(8,1,'2017-10-25 16:00:00'),(7,2,'2017-10-25 16:30:00'),(7,3,'2017-10-25 17:00:00'),
(9,1,'2017-10-25 19:00:00'),(5,2,'2017-10-25 19:30:00'),(6,3,'2017-10-25 20:00:00'),
(12,1,'2017-10-26 16:00:00'),(7,2,'2017-10-26 16:30:00'),(5,3,'2017-10-26 17:00:00'),
(12,1,'2017-10-26 19:00:00'),(9,2,'2017-10-26 19:30:00'),(12,3,'2017-10-26 20:00:00'),
(5,1,'2017-10-27 16:00:00'),(12,2,'2017-10-27 16:30:00'),(12,3,'2017-10-27 17:00:00'),
(7,1,'2017-10-27 19:00:00'),(12,2,'2017-10-27 19:30:00'),(7,3,'2017-10-27 20:00:00'),
(6,1,'2017-10-28 13:00:00'),(12,2,'2017-10-28 13:30:00'),(5,3,'2017-10-28 14:00:00'),
(5,1,'2017-10-28 16:00:00'),(6,2,'2017-10-28 16:30:00'),(5,3,'2017-10-28 17:00:00'),
(5,1,'2017-10-28 19:00:00'),(7,2,'2017-10-28 19:30:00'),(8,3,'2017-10-28 20:00:00'),
(12,1,'2017-10-29 13:00:00'),(8,2,'2017-10-29 13:30:00'),(9,3,'2017-10-29 14:00:00'),
(12,1,'2017-10-29 16:00:00'),(9,2,'2017-10-29 16:30:00'),(6,3,'2017-10-29 17:00:00'),
(5,1,'2017-10-29 19:00:00'),(5,2,'2017-10-29 19:30:00'),(12,3,'2017-10-29 20:00:00'),
(5,1,'2017-10-30 16:00:00'),(7,2,'2017-10-30 16:30:00'),(12,3,'2017-10-30 17:00:00'),
(5,1,'2017-10-30 19:00:00'),(12,2,'2017-10-30 19:30:00'),(7,3,'2017-10-30 20:00:00'),
(5,1,'2017-10-31 13:00:00'),(12,2,'2017-10-31 13:30:00'),(8,3,'2017-10-31 14:00:00'),
(5,1,'2017-10-31 16:00:00'),(5,2,'2017-10-31 16:30:00'),(9,3,'2017-10-31 17:00:00');
-- inserting data into seats table:
describe seats;
INSERT INTO seats (row_num, number, room_id)
VALUES ('A',1,1),('A',2,1),('A',3,1),('A',4,1),('A',5,1),('A',6,1),('A',7,1),('A',8,1),
('B',1,1),('B',2,1),('B',3,1),('B',4,1),('B',5,1),('B',6,1),('B',7,1),('B',8,1),
('C',1,1),('C',2,1),('C',3,1),('C',4,1),('C',5,1),('C',6,1),('C',7,1),('C',8,1),
('D',1,1),('D',2,1),('D',3,1),('D',4,1),('D',5,1),('D',6,1),('D',7,1),('D',8,1),
('E',1,1),('E',2,1),('E',3,1),('E',4,1),('E',5,1),('E',6,1),('E',7,1),('E',8,1),
('F',1,1),('F',2,1),('F',3,1),('F',4,1),('F',5,1),('F',6,1),('F',7,1),('F',8,1),
('G',1,1),('G',2,1),('G',3,1),('G',4,1),('G',5,1),('G',6,1),('G',7,1),('G',8,1),
('H',1,1),('H',2,1),('H',3,1),('H',4,1),('H',5,1),('H',6,1),('H',7,1),('H',8,1),
('I',1,1),('I',2,1),('I',3,1),('I',4,1),('I',5,1),('I',6,1),('I',7,1),('I',8,1),
('A',1,2),('A',2,2),('A',3,2),('A',4,2),('A',5,2),('A',6,2),
('B',1,2),('B',2,2),('B',3,2),('B',4,2),('B',5,2),('B',6,2),
('C',1,2),('C',2,2),('C',3,2),('C',4,2),('C',5,2),('C',6,2),
('D',1,2),('D',2,2),('D',3,2),('D',4,2),('D',5,2),('D',6,2),
('E',1,2),('E',2,2),('E',3,2),('E',4,2),('E',5,2),('E',6,2),
('F',1,2),('F',2,2),('F',3,2),('F',4,2),('F',5,2),('F',6,2),
('A',1,3),('A',2,3),('A',3,3),('A',4,3),('A',5,3),('A',6,3),
('B',1,3),('B',2,3),('B',3,3),('B',4,3),('B',5,3),('B',6,3),
('C',1,3),('C',2,3),('C',3,3),('C',4,3),('C',5,3),('C',6,3),
('D',1,3),('D',2,3),('D',3,3),('D',4,3),('D',5,3),('D',6,3),
('E',1,3),('E',2,3),('E',3,3),('E',4,3),('E',5,3),('E',6,3),
('F',1,3),('F',2,3),('F',3,3),('F',4,3),('F',5,3),('F',6,3);
-- inserting data in bookings table:
INSERT INTO bookings (screening_id, customer_id)
VALUES (2,2),(1,4),(2,6),(4,8),(6,10),(1,12),(5,14),(1,16),(2,18),(3,20),
(5,120),(4,12),(8,24),(10,33),(9,37),(4,67),(11,87),(4,109),(5,12),(6,21),
(8,11),(10,13),(14,7),(16,103),(18,81),(7,89),(17,52),(7,50),(8,49),(9,37),
(11,1),(16,37),(20,4),(22,23),(21,24),(10,24),(23,24),(10,55),(14,51),(12,69),
(14,3),(22,34),(26,33),(28,35),(27,65),(13,22),(29,22),(13,100),(20,101),(12,58),
(17,5),(28,29),(32,33),(34,45),(33,32),(19,32),(35,30),(16,17),(26,56),(18,55),
(17,7),(31,11),(38,26),(40,4),(30,51),(25,38),(41,37),(22,101),(32,99),(15,76),
(20,9),(37,10),(44,21),(46,55),(33,22),(31,33),(47,44),(25,55),(38,42),(24,1),
(23,11),(37,1),(50,77),(52,23),(39,1),(43,5),(53,89),(28,88),(44,37),(30,2),
(26,12),(40,1),(56,66),(58,27),(42,7),(46,45),(59,22),(31,25),(50,29),(27,9),
(29,14),(43,1),(62,55),(64,11),(45,8),(49,56),(65,11),(37,26),(56,120),(33,1),
(32,15),(49,1),(68,44),(70,11),(51,13),(55,58),(71,1),(49,33),(56,116),(36,103),
(35,17),(55,56),(74,33),(70,17),(54,11),(61,77),(71,45),(58,78),(62,36),(66,9),
(38,19),(61,88),(80,57),(76,120),(66,100),(67,89),(77,49),(58,89),(62,17),(69,61),
(41,100),(67,22),(86,45),(82,119),(72,27),(73,90),(80,56),(61,68),(68,20),(33,9),
(44,66),(76,119),(92,82),(88,100),(81,89),(79,5),(83,65),(64,42),(74,80),(42,26),
(47,45),(82,118),(98,67),(94,11),(81,55),(82,4),(83,23),(67,4),(86,80),(45,19),
(50,44),(88,117),(104,61),(100,97),(81,35),(85,3),(89,35),(76,41),(86,90),(48,17),
(53,33),(94,116),(110,4),(106,54),(84,33),(88,2),(95,34),(76,27),(86,29),(51,28),
(56,39),(97,115),(116,4),(112,32),(90,33),(88,1),(101,34),(82,90),(86,101),(51,104),
(59,111),(100,114),(122,7),(118,35),(93,57),(88,77),(107,69),(91,96),(92,4),(54,35),
(92,100),(106,113),(128,9),(124,60),(87,88),(91,39),(113,67),(91,43),(98,90),(60,36),
(98,99),(112,112),(134,10),(130,43),(69,84),(97,31),(119,1),(97,3),(104,7),(63,1),
(104,4),(118,111),(140,1),(136,22),(72,67),(97,111),(125,87),(100,24),(110,46),(66,4),
(110,17),(130,110),(146,12),(142,22),(75,48),(100,111),(131,47),(103,24),(122,27),(69,27),
(122,55),(136,91),(152,11),(148,13),(84,90),(103,101),(137,12),(109,11),(128,10),(75,9),
(128,58),(142,90),(158,56),(154,15),(93,91),(109,34),(143,9),(115,34),(131,33),(78,81),
(134,88),(148,48),(164,78),(160,16),(102,22),(115,33),(149,47),(121,46),(137,6),(90,6),
(140,67),(154,40),(170,77),(166,78),(108,21),(121,26),(155,53),(127,42),(143,31),(99,11),
(152,45),(160,70),(176,38),(172,66),(114,20),(127,106),(161,111),(211,109),(149,108),(102,113),
(158,44),(166,87),(182,99),(178,65),(120,19),(136,99),(167,49),(133,66),(158,67),(117,3),
(164,71),(172,33),(188,100),(184,50),(144,18),(142,23),(173,46),(139,23),(164,1),(129,3),
(170,78),(178,35),(194,36),(187,23),(159,24),(151,23),(179,55),(145,58),(170,60),(141,4),
(176,70),(184,7),(200,36),(190,78),(162,70),(157,80),(182,99),(151,95),(176,32),(156,7),
(182,88),(190,8),(200,34),(193,74),(168,35),(163,120),(185,109),(157,31),(182,68),(180,56),
(191,47),(190,16),(200,1),(196,72),(177,11),(169,12),(191,19),(166,108),(176,23),(189,23),
(197,32),(196,26),(203,2),(199,80),(192,4),(175,49),(197,55),(172,76),(188,99),(195,90),
(200,23),(199,43),(206,3),(202,90),(198,59),(181,58),(200,59),(178,6),(194,35),(198,44),
(203,116),(202,28),(209,4),(205,93),(201,23),(187,10),(203,76),(187,77),(200,78),(204,9),
(209,18),(205,10),(209,5),(208,43),(204,67),(193,54),(206,54),(196,1),(206,7),(207,9),
(212,68),(211,5),(212,6),(211,7),(207,8),(199,9),(209,9),(205,23),(212,111),(213,40);

-- inserting data in reserved_seat table
INSERT INTO reserved_seat (booking_id, seat_id) 
VALUES (1,74),(1,75),(1,76),(2,10),(2,11),(3,100),(3,101),(4,66),(4,67),(5,141),
(6,33),(6,34),(7,102),(7,103),(8,2),(8,3),(8,4),(8,5),(9,98),(9,99),
(10,120),(11,74),(11,75),(11,76),(12,23),(12,24),(13,104),(13,105),(14,60),(14,61),
(15,130),(15,131),(16,71),(16,72),(17,88),(17,89),(18,51),(18,52),(18,53),(18,54),
(19,83),(19,84),(20,138),(21,94),(22,30),(22,31),(22,32),(23,101),(23,102),(23,103),
(23,75),(24,67),(24,68),(25,113),(25,114),(26,44),(27,97),(27,98),(28,71),(29,76),
(30,139),(31,79),(32,50),(33,80),(33,81),(33,82),(33,83),(33,84),(34,62),(34,63),
(35,120),(35,121),(36,16),(36,17),(37,82),(37,83),(38,59),(39,78),(40,111),(40,112),
(41,90),(41,91),(41,92),(42,52),(42,53),(42,54),(43,89),(43,90),(44,71),(44,72),
(45,120),(45,121),(46,38),(46,39),(47,101),(47,102),(48,62),(48,63),(48,64),(49,81),
(50,121),(50,122),(50,123),(50,124),(51,91),(51,92),(51,93),(51,94),(52,61),(52,62),
(53,107),(53,108),(54,67),(54,68),(55,117),(55,118),(56,61),(57,104),(57,105),(57,106),
(58,1),(58,2),(59,75),(59,76),(60,139),(60,140),(61,86),(61,87),(62,13),(62,14),
(63,101),(63,102),(63,103),(64,66),(64,67),(64,68),(65,120),(65,121),(65,122),(65,123),
(66,9),(66,10),(67,76),(68,48),(68,49),(68,50),(69,93),(69,94),(70,121),(70,122),
(71,80),(71,81),(71,82),(72,67),(72,68),(73,77),(73,78),(74,61),(74,62),(74,63),
(75,130),(75,131),(76,9),(76,10),(77,100),(78,57),(79,107),(80,110),(81,91),(81,92),
(82,5),(82,6),(83,104),(83,105),(84,23),(84,24),(85,118),(85,119),(85,120),(85,121),
(86,31),(86,32),(87,76),(87,77),(88,63),(89,89),(89,90),(89,91),(90,113),(90,114),
(91,79),(91,80),(91,81),(92,1),(92,2),(92,3),(92,4),(92,5),(92,6),(93,105),
(94,12),(94,13),(94,14),(95,111),(95,112),(95,113),(95,114),(96,59),(96,60),(96,61),
(97,81),(97,82),(98,47),(98,48),(99,85),(99,86),(100,118),(100,119),(101,103),(101,104),
(102,23),(102,24),(103,81),(103,82),(104,66),(104,67),(105,136),(105,137),(106,39),(106,40),
(107,75),(108,72),(109,101),(109,102),(109,103),(109,104),(109,105),(110,122),(110,123),(110,124),
(111,77),(111,78),(112,8),(113,82),(113,83),(114,56),(114,57),(115,139),(115,140),(116,69),
(117,75),(117,76),(117,77),(118,60),(119,88),(120,111),(121,108),(122,31),(122,32),(123,98),
(124,18),(124,19),(125,120),(125,121),(126,61),(126,62),(127,101),(127,102),(128,70),(128,71),
(129,105),(129,106),(130,141),(130,142),(131,77),(132,71),(133,106),(133,107),(133,108),(134,61),
(135,110),(135,111),(136,52),(137,84),(137,85),(138,37),(139,75),(139,76),(140,140),(140,141),
(141,90),(142,42),(143,94),(143,95),(144,66),(145,112),(146,21),(147,79),(147,80),(147,81),
(148,63),(149,89),(150,128),(150,129),(151,77),(151,78),(151,79),(152,57),(152,58),(152,59),
(153,89),(153,90),(153,91),(154,37),(154,38),(155,111),(155,112),(155,113),(156,19),(156,20),
(157,83),(158,5),(159,77),(160,140),(161,89),(162,9),(163,104),(164,71),(165,117),(165,118),
(166,66),(166,67),(167,83),(167,84),(167,85),(167,86),(168,55),(168,56),(168,57),(168,58),
(169,105),(169,106),(170,121),(170,122),(171,92),(172,36),(173,99),(174,38),(175,117),(175,118),
(176,68),(176,69),(177,81),(177,82),(178,31),(178,32),(179,103),(179,104),(180,119),(181,102),
(182,71),(182,72),(183,100),(183,101),(184,48),(184,49),(185,110),(185,111),(186,12),(186,13),
(187,78),(187,79),(188,39),(189,81),(190,135),(191,79),(192,33),(192,34),(192,35),(193,90),
(194,54),(194,55),(195,121),(195,122),(196,53),(196,54),(197,80),(197,81),(198,2),(198,3),
(199,81),(199,82),(200,115),(201,76),(202,27),(203,103),(203,104),(204,22),(205,140),(206,51),
(207,83),(208,64),(209,98),(210,118),(211,101),(212,61),(212,62),(213,79),(213,80),(214,50),
(215,111),(216,30),(216,31),(217,106),(217,107),(218,40),(218,41),(219,91),(219,92),(220,123),
(221,76),(222,20),(222,21),(223,105),(224,60),(225,133),(225,134),(226,70),(226,71),(226,72),
(227,83),(228,47),(229,80),(230,120),(230,121),(231,85),(231,86),(232,11),(232,12),(232,13),
(233,81),(233,82),(234,62),(234,63),(235,113),(235,114),(236,35),(236,36),(237,81),(237,82),
(238,41),(238,42),(239,77),(239,78),(240,129),(241,102),(241,103),(242,21),(242,22),(242,23),
(243,89),(244,45),(245,137),(245,138),(245,139),(245,140),(246,49),(246,50),(246,51),(247,101),
(248,34),(249,77),(250,138),(251,102),(251,103),(251,104),(252,61),(253,98),(253,99),(254,70),
(255,119),(255,120),(255,121),(256,23),(257,87),(258,36),(258,37),(259,95),(259,96),(260,132),
(261,88),(261,89),(261,90),(262,20),(262,21),(262,22),(262,23),(263,102),(264,63),(265,118),
(266,24),(267,79),(268,68),(269,90),(269,91),(270,120),(271,104),(272,8),(273,76),(274,33),
(275,122),(275,123),(275,124),(276,11),(276,12),(276,13),(277,82),(277,83),(278,27),(278,28),
(279,75),(279,76),(279,77),(280,140),(280,141),(281,80),(282,26),(283,100),(283,101),(283,102),
(284,23),(284,24),(285,121),(286,68),(287,78),(288,4),(288,5),(289,97),(290,113),(290,114),
(291,81),(291,82),(292,49),(293,85),(294,39),(295,140),(296,68),(297,82),(298,25),(298,26),
(299,83),(299,84),(300,134),(300,135),(301,101),(301,102),(302,56),(302,57),(303,92),(303,93),
(304,5),(305,112),(305,113),(306,61),(306,62),(307,81),(308,72),(309,88),(309,89),(310,123),
(311,97),(311,98),(311,99),(312,39),(312,40),(313,79),(314,61),(314,62),(315,144),(316,55),
(317,81),(317,82),(318,66),(319,101),(320,129),(321,83),(321,84),(322,13),(322,14),(322,15),
(323,89),(323,90),(324,37),(324,38),(325,115),(325,116),(326,68),(326,69),(326,70),(327,108),
(328,61),(329,77),(330,125),(330,126),(331,91),(331,92),(332,58),(332,59),(333,76),(333,77),
(334,23),(334,24),(335,131),(335,132),(336,10),(336,11),(337,99),(337,100),(338,67),(338,68),
(339,101),(339,102),(340,138),(341,105),(342,3),(342,4),(343,74),(343,75),(344,58),(344,59),
(345,122),(345,123),(346,34),(346,35),(347,79),(347,80),(348,27),(348,28),(348,29),(349,77),
(350,112),(350,113),(351,83),(351,84),(352,67),(352,68),(352,69),(353,101),(353,102),(353,103),
(354,13),(355,113),(355,114),(356,45),(357,90),(358,70),(359,79),(360,138),(361,97),(362,72),
(363,80),(364,54),(365,122),(366,30),(367,89),(368,48),(369,103),(370,110),(371,88),(372,62),
(373,81),(373,82),(374,59),(375,140),(376,70),(377,93),(378,23),(378,24),(378,25),(378,26),
(379,79),(379,80),(379,81),(380,118),(380,119),(381,103),(382,66),(382,67),(382,68),(382,69),
(383,77),(384,41),(384,42),(384,43),(385,125),(386,68),(387,84),(388,70),(388,71),(389,95),
(390,120),(390,121),(390,122),(391,76),(391,77),(391,78),(392,8),(392,9),(392,10),(393,103),
(394,39),(394,40),(395,127),(395,128),(395,129),(396,66),(396,67),(397,85),(397,86),(398,58),
(399,83),(399,84),(400,118),(400,119),(400,120),(401,103),(401,104),(401,105),(402,51),(403,75),
(404,34),(404,35),(405,109),(405,110),(405,111),(406,72),(407,93),(407,94),(408,49),(409,88),
(410,117),(410,118),(410,119);

/*
What are aggregate functions: performs a calculation on data with a column and returns one result row.
Can use group by clauses to group the results by one(or more)
*/

use cinema_booking_system;
select count(last_name) from customers;
select count(first_name) from customers;
select count(last_name) from customers
where last_name ='Smith';

select * from rooms;
select sum(no_seats) from rooms;
-- count does not count the null entries and ie why ans of the above 2 queries is different:




-- HAVING CLAUSE: having clause work as a where clause only but with  group by statements 

use cinema_booking_system;
select customer_id, screening_id, count(customer_id) from bookings
group by customer_id, screening_id;


use cinema_booking_system;
select customer_id, screening_id, count(customer_id) from bookings
group by customer_id, screening_id
having customer_id=10;

-- if we would have used where clause here then it would have given error, bcz with group by clause we only
-- use have and not 'where'

/*
1: select the customer id and count the number of  reserved seats grouped by customer for oct 2017
2: select the films name and count the number of screenings for each film that is over 2 hr long.
*/
select * from bookings;
select * from screenings;
select * from rooms;
select * from films;
select * from reserved_seat;
select * from seats;
-- solution for 1st by me:
select b.customer_id, count(s.number) from seats s 
inner join reserved_seat rs on rs.seat_id= s.id
inner join bookings b on rs.booking_id=b.id
group by b.customer_id;
-- solution for 1st by sir:
select b.customer_id, count(rs.id) from reserved_seat rs
inner join bookings b on rs.booking_id=b.id
group by b.customer_id;
-- solution for 2nd by me:

-- 2: select the films name and count the number of screenings for each film that is over 2 hr long.

select * from films;
select * from screenings;
select * from rooms;
describe films;
-- so in screenings's table's film_id column we can clearly see that one film has been screened more than
-- one time, so here simply we have to use group by clause on film name and film_id so that we can see that
-- how many time each film has been displayed

select f.name,f.length_min, count(s.film_id) from screenings s
inner join films f on f.id= s.film_id

group by f.name
having f.length_min>120;
-- note: the column for which we are doing a having clause, it is necessary to select that clause in the 
-- first select statement otherwise it will give error, for ex here since we have to check for length min in 
-- the having clause so it is necessary to select f.length_min in the first statement otherwise it gives error
-- solution by sir that is giving error on my sql version:
select f.name,f.length_min, count(s.id) from screenings
inner join films f on f.id= s.film_id

group by f.name
having f.length_min>120;

/*
subquerry: subqueries are queries nested within other queries.
ex: select id, start_time from screenings
where film_id IN
(select id from films
where length_min>120)

here first 2 lines are outer query and the last 2 lines within the bracket are inner query.
subqueries can be used in select, insert, update, delete statement.
subqueries are aslo called nested queries.
nested queries can be used in where clause of the select statement or it can come after the 'FROM' clause in
the select statement.
There are 2 types of subqueries:1) non corelated subquerry 2) corelated subquerry
- Non corelated subquery: The inner query can run independently of the outer query.
In non corelated subquery the inner query runs first and it runs only once and produces a set of results which
is then used by the outer query, like in the ex:
 select id, start_time from screenings
where film_id IN
(select id from films
where length_min>120)
 the inner query ie:
(select id from films
where length_min>120)  can run independently of the outer query and we do not need the outer query to enable
this inner query to run.
Correlated subquery: where the inner query cannot run independenty of the outer query, that is bcz the inner
query is using data from the outer query.
In correlated subquery the inner query runs for every row in the outer query.
ex: select screening_id,customer_id
(select count(seat_id) from reserved_seat
where  booking_id=b.id)
from bookings b;
-- so in the above ex two tables are used(without inner join, thanks to subquery) , in the where clause of 
subquery condition is  booking_id=b.id, but this condition can only run successfully when the inner query 
has information of the 'bookings.id' which is totally the part of the outer query, so here the inner query
is totally dependent on the outer query for it's successfull run.
*/

-- Non corelated subquery:
select * from screenings;
select * from films;

select films.name,start_time,count(film_id) from screenings
inner join films on screenings.film_id=films.id
where films.length_min>120
group by films.name;
-- writing a sub query consisting of an outer query and an non corelated inner query:
select id, film_id , start_time from screenings
where film_id IN
(select id from films
where length_min>120);

-- now to verify that this inner query is non corelated we will run it independently:

select id from films
where length_min>120;
-- and the above query runs independently also, so it is a  non corelated innerquery.
-- return 1st name, last name, email from th customers table but where screening id is equals to 1 in the 
-- bookings table
select * from customers;
select * from bookings;
select first_name,last_name, email from customers
where id in
(select customer_id from bookings
where screening_id=1);



-- from the above 2 queries it can be seen that while writing a nonrelated inner query we  make use of the
-- combination of primary key and foreign key in the where clause of the outer table not necessarily in the
-- same order ie primary key 1st in the where clause and then the foreign key or vice versa.
-- now doing the above query with inner join
select c.first_name,c.last_name, c.email from customers c
inner join bookings b on c.id=b.customer_id
where b.screening_id=1;
select * from reserved_seat;
select * from seats;
select booking_id,count(seat_id) from reserved_seat
group by booking_id; 
use cinema_booking_system;
-- now to select the booking id with maximum no of booked seat id:
 select max(seat_num) from
 (select booking_id,count(seat_id) as seat_num from reserved_seat
group by booking_id) b;
-- note from the above query that whenever we have to select max,min, avg from the inner query then 2 things
-- must to do : 1st: the table derived from the inner query must have an alias name,  if not given then 
-- erorr will pop up saying: the derived table must have an alias name, and that is why we have given
-- an alias name b to the derived table from the inner query and 2nd: the value which is inside the count
-- clause must have an alias name bcz we will use that name inside the outer query max/min/avg clause , and
-- the reason to do so is simple that since we are not mentioning any table's name in the outer query name
-- then how will the sql know that which column's max value has to be found out and since seat_ id is column
-- of the table that is part of the select statement inside inner query , so to make it available to the 
-- outer query we also have to give it an alias name.

 select avg(seat_num),max(seat_num) from
 (select booking_id,count(seat_id) as seat_num from reserved_seat
group by booking_id) b;

-- CORELATED SUBQUERY:
select * from bookings;
select * from reserved_seat;
select * from seats;
select screening_id, customer_id from bookings
group by screening_id;
-- above query tells that how many customer have book each screens, like screen 1 is booked by 4 customers
-- , screen 2 is booked by 2 customers and so on 
-- find out how many seats are book for each screeings, and also display the customer_id alongwith the number
-- of seats booked by that customer_id at each screening_id
select * from bookings;
select * from customers;
select * from reserved_seat;
select * from seats;
select b.screening_id,b.customer_id,count(number) from seats s 
inner join reserved_seat rs on s.id=rs.seat_id
inner join bookings b on rs.booking_id=b.id
group by screening_id,customer_id
order by screening_id;
-- now doing the above same query with the subquery method of using an outer and inner query
-- ps : i am comfortable of doing withe above method of using 3 inner joins
select screening_id,customer_id,
(select count(seat_id)
from reserved_seat where booking_id=b.id)
from bookings b
order by screening_id;

-- find out how many seats are book for each screeings, and also display the customer_id alongwith the 
-- name of that customer_id and the number of seats booked by that customer_id at each screening_id


select b.screening_id,b.customer_id,c.first_name,count(number) from seats s 
inner join reserved_seat rs on s.id=rs.seat_id
inner join bookings b on rs.booking_id=b.id
inner join customers c on b.customer_id=c.id
group by b.screening_id,c.first_name
order by screening_id;

/*
EXCERSISE:
1: select the film name and length for all the films with a length greater than the avg film length.
2:select the maximum number and the minimum number of screenings for a particular film.
3:select each film name and the number of screenings for that film.

*/ 
select * from films;
select avg(length_min) from films;
select name, length_min from films
where length_min >
(select avg(length_min) from films) ;

-- 2: 2:select the film with the maximum and minimum number of screenings.

select * from screenings;
select  min(film_screen_num), max( film_screen_num) from
(select f.name as film_name,count(s.film_id) as film_screen_num from screenings s
inner join films f on s.film_id= f.id
group by f.name) bb; 

 

-- in the above solution I decided to group by film name that is why I have to use inner join to
-- get the name of the film from the above table, however the above query can also be solved like:
select min(film_screen_num), max( film_screen_num) from
(select film_id , count(film_id) AS film_screen_num from screenings
group by film_id) bb;

select * from films;
select * from screenings;


-- 3:select each film name and the number of screenings for that film.


select f.name,count(s.film_id) as film_screen_num from screenings s
inner join films f on s.film_id= f.id

group by f.name ;
-- display the name of the film with the maximum and minimum screenings

select film_name, max(film_num), min(film_num) from 
( select f.name as film_name, count(s.film_id) as film_num from screenings s
inner join films f on s.film_id= f.id
group by f.name) dt
group by film_name
;

use cinema_booking_system;
select bb.name, bb.film_screen_num from 
(select f.name,count(s.film_id) as film_screen_num from screenings s
inner join films f on s.film_id= f.id

group by f.name )bb
where film_screen_num =
(select max(film_screen_num) from
(select f.name,count(s.film_id) as film_screen_num from screenings s
inner join films f on s.film_id= f.id

group by f.name )bb);
-- above is very lengthy method to display the name of the film with max screenings, now below is the smart 
-- way:
select f.name,f.length_min,count(s.film_id) as film_num from screenings s
inner join films f on s.film_id=f.id

group by f.name
order by film_num desc
limit 1;

-- now display the film name with 2nd highest screening:
select f.name,f.length_min,count(s.film_id) as film_num from screenings s
inner join films f on s.film_id=f.id

group by f.name
order by film_num desc
limit 1
offset 1;

select f.name,f.length_min,count(s.film_id) as film_num from screenings s
inner join films f on s.film_id=f.id

group by f.name;

/*
STRING FUNCIOTNS
*/
-- CONCATINATE:
-- SELECT CONCAT(column1,column2) AS new column_name from table;

select concat (first_name,last_name) as full_name from customers;
-- now in the above concatination of first name and last name there is no space in between, so to add space
select concat (first_name," ",last_name) as full_name from customers;
-- in the above concatination clause what we are doing is that we are concatinating 3 strings

-- SUBSTRING FUNCTION
-- select substring("string",start,length) as aliasname;
-- select substring("example",3,3) as newstring: result will be amp
-- and if we do not select the length then complete string will be selected from the starting letter
-- select substring("example",3) as newstring: result will be ample
-- also in substring we can mention the starting index as a negative number
-- ex select substring("example"-3,3) as newstring: result will be ple bcz -3 means 3rd last letter
-- ex select substring("punjabi"-4) as newstring: result will be jabi bcz -3=4 means 4rth last letter

-- UPPERCASE AND LOWERCASE
-- select upper(columnname) as newname from table; 
-- select lower(columnname) as newname from table; 

select * from rooms;
select upper(name) as room_name from rooms;
-- note that the above statement will not change the name of the column in the original table;
select lower(name) as room_name from rooms;

/*
EXERCISE:
1:Concatenate the film names and length from the films table.
2:extract the customer's email from the 5th character onwards.
3: select the customers first name in lower case and last name in upper case for each customer with last name as "Smith".
4:select last 3 letters of each films name from the film table.
5:concatenate the 1st 3 letters of the first name and the 1st 4 letters from the last name from the customers table.

*/
-- 1:
select * from films;
select concat("Length of the film ",name," is  ",length_min) as film_and_its_length from films;
-- 2: 
select substring(email,5) as short_email from customers;
-- note from the above 2 queries that the column name will never be inside double inverted commas
-- 3:
 select lower(first_name), upper(last_name) from customers
  where last_name="Smith";
  -- 4: 
  select substring(name,-3) from films;
  -- 5:
  select concat(substring(first_name,1,3),"  ",substring(last_name,1,3)) as short_name from customers;
  -- note from the above query that we can use a function on another function
  
  -- DATE FUNCTION:
  SELECT DATE("2017-01-03 08-23-47");
  -- SO THE above function will only return the date from te complete date time, so we can use this method
  -- in our queries where ever we have to only select date , ex:
  select * from screenings
  where start_time="2017-10-03";
  -- so the above query will not return anything bcz in screening table's start_time column time is in date 
  -- and time form so the above condition matches with none, so here comes date function in use
  select * from screenings
  where date(start_time)="2017-10-03";
  -- now the above query will work simply bcz the start_time se date extract ho jaegi using date function 
  select * from screenings
  where date(start_time) between "2017-10-03" and "2017-10-05";
  -- so the date function is also usefull when we have to return data b/w 2 dates
  -- note one thing, when we are using the date function to return dates b/w 2 dates then it takes into 
  -- consideration of the 1st  date from 00:00 hour ie start of the date  and the 2nd date till 23:59 
  -- ie till end of the date , when we return 
  -- data b/w dates  "2017-10-03" and "2017-10-05" then all data b/w 2017-10-03 00:00 and 2017-10-05 23:59
  -- will be returned ie for 3 days ie for 3rd, 4th,5th oct where as when we use:
  
   select * from screenings
  where start_time between "2017-10-03" and "2017-10-05";
  -- then it takes into consideration of both dates from 00:00 to 00:00  ie start of 1st date till start 
  -- of the 2nd date ie till 00:00 so it will return data only for 2 days ie 03 oct and 04 oct
  
   select month("2017-05-01");
   
   select month("2017-05-01 23:45:45");
   -- select data from screening for the month of oct:
   select * from screenings
   where month(start_time)="10";
   -- so if had years of data then the above query would return data for oct of every year
   
   
   select year("2017-05-01");
   select year("2017-05-01 23:45:45");
   
    select * from screenings
   where year(start_time)="2017";
   -- so if had years of data then the above query would return data for the paritcular year
  /*
  Excercise:
  1:select the film id and the start time from screenings table for the date of 20th oct 2017
  2:select all the data from the screenings table for the start time b/w 6th and 13th oct 2017
  3: select all the data from the screenings table for oct 2017
  */
  select film_id,start_time from screenings
  where date(start_time)='2017-10-20';
  
  
  select film_id,start_time from screenings
  where date(start_time) between "2017-10-06" and "2017-10-13";
  
  
  select film_id,start_time from screenings
  where month(start_time)='10';

/*
FINAL CHALLENGE OF THE COURSE
*/
-- 1: select the films which are 2 hr long.  
select * from films;
select * from films
where length_min >120;
-- select the film which had most number of screenings in oct 2017.
select * from screenings;
-- below query will display each film name and it's screenings number in total
select f.name,count(s.film_id) as film_num from screenings s
inner join films f on s.film_id=f.id
group by f.name
order by film_num desc;
-- now the film with the maximum number of screenings
select f.name,count(s.film_id) as film_num from screenings s
inner join films f on s.film_id=f.id

group by f.name
order by film_num desc
limit 1 ;


-- select the films with avg time more than 120 min which had most number of screenings in oct 2017.

select f.name,f.length_min,count(s.film_id) as film_num from screenings s
inner join films f on s.film_id=f.id
where f.length_min>120
group by f.name
order by film_num desc
limit 1;

-- how many bookings did jigsaw had in oct 2017.
select * from bookings;
select* from screenings;
select * from films;
select f.name, count(b.screening_id) as tot_booking from bookings b
inner join screenings s on s.id=b.screening_id
inner join films f on s.film_id=f.id
where f.name="Jigsaw" and month(s.start_time)='10'
group by f.name ;

-- now doing above query using substring

select count(screening_id) from bookings
where screening_id in
(select id from screenings
where film_id in
(select id from films
where name="Jigsaw"));
-- ps: I am more comfortable in doing question with inner join

-- 4th: name of 5 customers who made the most bookings in oct 2017.
select * from customers;
select * from bookings;
select concat("bookings done by ",c.first_name," ", c.last_name," is ") as customer_name,count(b.customer_id) as tot_bookings from bookings b
inner join customers c on b.customer_id=c.id
group by customer_name
limit 5;
-- the above solution does gives a list of 5 customers but they are not the top 5 customers so did'nt get
-- the desired result and ie bcz "IF WE AER APPLYING LIMIT CLAUSE TO FIND THE TOP SPECIFIC NUMBER OF ITEMS
-- THEN IT IS NECESSARY TO FIRST ORDER THE LIST IN DESCENDING OR ASCENDING ORDER AS PER OUR NEED", and since
-- we didn't apply the order by desc so the above query just returned the random top 5 cusotmers. 
-- so the correct solution will be:
select concat("bookings done by ",c.first_name," ", c.last_name," is ") as customer_name,count(b.customer_id) as tot_bookings from bookings b
inner join customers c on b.customer_id=c.id
group by customer_name
order by tot_bookings desc
limit 5;

select c.first_name, c.last_name,count(b.customer_id) as tot_bookings from bookings b
inner join customers c on b.customer_id=c.id
group by c.first_name,c.last_name
order by tot_bookings desc
limit 5;

-- 5th: which film was shown most number of times in Chaplin room in oct 2017.

select * from films;
select * from rooms;
select * from screenings;
select f.name, count(s.room_id) as tot_shows from screenings s
inner join   rooms r on r.id=s.room_id
inner join films f on s.film_id=f.id
where r.name="Chaplin"
group by f.name
order by tot_shows desc;
-- so above query will count tot number of room id for each films where room id is 1 ie where room name is 
-- chaplin 
-- above sql query will display names of films alongwith number of times they were displayed in chaplin
select f.name, count(s.room_id) as tot_shows from screenings s
inner join   rooms r on r.id=s.room_id
inner join films f on s.film_id=f.id
where r.name="Chaplin"
-- r.name= "Chaplin" is same as saying r.id=1, but since in question chaplin is mentioned so doing for that
-- so it will count how many times each film has been shown in room chaplin(since we have done group by f.name)
group by f.name
order by tot_shows desc
limit 1 ;
-- 6th:  how many of the customers made the bookings in oct 2017.
select * from customers;
select * from bookings;
select * from screenings;
-- for the above query we have to simply count the customer id in the bookings table but since many customer
-- has done more than one bookings and we have to find out tot no of customers who had done bookings and NOT
-- total bookings , so will have to add up all the distinct customer ids.
select count(distinct(customer_id)) as tot_customers from bookings;
