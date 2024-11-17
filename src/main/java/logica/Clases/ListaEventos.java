package logica.Clases;

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

    public ArrayList<AlquilerCancha> mostrarEventosPasados(Date fecha){
        ArrayList<AlquilerCancha> listaEventosPasados = new ArrayList<>();
        for (Map.Entry<Date, ArrayList<AlquilerCancha>> eventoenlista : Eventos.entrySet()){
            System.out.println(eventoenlista.getKey());
            if(fecha.after(eventoenlista.getKey())){
                for(AlquilerCancha alquilerCancha : eventoenlista.getValue()){
                    listaEventosPasados.add(alquilerCancha);
                }

            }
        }
        
        mostrar(listaEventosPasados);
        return listaEventosPasados;
    }

    public ArrayList<AlquilerCancha> mostrarEventosFuturos(Date fecha){
        ArrayList<AlquilerCancha> listaEventosFuturos = new ArrayList<>();
        for (Map.Entry<Date, ArrayList<AlquilerCancha>> eventoenlista : Eventos.entrySet()){
            if(fecha.before(eventoenlista.getKey())){
                for(AlquilerCancha alquilerCancha : eventoenlista.getValue()){
                    listaEventosFuturos.add(alquilerCancha);
                }

            }
        }
        //mostrar(listaEventosFuturos);
        return listaEventosFuturos;
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

    public String generarID(){
        int idMasAlto = 0;
        if(Eventos.isEmpty()) return "0";
        for(Map.Entry<Date, ArrayList<AlquilerCancha>> eventosDelDia: Eventos.entrySet()){
            for(AlquilerCancha alquiler: eventosDelDia.getValue()){
                if(alquiler.getID() > idMasAlto) idMasAlto = alquiler.getID();
            }
        }
        return Integer.toString(idMasAlto + 1);
    }

    public boolean existeEventoConID(String id){
        return (obtenerEventoPorID(id) != null);
    }

    public AlquilerCancha obtenerEventoPorID(String id){
        for(Map.Entry<Date, ArrayList<AlquilerCancha>> eventosDelDia: Eventos.entrySet()){
            for(AlquilerCancha alquiler: eventosDelDia.getValue()){
                if(Integer.toString(alquiler.getID()).equals(id) ) return alquiler;
            }
        }
        return null;
    }

    public boolean exitenEventosEnFechaYHora(Date fecha, String horario){
        ArrayList<AlquilerCancha> listaEventos = obtenerEventosEnFecha(fecha);
        for(AlquilerCancha alquiler: listaEventos){
            if(alquiler.getHorario().equals(horario)) return true;
        }
        return false;
    }
}
