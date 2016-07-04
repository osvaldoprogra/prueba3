package negocio;

import Acceso.Conex;

public class Sucursal {

    private int creado_por;
    Conex con;
    private int sucursal_id;
    private String nombre;

    public Sucursal() {

        con = new Conex();

    }

    public int getCreado_por() {
        return creado_por;
    }

    public void setCreado_por(int creado_por) {
        this.creado_por = creado_por;
    }

    public int getSucursal_id() {
        return sucursal_id;
    }

    public void setSucursal_id(int sucursal_id) {
        this.sucursal_id = sucursal_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void save() {

        con.setInsertar("insert into sucursales(nombre,estado,creado_por)values('" + this.getNombre() + "','ACTIVO','"+this.getCreado_por()+"')");

    }

    public void delete() {

        con.setInsertar("update sucursales set estado='PASIVO' where sucursal_id='" + this.getSucursal_id() + "'");

    }

    public void update() {

        con.setInsertar("update sucursales set nombre='" + this.getNombre() + "',creado_por='"+this.getCreado_por()+"' where sucursal_id='" + this.getSucursal_id() + "'");

    }

}
