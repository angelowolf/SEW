-- SELECT m.numeromesa,
--  cast(sum(case when votorealizado = 1 then 1 else 0 end) as signed) as cantidad,
--  count(*) as total
-- FROM mesa m
-- LEFT JOIN votante v1 ON m.numeromesa = v1.numeromesa
-- GROUP BY m.numeromesa;

select * from usuario;
select * from cliente;