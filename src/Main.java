import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        Inquilino inquilino1 = new Inquilino("Nicolas", "Perez");

        AlquilerCanchita reunion1 = new AlquilerCanchaCasual(new GregorianCalendar(2024,10,6).getTime(),"LaMadrid",5,"canchita de fulbo 5", inquilino1);
        //AlquilerCanchita reunion2 = new AlquilerCanchaCasual(new GregorianCalendar(2022,11,25).getTime(),"Indepe",5, "canchita de fulbo 5", inquilino1);
        //AlquilerCanchita reunion3 = new AlquilerCanchaCasual(new GregorianCalendar(2020,11,25).getTime(),"Indepe",11, "canchita de fulbo 11", inquilino1);

        //System.out.println(new GregorianCalendar(2024,11,25).getTime());

        reunion1.setDescripcion("la fiesta sera increible");

        ListaEventos listaeve = new ListaEventos();
        listaeve.agregarEvento(reunion1);
        //listaeve.agregarEvento(reunion2);
        //listaeve.agregarEvento(reunion3);
        listaeve.mostrareventos();


        //listaeve.mostrarEventosPasados(new GregorianCalendar(2021,10,2).getTime());
        //listaeve.mostrarEventosFuturos(new GregorianCalendar(2021,10,2).getTime());
        //System.out.println(" ");

        Invitado invitado = new Invitado("Adan", "Rodriguez");
        Invitado invitado2 = new Invitado("Lionel","Messi");
        Invitado invitado3 = new Invitado("Safari","Lopez");
        Invitado invitado4 = new Invitado("Juan","Shul");
        Invitado invitado5 = new Invitado("Federico","Lupica");

        invitado5.setNombre("Francisco");

        invitado.esInvitadoAAlquiler(reunion1);
        invitado2.esInvitadoAAlquiler(reunion1);
        invitado5.esInvitadoAAlquiler(reunion1);
        System.out.println("Los invitados confirmados son: ");

        invitado.confirmarAsistencia();

        reunion1.mostrarAsistentes();

        invitado3.confirmarAsistencia();

        //System.out.println(reunion1.estaPresente(invitado));

        //AlquilerCanchaFiesta reunion4 = new AlquilerCanchaFiesta(new GregorianCalendar(2024,10,6).getTime(),"LaMadrid",5,"canchita de fulbo 5", inquilino1);
        System.out.println(reunion1.getTamañodecancha());
        inquilino1.cambiarTamañoCancha(11);
        System.out.println(reunion1.getTamañodecancha());

    }
}