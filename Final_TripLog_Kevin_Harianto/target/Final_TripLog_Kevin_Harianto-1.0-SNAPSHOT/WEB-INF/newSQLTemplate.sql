-- create database java3;
use java3;

create table triplog (  
  tripid int not null,
  country varchar(20) not null,
  description varchar(100) not null,
  primary key (tripid)
);

insert into triplog values 
(11,'Canada', 'Sheridan campus tours, 07.2020'),
(12,'Japan', 'Take a Java course, TK, 08.2021'),
(13,'USA', 'Google interview, LA 06.2018'),
(14,'Canada', 'Web Dev Conference, BC 05.2019'),
(15,'Singapore', 'Visiting parents, 03.2017'),
(16,'Germnay', 'Sister wedding, MU 04.2019'),
(17, 'Canada', 'Visiting customers, Waterloo, 01.2022');
