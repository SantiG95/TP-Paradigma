/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Set;
import javax.swing.JPanel;

/**
 *
 * @author ehoka
 */
public class Datos extends JPanel{
    
    public Set<Date> fechasOcupadas;
    public javax.swing.JPanel jPanel1; 
    private static int IdEvento = 0; 
    
    public void guardarDatos(String organizador, Date fecha, String tamañoSeleccionado, ArrayList<String> invitados, String Horario) {
        IdEvento++;
        String fechaFormateada = new SimpleDateFormat("dd/MM/yyyy").format(fecha);
        
        String stringinvitados = "";
        for (String inv : invitados){
            stringinvitados = stringinvitados + inv + " " ;
        }
        
        // Crear la cadena con el formato deseado
        String datos = organizador + "," + fechaFormateada + "," + Horario +","+ tamañoSeleccionado+ "," + stringinvitados + "," + IdEvento;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("rtas.txt", true))) { // 'true' para agregar al final
            writer.write(datos + "\n");  // Escribir en una línea y agregar un salto de línea al final
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public void modificarDatos(String organizador, Date fecha, String tamañoSeleccionado, String invitados, String Horario, String IdEvento) {
        
        String fechaFormateada = new SimpleDateFormat("dd/MM/yyyy").format(fecha);
        String nuevosDatos = organizador + "," + fechaFormateada + "," + Horario + "," + tamañoSeleccionado + "," + invitados + "," + IdEvento;
        
        List<String> lineas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("rtas.txt"))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(","); 
                if (datos.length > 5 && datos[5].equals(IdEvento)) {
                    lineas.add(nuevosDatos);
                } else {
                    lineas.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return; // Salimos si hay un error de lectura
        }

        // Reescribimos el archivo con los datos actualizados
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("rtas.txt"))) {
            for (String linea : lineas) {
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public boolean se_encuentra(String idEvento) {
    try (BufferedReader reader = new BufferedReader(new FileReader("rtas.txt"))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split(",");
            if (datos.length > 5 && datos[5].equals(idEvento)) {
                return true; // Si encontramos el IdEvento, retornamos true
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false; // Si no se encuentra, retornamos false
}

public boolean buscarEvento(Date fecha, String hora, String tamañoCancha) {
    String fechaFormateada = new SimpleDateFormat("dd/MM/yyyy").format(fecha);
    
    try (BufferedReader reader = new BufferedReader(new FileReader("rtas.txt"))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split(",");
            // Verificamos si la fecha, hora y tamaño de cancha coinciden
            if (datos.length >= 4 && datos[1].equals(fechaFormateada) && datos[2].equals(hora) && datos[3].equals(tamañoCancha)) {
                return true; // Si encontramos la coincidencia, retornamos true
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    return false; // Si no se encuentra ninguna coincidencia, retornamos false
}

}
    



    


