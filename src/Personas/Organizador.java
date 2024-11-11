package Personas;

import Alquileres.AlquilerCancha;
import java.util.Date;

public class Organizador extends Persona {
    private AlquilerCancha alquilerCancha;

    public Organizador(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public AlquilerCancha getAlquilerCanchita() {return alquilerCancha;}

    public void setAlquilerCanchita(AlquilerCancha alquilerCancha) {this.alquilerCancha = alquilerCancha;}

    public void cambiarFechaAlquiler(Date fechaNueva){
        alquilerCancha.setFecha(fechaNueva);
    }

    public void cambiarDescripcion(String descripcionNueva){
        alquilerCancha.setDescripcion(descripcionNueva);
    }

    public void cambiarTamañoCancha(int tamañoNuevo){
        alquilerCancha.setTamañodecancha(tamañoNuevo);
    }

    public void cambiarUbicacion(String ubicacionNueva){
        alquilerCancha.setUbicacion(ubicacionNueva);
    }

    public void asignarAlquiler(AlquilerCancha alquiler){
        this.alquilerCancha = alquiler;
    }

}
