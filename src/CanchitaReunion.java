import java.util.ArrayList;

public class CanchitaReunion {
    private String fecha;
    private String ubicacion;
    private String descripcion;
    private ArrayList<Asistentes> Listita = new ArrayList<>();

    public CanchitaReunion(String fecha, String ubicacion, String descripcion){
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void agregar(Asistentes asistente){
        Listita.add(asistente);
    }

    public void eliminar(Asistentes asistente){
        Listita.remove(asistente);
    }

    public void mostrar(){
        for (Asistentes asistentes : Listita) {
            System.out.println(asistentes.getNombre() +" "+ asistentes.getApellido());
        }
    }

    public boolean asistencia (Asistentes asistente){
        return Listita.contains(asistente);
    }

}
