# prueba3
```


MariaDB [libros]> create table usuarios(usuario_id int(10) primary key not null auto_increment,
    -> user varchar(50),
    -> clave varchar (25),
    -> estado varchar(6));
Query OK, 0 rows affected (0.39 sec)

MariaDB [libros]> create table autores(autor_id int(10) primary key not null auto_increment,
    -> nombre varchar(25),
    -> estado varchar(6));
Query OK, 0 rows affected (0.30 sec)

MariaDB [libros]> create table idiomas(idioma_id int(10) primary key not null auto_increment,
    -> nombre varchar(25),
    -> estado varchar(6));
Query OK, 0 rows affected (0.27 sec)


MariaDB [libros]> create table libros (libro_id int (10) primary key not null auto_increment,
    -> isbn varchar(30),
    -> nombre varchar(30),
    -> cantidad_paginas int(3),
    -> autor_id int(10),
    -> idioma_id int(10),
    -> creado_por varchar(30),
    -> estado varchar(6));

MariaDB [libros]> select * from usuarios where estado='activo';
+------------+-------+-------+--------+
| usuario_id | user  | clave | estado |
+------------+-------+-------+--------+
|          8 | juan  | 111   | ACTIVO |
+------------+-------+-------+--------+
1 row in set (0.02 sec)

MariaDB [libros]> select * from Idiomas where estado='activo';
+-----------+------------+--------+
| idioma_id | nombre     | estado |
+-----------+------------+--------+
|         5 | castellano | ACTIVO |
|         6 | ingles     | ACTIVO |
+-----------+------------+--------+
2 rows in set (0.00 sec)

MariaDB [libros]> select * from usuarios where estado='activo';
+------------+-------+-------+--------+
| usuario_id | user  | clave | estado |
+------------+-------+-------+--------+
|          8 | juan  | 111   | ACTIVO |
+------------+-------+-------+--------+
1 row in set (0.00 sec)

MariaDB [libros]> select autores.autor_id as id,autores.nombre as autor,idiomas.nombre as idioma,libros.libro_id,libros.isbn,libros.nombre,libros.creado_por,libros.cantidad_paginas,usuarios.user from libros,usuarios,idiomas,autores where libros.autor_id=autores.autor_id and libros.idioma_id=idiomas.idioma_id and usuarios.usuario_id=libros.creado_por and libros.estado='activo';
+----+---------------------+------------+----------+---------------+----------------------------+------------+------------------+-------+
| id | autor               | idioma     | libro_id | isbn          | nombre                     | creado_por | cantidad_paginas | user  |
+----+---------------------+------------+----------+---------------+----------------------------+------------+------------------+-------+
|  7 | JK Rowling          | castellano |       16 | 9788700631625 | harry potter y la piedra   |          8 |              258 | juan  |
|  8 | George R. R. Martin | ingles     |       17 | 9780553386790 | juego de tronos            |          8 |              258 | juan  |
+----+---------------------+------------+----------+---------------+----------------------------+------------+------------------+-------+
2 rows in set (0.00 sec)




NOMBRE:Osvaldo Paredes Iturra
RUT:16.635.834-5






```
