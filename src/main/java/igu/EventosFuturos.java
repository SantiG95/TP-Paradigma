/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package igu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import utils.GuardaDatos;
import logica.Clases.*;

/**
 *
 * @author ehoka
 */
public class EventosFuturos extends javax.swing.JFrame {
    DefaultTableModel modelo;
    ListaEventos listaEventos;

    public EventosFuturos(ListaEventos listaEventos) {
        initComponents();
        this.listaEventos = listaEventos;
        modelo = new DefaultTableModel();
        modelo.addColumn("ORGANIZADOR");
        modelo.addColumn("FECHA");
        modelo.addColumn("HORARIO");
        modelo.addColumn("TAMAÑO");
        modelo.addColumn("INVITADOS");
        modelo.addColumn("ID");

        this.tb1EventosFuturos.setModel(modelo);
            try {
            //FileReader archivoRTA = new FileReader("rtas.txt");
            //BufferedReader lectorRTA = new BufferedReader(archivoRTA);
            //String cadena;
            
            ArrayList<AlquilerCancha> listaEventosFuturos = listaEventos.mostrarEventosFuturos(new Date());
            System.out.print(listaEventosFuturos);
            for(AlquilerCancha alquilerCancha: listaEventosFuturos){
                
                modelo.addRow(new Object[]
                {alquilerCancha.getOrganizador().getNombreApellido(), 
                        alquilerCancha.getFecha(), 
                        alquilerCancha.getHorario(),
                        alquilerCancha.getTamañodecancha(),
                        alquilerCancha.mostrarAsistentes(),
                        alquilerCancha.getID()
                });
            }
            /*
            // Leer el archivo línea por línea
            while ((cadena = lectorRTA.readLine()) != null) {
                String[] bloques = cadena.split(",");

                Date fecha = new Date();
                System.out.println("Fecha actual: " + fecha);  
                
                //COMPROBACION DE QUE LA FECHA INGRESADA A LA TABLA ES ANTERIOR A LA ACTUAL
                try {
                    Date hoy = new Date(); // fecha de hoy
                    
                    String fechaString = bloques[1].trim() ; //fecha que se lee del txt
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date fechadoc = sdf.parse(fechaString);

                    if(fechadoc.compareTo(hoy)==1){
                        modelo.addRow(new Object[]{bloques[0].trim(), bloques[1].trim(), bloques[2].trim(),bloques[3].trim(),bloques[4].trim(),bloques[5].trim()});
                    }
                    
                } catch (Exception e) {System.out.println("Error al convertir la fecha: " + e.getMessage());}
                //FIN DE LA COMPROBACION
                
            }//FIN CICLO WHILE
            */
        } catch (Exception ex2) {System.out.println("error: " + ex2.getMessage());}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        ATRASBTN = new javax.swing.JButton();
        EditarEventoBTN = new javax.swing.JButton();
        IdAEditar = new javax.swing.JTextField();
        TITULOtxt1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb1EventosFuturos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        ATRASBTN.setText("Volver Atras");
        ATRASBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ATRASBTNActionPerformed(evt);
            }
        });

        EditarEventoBTN.setText("Editar un evento próximo");
        EditarEventoBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarEventoBTNActionPerformed(evt);
            }
        });

        IdAEditar.setText("ID DEL EVENTO  A EDITAR");
        IdAEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdAEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(IdAEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ATRASBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EditarEventoBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(305, Short.MAX_VALUE)
                .addComponent(EditarEventoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IdAEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(ATRASBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        TITULOtxt1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        TITULOtxt1.setText("STADIO QUILMES : EVENTOS FUTUROS");

        tb1EventosFuturos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tb1EventosFuturos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(TITULOtxt1)))
                .addGap(0, 39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(TITULOtxt1)
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ATRASBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATRASBTNActionPerformed
        Pantalla newframe = new Pantalla();
        newframe.setVisible(true);
        newframe.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ATRASBTNActionPerformed

    private void EditarEventoBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarEventoBTNActionPerformed
        String IdEventoSeleccionado = IdAEditar.getText();
        //Datos datos = new Datos();
        if(listaEventos.existeEventoConID(IdEventoSeleccionado)){
            EditarEvento newframe = new EditarEvento(IdEventoSeleccionado);
            newframe.setVisible(true);
            newframe.setLocationRelativeTo(null);
            this.dispose();    
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "El evento con el ID " + IdEventoSeleccionado + " no existe.", "Intente nuevamente", javax.swing.JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_EditarEventoBTNActionPerformed

    private void IdAEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdAEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdAEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ATRASBTN;
    private javax.swing.JButton EditarEventoBTN;
    private javax.swing.JTextField IdAEditar;
    private javax.swing.JLabel TITULOtxt1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb1EventosFuturos;
    // End of variables declaration//GEN-END:variables
}
