use elecciones;

insert into candidato(nombre) values ("Nulo");
insert into candidato(nombre) values ("Blanco");
insert into candidato(nombre) values ("Eduardo Zacco");
insert into candidato(nombre) values ("Engel Charly");
insert into mesa(numeroMesa) values (10);
insert into mesa(numeroMesa) values (11);
insert into mesa(numeroMesa) values (12);
insert into mesa(numeroMesa) values (13);
insert into mesa(numeroMesa) values (14);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (1,10,15);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (1,11,0);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (1,12,0);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (1,13,0);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (1,14,0);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (2,10,0);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (2,11,0);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (2,12,0);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (2,13,0);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (2,14,0);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (3,10,0);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (3,11,0);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (3,12,0);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (3,13,0);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (3,14,0);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (4,10,0);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (4,11,0);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (4,12,0);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (4,13,0);
insert into cantidad_votos_por_mesa_candidato (idCandidato,numeroMesa,cantidad) values (4,14,0);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name0",36773357,0,0,10);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name1",65467854,0,0,10);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name2",45353253,0,0,10);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name3",32134543,0,0,10);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name4",95462431,0,0,11);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name5",65467854,0,0,11);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name6",654754,0,0,11);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name7",98766546,0,0,11);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name8",74556234,0,0,12);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name9",32436657,0,0,12);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name10",3216854,0,0,12);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name11",95435782,0,0,12);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name12",35751459,0,0,13);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name13",65467875,0,0,13);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name14",55465456,0,0,13);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name15",32154654,0,0,13);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name16",54365456,0,0,14);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name17",098745,0,0,14);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name18",6547867,0,0,14);
insert into votante (nombre,dni,votoRealizado,pertenecePartido,numeroMesa) values ("name19",98757653,0,0,14);
insert into usuario(nick,clave,administrador,habilitado) values ("cazador1992","daa4699d635fac8f363e6406d815d7a1",1,1);
insert into cliente(nombre,apellido,idUsuario,email) values ("Angelo","Wolf",1,"angelowolf21@gmail.com");