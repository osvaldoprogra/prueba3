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





NOMBRE:Osvaldo Paredes Iturra
RUT:16.635.834-5






```
