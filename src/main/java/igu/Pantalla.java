/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package igu;

import java.awt.Color;
import java.util.Date;
import utils.*;
import logica.Clases.ListaEventos;


public class Pantalla extends javax.swing.JFrame {
    private int IdEvento;
    private ListaEventos listaEventos;

    /**
     * Creates new form NewJFrame
     */
    public Pantalla() {
        initComponents();
        listaEventos = new ListaEventos();
        listaEventos.setListaEventos(GuardaDatos.cargarDatos());
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            GuardaDatos.guardarDatos(listaEventos.getListaEventos());
        }));
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
        EVENTOSPASADOS = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        TITULO = new javax.swing.JLabel();
        tamaños = new javax.swing.JComboBox<>();
        FechaLabel = new javax.swing.JLabel();
        ORGANIZADOR = new javax.swing.JTextField();
        FECHAINDICADA = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        ContinuarBotton = new javax.swing.JButton();
        FechaLabel1 = new javax.swing.JLabel();
        FechaLabel2 = new javax.swing.JLabel();
        horarios = new javax.swing.JComboBox<>();
        EVENTOSFUTUROS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        EVENTOSPASADOS.setText("EventosPasados");
        EVENTOSPASADOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EVENTOSPASADOSActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        TITULO.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        TITULO.setText("ALQUILER DE CANCHAS");

        tamaños.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " Futbol 5 - $22000 ", " Futbol 6 - $26000 ", " Futbol 7 - $43000 ", " Futbol 8 - $48000 "  }));
        tamaños.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamañosActionPerformed(evt);
            }
        });

        FechaLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        FechaLabel.setForeground(new java.awt.Color(51, 51, 51));
        FechaLabel.setText("Seleccione Fecha");

        ORGANIZADOR.setForeground(new java.awt.Color(153, 153, 153));
        ORGANIZADOR.setText("NombreyApellido");
        ORGANIZADOR.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ORGANIZADORFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ORGANIZADORFocusLost(evt);
            }
        });
        ORGANIZADOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ORGANIZADORActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Seleccione Tamaño");

        ContinuarBotton.setText("Continuar");
        ContinuarBotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuarBottonActionPerformed(evt);
            }
        });

        FechaLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        FechaLabel1.setForeground(new java.awt.Color(51, 51, 51));
        FechaLabel1.setText("Ingrese su usuario");

        FechaLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        FechaLabel2.setForeground(new java.awt.Color(51, 51, 51));
        FechaLabel2.setText("Seleccione Horario");

        horarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "14","15","16","17","18","19","20","21","22","23" }));
        horarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ORGANIZADOR)
                        .addComponent(TITULO)
                        .addComponent(jLabel5)
                        .addComponent(FechaLabel1)
                        .addComponent(FechaLabel)
                        .addComponent(tamaños, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(FECHAINDICADA, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FechaLabel2)
                    .addComponent(horarios, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(ContinuarBotton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(TITULO)
                .addGap(56, 56, 56)
                .addComponent(FechaLabel1)
                .addGap(18, 18, 18)
                .addComponent(ORGANIZADOR, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FechaLabel)
                    .addComponent(FechaLabel2))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FECHAINDICADA, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(horarios, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addComponent(tamaños, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ContinuarBotton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        EVENTOSFUTUROS.setText("EventosFuturos");
        EVENTOSFUTUROS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EVENTOSFUTUROSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(EVENTOSPASADOS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EVENTOSFUTUROS)
                .addGap(75, 75, 75)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EVENTOSFUTUROS)
                    .addComponent(EVENTOSPASADOS))
                .addGap(124, 124, 124))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EVENTOSFUTUROSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EVENTOSFUTUROSActionPerformed
        listaEventos.setListaEventos(GuardaDatos.cargarDatos());
        EventosFuturos newframe = new EventosFuturos(listaEventos);
        newframe.setVisible(true);
        newframe.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_EVENTOSFUTUROSActionPerformed

    private void horariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horariosActionPerformed

    private void ContinuarBottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarBottonActionPerformed
        String organizador = ORGANIZADOR.getText();
        Date fecha = FECHAINDICADA.getDate();
        String tamañoSeleccionado = tamaños.getSelectedItem().toString();
        String Horario = horarios.getSelectedItem().toString();
        if(listaEventos.exitenEventosEnFechaYHora(fecha,Horario)){
            javax.swing.JOptionPane.showMessageDialog(this, "La opción de alquiler seleccionada ya se encuentra ocupada.", "Intente nuevamente.", javax.swing.JOptionPane.ERROR_MESSAGE);
        }else{
            switch (tamaños.getSelectedItem().toString()) {
                case " Futbol 5 - $22000 ":
                Futbol5 newFrame5 = new Futbol5(organizador,fecha,tamañoSeleccionado,Horario, listaEventos);
                newFrame5.setVisible(true);
                newFrame5.setLocationRelativeTo(null);
                this.dispose();
                break;
                case " Futbol 6 - $26000 ":
                Futbol6 newFrame6 = new Futbol6(organizador,fecha,tamañoSeleccionado,Horario, listaEventos);
                newFrame6.setVisible(true);
                newFrame6.setLocationRelativeTo(null);
                this.dispose();
                break;
                case " Futbol 7 - $43000 ":
                Futbol7 newFrame7 = new Futbol7(organizador,fecha,tamañoSeleccionado,Horario, listaEventos);
                newFrame7.setVisible(true);
                newFrame7.setLocationRelativeTo(null);
                this.dispose();
                break;
                case " Futbol 8 - $48000 ":
                Futbol8 newFrame8 = new Futbol8(organizador,fecha,tamañoSeleccionado,Horario, listaEventos);
                newFrame8.setVisible(true);
                newFrame8.setLocationRelativeTo(null);
                this.dispose();
                break;
            }

        }

    }//GEN-LAST:event_ContinuarBottonActionPerformed

    private void ORGANIZADORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ORGANIZADORActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ORGANIZADORActionPerformed

    private void ORGANIZADORFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ORGANIZADORFocusLost

    }//GEN-LAST:event_ORGANIZADORFocusLost

    private void ORGANIZADORFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ORGANIZADORFocusGained

    }//GEN-LAST:event_ORGANIZADORFocusGained

    private void tamañosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamañosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamañosActionPerformed

    private void EVENTOSPASADOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EVENTOSPASADOSActionPerformed
        listaEventos.setListaEventos(GuardaDatos.cargarDatos());
        EventosPasados newframe = new EventosPasados(listaEventos);
        newframe.setVisible(true);
        newframe.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_EVENTOSPASADOSActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ContinuarBotton;
    private javax.swing.JButton EVENTOSFUTUROS;
    private javax.swing.JButton EVENTOSPASADOS;
    private com.toedter.calendar.JDateChooser FECHAINDICADA;
    private javax.swing.JLabel FechaLabel;
    private javax.swing.JLabel FechaLabel1;
    private javax.swing.JLabel FechaLabel2;
    private javax.swing.JTextField ORGANIZADOR;
    private javax.swing.JLabel TITULO;
    private javax.swing.JComboBox<String> horarios;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> tamaños;
    // End of variables declaration//GEN-END:variables
}
