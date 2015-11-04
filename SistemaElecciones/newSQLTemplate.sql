-- select * from 
-- (select numeromesa, count(idVotante) as cantidad from votante where votante.votoRealizado = 1 group by votante.numeroMesa) as cantidad,
-- (select count(idVotante)as total from votante group by votante.numeroMesa) as total

select numeromesa, cast(sum(cantidad) as signed) as cantidad from cantidad_votos_por_mesa_candidato
 group by numeromesa;