import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class AplicacionCalendarioGUI {
    private static JFrame frame;
    private static Calendario calendario;
    private static JPanel calendarioPanel;
    private static int mesActual = Calendar.getInstance().get(Calendar.MONTH);  // Empezar con el mes actual
    private static int añoActual = Calendar.getInstance().get(Calendar.YEAR);    // Empezar con el año actual
    private static String fechaSeleccionada;  // Guardar la fecha seleccionada

    public static void main(String[] args) {
        // Crear el JFrame (ventana principal)
        frame = new JFrame("Aplicación Calendario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Ajustar tamaño para ver todo el año

        // Inicializar el calendario
        calendario = new Calendario();

        // Crear un panel para mostrar el calendario
        calendarioPanel = new JPanel();
        calendarioPanel.setLayout(new BorderLayout());

        // Mostrar el calendario del mes actual
        mostrarCalendario(mesActual, añoActual);

        // Crear barra de menú
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        JMenuItem agregarEventoItem = new JMenuItem("Agregar Evento");
        JMenuItem modificarEventoItem = new JMenuItem("Modificar Evento");
        JMenuItem eliminarEventoItem = new JMenuItem("Eliminar Evento");

        // Agregar opciones al menú
        menu.add(agregarEventoItem);
        menu.add(modificarEventoItem);
        menu.add(eliminarEventoItem);
        menuBar.add(menu);

        // Agregar botones de navegación para los meses
        JButton botonIzquierda = new JButton("<");
        JButton botonDerecha = new JButton(">");

        botonIzquierda.addActionListener((ActionEvent e) -> {
            mesActual--;
            if (mesActual < 0) {
                mesActual = 11;  // Volver al diciembre si estamos en enero
                añoActual--;
            }
            mostrarCalendario(mesActual, añoActual);  // Actualizar el calendario con el mes correcto
        });

        botonDerecha.addActionListener((ActionEvent e) -> {
            mesActual++;
            if (mesActual > 11) {
                mesActual = 0;  // Volver al enero si estamos en diciembre
                añoActual++;
            }
            mostrarCalendario(mesActual, añoActual);  // Actualizar el calendario con el mes correcto
        });

        JPanel panelNavegacion = new JPanel();
        panelNavegacion.setLayout(new BorderLayout());
        panelNavegacion.add(botonIzquierda, BorderLayout.WEST);
        panelNavegacion.add(botonDerecha, BorderLayout.EAST);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(panelNavegacion, BorderLayout.NORTH);
        frame.getContentPane().add(calendarioPanel, BorderLayout.CENTER);

        frame.setVisible(true);

        // Llamada para mostrar eventos de hoy cada 10 segundos
        iniciarAlertaDeEventos();

        // Acción para agregar evento
        agregarEventoItem.addActionListener((ActionEvent e) -> {
            if (fechaSeleccionada == null) {
                JOptionPane.showMessageDialog(frame, "Por favor, seleccione una fecha para agregar el evento.");
                return;
            }
            String descripcion = JOptionPane.showInputDialog(frame, "Ingrese la descripción del evento:");
            String ubicacion = JOptionPane.showInputDialog(frame, "Ingrese la ubicación del evento:");
            if (descripcion != null && ubicacion != null) {
                calendario.agregarEvento(new Evento(fechaSeleccionada, descripcion, ubicacion));
                mostrarCalendario(mesActual, añoActual);
            }
        });

        // Acción para modificar evento
        modificarEventoItem.addActionListener((ActionEvent e) -> {
            if (fechaSeleccionada == null) {
                JOptionPane.showMessageDialog(frame, "Por favor, seleccione una fecha para modificar el evento.");
                return;
            }
            ArrayList<Evento> eventosDelDia = calendario.obtenerEventos(fechaSeleccionada);
            if (eventosDelDia.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No hay eventos para este día.");
                return;
            }
            
            String descripcion = JOptionPane.showInputDialog(frame, "Ingrese la nueva descripción del evento:");
            String ubicacion = JOptionPane.showInputDialog(frame, "Ingrese la nueva ubicación del evento:");
            
            // Modificar el primer evento en la lista
            Evento evento = eventosDelDia.get(0);  // Suponemos que sólo modificamos el primer evento en este caso
            evento.setDescripcion(descripcion);
            evento.setUbicacion(ubicacion);
            
            mostrarCalendario(mesActual, añoActual);
        });

        // Acción para eliminar evento
        eliminarEventoItem.addActionListener((ActionEvent e) -> {
            if (fechaSeleccionada == null) {
                JOptionPane.showMessageDialog(frame, "Por favor, seleccione una fecha para eliminar el evento.");
                return;
            }
            ArrayList<Evento> eventosDelDia = calendario.obtenerEventos(fechaSeleccionada);
            if (eventosDelDia.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No hay eventos para este día.");
                return;
            }
            
            // Eliminar el primer evento en la lista
            calendario.eliminarEvento(eventosDelDia.get(0));  // Suponemos que eliminamos el primer evento
            
            mostrarCalendario(mesActual, añoActual);
        });
    }

    public static void mostrarCalendario(int mes, int año) {
        calendarioPanel.removeAll(); // Limpiar el panel antes de dibujar el nuevo calendario

        // Título con el mes y el año
        JLabel titulo = new JLabel(String.format("%1$tB %1$tY", new GregorianCalendar(año, mes, 1)));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        calendarioPanel.add(titulo, BorderLayout.NORTH);

        // Crear la grilla del calendario
        JPanel calendarioMesPanel = new JPanel(new GridLayout(0, 7)); // 7 columnas para los días de la semana
        String[] diasSemana = {"Dom", "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb"};
        for (String dia : diasSemana) {
            calendarioMesPanel.add(new JLabel(dia, JLabel.CENTER)); // Agregar encabezado de los días
        }

        // Determinar el primer día del mes y la cantidad de días
        Calendar cal = new GregorianCalendar(año, mes, 1);
        int primerDia = cal.get(Calendar.DAY_OF_WEEK);  // Día de la semana del primer día del mes
        int diasEnMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH);  // Número de días en el mes

        // Agregar espacios en blanco para los días anteriores al primer día
        for (int i = 1; i < primerDia; i++) {
            calendarioMesPanel.add(new JLabel(" ", JLabel.CENTER));
        }

        // Agregar los días del mes
        for (int dia = 1; dia <= diasEnMes; dia++) {
            final int diaFinal = dia;  // Declaramos `dia` como final para pasarlo al ActionListener
            JButton botonDia = new JButton(String.valueOf(diaFinal));
            botonDia.addActionListener((ActionEvent e) -> {
                // Usamos `diaFinal` en lugar de `dia`, ya que es final
                fechaSeleccionada = año + "-" + (mes + 1) + "-" + diaFinal;
                JOptionPane.showMessageDialog(frame, "Fecha seleccionada: " + fechaSeleccionada);
            });

            // Resaltar los días que tienen eventos
            String fechaDia = año + "-" + (mes + 1) + "-" + diaFinal;
            ArrayList<Evento> eventosDelDia = calendario.obtenerEventos(fechaDia);
            if (!eventosDelDia.isEmpty()) {
                botonDia.setBackground(Color.RED);  // Cambiar el color a rojo si tiene eventos
            }

            calendarioMesPanel.add(botonDia);
        }

        calendarioPanel.add(calendarioMesPanel, BorderLayout.CENTER);
        calendarioPanel.revalidate();
        calendarioPanel.repaint();
    }

    public static void iniciarAlertaDeEventos() {
        // Crear un temporizador que se active cada 10 segundos utilizando javax.swing.Timer
        javax.swing.Timer timer = new javax.swing.Timer(10000, (ActionEvent e) -> {
            // Obtener eventos de hoy y mostrar alerta
            ArrayList<Evento> eventosHoy = calendario.obtenerEventosDeHoy();
            if (!eventosHoy.isEmpty()) {
                for (Evento evento : eventosHoy) {
                    JOptionPane.showMessageDialog(frame, "¡Alerta! Evento hoy: " + evento.getDescripcion() + " - " + evento.getUbicacion());
                }
            }
        });
        timer.start();
    }
}
