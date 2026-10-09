
package modelo;

public class Materia {
    private int idMateria;
    private String nombre;
    private boolean activo;

    public Materia() {
    }

    public Materia(String nombre, boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }
    
    public Materia(int idMateria, String nombre, boolean activo) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.activo = activo;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setId(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "\n--Materia--" 
                + "\nidMateria: " + idMateria + ", "
                + "\nnombre: " + nombre + ", "
                + "\nactivo: " + activo;
    }
  
}
