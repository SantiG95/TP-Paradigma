import java.util.Date;

public class AlquilerCanchaFiesta extends AlquilerCanchita{
    public AlquilerCanchaFiesta(Date fecha, String ubicacion){
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = "Un alquiler de cancha para una fiesta para un maximo de 10 personas";
        this.maximoAsistentes = 10;
    }
}
