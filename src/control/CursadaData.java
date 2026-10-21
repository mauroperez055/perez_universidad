
package control;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import modelo.Alumno;
import modelo.Cursada;
import modelo.Materia;

public class CursadaData {
    private Connection conection = null;
    private AlumnoData alumnoData;
    private MateriaData materiaData;

    public CursadaData(Conexion conex) {
        this.conection = conex.buscarConexion();
    }
        
    public void inscribirAlumno(Cursada cursada) throws SQLException{
        String sql = "INSERT INTO cursada (idAlumno, idMateria, nota, asist, anio) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cursada.getAlumno().getIdAlumno());
            ps.setInt(2, cursada.getMateria().getIdMateria());
            ps.setDouble(3, cursada.getNota());
            ps.setFloat(4, cursada.getAsist());
            ps.setInt(5, cursada.getAnio().getValue());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                cursada.setIdCursada(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener id de materia.");
            }
            
            System.out.println("Alumno inscripto correctamente.");
            ps.close();
        } catch (SQLException e) {
            System.out.println("El alumno ya está inscripto en la materia seleccionada.");
//            return;
            throw e;
        }
    }
    
    public ArrayList<Materia> materiasInscriptas(int idAlumno) throws SQLException {
        ArrayList<Materia> materiasInscriptas = new ArrayList<>();
        
        String sql = "SELECT m.idMateria, m.nombre, m.activo "
                        + "FROM cursada c "
                        + "INNER JOIN alumno a ON c.idAlumno = a.idAlumno "
                        + "INNER JOIN materia m ON c.idMateria = m.idMateria "
                        + "WHERE c.idAlumno = ? "
                        + "AND a.idAlumno = ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idAlumno);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int idMateria = rs.getInt("idMateria");
                String nombreMateria = rs.getString("nombre");
                boolean activoMateria = rs.getBoolean("activo");
                
                Materia materia = new Materia(idMateria, nombreMateria, activoMateria);

                materiasInscriptas.add(materia);
            }
//            ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo obtener las materias.");
            throw e;
        }
        
        return materiasInscriptas;
    }
    
    public ArrayList<Materia> materiasNoInscriptas(int idAlumno) throws SQLException{
        ArrayList<Materia> materiasNoInscriptas = new ArrayList<>();
        
        String sql = "SELECT m.idMateria, m.nombre, m.activo "
                            + "FROM materia m "
                            + "WHERE m.activo = 1 "
                            + "AND NOT EXISTS ( "
                                + "SELECT 1 "
                                + "FROM cursada c "
                                + "WHERE c.idMateria = m.idMateria "
                                + "AND c.idAlumno = ? "
                            + ")";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int idMateria = rs.getInt("idMateria");
                String nombre = rs.getString("nombre");
                boolean activo = rs.getBoolean("activo");
                
                Materia materia = new Materia(idMateria, nombre, activo);
                materiasNoInscriptas.add(materia);
//                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("No se pudo obtener las materias.");
            throw e;
        }
        
        return materiasNoInscriptas;
    }
    
    public void desinscribirAlumno(int idCursada) throws SQLException {
        String sql = "DELETE FROM cursada WHERE idCursada = ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, idCursada);
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                System.out.println("Cursada eliminada.");
            } else {
                System.out.println("No se pudo eliminar la cursada.");
            }
            
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar la cursada." + e.getMessage());
            throw e;
        }
    }
    
    public Integer buscarIdCursada(int idAlumno, int idMateria, Year anio) throws SQLException {
        
        String sql = "SELECT c.idCursada FROM cursada c WHERE c.idAlumno = ? AND c.idMateria = ? AND c.anio = ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            ps.setInt(3, anio.getValue());
            
            ResultSet rs = ps.executeQuery();
            
           if (rs.next()) {
               return rs.getInt(1);
           }
           ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo obtener el id de la cursada." + e.getMessage());
            throw e;
        }
        return null;
    }
    
    public ArrayList<Alumno> alumnosPorMat(int idMateria) throws SQLException {
        ArrayList<Alumno> alumnosPorMateria = new ArrayList<>();
        
        String sql = "SELECT a.idAlumno, a.nombre, a.apellido, a.dni, a.fechaNac, a.activo "
                            + "FROM cursada c "
                            + "INNER JOIN alumno a ON c.idAlumno = a.idAlumno "
                            + "INNER JOIN materia m ON c.idMateria = m.idMateria "
                            + "WHERE c.idMateria = ? "
                            + "AND m.idMateria = ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ps.setInt(2, idMateria);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int idAlumno = rs.getInt("idAlumno");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                int dni = rs.getInt("dni");
                LocalDate fechaNac = rs.getDate("fechaNac").toLocalDate();
                boolean activo = rs.getBoolean("activo");
                
                Alumno alumno = new Alumno(idAlumno, dni, apellido, nombre, fechaNac, activo);
                alumnosPorMateria.add(alumno);
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo obtener los alumnos de la materia." + e.getMessage());
            throw e;
        }
        return alumnosPorMateria;
    }
    
    public ArrayList<Cursada> cursadasRegistradas(int idAlumno) throws SQLException {
        ArrayList<Cursada> cursadasRegistradas = new ArrayList<>();
        
        String sql = "SELECT m.idMateria, m.nombre AS nomMat, m.activo AS activoMat, " +
                            "a.idAlumno, a.dni, a.apellido, a.nombre AS nomAlu, a.fechaNac, a.activo AS activoAlu, " +
                            "c.idCursada, c.asist, c.nota, c.anio " +
                            "FROM cursada c " +
                            "INNER JOIN materia m ON c.idMateria = m.idMateria " +
                            "INNER JOIN alumno a ON c.idAlumno = a.idAlumno " +
                            "WHERE c.idAlumno = ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int idMateria = rs.getInt("idMateria");
                String nombreMateria = rs.getString("nomMat");
                boolean activoMateria = rs.getBoolean("activoMat");
                
                int idAlu = rs.getInt("idAlumno");
                int dni = rs.getInt("dni");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nomAlu");
                LocalDate fechaNac = rs.getDate("fechaNac").toLocalDate();
                boolean activoAlu = rs.getBoolean("activoAlu");
                
                int idCursada = rs.getInt("idCursada");
                float asist = rs.getFloat("asist");
                double nota = rs.getDouble("nota");
                Year anio = Year.of(rs.getInt("anio"));
                
                Alumno alumno = new Alumno(idAlumno, dni, apellido, nombre, fechaNac, activoAlu);
                Materia materia = new Materia(idMateria, nombreMateria, activoMateria);
                Cursada cursada = new Cursada(idCursada, alumno, materia, nota, asist, anio);

                cursadasRegistradas.add(cursada);
            }
//            ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo obtener las materias.");
            throw e;
        }
        
        return cursadasRegistradas;
    }
    
    public void cargarNota(int idCursada, double nota) throws SQLException {
        String sql = "UPDATE cursada SET nota = ? WHERE idCursada = ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idCursada);
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                System.out.println("Nota guardada.");
            } else {
                System.out.println("No se pudo guardar la nota.");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo obtener el id de la cursada.");
            throw e;
        }
    }
    
    public boolean materiaTieneInscriptos(int idMateria) throws SQLException {
        String sql = "SELECT EXISTS ( "
                            + "SELECT 1 "
                            + "FROM materia m "
                            + "INNER JOIN cursada c ON m.idMateria = c.idMateria "
                            + "WHERE m.idMateria = ? "
                            + "AND m.activo = 1 "
                        + ")";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, idMateria);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getBoolean(1);
            }
            
            System.out.println("No se puede dar de baja la materia.");
        } catch (SQLException e) {
            System.out.println("No se pudo controlar si la materia tiene alumnos." + e.getMessage());
            throw e;
        }
        return false;
    }
    
    public void marcarAsistencia(int idCursada, float asist) throws SQLException {
        String sql ="UPDATE cursada SET asist = ? WHERE idCursada = ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setFloat(1, asist);
            ps.setInt(2, idCursada);
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                System.out.println("Asistencia guardada.");
            } else {
                System.out.println("No se pudo guardar la asistencia.");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se pudo obtener el id de la cursada.");
            throw e;
        }
    }
    
    public ArrayList<Alumno> alumnosConCursada() throws SQLException {
        ArrayList<Alumno> alumnosConCursada = new ArrayList<>();
        
        String sql = "SELECT DISTINCT a.idAlumno, a.dni, a.apellido, a.nombre AS nomAlu, a.fechaNac, a.activo AS activoAlu "
                + "FROM cursada c "
                + "INNER JOIN alumno a ON c.idAlumno = a.idAlumno "
                + "INNER JOIN materia m ON c.idMateria = m.idMateria";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int idAlumno = rs.getInt("idAlumno");
                int dni = rs.getInt("dni");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nomAlu");
                LocalDate fechaNac = rs.getDate("fechaNac").toLocalDate();
                boolean activo = rs.getBoolean("activoAlu");
                
                Alumno alumno = new Alumno(idAlumno, dni, apellido, nombre, fechaNac, activo);
                
                alumnosConCursada.add(alumno);
            }
            
            return alumnosConCursada;
        } catch (SQLException e) {
            System.out.println("No se pudieron obtener los alumnos." + e.getMessage());
            throw e;
        }
    }
}