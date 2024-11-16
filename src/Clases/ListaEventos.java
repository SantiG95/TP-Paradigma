package Clases;

import java.util.*;
import java.io.Serializable;

public class ListaEventos implements Serializable {
    Map<Date, ArrayList<AlquilerCancha>> Eventos;
    private static final long serialVersionUID = 1L;

    public ListaEventos(){
        //Eventos = new ArrayList<>();
        Eventos = new HashMap<>();
    }

    public void setListaEventos(ListaEventos listaEventos){
        this.Eventos = listaEventos.Eventos;
    }

    public void agregarEvento(AlquilerCancha eventoParaAgregar, Date fecha){
        ArrayList<AlquilerCancha> Lista = Eventos.get(fecha);
        if(Lista == null){
            Eventos.put(fecha, new ArrayList<AlquilerCancha>());
            Lista = Eventos.get(fecha);
        }
        Lista.add(eventoParaAgregar);
    }

    public void eliminarEvento(AlquilerCancha evento){
        ArrayList<AlquilerCancha> Lista = Eventos.get(evento.getFecha());
        if(Lista == null) return;
        Lista.remove(evento);
    }

    public void mostrarEventos(){
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

    public ArrayList<AlquilerCancha> obtenerEventosEnFecha(Date fecha){
        ArrayList<AlquilerCancha> listaEventos = Eventos.get(fecha);
        if(listaEventos != null) return listaEventos;
        Eventos.put(fecha, new ArrayList<AlquilerCancha>());
        return Eventos.get(fecha);
    }

    public Map<Date, ArrayList<AlquilerCancha>> getListaEventos(){
        return Eventos;
    }

    public void setListaEventos(Map<Date, ArrayList<AlquilerCancha>> listaEventos){
        this.Eventos = listaEventos;
    }

    public ArrayList<AlquilerCancha> obtenerEventosDeHoy() {
        Calendar cal = Calendar.getInstance();
        Date fechaHoy = cal.getTime();
        return obtenerEventosEnFecha(fechaHoy);
    }
}
