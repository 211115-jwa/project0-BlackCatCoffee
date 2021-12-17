--create schema bike_app;

drop table bike;


create table bike (
	bike_model varchar(30) not null,
	id serial primary key,
	bike_type varchar(30) not null,
	manufacturer varchar(30) not null,
	frame_weight integer not null,
	price integer not null
);

commit;