package Personas;
import java.io.Serializable;

abstract class Persona implements Serializable {
    protected static final long serialVersionUID = 1L;
    protected String nombre;
    protected String apellido;

    public String getApellido() {
        return apellido;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
