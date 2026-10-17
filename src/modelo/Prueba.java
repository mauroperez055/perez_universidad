
package modelo;

import modelo.Alumno;
import java.time.LocalDate;
import control.AlumnoData;
import control.Conexion;
import control.CursadaData;
import control.MateriaData;
import java.sql.SQLException;

public class Prueba {
    private AlumnoData alumnoData;
    private MateriaData materiaData;
    private CursadaData cursadaData;
    private Conexion conection;

    public static void main(String[] args) throws SQLException {
        
        LocalDate fecha = LocalDate.now();
        Alumno alumnoNuevo = new Alumno(1, 38749011, "Perez", "Mauro Gabriel", fecha, true);
        Materia materiaNueva = new Materia(4, "Web 1", true);
        Cursada cursadaNueva = new Cursada(alumnoNuevo, materiaNueva, 0, 0);
        
//        new Prueba().conectar(alumnoNuevo);
//        new Prueba().conectar(materiaNueva);
        new Prueba().conectar(cursadaNueva);
    }
    
    public void conectar(Object objeto) throws SQLException {
        conection = new Conexion("jdbc:mysql://localhost/perezmauro_universidad", "root", "");
    
        if (objeto instanceof Alumno) {
        Alumno alumnoNuevo = (Alumno) objeto;
        alumnoData = new AlumnoData(conection);
        /*agrego un alumno nuevo*/
//        alumnoData.agregarAlumno(alumnoNuevo);

        /*listo todos los alumnos, activos e inactivos*/
//        for (Alumno alu : alumnoData.listarAlumnos()) {
//            System.out.println(alu.toString());
//        }

//        for (Alumno alu : alumnoData.buscarAlumnosApellido("messi")) {
//            System.out.println("alumnos por apellido: " + alu.toString());
//        }
        
        /*listo solo los alumnos activos*/
//            for (Alumno alu : alumnoData.listarActivos()) {
//                System.out.println(alu.toString());
//            }
            
         /*listo solo los alumnos inactivos*/
//            for (Alumno alu : alumnoData.listarInactivos()) {
//                System.out.println(alu.toString());
//            }
            
         /*busco un alumno por dni*/
//        Alumno alumno = alumnoData.buscarAlumno(38749011);
//        System.out.println(alumno.toString());

        /*actualizo un alumno*/
//        alumnoData.actualizarAlumno(alumno);

        /*elimino un alumno de manera logica*/
//        alumnoData.bajaLogico(alumno);
    }
    
        if (objeto instanceof Materia) {
            Materia materiaNueva = (Materia) objeto;
            materiaData = new MateriaData(conection);
//            materiaData.agregarMateria(materiaNueva);
//            for (Materia mat : materiaData.listarMaterias()) {
//                System.out.println(mat.toString());
//            }
            
//            for (Materia mat : materiaData.listarMateriasActivas()) {
//                System.out.println(mat.toString());
//            }
            
//            for (Materia mat : materiaData.listarMateriasInactivas()) {
//                System.out.println(mat.toString());
//            }

//            for (Materia mat : materiaData.buscarMateriaNombre("programacion")) {
//                System.out.println("\nMateria por nombre: " + mat.toString());
//            }

//            Materia mat = materiaData.buscarMateriaId(5);
//            System.out.println(mat);
//            
//            mat.setNombre("Algebra Lineal");
//            materiaData.actualizarMateria(mat);
//            materiaData.eliminarMateriaLogico(3);
        }
        
        if (objeto instanceof Cursada) {
            Cursada cursadaNueva = (Cursada) objeto;
            cursadaData = new CursadaData(conection);
            
            cursadaData.inscribirAlumno(cursadaNueva);
        }
    }
}
