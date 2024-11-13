import Alquileres.AlquilerCancha;

import java.text.SimpleDateFormat;
import java.util.*;

public class Calendario {
    private final ListaEventos eventos;

    public Calendario() {
        eventos = new ListaEventos();
    }

    public void agregarEvento(AlquilerCancha alquilerCancha) {
        ArrayList<AlquilerCancha> eventosDelDia = eventos.buscarEventosEnFecha(alquilerCancha.getFecha());
        eventosDelDia.add(alquilerCancha);
        //eventos.put(alquilerCancha.getFecha(), eventosDelDia);
    }

    public ArrayList<AlquilerCancha> obtenerEventos(Date fecha) {
        return eventos.buscarEventosEnFecha(fecha);
    }

    public ArrayList<AlquilerCancha> obtenerEventosDeHoy() {
        Calendar cal = Calendar.getInstance();
        Date fechaHoy = cal.getTime();
        return obtenerEventos(fechaHoy);
    }

    public void eliminarEvento(AlquilerCancha evento) {
        eventos.eliminarevento(evento);
    }
}
