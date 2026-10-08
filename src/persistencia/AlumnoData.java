package persistencia;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import entidades.Alumno;
import java.time.LocalDate;
import java.util.ArrayList;

public class AlumnoData {
     private Connection conection = null;
     private ArrayList<Alumno> alumnos = new ArrayList<>();
     
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
                System.out.println(rs.getInt(1));
            }
            
            System.out.println("Alumno creado");
            ps.close();
        } catch (SQLException e) {
            System.out.println("No pude insertar: " + e.getMessage());
        }
    }
    
    public ArrayList<Alumno> listarAlumnos() {
        
        String sql = "SELECT * FROM alumno";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
//                System.out.println("id: " + rs.getInt("idAlumno"));
//                System.out.println("Apellido: " + rs.getString("apellido"));
//                System.out.println("Nombre: " + rs.getString("nombre"));
//                System.out.println("Fecha Nac.: " + rs.getDate("fechaNac"));
//                System.out.println("Activo?: " + rs.getBoolean("activo"));
//                System.out.println("-------------------------------------");
                
                int id = rs.getInt("idAlumno");
                int dni = rs.getInt("dni");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                LocalDate fechaNac = (rs.getDate("fechaNac")).toLocalDate();
                boolean activo = rs.getBoolean("activo");
                
                Alumno alu = new Alumno(id, dni, apellido, nombre, fechaNac, activo);
                
                alumnos.add(alu);
            }
            
            ps.close();
            return alumnos;
        } catch (SQLException e) {
            System.out.println("No se encontró el alumno. " + e.getMessage());
        }
        
        return null;
    }
    
    public Alumno buscarAlumno(int id) {
        String sql = "SELECT * FROM alumno WHERE idAlumno = ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
           while (rs.next()) {
                id = rs.getInt("idAlumno");
                int dni = rs.getInt("dni");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                LocalDate fechaNac = (rs.getDate("fechaNac")).toLocalDate();
                boolean activo = rs.getBoolean("activo");
                
                Alumno alu = new Alumno(id, dni, apellido, nombre, fechaNac, activo);
                return alu;
           }
           
           ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo encontrar el alumno.");
        }
        return null;
    }
    
    public void actualizarAlumno(Alumno alumno) {
        String sql = "UPDATE alumno SET dni = ?, apellido = ?, nombre = ?, fechaNac = ?, activo = ? WHERE idAlumno = ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isActivo());
            ps.setInt(6, alumno.getId());
            ps.executeUpdate();
            
            System.out.println("Alumno actualizado.");
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo actualizar el alumno. " + e.getMessage());
        }
    }
}
