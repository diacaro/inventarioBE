CREATE VIEW productos_view as
    select p.*,c.categoria categoria, i.invernadero invernadero, m.mesa mesa, i.sede sede
    from productos p JOIN categoria c
    ON p.id_categoria = c.id
    JOIN mesa m
    ON p.id_mesa = m.id
    JOIN invernadero i
    ON i.id = m.id_invernadero;

CREATE VIEW mesa_view as
    select m.*,i.invernadero invernadero
    from mesa m JOIN invernadero i
    ON m.id_invernadero = i.id;

CREATE VIEW orden_view as
select o.*, c.fullname clientes
from orden o join clientes c on c.id=o.id_clientes
order by o.create_at DESC;

CREATE VIEW detalle_view as
select d.*, p.nombre nombre,p.cantidad cantidad, i.invernadero invernadero, m.mesa mesa
from detalles d
    join productos p
    ON p.id=d.id_productos
    JOIN mesa m
    ON p.id_mesa = m.id
    JOIN invernadero i
    ON i.id = m.id_invernadero;
