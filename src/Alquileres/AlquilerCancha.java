package Alquileres;

import Personas.Invitado;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

abstract public class AlquilerCancha implements Serializable {
    protected Date fecha;
    protected String ubicacion;
    protected String descripcion;
    public ArrayList<Invitado> listaAsistentes = new ArrayList<>();
    protected int tamañoCancha;
    private static final long serialVersionUID = 1L;
    //TODO falta hacer la parte de que recursos maneja. Podria ser la pelota, ponchos de color(nombre temporal)

    public Date getFecha() {
        return fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getTamañodecancha() {return tamañoCancha; }

    public void setTamañodecancha(int tamañodecancha) {this.tamañoCancha = tamañodecancha; }

    public void setFecha(Date fecha) {this.fecha = fecha;}

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public void agregarAsistente(String nombre, String apellido){
        listaAsistentes.add(new Invitado(nombre, apellido));
    }

    public void eliminarAsistente(Invitado asistente){
        listaAsistentes.remove(asistente);
    }
    //TODO puede que el atributo que se pase para eliminar a alguien pueda ser el index de donde se encuentra el invitado, puede que asi sea mas facil para Fran

    public void mostrarAsistentes(){
        for (Invitado asistentes : listaAsistentes) {
            System.out.println(asistentes.getNombre() +" "+ asistentes.getApellido());
        }
    }

    public boolean estaPresente (Invitado asistente){
        return listaAsistentes.contains(asistente);
    }

}
