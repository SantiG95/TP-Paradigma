import Alquileres.AlquilerCancha;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Date;

public class ListaEventos {
    //ArrayList<AlquilerCancha> Eventos;
    Map<Date, ArrayList<AlquilerCancha>> Eventos;
    public ListaEventos(){
        //Eventos = new ArrayList<>();
        Eventos = new HashMap<>();
    }

    public void agregarEvento(AlquilerCancha eventoParaAgregar, Date fecha){
        ArrayList<AlquilerCancha> Lista = Eventos.get(fecha);
        if(Lista == null){
            Eventos.put(fecha, new ArrayList<AlquilerCancha>());
            Lista = Eventos.get(fecha);
        }
        Lista.add(eventoParaAgregar);
    }

    public void eliminarevento(AlquilerCancha evento){
        ArrayList<AlquilerCancha> Lista = Eventos.get(evento.getFecha());
        if(Lista == null) return;
        Lista.remove(evento);
    }

    public void mostrareventos(){
        for (Map.Entry<Date, ArrayList<AlquilerCancha>> evento : Eventos.entrySet()) {
            System.out.println(evento.getKey());
            for(AlquilerCancha alquilerCancha : evento.getValue()){
                System.out.println(alquilerCancha.getDescripcion());
            }
        }
    }

    private void mostrar(ArrayList<AlquilerCancha> listaEventos){
        for (AlquilerCancha evento : listaEventos) {
            System.out.println(evento.getFecha());
        }
    }

    public void mostrarEventosPasados(Date fecha){
        ArrayList<AlquilerCancha> listaEventosPasados = new ArrayList<>();
        for (Map.Entry<Date, ArrayList<AlquilerCancha>> eventoenlista : Eventos.entrySet()){
            if(fecha.after(eventoenlista.getKey())){
                for(AlquilerCancha alquilerCancha : eventoenlista.getValue()){
                    listaEventosPasados.add(alquilerCancha);
                }

            }
        }
        mostrar(listaEventosPasados);
    }

    public void mostrarEventosFuturos(Date fecha){
        ArrayList<AlquilerCancha> listaEventosFuturos = new ArrayList<>();
        for (Map.Entry<Date, ArrayList<AlquilerCancha>> eventoenlista : Eventos.entrySet()){
            if(fecha.before(eventoenlista.getKey())){
                for(AlquilerCancha alquilerCancha : eventoenlista.getValue()){
                    listaEventosFuturos.add(alquilerCancha);
                }

            }
        }
        mostrar(listaEventosFuturos);
    }

    public ArrayList<AlquilerCancha> buscarEventosEnFecha(Date fecha){
        ArrayList<AlquilerCancha> listaEventos = Eventos.get(fecha);
        if(listaEventos != null) return listaEventos;
        Eventos.put(fecha, new ArrayList<AlquilerCancha>());
        return Eventos.get(fecha);
    }

}
