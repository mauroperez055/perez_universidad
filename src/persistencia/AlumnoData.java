package persistencia;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import entidades.Alumno;

public class AlumnoData {
     private Connection conection = null;

    public AlumnoData(Conexion conex) {
        this.conection = conex.buscarConexion();
    }
     
    public void agregarAlumno(Alumno alu) {
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNac, activo) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, alu.getDni());
            ps.setString(2, alu.getApellido());
            ps.setString(3, alu.getNombre());
            ps.setDate(4, Date.valueOf(alu.getFechaNac()));
            ps.setBoolean(5, alu.isActivo());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                System.out.println("Id asignado al alumno: " + rs.getInt(1));
            }
            
            System.out.println("Alumno creado");
            ps.close();
//            conection.close();
        } catch (SQLException e) {
            System.out.println("No pude insertar: " + e.getMessage());
        }
    }
    
    public void buscarAlumnos() {
        
        String sql = "SELECT * FROM alumno";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("idAlumno"));
                System.out.println("Apellido: " + rs.getString("apellido"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Fecha Nac.: " + rs.getDate("fechaNac"));
                System.out.println("Activo?: " + rs.getBoolean("activo"));
                System.out.println("-------------------------------------");
            }
            
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se encontró el alumno. " + e.getMessage());
        }
    }
    
    public void buscarAlumno(int id) {
        String sql = "SELECT * FROM alumno WHERE idAlumno = ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
           while (rs.next()) {
                System.out.println("id: " + rs.getInt("idAlumno"));
                System.out.println("Apellido: " + rs.getString("apellido"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Fecha Nac.: " + rs.getDate("fechaNac"));
                System.out.println("Activo?: " + rs.getBoolean("activo"));
           }
           
           ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo encontrar el alumno.");
        }
    }
}
