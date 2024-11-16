package Clases;
import java.io.Serializable;

public class Persona implements Serializable {
    protected static final long serialVersionUID = 1L;
    protected String nombreApellido;

    public Persona(String nombreApellido){
        this.nombreApellido = nombreApellido;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombre) {
        this.nombreApellido = nombre;
    }
}
