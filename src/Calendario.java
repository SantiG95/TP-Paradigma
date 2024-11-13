import Alquileres.AlquilerCancha;

import java.text.SimpleDateFormat;
import java.util.*;

public class Calendario {
    private final ListaEventos eventos;

    public Calendario() {
        eventos = new ListaEventos();
    }

    public void agregarEvento(AlquilerCancha alquilerCancha) {
        ArrayList<AlquilerCancha> eventosDelDia = eventos.buscarEventosEnFecha(AlquilerCancha.getFecha());
        eventosDelDia.add(alquilerCancha);
        //eventos.put(alquilerCancha.getFecha(), eventosDelDia);
    }

    public ArrayList<AlquilerCancha> obtenerEventos(String fecha) {
        return eventos.buscarEventosEnFecha(AlquilerCancha.getFecha());
    }

    public ArrayList<AlquilerCancha> obtenerEventosDeHoy() {
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
