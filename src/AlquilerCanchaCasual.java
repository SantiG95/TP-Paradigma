import java.util.Date;

public class AlquilerCanchaCasual extends AlquilerCanchita{

    public AlquilerCanchaCasual(Date fecha, String ubicacion, int tamañodecancha, String descripcion){
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.tamañodecancha = tamañodecancha;
    }
}
