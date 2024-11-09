import java.util.Date;

public class AlquilerCanchaCasual extends AlquilerCanchita{

    public AlquilerCanchaCasual(Date fecha, String ubicacion){
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = "Un alquiler de cancha casual para un maximo de 6 personas";
        this.maximoAsistentes = 6;
    }
}
