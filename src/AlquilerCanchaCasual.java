import java.util.Date;

public class AlquilerCanchaCasual extends AlquilerCanchita{

    public AlquilerCanchaCasual(Date fecha, String ubicacion, int tamañodecancha, String descripcion, Inquilino inquilino){
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.tamañoCancha = tamañodecancha;
        inquilino.setAlquilerCanchita(this);
    }
}
