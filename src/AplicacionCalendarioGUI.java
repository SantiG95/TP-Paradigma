import Clases.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
//import com.toedter.calendar.JDateChooser;

public class AplicacionCalendarioGUI {
    private static JFrame frame;
    private static ListaEventos listaEventos;
    private static JPanel calendarioPanel;
    private static int mesActual = Calendar.getInstance().get(Calendar.MONTH);
    private static int añoActual = Calendar.getInstance().get(Calendar.YEAR);

    public static void main(String[] args) {
        frame = new JFrame("Aplicación Calendario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        listaEventos = new ListaEventos();
        listaEventos.setListaEventos(GuardaDatos.cargarDatos());
        calendarioPanel = new JPanel();
        calendarioPanel.setLayout(new BorderLayout());

        mostrarCalendario(mesActual, añoActual);

        JMenuBar menuBar = new JMenuBar();
        JButton botonIzquierda = new JButton("<");
        JButton botonDerecha = new JButton(">");

        botonIzquierda.addActionListener((ActionEvent e) -> {
            mesActual--;
            if (mesActual < 0) {
                mesActual = 11;
                añoActual--;
            }
            mostrarCalendario(mesActual, añoActual);
        });

        botonDerecha.addActionListener((ActionEvent e) -> {
            mesActual++;
            if (mesActual > 11) {
                mesActual = 0;
                añoActual++;
            }
            mostrarCalendario(mesActual, añoActual);
        });

        JPanel panelNavegacion = new JPanel(new BorderLayout());
        panelNavegacion.add(botonIzquierda, BorderLayout.WEST);
        panelNavegacion.add(botonDerecha, BorderLayout.EAST);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(panelNavegacion, BorderLayout.NORTH);
        frame.getContentPane().add(calendarioPanel, BorderLayout.CENTER);

        frame.setVisible(true);
        iniciarAlertaDeEventos();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            GuardaDatos.guardarDatos(listaEventos.getListaEventos());
        }));
    }

    public static void mostrarCalendario(int mes, int año) {
        calendarioPanel.removeAll();

        JLabel titulo = new JLabel(String.format("%1$tB %1$tY", new GregorianCalendar(año, mes, 1)));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        calendarioPanel.add(titulo, BorderLayout.NORTH);

        JPanel calendarioMesPanel = new JPanel(new GridLayout(0, 7));
        String[] diasSemana = {"Dom", "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb"};
        for (String dia : diasSemana) {
            calendarioMesPanel.add(new JLabel(dia, JLabel.CENTER));
        }

        Calendar cal = new GregorianCalendar(año, mes, 1);
        int primerDia = cal.get(Calendar.DAY_OF_WEEK);
        int diasEnMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 1; i < primerDia; i++) {
            calendarioMesPanel.add(new JLabel(" ", JLabel.CENTER));
        }

        for (int dia = 1; dia <= diasEnMes; dia++) {
            final int diaFinal = dia;
            JButton botonDia = new JButton(String.valueOf(diaFinal));
            Calendar tempCal = new GregorianCalendar(año, mes, diaFinal);
            Date fechaDia = tempCal.getTime();

            botonDia.addActionListener((ActionEvent e) -> {
                ArrayList<AlquilerCancha> eventosDelDia = listaEventos.obtenerEventosEnFecha(fechaDia);
                if (eventosDelDia.isEmpty()) {
                    agregarEvento(fechaDia);
                } else {
                    mostrarOpcionesDeEventos(fechaDia, eventosDelDia);
                }
            });

            if (!listaEventos.obtenerEventosEnFecha(fechaDia).isEmpty()) {
                botonDia.setBackground(Color.RED);
            }

            calendarioMesPanel.add(botonDia);
        }

        calendarioPanel.add(calendarioMesPanel, BorderLayout.CENTER);
        calendarioPanel.revalidate();
        calendarioPanel.repaint();
    }

    public static void agregarEvento(Date fecha) {
        JPanel panel = new JPanel(new GridLayout(6, 6));

        JTextField descripcionField = new JTextField(20);
        JTextField ubicacionField = new JTextField(20);
        JTextField organizadorField = new JTextField(20);
        Integer[] tamañosDisponibles = {5, 7, 11};
        JComboBox<Integer> tamañoComboBox = new JComboBox<>(tamañosDisponibles);

        panel.add(new JLabel("Organizador:"));
        panel.add(organizadorField);
        panel.add(new JLabel("Descripción:"));
        panel.add(descripcionField);
        panel.add(new JLabel("Ubicación:"));
        panel.add(ubicacionField);
        panel.add(new JLabel("Tamaño:"));
        panel.add(tamañoComboBox);


        int resultado = JOptionPane.showConfirmDialog(frame, panel, "Agregar Evento", JOptionPane.OK_CANCEL_OPTION);

        if (resultado == JOptionPane.OK_OPTION) {
            String organizador = organizadorField.getText();
            String descripcion = descripcionField.getText();
            String ubicacion = ubicacionField.getText();
            int tamañoCancha = (int) tamañoComboBox.getSelectedItem();


            if (descripcion != null && ubicacion != null && organizador != null) {
                listaEventos.agregarEvento(new AlquilerCancha(fecha, ubicacion, 7, descripcion, new Persona("Francisco Lupica")), fecha);
                GuardaDatos.guardarDatos(listaEventos.getListaEventos());
                mostrarCalendario(mesActual, añoActual);
            }
        }
    }

    public static void mostrarOpcionesDeEventos(Date fecha, ArrayList<AlquilerCancha> eventosDelDia) {
        String[] opciones = new String[eventosDelDia.size() + 1];
        for (int i = 0; i < eventosDelDia.size(); i++) {
            opciones[i] = eventosDelDia.get(i).getDescripcion() + " en " + eventosDelDia.get(i).getUbicacion();
        }
        opciones[eventosDelDia.size()] = "Agregar nuevo evento";

        int opcion = JOptionPane.showOptionDialog(frame, "Seleccione una opción:", "Opciones de Evento",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        if (opcion == eventosDelDia.size()) {
            agregarEvento(fecha);
        } else if (opcion >= 0 && opcion < eventosDelDia.size()) {
            AlquilerCancha eventoSeleccionado = eventosDelDia.get(opcion);
            String[] opcionesModificacion = {"Modificar", "Eliminar"};
            int eleccion = JOptionPane.showOptionDialog(frame, "¿Qué desea hacer con el evento seleccionado?",
                    "Modificar o Eliminar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, opcionesModificacion, opcionesModificacion[0]);

            if (eleccion == 0) {
                modificarEvento(eventoSeleccionado);
            } else if (eleccion == 1) {
                listaEventos.eliminarEvento(eventoSeleccionado);
                mostrarCalendario(mesActual, añoActual);
            }
        }
    }

    public static void modificarEvento(AlquilerCancha evento) {
        String nuevaDescripcion = JOptionPane.showInputDialog(frame, "Ingrese la nueva descripción del evento:", evento.getDescripcion());
        String nuevaUbicacion = JOptionPane.showInputDialog(frame, "Ingrese la nueva ubicación del evento:", evento.getUbicacion());

        if (nuevaDescripcion != null && nuevaUbicacion != null) {
            evento.setDescripcion(nuevaDescripcion);
            evento.setUbicacion(nuevaUbicacion);
            GuardaDatos.guardarDatos(listaEventos.getListaEventos());
            mostrarCalendario(mesActual, añoActual);
        }
    }

    public static void iniciarAlertaDeEventos() {
        javax.swing.Timer timer = new javax.swing.Timer(10000, (ActionEvent e) -> {
            ArrayList<AlquilerCancha> eventosHoy = listaEventos.obtenerEventosDeHoy();
            if (!eventosHoy.isEmpty()) {
                for (AlquilerCancha evento : eventosHoy) {
                    JOptionPane.showMessageDialog(frame, "¡Alerta! Evento hoy: " + evento.getDescripcion() + " - " + evento.getUbicacion());
                }
            }
        });
        timer.start();
    }
}
