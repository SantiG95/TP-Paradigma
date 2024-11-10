import java.util.ArrayList;
import java.util.Date;

abstract class AlquilerCanchita {
    protected Date fecha;
    protected String ubicacion;
    protected String descripcion;
    protected ArrayList<Invitado> listaAsistentes = new ArrayList<>();
    protected int tamañoCancha;
    //TODO falta hacer la parte de que recursos maneja. Podria ser la pelota, ponchos de color(nombre temporal)
    //TODO diferencia de alquileres por el tiempo
    //TODO canchas de difentes suelos

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

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void agregarAsistente(Invitado asistente){
        if(asistente.asistira()) {listaAsistentes.add(asistente); }
    }

    public void eliminarAsistente(Invitado asistente){
        listaAsistentes.remove(asistente);
    }

    public void mostrarAsistentes(){
        for (Invitado asistentes : listaAsistentes) {
            System.out.println(asistentes.getNombre() +" "+ asistentes.getApellido());
        }
    }

    public boolean estaPresente (Invitado asistente){
        return listaAsistentes.contains(asistente);
    }

}
