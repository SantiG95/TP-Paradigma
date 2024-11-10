public class Invitado extends Usuario{

    private boolean asistencia;
    //TODO puede que se pueda hacer herencia y que tengamos a quien hacer el alquiler y los que asisten simplemente
    //TODO revisar tema asistencia y confirmacion

    public boolean asistira() {
        return asistencia;
    }

    public Invitado(String nombre, String apellido, boolean asistencia){
        this.nombre = nombre;
        this.apellido = apellido;
        this.asistencia = asistencia;
    }
}
