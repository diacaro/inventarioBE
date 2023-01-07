

CREATE TABLE IF NOT EXISTS categoria (
    id serial,
    categoria VARCHAR (10),
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS invernadero (
        id serial,
        invernadero VARCHAR (10),
        sede VARCHAR (10),
        PRIMARY KEY (id)
    );

--CREATE TABLE IF NOT EXISTS mesa (
--        id serial,
--        mesa VARCHAR (10),
--        id_invernadero INT NOT NULL,
--        PRIMARY KEY (id),
--        FOREIGN KEY (id_invernadero) REFERENCES invernadero(id)
--    );

CREATE TABLE IF NOT EXISTS mesa (
        id serial,
        mesa VARCHAR(10) NOT NULL,
        id_invernadero INT NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (id_invernadero) REFERENCES invernadero(id)
    );

CREATE TABLE IF NOT EXISTS productos (
        id serial,
        nombre VARCHAR (60),
        id_categoria INT NOT NULL,
        id_mesa INT NOT NULL,
        clima VARCHAR (12),
        precio DECIMAL(7,2),
        cantidad DECIMAL(7,2),
        PRIMARY KEY (id),
        FOREIGN KEY (id_categoria) REFERENCES categoria(id),
        FOREIGN KEY (id_mesa) REFERENCES mesa(id)
    );
