
package modelo;

import modelo.Alumno;
import java.time.LocalDate;
import control.AlumnoData;
import control.Conexion;
import control.MateriaData;

public class Prueba {
    private AlumnoData alumnoData;
    private MateriaData materiaData;
    private Conexion conection;

    public static void main(String[] args) {
        
        LocalDate fecha = LocalDate.now();
        Alumno alumnoNuevo = new Alumno(132545, "Fernandez", "Enzo", fecha, true);
        Materia materiaNueva = new Materia("Ingles 2", false);
        new Prueba().conectar(alumnoNuevo);
        new Prueba().conectar(materiaNueva);
    }
    
    public void conectar(Object objeto) {
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
//        alumnoData.eliminarLogico(alumno);
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
        
    }
}
