import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        AlquilerCanchita reunion1 = new AlquilerCanchaCasual(new GregorianCalendar(2024,10,6).getTime(),"LaMadrid",5,"canchita de fulbo 5");
        AlquilerCanchita reunion2 = new AlquilerCanchaCasual(new GregorianCalendar(2022,11,25).getTime(),"Indepe",5, "canchita de fulbo 5");
        AlquilerCanchita reunion3 = new AlquilerCanchaCasual(new GregorianCalendar(2020,11,25).getTime(),"Indepe",11, "canchita de fulbo 11");

        //System.out.println(new GregorianCalendar(2024,11,25).getTime());

        reunion1.setDescripcion("la fiesta sera increible");

        ListaEventos listaeve = new ListaEventos();
        listaeve.agregarEvento(reunion1);
        listaeve.agregarEvento(reunion2);
        listaeve.agregarEvento(reunion3);
        listaeve.mostrareventos();


        listaeve.mostrarEventosPasados(new GregorianCalendar(2021,10,2).getTime());
        listaeve.mostrarEventosFuturos(new GregorianCalendar(2021,10,2).getTime());
        //System.out.println(" ");

        Invitado invitado = new Invitado("Adan", "Rodriguez", false);
        Invitado invitado2 = new Invitado("Lionel","Messi", true);
        Invitado invitado3 = new Invitado("Safari","Lopez", true);
        Invitado invitado4 = new Invitado("Juan","Shul",true);
        Invitado invitado5 = new Invitado("Federico","Lupica",true);

        invitado5.setNombre("Francisco");

        reunion1.agregarAsistente(invitado);
        reunion1.agregarAsistente(invitado2);
        reunion1.agregarAsistente(invitado5);
        reunion1.mostrarAsistentes();

        System.out.println(reunion1.estaPresente(invitado));
        

    }
}