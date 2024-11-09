public class Asistentes {
    
    private String nombre;
    private String apellido;
    //private String edad;
    //TODO puede que se pueda hacer herencia y que tengamos a quien hacer el alquiler y los que asisten simplemente


    public String getApellido() {
        return apellido;
    }

    public String getNombre(){
        return nombre;
    }

    public Asistentes(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
