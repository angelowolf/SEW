create database elecciones;
use elecciones;
drop table if exists votante;
drop table if exists cantidad_votos_por_mesa_candidato;
drop table if exists mesa;
drop table if exists candidato;
drop table if exists cliente;
drop table if exists usuario;

create table mesa
(
        numeroMesa INT not null,
        primary key (numeroMesa)
);

create table candidato
(
        idCandidato INT not null auto_increment,
        nombre varchar(50) not null,
        primary key (idCandidato)
);


create table votante
(
	idVotante INT not null auto_increment,
	nombre VARCHAR(45) not null,
	dni INT not null,
	votoRealizado TINYINT(1) not null,
        pertenecePartido TINYINT(1) not null,
        numeroMesa int not null,
        primary key (idVotante),
        constraint fk_numero_mesa foreign key (numeroMesa) references mesa (numeroMesa)
);

create table cantidad_votos_por_mesa_candidato
(
        idCandidato int not null,
        numeroMesa int not null,
        cantidad int not null,
        primary key (idCandidato,numeroMesa),
        constraint fk_numero_mesa_cvmc foreign key (numeroMesa) references mesa (numeroMesa),
        constraint fk_id_candidato foreign key (idCandidato) references candidato (idCandidato)
);

create table usuario
(
	idUsuario INT not null auto_increment,
	nick varchar(45) not null,
        clave varchar(45) not null,
        administrador TINYINT(1) not null, 
        habilitado TINYINT(1) not null, 
        primary key (idUsuario)
);

create table cliente
(
	idCliente INT not null auto_increment,
	nombre varchar(45) not null,
        apellido varchar(45) not null,
        idUsuario INT not null,
        email varchar(50) not null,
        primary key (idCliente),
        constraint fk_id_usuario foreign key (idUsuario) references usuario (idUsuario)
);



