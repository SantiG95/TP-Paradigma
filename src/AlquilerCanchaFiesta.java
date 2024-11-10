import java.util.Date;

public class AlquilerCanchaFiesta extends AlquilerCanchita{
    public AlquilerCanchaFiesta(Date fecha, String ubicacion, int tamañodecancha, String descripcion){
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.tamañodecancha = tamañodecancha;
    }
}
