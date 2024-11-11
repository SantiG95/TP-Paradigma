import java.util.Date;

public class Inquilino extends Usuario{
    public Inquilino(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void cambiarFechaAlquiler(Date fechaNueva){
        alquilerCanchita.setFecha(fechaNueva);
    }

    public void cambiarDescripcion(String descripcionNueva){
        alquilerCanchita.setDescripcion(descripcionNueva);
    }

    public void cambiarTamañoCancha(int tamañoNuevo){
        alquilerCanchita.setTamañodecancha(tamañoNuevo);
    }

    public void cambiarUbicacion(String ubicacionNueva){
        alquilerCanchita.setUbicacion(ubicacionNueva);
    }


}
