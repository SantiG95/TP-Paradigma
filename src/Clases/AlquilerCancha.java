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
    private RecursosCancha recursosCancha;

    public AlquilerCancha(Date fecha, String ubicacion, int tamañoCancha, String descripcion, Persona organizador){
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.tamañoCancha = tamañoCancha;
        this.organizador = organizador;
        this.recursosCancha = new RecursosCancha();
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

    public void agregarAsistente(String nombreApellido){
        listaAsistentes.add(new Persona(nombreApellido));
    }

    public void eliminarAsistente(Persona asistente){
        listaAsistentes.remove(asistente);
    }

    public void mostrarAsistentes(){
        for (Persona asistentes : listaAsistentes) {
            System.out.println(asistentes.getNombreApellido());
        }
    }

    public void agregarGrabacion(){
        this.recursosCancha.setGrabacion(true);
    }

    public void quitarGrabacion(){
        this.recursosCancha.setGrabacion(false);
    }

    public void agregarPelota(){
        this.recursosCancha.setPelota(true);
    }

    public void quitarPelota(){
        this.recursosCancha.setPelota(false);
    }

    public void agregarPechera(){
        this.recursosCancha.setPecheras(true);
    }

    public void quitarPechera(){
        this.recursosCancha.setPecheras(false);
    }

    public boolean obtenerGrabacion(){
        return this.recursosCancha.getGrabacion();
    }

    public boolean obtenerPelota(){
        return this.recursosCancha.getPelota();
    }

    public boolean obtenerPecheras(){
        return this.recursosCancha.getPecheras();
    }
}
