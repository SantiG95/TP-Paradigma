
public class Main {
    public static void main(String[] args) {

        CanchitaReunion reunion1 = new CanchitaReunion("06/11/24","LaMadrid", "muy pobre");
        CanchitaReunion reunion2 = new CanchitaReunion("25/12/24","Indepe", "lukas");

        ListaEventos listaeve = new ListaEventos();
        listaeve.agregarevento(reunion2);
        listaeve.agregarevento(reunion1);
        listaeve.mostrar();
        System.out.println(" ");

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


    }
}