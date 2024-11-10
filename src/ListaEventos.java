import java.util.ArrayList;
import java.util.Date;

public class ListaEventos {
    ArrayList<AlquilerCanchita> Eventos;

    public ListaEventos(){
        Eventos = new ArrayList<>();
    }

    public void agregarEvento(AlquilerCanchita eventoParaAgregar){
        for (AlquilerCanchita eventoEnLista : Eventos){
            if(eventoParaAgregar.getFecha().before(eventoEnLista.getFecha())){
                Eventos.add(Eventos.indexOf(eventoEnLista), eventoParaAgregar);
                return;
            }
        }
        Eventos.add(eventoParaAgregar);
    }

    public void eliminarevento(AlquilerCanchita evento){
        Eventos.remove(evento);
    }

    public void mostrareventos(){
        for (AlquilerCanchita evento : Eventos) {
            System.out.println(evento.getDescripcion());
        }
    }

    private void mostrar(ArrayList<AlquilerCanchita> listaEventos){
        for (AlquilerCanchita evento : listaEventos) {
            System.out.println(evento.getFecha());
        }
    }

    public void mostrarEventosPasados(Date fecha){
        ArrayList<AlquilerCanchita> listaEventosPasados = new ArrayList<>();
        for (AlquilerCanchita eventoEnLista : Eventos){
            if(fecha.after(eventoEnLista.getFecha())){
                listaEventosPasados.add(eventoEnLista);

            }
        }
        mostrar(listaEventosPasados);
    }

    public void mostrarEventosFuturos(Date fecha){
        ArrayList<AlquilerCanchita> listaEventosFuturos = new ArrayList<>();
        for (AlquilerCanchita eventoEnLista : Eventos){
            if(fecha.before(eventoEnLista.getFecha())){
                listaEventosFuturos.add(eventoEnLista);

            }
        }
        mostrar(listaEventosFuturos);
    }

}
