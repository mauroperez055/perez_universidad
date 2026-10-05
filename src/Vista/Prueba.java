
package Vista;

import entidades.Alumno;
import java.time.LocalDate;
import persistencia.AlumnoData;
import persistencia.Conexion;

public class Prueba {
    private AlumnoData alumnoData;
    private Conexion conection;

    public static void main(String[] args) {
        
        LocalDate fecha = LocalDate.now();
        Alumno alu = new Alumno(12345678, "Messi", "Lionel", fecha, true);
        new Prueba().conectar(alu);
    }
    
    public void conectar(Alumno alu) {
    conection = new Conexion("jdbc:mysql://localhost/perezmauro_universidad", "root", "");
        alumnoData = new AlumnoData(conection);
//        alumnoData.agregarAlumno(alu);
//        alumnoData.buscarAlumnos();
        alumnoData.buscarAlumno(9);
    }
}
