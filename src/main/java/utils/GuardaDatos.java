package utils;

import logica.Clases.AlquilerCancha;
import logica.Clases.ListaEventos;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class GuardaDatos {
    private static final String archivoGuardado = "datos.dat";

    public static void guardarDatos(Map<Date, ArrayList<AlquilerCancha>> listaEventos){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoGuardado));
            oos.writeObject(listaEventos);
            System.out.println("Los datos se han guardado");
            oos.close();
        } catch (Exception e){
            System.out.println("Error al guardar los datos");
        }
    }

    public static Map<Date, ArrayList<AlquilerCancha>> cargarDatos(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoGuardado));
            //@SuppressWarnings("unchecked")
            Map<Date, ArrayList<AlquilerCancha>> datos = (Map<Date, ArrayList<AlquilerCancha>>) ois.readObject();
            ois.close();
            System.out.println("Los datos se han cargado");
            return datos;    
        } 
        catch (Exception e){
            System.out.println("Error al cargar los datos");
            return new HashMap<Date, ArrayList<AlquilerCancha>>();
        }
    }
}
