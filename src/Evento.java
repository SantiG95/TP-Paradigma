public class Evento {
    private final String fecha;
    private String descripcion;
    private String ubicacion;

    public Evento(String fecha, String descripcion, String ubicacion) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
