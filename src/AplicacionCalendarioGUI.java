import Alquileres.AlquilerCancha;
import Alquileres.AlquilerCanchaCasual;
import Personas.Organizador;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class AplicacionCalendarioGUI {
    private static JFrame frame;
    private static Calendario calendario;
    private static JPanel calendarioPanel;
    private static int mesActual = Calendar.getInstance().get(Calendar.MONTH);
    private static int añoActual = Calendar.getInstance().get(Calendar.YEAR);

    public static void main(String[] args) {
        frame = new JFrame("Aplicación Calendario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        calendario = new Calendario();
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
                ArrayList<AlquilerCancha> eventosDelDia = calendario.obtenerEventos(fechaDia);
                if (eventosDelDia.isEmpty()) {
                    agregarEvento(fechaDia);
                } else {
                    mostrarOpcionesDeEventos(fechaDia, eventosDelDia);
                }
            });

            if (!calendario.obtenerEventos(fechaDia).isEmpty()) {
                botonDia.setBackground(Color.RED);
            }

            calendarioMesPanel.add(botonDia);
        }

        calendarioPanel.add(calendarioMesPanel, BorderLayout.CENTER);
        calendarioPanel.revalidate();
        calendarioPanel.repaint();
    }

    public static void agregarEvento(Date fecha) {
        String descripcion = JOptionPane.showInputDialog(frame, "Ingrese la descripción del evento:");
        String ubicacion = JOptionPane.showInputDialog(frame, "Ingrese la ubicación del evento:");
        if (descripcion != null && ubicacion != null) {
            //TODO revisar esto
            calendario.agregarEvento(new AlquilerCanchaCasual(fecha, ubicacion, 7, descripcion, new Organizador("Francisco", "Lupica")));
            mostrarCalendario(mesActual, añoActual);
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
                calendario.eliminarEvento(eventoSeleccionado);
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
            mostrarCalendario(mesActual, añoActual);
        }
    }

    public static void iniciarAlertaDeEventos() {
        javax.swing.Timer timer = new javax.swing.Timer(10000, (ActionEvent e) -> {
            ArrayList<AlquilerCancha> eventosHoy = calendario.obtenerEventosDeHoy();
            if (!eventosHoy.isEmpty()) {
                for (AlquilerCancha evento : eventosHoy) {
                    JOptionPane.showMessageDialog(frame, "¡Alerta! Evento hoy: " + evento.getDescripcion() + " - " + evento.getUbicacion());
                }
            }
        });
        timer.start();
    }
}
