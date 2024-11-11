public class Invitado extends Usuario{

    //TODO puede que se pueda hacer herencia y que tengamos a quien hacer el alquiler y los que asisten simplemente
    //TODO revisar tema asistencia y confirmacion

    public Invitado(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void esInvitadoAAlquiler(AlquilerCanchita alquilerCanchita){
        this.alquilerCanchita = alquilerCanchita;
    }

    public void confirmarAsistencia(){
        try {
            alquilerCanchita.agregarAsistente(this);
        }
        catch (Exception e) {
            System.out.println(this.nombre + " " + this.apellido + " no esta invitado en ningun lado");
        }
    }
}
