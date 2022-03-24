create database board default character set utf8mb4 default collate utf8mb4_general_ci;

use board;

create table member (
	id integer auto_increment primary key,
	name varchar(128) not null,
	password varchar(128) not null
);

create table article (
	no integer auto_increment primary key,
	title varchar(128) not null,
	content text not null,
	hits integer default 0,
	time_posted date default (current_date),
	id integer not null,
	foreign key (id) references member(id)
  );