create table survivor
(
   id integer not null,
   name varchar(255) not null,
   age integer not null,
   gender varchar(255) not null,
   latitude varchar(255) not null,
   longitude varchar(255) not null,
   infected boolean,
   primary key(id)
);


create table survivorresource
(
   survivorid integer not null,
   resources varchar(255) not null,
   primary key(survivorid)
);