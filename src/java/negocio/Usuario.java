package negocio;

import Acceso.Conex;

public class Usuario {

    Conex con;
    private String user;
    private String clave;
    private int usuario_id;

    public Usuario() {

        con = new Conex();
    }
  public Usuario(String user,String clave) {

        this.user=user;
        this.clave=clave;
    }
    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void save() {

        con.setInsertar("insert into usuarios (user,clave,estado)values('" + this.getUser() + "','" + this.getClave() + "','ACTIVO')");

    }

    public void delete() {

        con.setInsertar("update usuarios set estado='PASIVO' where usuario_id='" + this.getUsuario_id() + "'");

    }

    public void update() {

        con.setInsertar("update usuarios set user='" + this.getUser() + "' ,clave='"+this.getClave()+"' where usuario_id='" + this.getUsuario_id() + "'");

    }
    
    public void login(){
    con.setConsulta("select * from usuarios where  user='" + getUser() + "' and clave='" +getClave() + "'");
    
    
    }
}
