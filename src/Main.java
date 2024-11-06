import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        CanchitaReunion reunion1 = new CanchitaReunion(new GregorianCalendar(2024,10,6).getTime(),"LaMadrid", "muy pobre");
        CanchitaReunion reunion2 = new CanchitaReunion(new GregorianCalendar(2022,11,25).getTime(),"Indepe", "lukas");
        CanchitaReunion reunion3 = new CanchitaReunion(new GregorianCalendar(2020,11,25).getTime(),"Indepe", "lukas");

        //System.out.println(new GregorianCalendar(2024,11,25).getTime());

        ListaEventos listaeve = new ListaEventos();
        listaeve.agregarEvento(reunion1);
        listaeve.agregarEvento(reunion2);
        listaeve.agregarEvento(reunion3);
        //listaeve.mostrar();

        listaeve.mostrarEventosPasados(new GregorianCalendar(2021,10,2).getTime());
        listaeve.mostrarEventosFuturos(new GregorianCalendar(2021,10,2).getTime());
        /*System.out.println(" ");

        Asistentes asistente = new Asistentes("Adan", "Rodriguez");
        Asistentes asistente2 = new Asistentes("Lionel","Messi");
        Asistentes asistente3 = new Asistentes("Safari","Lopez");
        Asistentes asistente4 = new Asistentes("Juan","Shul");
        Asistentes asistente5 = new Asistentes("Federico","Lupica");

        asistente5.setNombre("Francisco");

        reunion1.agregar(asistente);
        reunion1.agregar(asistente2);
        reunion1.agregar(asistente5);
        //reunion1.mostrar();

        System.out.println(reunion1.asistencia(asistente));
*/

    }
}