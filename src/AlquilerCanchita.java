import java.util.ArrayList;
import java.util.Date;

abstract class AlquilerCanchita {
    protected Date fecha;
    protected String ubicacion;
    protected String descripcion;
    protected ArrayList<Invitados> listaAsistentes = new ArrayList<>();
    protected int tamañodecancha;
    //TODO falta hacer la parte de que recursos maneja. Podria ser la pelota

    public Date getFecha() {
        return fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getTamañodecancha() {return tamañodecancha; }

    public void setTamañodecancha(int tamañodecancha) {this.tamañodecancha = tamañodecancha; }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void agregarAsistente(Invitados asistente){
        if(asistente.asistira()) {listaAsistentes.add(asistente); }
    }

    public void eliminarAsistente(Invitados asistente){
        listaAsistentes.remove(asistente);
    }

    public void mostrarAsistentes(){
        for (Invitados asistentes : listaAsistentes) {
            System.out.println(asistentes.getNombre() +" "+ asistentes.getApellido());
        }
    }

    public boolean estapresente (Invitados asistente){
        return listaAsistentes.contains(asistente);
    }

}
