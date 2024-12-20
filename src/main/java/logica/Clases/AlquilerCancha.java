package logica.Clases;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

public class AlquilerCancha implements Serializable {
    private int ID;
    private Date fecha;
    private String ubicacion;
    private String descripcion;
    public ArrayList<Persona> listaAsistentes = new ArrayList<>();
    private String tamañoCancha;
    private String horario;
    private static final long serialVersionUID = 1L;
    private Persona organizador;
    private RecursosCancha recursosCancha;
    
    public AlquilerCancha(String id, Date fecha, String ubicacion, String tamañoCancha, String descripcion, Persona organizador, String Horario){
        this.ID = Integer.parseInt(id);
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.tamañoCancha = tamañoCancha;
        this.organizador = organizador;
        this.recursosCancha = new RecursosCancha();
        this.horario = Horario;
    }

    public int getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = Integer.getInteger(ID);
    }

    public Date getFecha() {return fecha;}

    public String getUbicacion() {
        return ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public String getHorario() {
        return horario;
    }
    
    public void setHorario(String Horario){
        this.horario = Horario;
    }
    
    public String getTamañodecancha() {return tamañoCancha; }

    public void setTamañodecancha(String tamañodecancha) {this.tamañoCancha = tamañodecancha; }

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

    public String mostrarAsistentes(){
        String asistentesString = "";
        for (Persona asistentes : listaAsistentes) {
            asistentesString += asistentes.getNombreApellido();
            asistentesString += " ";
        }
        return asistentesString;
    }

    public Persona getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Persona organizador) {
        this.organizador = organizador;
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
    
    public String obtenerRecursos(){
        String respuesta = "";
        if(obtenerGrabacion()) respuesta += "Grabacion ";
        if(obtenerPelota()) respuesta += "Pelota ";
        if(obtenerPecheras()) respuesta += "Pecheras";
        return respuesta;
    }
}
