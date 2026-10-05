
package persistencia;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conexion {
    private String url;
    private String usuario;
    private String pass;
    
    private static Connection conection = null;

    public Conexion(String url, String usuario, String pass) {
        this.url = url;
        this.usuario = usuario;
        this.pass = pass;
    }
    
    public Connection buscarConexion() {
        if (conection == null) { //si es la primera vez que se conecta
            try {
                // cargamos las clases de mariadb o mysql que implementan JDBC
                Class.forName("com.mysql.jdbc.Driver");
//                   Class.forName("org.mariadb.jdbc.Driver");
                   conection = DriverManager.getConnection(url, usuario, pass);
                   
            } catch (SQLException | ClassNotFoundException ex) { // por si me olvide de importar la libreria // error al cargar los driver
                System.out.println("No se puede conectar o no se puede cargar el driver. Error: " + ex.getMessage());
            }
        }
        
        return conection; // devuelve la conexion establecida.
    }
}
