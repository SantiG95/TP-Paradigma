package Clases;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

public class AlquilerCancha implements Serializable {
    private Date fecha;
    private String ubicacion;
    private String descripcion;
    public ArrayList<Persona> listaAsistentes = new ArrayList<>();
    private int tamañoCancha;
    private static final long serialVersionUID = 1L;
    private Persona organizador;
    private ArrayList<String> listaRecursos = new ArrayList<>();
    //TODO falta hacer la parte de que recursos maneja. Podria ser la pelota, ponchos de color(nombre temporal)

    public AlquilerCancha(Date fecha, String ubicacion, int tamañoCancha, String descripcion, Persona organizador){
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.tamañoCancha = tamañoCancha;
        this.organizador = organizador;
    }

    public Date getFecha() {return fecha;}

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
        listaAsistentes.add(new Persona(nombre, apellido));
    }

    public void eliminarAsistente(Persona asistente){
        listaAsistentes.remove(asistente);
    }
    //TODO puede que el atributo que se pase para eliminar a alguien pueda ser el index de donde se encuentra el invitado, puede que asi sea mas facil para Fran

    public void mostrarAsistentes(){
        for (Persona asistentes : listaAsistentes) {
            System.out.println(asistentes.getNombre() +" "+ asistentes.getApellido());
        }
    }

    public ArrayList<String> getListaRecursos(){
        return this.listaRecursos;
    }

    public void agregarRecurso(String recursoNuevo){
        listaRecursos.add(recursoNuevo);
    }

    public void quitarRecurso(String recursoNuevo){
        listaRecursos.remove(recursoNuevo);
    }

    public boolean estaPresente (Persona asistente){
        return listaAsistentes.contains(asistente);
    }

}
