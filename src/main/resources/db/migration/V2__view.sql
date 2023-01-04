CREATE VIEW productos_view as
    select p.*,c.categoria categoria, i.invernadero invernadero, m.mesa mesa, i.sede sede
    from productos p JOIN categoria c
    ON p.id_categoria = c.id
    JOIN mesa m
    ON p.id_mesa = m.id
    JOIN invernadero i
    ON i.id = m.id_invernadero;