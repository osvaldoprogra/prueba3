
package Acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conex {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    public Conex() {

        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String pass = "";
        String url = "jdbc:mysql://localhost:3306/libros";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);

        } catch (Exception ex) {
            System.out.println("Error de conexion!!" + ex.getMessage());
        }
    }

    
    public void setConsulta(String sql) {
        try {
            stmt = con.createStatement();
            stmt.executeQuery(sql);
            rs = stmt.getResultSet();
        } catch (SQLException ex) {
            System.out.println("Error de conexion!!" + ex.getMessage());

        }
    }

   
    public ResultSet getResultado() {
        return rs;
    }

    public void setInsertar(String sql) {
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error de conexion!!" + ex.getMessage());

        }

    }public void cerrarConexion(){
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("ERROR AL CERRAR:"+ex.getMessage());
        }
}
  
    

}
