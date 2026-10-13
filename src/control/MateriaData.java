
package control;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import modelo.Materia;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MateriaData {
    private Connection conection = null;
    
    public MateriaData(Conexion conex) {
        this.conection = conex.buscarConexion();
    }
    
    public void agregarMateria(Materia mat) throws SQLException{
        String sql = "INSERT INTO materia (nombre, activo) VALUES (?, ?)";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS );
            
            ps.setString(1, mat.getNombre().trim());
            ps.setBoolean(2, mat.isActivo());
            int exito = ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                mat.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener Id de la materia.");
            }
            
            if (exito == 1) {
                System.out.println("Materia creada correctamente.");
            } else {
                System.out.println("No se pudo crear la materia.");
            }
            
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo insertar la materia: " + e.getMessage());
            throw e;
        }
    }
    
    public ArrayList<Materia> listarMaterias() throws SQLException{
        ArrayList<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("idMateria");
                String nombre = rs.getString("nombre");
                boolean activo = rs.getBoolean("activo");
                
                Materia mat = new Materia(id, nombre, activo);
                
                materias.add(mat);
            } 
            
            ps.close();
            return materias;
        } catch (SQLException e) {
            System.out.println("No se encontraron materias. " + e.getMessage());
            throw e;
        }
        
    }
    
    public ArrayList<Materia> listarMateriasActivas() throws SQLException{
        ArrayList<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE activo = 1";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Materia mat = new Materia();
                
                mat.setId(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setActivo(rs.getBoolean("activo"));
                
                materias.add(mat);
            } 
            
            ps.close();
            return materias;
        } catch (SQLException e) {
            System.out.println("No se encontraron materias activas. " + e.getMessage());
            throw e;
        }
        
    }
    
    public ArrayList<Materia> listarMateriasInactivas() throws SQLException{
        ArrayList<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE activo = 0";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Materia mat = new Materia();
                
                mat.setId(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setActivo(rs.getBoolean("activo"));
                
                materias.add(mat);
            } 
            
            ps.close();
            return materias;
        } catch (SQLException e) {
            System.out.println("No se encontraron materias inactivas. " + e.getMessage());
            throw e;
        }
        
    }
    
//    public ArrayList<Materia> buscarMateriaNombre(String nombre) {
//        ArrayList<Materia> materias = new ArrayList<>();
//        String sql = "SELECT * FROM materia WHERE nombre LIKE ?";
//        
//        try {
//            
//            PreparedStatement ps = conection.prepareStatement(sql);
//            ps.setString(1, "%" + nombre.trim() + "%");
//            
//            ResultSet rs = ps.executeQuery();
//            
//            while (rs.next()) {
//                Materia mat = new Materia();
//                mat.setId(rs.getInt("idMateria"));
//                mat.setNombre(rs.getString("nombre"));
//                mat.setActivo(rs.getBoolean("activo"));
//                
//                materias.add(mat);
//           } 
//            
//           ps.close();
//           
//           return materias;
//        } catch (SQLException e) {
//            System.out.println("No se pudo encontrar la materia.");
//        }
//        return null;
//    }
    
    public Materia buscarMateriaId(int id) throws SQLException{
        String sql = "SELECT * FROM materia WHERE idMateria = ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Materia mat = new Materia();
                mat.setId(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setActivo(rs.getBoolean("activo"));
                
                return mat;
           } else {
               System.out.println("No se encontró la materia con ese id.");
           }
           
           ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo encontrar la materia.");
            throw e;
        }
        return null;
    }
    
    public void actualizarMateria(Materia mat) throws SQLException{
        String sql = "UPDATE materia SET nombre = ?, activo = ? WHERE idMateria = ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            
            ps.setString(1, mat.getNombre());
            ps.setBoolean(2, mat.isActivo());
            ps.setInt(3, mat.getIdMateria());
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                System.out.println("Materia actualizada.");
            } else {
                System.out.println("No se encontró la materia.");
            }
            
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo actualizar la materia. " + e.getMessage());
            throw e;
        }
    }
    
    /* elimina de manera logica una materia buscada por id*/
    public void bajaLogica(Materia materia) throws SQLException{
        String sql = "UPDATE materia SET activo = 0 WHERE idMateria = ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, materia.getIdMateria());
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                System.out.println("Materia dada de baja.");
            } else {
                System.out.println("No se encontró la materia.");
            }
            
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo dar de baja la materia. " + e.getMessage());
            throw e;
        }
    }
    
    public void altaLogica(Materia materia) throws SQLException{
        String sql = "UPDATE materia SET activo = 1 WHERE idMateria = ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, materia.getIdMateria());
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                System.out.println("Materia dada de alta.");
            } else {
                System.out.println("No se encontró la materia.");
            }
            
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo dar de alta la materia. " + e.getMessage());
            throw e;
        }
    }
    
    /* elimina de manera logica una materia buscada por nombre*/
//    public void eliminarMateriaLogico(String nombre) {
//        String sql = "UPDATE materia SET activo = 0 WHERE nombre LIKE ?";
//        
//        try {
//            PreparedStatement ps = conection.prepareStatement(sql);
//            ps.setString(1, "%" + nombre + "%");
//            
//            int exito = ps.executeUpdate();
//            
//            if (exito == 1) {
//                System.out.println("Materia desactivada.");
//            } else {
//                System.out.println("No se encontró la materia.");
//            }
//            
//            ps.close();
//        } catch (SQLException e) {
//            System.out.println("No se pudo desactivar la materia. " + e.getMessage());
//        }
//    }
}
