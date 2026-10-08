
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
        Alumno alumnoNuevo = new Alumno(12345, "Messi", "Lionel", fecha, false);
        new Prueba().conectar(alumnoNuevo);
    }
    
    public void conectar(Alumno alumnoNuevo) {
    conection = new Conexion("jdbc:mysql://localhost/perezmauro_universidad", "root", "");
        alumnoData = new AlumnoData(conection);
//        alumnoData.agregarAlumno(alumnoNuevo);
        for (Alumno alu : alumnoData.listarAlumnos()) {
            System.out.println(alu.toString());
        }
//        alumnoData.listarAlumnos();
//        Alumno alumno = alumnoData.buscarAlumno(4);
//        System.out.println(alumno.toString());
//        alumnoData.actualizarAlumno(alumno);
    }
}
