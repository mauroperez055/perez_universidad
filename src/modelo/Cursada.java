
package modelo;

import java.time.Year;

public class Cursada {
    private int idCursada;
    private Alumno alumno;
    private Materia materia;
    private double nota;
    private float asist;
    private Year anio; // año lectivo, en BD es Year

    public Cursada() {
    }

    public Cursada(int idCursada, Alumno alumno, Materia materia, double nota, float asist, Year anio) {
        this.idCursada = idCursada;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.asist = asist;
        this.anio = anio;
    }
    
    public Cursada(Alumno alumno, Materia materia, double nota, float asist) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.asist = asist;
        this.anio = Year.now();
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

    public float getAsist() {
        return asist;
    }

    public void setAsist(float asist) {
        this.asist = asist;
    }

    public Year getAnio() {
        return anio;
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
