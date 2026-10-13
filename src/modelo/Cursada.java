
package modelo;

import java.time.Year;

public class Cursada {
    private int idCursada;
    private Alumno alumno;
    private Materia materia;
    private double nota;
    private int asist;
    private Year anio; // año lectivo, en BD es Year

    public Cursada() {
    }

    public Cursada(int idCursada, Alumno alumno, Materia materia, double nota, int asist) {
        this.idCursada = idCursada;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.asist = asist;
        this.anio = anio = Year.now();
    }
    
    public Cursada(Alumno alumno, Materia materia, double nota, int asist) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.asist = asist;
        this.anio = anio = Year.now();
    }

    public int getIdCursada() {
        return idCursada;
    }

    public void setIdCursada(int idCursada) {
        this.idCursada = idCursada;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getAsist() {
        return asist;
    }

    public void setAsist(int asist) {
        this.asist = asist;
    }

    @Override
    public String toString() {
        return "\n--Cursada--" 
                + "\nidCursada: " + idCursada 
                + ",\n alumno: " + alumno 
                + ",\n materia=" + materia 
                + ",\n nota: " + nota 
                + ",\n asist: " + asist
                + ",\n anio: " + anio;
    }
    
    
}
