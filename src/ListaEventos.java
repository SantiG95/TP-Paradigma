import java.util.ArrayList;

public class ListaEventos {
    ArrayList<CanchitaReunion> Eventos;

    public ListaEventos(){
        Eventos = new ArrayList<>();
    }

    public void agregarevento(CanchitaReunion evento){
        Eventos.add(evento);
    }

    public void eliminarevento(CanchitaReunion evento){
        Eventos.remove(evento);
    }

    public void mostrar(){
        for (CanchitaReunion evento : Eventos) {
            System.out.println(evento.getFecha());
        }
    }

}
