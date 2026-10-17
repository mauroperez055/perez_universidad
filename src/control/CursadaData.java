
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
            ps.setInt(4, cursada.getAsist());
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
            }
        } catch (SQLException e) {
            System.out.println("No se pudo obtener las materias.");
            throw e;
        }
        
        return materiasNoInscriptas;
    }
}