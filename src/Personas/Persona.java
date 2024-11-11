package Personas;

abstract class Persona {
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
