drop table if exists spittle;
drop table if exists spitter;

create table spitter (
  id identity,
  username varchar(25) not null,
  password varchar(25) not null,
  firstName varchar(25) not null,
  lastName varchar(25) not null,
  email varchar(50) not null,
);

create table spittle (
  id integer identity primary key,
  spitter integer not null,
  message varchar(2000) not null,
  time datetime not null,
  foreign key (spitter) references spitter(id)
);
