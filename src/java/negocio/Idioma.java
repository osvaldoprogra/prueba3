
package negocio;

import Acceso.Conex;


public class Idioma {
    Conex con;
    private String nombre;
    private int idioma_id;
    
     public Idioma() {

        con = new Conex();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdioma_id() {
        return idioma_id;
    }

    public void setIdioma_id(int idioma_id) {
        this.idioma_id = idioma_id;
    }
    
    public void save() {

        con.setInsertar("insert into idiomas(nombre,estado)values('" + this.getNombre()+ "','ACTIVO')");

    }

    public void delete() {

        con.setInsertar("update idiomas set estado='PASIVO' where idioma_id='" + this.getIdioma_id() + "'");

    }

    public void update() {

        con.setInsertar("update idiomas set nombre='" + this.getNombre()+ "' where idioma_id='" + this.getIdioma_id() + "'");

    }
     
}
