
package negocio;

import Acceso.Conex;

public class Autor{
    Conex con;
    private String nombre;
    private int autor_id;
    
     public Autor() {

        con = new Conex();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(int autor_id) {
        this.autor_id = autor_id;
    }
      public void save() {

        con.setInsertar("insert into autores(nombre,estado)values('" + this.getNombre()+ "','ACTIVO')");

    }

    public void delete() {

        con.setInsertar("update autores set estado='PASIVO' where autor_id='" + this.getAutor_id() + "'");

    }

    public void update() {

        con.setInsertar("update autores set nombre='" + this.getNombre()+ "' where autor_id='" + this.getAutor_id() + "'");

    }
}
