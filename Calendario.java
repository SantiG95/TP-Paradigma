import java.text.SimpleDateFormat;
import java.util.*;

public class Calendario {
    private final HashMap<String, ArrayList<Evento>> eventos;

    public Calendario() {
        eventos = new HashMap<>();
    }

    public void agregarEvento(Evento evento) {
        ArrayList<Evento> eventosDelDia = eventos.getOrDefault(evento.getFecha(), new ArrayList<>());
        eventosDelDia.add(evento);
        eventos.put(evento.getFecha(), eventosDelDia);
    }

    public ArrayList<Evento> obtenerEventos(String fecha) {
        return eventos.getOrDefault(fecha, new ArrayList<>());
    }

    public ArrayList<Evento> obtenerEventosDeHoy() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaHoy = sdf.format(new Date());
        return obtenerEventos(fechaHoy);
    }

    public void eliminarEvento(Evento evento) {
        ArrayList<Evento> eventosDelDia = eventos.get(evento.getFecha());
        if (eventosDelDia != null) {
            eventosDelDia.remove(evento);
        }
    }
}
