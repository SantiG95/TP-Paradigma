import java.util.ArrayList;
import java.util.Date;

public class ListaEventos {
    ArrayList<CanchitaReunion> Eventos;

    public ListaEventos(){
        Eventos = new ArrayList<>();
    }

    public void agregarEvento(CanchitaReunion eventoParaAgregar){
        for (CanchitaReunion eventoEnLista : Eventos){
            if(eventoParaAgregar.getFecha().before(eventoEnLista.getFecha())){
                Eventos.add(Eventos.indexOf(eventoEnLista), eventoParaAgregar);
                return;
            }
        }
        Eventos.add(eventoParaAgregar);
    }

    public void eliminarevento(CanchitaReunion evento){
        Eventos.remove(evento);
    }

    public void mostrar(){
        for (CanchitaReunion evento : Eventos) {
            System.out.println(evento.getFecha());
        }
    }

    public void mostrar(ArrayList<CanchitaReunion> listaEventos){
        for (CanchitaReunion evento : listaEventos) {
            System.out.println(evento.getFecha());
        }
    }

    public void mostrarEventosPasados(Date fecha){
        ArrayList<CanchitaReunion> listaEventosPasados = new ArrayList<>();
        for (CanchitaReunion eventoEnLista : Eventos){
            if(fecha.after(eventoEnLista.getFecha())){
                listaEventosPasados.add(eventoEnLista);
                System.out.println("Entro");
            }
        }
        mostrar(listaEventosPasados);
    }

    public void mostrarEventosFuturos(Date fecha){
        ArrayList<CanchitaReunion> listaEventosPasados = new ArrayList<>();
        for (CanchitaReunion eventoEnLista : Eventos){
            if(fecha.before(eventoEnLista.getFecha())){
                listaEventosPasados.add(eventoEnLista);
                System.out.println("Entro");
            }
        }
        mostrar(listaEventosPasados);
    }



}
