
package modelo;

public class Cursada {
    private int idCursada;
    private Alumno alumno;
    private Materia materia;
    private double nota;
    private int anio; // año lectivo, en BD es Year
    private int asist;
    private boolean activo;

    public Cursada() {
    }

    public Cursada(int idCursada, Alumno alumno, Materia materia, double nota, int anio, int asist, boolean activo) {
        this.idCursada = idCursada;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.anio = anio;
        this.asist = asist;
        this.activo = activo;
    }
    
    public Cursada(Alumno alumno, Materia materia, double nota, int anio, int asist, boolean activo) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        this.anio = anio;
        this.asist = asist;
        this.activo = activo;
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

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getAsist() {
        return asist;
    }

    public void setAsist(int asist) {
        this.asist = asist;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "\n--Cursada--" 
                + "\nidCursada: " + idCursada 
                + ",\n alumno: " + alumno 
                + ",\n materia=" + materia 
                + ",\n nota: " + nota 
                + ",\n anio: " + anio 
                + ",\n asist: " + asist 
                + ",\n activo=" + activo;
    }
    
    
}
