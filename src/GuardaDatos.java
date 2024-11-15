import Clases.ListaEventos;

import java.io.*;

public class GuardaDatos {
    private static final String archivoGuardado = "datos.dat";

    public static void guardarDatos(ListaEventos listaEventos){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoGuardado));
            oos.writeObject(listaEventos);
            oos.close();
        } catch (Exception e){
            System.out.println("Error al guardar los datos");
        }
    }

    public static ListaEventos cargarDatos(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoGuardado));
            ListaEventos datos = (ListaEventos) ois.readObject();
            ois.close();
            return datos;    
        } 
        catch (Exception e){
            System.out.println("Error al cargar los datos");
            return new ListaEventos();
        }
    }
}
