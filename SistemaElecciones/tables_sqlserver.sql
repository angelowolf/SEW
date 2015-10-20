use master;
drop database bd_elecciones;
create database bd_elecciones;
use bd_elecciones;


create table mesa_1
(
	id INT not null IDENTITY(1,1) primary key ,
	nombre VARCHAR(45) not null,
	dni INT not null,
	votoRealizado bit not null,
	pertenecePartido bit not null);
        
create table mesa_2
(
	id INT not null IDENTITY(1,1) primary key ,
	nombre VARCHAR(45) not null,
	dni INT not null,
	votoRealizado bit not null,
	pertenecePartido bit not null);
	
create table mesa_3
(
	id INT not null IDENTITY(1,1) primary key ,
	nombre VARCHAR(45) not null,
	dni INT not null,
	votoRealizado bit not null,
	pertenecePartido bit not null);
	
create table mesa_4
(
	id INT not null IDENTITY(1,1) primary key ,
	nombre VARCHAR(45) not null,
	dni INT not null,
	votoRealizado bit not null,
	pertenecePartido bit not null);
	
create table mesa_5
(
	id INT not null IDENTITY(1,1) primary key ,
	nombre VARCHAR(45) not null,
	dni INT not null,
	votoRealizado bit not null,
	pertenecePartido bit not null);

insert into mesa_1 (nombre,dni,votoRealizado,pertenecePartido) values ('name0',36773357,0,0);
insert into mesa_1 (nombre,dni,votoRealizado,pertenecePartido) values ('name1',65467854,0,0);
insert into mesa_1 (nombre,dni,votoRealizado,pertenecePartido) values ('name2',45353253,0,0);
insert into mesa_1 (nombre,dni,votoRealizado,pertenecePartido) values ('name3',32134543,0,0);

insert into mesa_2 (nombre,dni,votoRealizado,pertenecePartido) values ('name4',95462431,0,0);
insert into mesa_2 (nombre,dni,votoRealizado,pertenecePartido) values ('name5',65467854,0,0);
insert into mesa_2 (nombre,dni,votoRealizado,pertenecePartido) values ('name6',654754,0,0);
insert into mesa_2 (nombre,dni,votoRealizado,pertenecePartido) values ('name7',98766546,0,0);

insert into mesa_3 (nombre,dni,votoRealizado,pertenecePartido) values ('name8',74556234,0,0);
insert into mesa_3 (nombre,dni,votoRealizado,pertenecePartido) values ('name9',32436657,0,0);
insert into mesa_3 (nombre,dni,votoRealizado,pertenecePartido) values ('name10',3216854,0,0);
insert into mesa_3 (nombre,dni,votoRealizado,pertenecePartido) values ('name11',95435782,0,0);

insert into mesa_4 (nombre,dni,votoRealizado,pertenecePartido) values ('name12',35751459,0,0);
insert into mesa_4 (nombre,dni,votoRealizado,pertenecePartido) values ('name13',65467875,0,0);
insert into mesa_4 (nombre,dni,votoRealizado,pertenecePartido) values ('name14',55465456,0,0);
insert into mesa_4 (nombre,dni,votoRealizado,pertenecePartido) values ('name15',32154654,0,0);

insert into mesa_5 (nombre,dni,votoRealizado,pertenecePartido) values ('name16',54365456,0,0);
insert into mesa_5 (nombre,dni,votoRealizado,pertenecePartido) values ('name17',098745,0,0);
insert into mesa_5 (nombre,dni,votoRealizado,pertenecePartido) values ('name18',6547867,0,0);
insert into mesa_5 (nombre,dni,votoRealizado,pertenecePartido) values ('name19',98757653,0,0);
