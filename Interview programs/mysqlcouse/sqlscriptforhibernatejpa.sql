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


