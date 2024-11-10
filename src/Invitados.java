public class Invitados {
    
    private String nombre;
    private String apellido;
    private boolean asistencia;
    //private String edad;
    //TODO puede que se pueda hacer herencia y que tengamos a quien hacer el alquiler y los que asisten simplemente


    public String getApellido() {
        return apellido;
    }

    public String getNombre(){
        return nombre;
    }

    public boolean asistira() {return asistencia; }

    public Invitados(String nombre, String apellido, boolean asistencia){
        this.nombre = nombre;
        this.apellido = apellido;
        this.asistencia = asistencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
