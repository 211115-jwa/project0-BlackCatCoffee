--create schema bike_app;

drop table bike;


create table bike (
	bike_model varchar(30) not null,
	id serial primary key,
	bike_type varchar(30) not null,
	manufacturer varchar(30) not null,
	frame_weight decimal not null,
	price decimal not null
);

