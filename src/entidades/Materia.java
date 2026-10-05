
package entidades;

public class Materia {
    private int id = -1;
    private String nombre;
    private boolean activo;

    public Materia(String nombre, boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }
    
    public Materia(int id, String nombre, boolean activo) {
        this.id = -1;
        this.nombre = nombre;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return id + " - " + nombre;
    }
    
    
}
