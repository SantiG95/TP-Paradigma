import java.util.ArrayList;
import java.util.Date;

abstract class AlquilerCanchita {
    protected Date fecha;
    protected String ubicacion;
    protected String descripcion;
    protected ArrayList<Asistentes> listaAsistentes = new ArrayList<>();
    protected int maximoAsistentes;
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

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void agregarAsistente(Asistentes asistente){
        listaAsistentes.add(asistente);
    }

    public void eliminarAsistente(Asistentes asistente){
        listaAsistentes.remove(asistente);
    }

    public void mostrarAsistentes(){
        for (Asistentes asistentes : listaAsistentes) {
            System.out.println(asistentes.getNombre() +" "+ asistentes.getApellido());
        }
    }

    public boolean getAsistentes (Asistentes asistente){
        return listaAsistentes.contains(asistente);
    }

    public int getMaximoAsistentes(){
        return maximoAsistentes;
    }

}
