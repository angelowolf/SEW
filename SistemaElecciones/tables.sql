drop table mesa;
drop table mesa_resultado;
drop table cliente;
drop table usuario;

create table mesa_resultado
(
	id_mesaResultado INT not null auto_increment,
        num_mesa INT not null,
	cnt_oficial INT not null,       
        cnt_a INT not null,
        cnt_b int not null,
        cnt_blanco int not null,
        cnt_nulo int not null,
        primary key (id_mesaResultado)
);
insert into mesa_resultado (num_mesa,cnt_oficial,cnt_a,cnt_b,cnt_blanco,cnt_nulo) values (1,0,0,0,0,0);
insert into mesa_resultado (num_mesa,cnt_oficial,cnt_a,cnt_b,cnt_blanco,cnt_nulo) values (2,0,0,0,0,0);
insert into mesa_resultado (num_mesa,cnt_oficial,cnt_a,cnt_b,cnt_blanco,cnt_nulo) values (3,0,0,0,0,0);
insert into mesa_resultado (num_mesa,cnt_oficial,cnt_a,cnt_b,cnt_blanco,cnt_nulo) values (4,0,0,0,0,0);
insert into mesa_resultado (num_mesa,cnt_oficial,cnt_a,cnt_b,cnt_blanco,cnt_nulo) values (5,0,0,0,0,0);

create table mesa
(
	id INT not null auto_increment,
	nombre VARCHAR(45) not null,
	dni INT not null,
	votoRealizado TINYINT(1) not null,
        pertenecePartido TINYINT(1) not null,
        mesa int not null,
        primary key (id)
);

insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name0",36773357,0,0,1);
insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name1",65467854,0,0,1);
insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name2",45353253,0,0,1);
insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name3",32134543,0,0,1);

insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name4",95462431,0,0,2);
insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name5",65467854,0,0,2);
insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name6",654754,0,0,2);
insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name7",98766546,0,0,2);

insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name8",74556234,0,0,3);
insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name9",32436657,0,0,3);
insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name10",3216854,0,0,3);
insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name11",95435782,0,0,3);

insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name12",35751459,0,0,4);
insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name13",65467875,0,0,4);
insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name14",55465456,0,0,4);
insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name15",32154654,0,0,4);

insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name16",54365456,0,0,5);
insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name17",098745,0,0,5);
insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name18",6547867,0,0,5);
insert into mesa (nombre,dni,votoRealizado,pertenecePartido,mesa) values ("name19",98757653,0,0,5);


create table usuario
(
	id_usuario INT not null auto_increment,
	nick varchar(45) not null,
        clave varchar(45) not null,
        habilitado TINYINT(1) not null, 
        primary key (id_usuario)
);

insert into usuario(nick,clave,habilitado) values ("cazador1992","counter1.5",1);

create table cliente
(
	id_cliente INT not null auto_increment,
	nombre varchar(45) not null,
        apellido varchar(45) not null,
        id_usuario INT not null,
        email varchar(50) not null,
        primary key (id_cliente),
        constraint fk_id_usuario foreign key (id_usuario) references usuario (id_usuario)
);

insert into cliente(nombre,apellido,id_usuario,email) values ("Angelo","Wolf",1,"angelowolf21@gmail.com");
