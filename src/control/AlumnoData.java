package control;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import modelo.Alumno;
import java.time.LocalDate;
import java.util.ArrayList;

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
            ps.setString(2, alu.getApellido().trim());
            ps.setString(3, alu.getNombre().trim());
            ps.setDate(4, Date.valueOf(alu.getFechaNac()));
            ps.setBoolean(5, alu.isActivo());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                alu.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener Id del alumno.");
            }
            
            System.out.println("Alumno creado correctamente.");
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo insertar: " + e.getMessage());
        }
    }
    
    public ArrayList<Alumno> listarAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();

        String sql = "SELECT * FROM alumno";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
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
            System.out.println("No se encontraron alumnos. " + e.getMessage());
        }
        
        return null;
    }
    
    public ArrayList<Alumno> listarActivos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumno WHERE activo = 1";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Alumno alu = new Alumno();
                
                alu.setId(rs.getInt("idAlumno"));
                alu.setDni(rs.getInt("dni"));
                alu.setApellido(rs.getString("apellido"));
                alu.setNombre(rs.getString("nombre"));
                alu.setFechaNac((rs.getDate("fechaNac")).toLocalDate());
                alu.setActivo(rs.getBoolean("activo"));
                
                alumnos.add(alu);
            } 
            
            ps.close();
            return alumnos;
        } catch (SQLException e) {
            System.out.println("No se encontraron alumnos activos. " + e.getMessage());
        }
        
        return null;
    }
    
    public ArrayList<Alumno> listarInactivos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumno WHERE activo = 0";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Alumno alu = new Alumno();
                
                alu.setId(rs.getInt("idAlumno"));
                alu.setDni(rs.getInt("dni"));
                alu.setApellido(rs.getString("apellido"));
                alu.setNombre(rs.getString("nombre"));
                alu.setFechaNac((rs.getDate("fechaNac")).toLocalDate());
                alu.setActivo(rs.getBoolean("activo"));
                
                alumnos.add(alu);
            }
            
            ps.close();
            return alumnos;
        } catch (SQLException e) {
            System.out.println("No se encontraron alumnos inactivos. " + e.getMessage());
        }
        
        return null;
    }
    
    public Alumno buscarAlumno(int dni) {
        String sql = "SELECT * FROM alumno WHERE dni = ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, dni);
            
            ResultSet rs = ps.executeQuery();
            
           if (rs.next()) {
                Alumno alu = new Alumno();
                alu.setId(rs.getInt("idAlumno"));
                alu.setDni(rs.getInt("dni"));
                alu.setApellido(rs.getString("apellido"));
                alu.setNombre(rs.getString("nombre"));
                alu.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alu.setActivo(rs.getBoolean("activo"));
                
                return alu;
           } 
           
           ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo encontrar el alumno.");
        }
        return null;
    }
    
    public ArrayList<Alumno> buscarAlumnosApellido(String apellido) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumno WHERE apellido LIKE ?";
        
        try {
            
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setString(1, "%" + apellido.trim() + "%");
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Alumno alu = new Alumno();
                
                alu.setId(rs.getInt("idAlumno"));
                alu.setDni(rs.getInt("dni"));
                alu.setApellido(rs.getString("apellido"));
                alu.setNombre(rs.getString("nombre"));
                alu.setFechaNac((rs.getDate("fechaNac")).toLocalDate());
                alu.setActivo(rs.getBoolean("activo"));
                
                alumnos.add(alu);
                
           }
           
           ps.close();
           
           return alumnos;
        } catch (SQLException e) {
            System.out.println("No se encontraron alumnos con ese apellido.");
        }
        return null;
    }
    
    public void actualizarAlumno(Alumno alumno) {
        String sql = "UPDATE alumno SET dni = ?, apellido = ?, nombre = ?, fechaNac = ?, activo = ? WHERE dni = ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isActivo());
            ps.setInt(6, alumno.getDni());
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                System.out.println("Alumno actualizado.");
            } else {
                System.out.println("No se encontró el alumno.");
            }
            
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo actualizar el alumno. " + e.getMessage());
        }
    }
    
    /* elimina de manera logica un alumno buscado por id */
    public void eliminarLogico(int dni) {
        String sql = "UPDATE alumno SET activo = 0 WHERE dni = ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, dni);
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                System.out.println("Alumno desactivado.");
            } else {
                System.out.println("No se encontró el alumno.");
            }
            
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo desactivar el alumno. " + e.getMessage());
        }
    }
    
    /* elimina de manera logica un alumno buscado por apellido */
    public void eliminarLogico(String apellido) {
        String sql = "UPDATE alumno SET activo = 0 WHERE apellido LIKE ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setString(1, "%" + apellido + "%");
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                System.out.println("Alumno desactivado.");
            } else {
                System.out.println("No se encontró el alumno.");
            }
            
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo desactivar el alumno. " + e.getMessage());
        }
    }
}
