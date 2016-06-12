package negocio;

import Acceso.Conex;

public class Libro {
  Conex con;
    private String isbn;
    private String nombre;
    private int creado_por;
    private int idioma_id;
    private int autor_id;
    private int libro_id;
    private int cantidad_pagina;

    public Libro() {

        con = new Conex();

    }
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreado_por() {
        return creado_por;
    }

    public void setCreado_por(int creado_por) {
        this.creado_por = creado_por;
    }

   

    public int getIdioma_id() {
        return idioma_id;
    }

    public void setIdioma_id(int idioma_id) {
        this.idioma_id = idioma_id;
    }

    public int getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(int autor_id) {
        this.autor_id = autor_id;
    }

    public int getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(int libro_id) {
        this.libro_id = libro_id;
    }

    public int getCantidad_pagina() {
        return cantidad_pagina;
    }

    public void setCantidad_pagina(int cantidad_pagina) {
        this.cantidad_pagina = cantidad_pagina;
    }

  
public void save() {

        con.setInsertar("insert into libros(isbn,nombre,cantidad_paginas,autor_id,idioma_id,creado_por,estado)values('" + this.getIsbn()+ "','"+this.getNombre()+"','"+this.getCantidad_pagina()+"','"+this.getAutor_id()+"','"+this.getIdioma_id()+"','"+this.getCreado_por()+"','ACTIVO')");

    }

    public void delete() {

        con.setInsertar("update libros set estado='PASIVO' where libro_id='" + this.getLibro_id()+ "'");

    }

    public void update() {

        con.setInsertar("update libros set isbn='"+this.getIsbn()+"',nombre='" + this.getNombre()+ "',cantidad_paginas='"+this.getCantidad_pagina()+"',autor_id='"+this.getAutor_id()+"',idioma_id='"+this.getIdioma_id()+"',creado_por='"+this.getCreado_por()+"' where libro_id='" + this.getLibro_id() + "'");

    }
     
}
