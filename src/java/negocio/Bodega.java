package negocio;

import Acceso.Conex;

public class Bodega {

    private int bodega_id;
    private String nombre;
    private int sucursal_id;
    private int creado_por;
    Conex con;

    public Bodega() {

        con = new Conex();

    }

    public int getBodega_id() {
        return bodega_id;
    }

    public void setBodega_id(int bodega_id) {
        this.bodega_id = bodega_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSucursal_id() {
        return sucursal_id;
    }

    public void setSucursal_id(int sucursal_id) {
        this.sucursal_id = sucursal_id;
    }

    public int getCreado_por() {
        return creado_por;
    }

    public void setCreado_por(int creado_por) {
        this.creado_por = creado_por;
    }

    public void save() {

        con.setInsertar("insert into bodegas (nombre,sucursal_id,estado,creado_por)values('" + this.getNombre() + "','"+this.getSucursal_id()+"','ACTIVO','"+this.getCreado_por()+"')");

    }

    public void delete() {

        con.setInsertar("update bodegas set estado='PASIVO' where bodega_id='" + this.getBodega_id() + "'");

    }

    public void update() {

        con.setInsertar("update bodegas set nombre='" + this.getNombre() + "',sucursal_id='"+this.getSucursal_id()+"',creado_por='"+this.getCreado_por()+"' where bodega_id='" + this.getBodega_id()+ "'");

    }
}
