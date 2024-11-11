import Alquileres.AlquilerCancha;

import java.util.ArrayList;
import java.util.Date;

public class ListaEventos {
    ArrayList<AlquilerCancha> Eventos;

    public ListaEventos(){
        Eventos = new ArrayList<>();
    }

    public void agregarEvento(AlquilerCancha eventoParaAgregar){
        for (AlquilerCancha eventoEnLista : Eventos){
            if(eventoParaAgregar.getFecha().before(eventoEnLista.getFecha())){
                Eventos.add(Eventos.indexOf(eventoEnLista), eventoParaAgregar);
                return;
            }
        }
        Eventos.add(eventoParaAgregar);
    }

    public void eliminarevento(AlquilerCancha evento){
        Eventos.remove(evento);
    }

    public void mostrareventos(){
        for (AlquilerCancha evento : Eventos) {
            System.out.println(evento.getDescripcion());
        }
    }

    private void mostrar(ArrayList<AlquilerCancha> listaEventos){
        for (AlquilerCancha evento : listaEventos) {
            System.out.println(evento.getFecha());
        }
    }

    public void mostrarEventosPasados(Date fecha){
        ArrayList<AlquilerCancha> listaEventosPasados = new ArrayList<>();
        for (AlquilerCancha eventoEnLista : Eventos){
            if(fecha.after(eventoEnLista.getFecha())){
                listaEventosPasados.add(eventoEnLista);

            }
        }
        mostrar(listaEventosPasados);
    }

    public void mostrarEventosFuturos(Date fecha){
        ArrayList<AlquilerCancha> listaEventosFuturos = new ArrayList<>();
        for (AlquilerCancha eventoEnLista : Eventos){
            if(fecha.before(eventoEnLista.getFecha())){
                listaEventosFuturos.add(eventoEnLista);

            }
        }
        mostrar(listaEventosFuturos);
    }

}
