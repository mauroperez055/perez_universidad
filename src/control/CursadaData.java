
package control;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import modelo.Cursada;

public class CursadaData {
    private Connection conection = null;
    private AlumnoData alumnoData;
    private MateriaData materiaData;

    public CursadaData(Conexion conex) {
        this.conection = conex.buscarConexion();
    }
        
    public void inscribirAlumno(Cursada cursada) throws SQLException{
        String sql = "INSERT INTO cursada (idAlumno, idMateria, nota, asist) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cursada.getAlumno().getIdAlumno());
            ps.setInt(2, cursada.getMateria().getIdMateria());
            ps.setDouble(3, cursada.getNota());
            ps.setInt(4, cursada.getAsist());
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
            System.out.println("No se pudo inscribir al alumno: " + e.getMessage());
            return;
//            throw e;
        }
    }
}
