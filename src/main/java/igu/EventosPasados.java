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


public class EventosPasados extends javax.swing.JFrame {
    DefaultTableModel modelo;
    ListaEventos listaEventos;

    public EventosPasados(ListaEventos listaEventos){
        initComponents();
        this.listaEventos = listaEventos;
        modelo = new DefaultTableModel();
        modelo.addColumn("ORGANIZADOR");
        modelo.addColumn("FECHA");
        modelo.addColumn("HORARIO");
        modelo.addColumn("TAMAÑO");
        modelo.addColumn("INVITADOS");
        modelo.addColumn("ID");      
        modelo.addColumn("RECURSOS");
        this.tb1Registros.setModel(modelo);
                try {
            
            ArrayList<AlquilerCancha> listaEventosPasados = listaEventos.mostrarEventosPasados(new Date());
            System.out.print(listaEventosPasados);
            for(AlquilerCancha alquilerCancha: listaEventosPasados){
                
                modelo.addRow(new Object[]
                {alquilerCancha.getOrganizador().getNombreApellido(), 
                        alquilerCancha.getFecha(), 
                        alquilerCancha.getHorario(),
                        alquilerCancha.getTamañodecancha(),
                        alquilerCancha.mostrarAsistentes(),
                        alquilerCancha.getID(),
                        alquilerCancha.obtenerRecursos()
                });
            }
            
        } catch (Exception ex2) {System.out.println("error: " + ex2.getMessage());}
    }

    public static void main(String[] args) {

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
        jScrollPane2 = new javax.swing.JScrollPane();
        tb1Registros = new javax.swing.JTable();
        TITULOtxt1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        ATRASBTN.setText("Volver Atras");
        ATRASBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ATRASBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(ATRASBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ATRASBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        tb1Registros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tb1Registros);

        TITULOtxt1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        TITULOtxt1.setText("ALQUILER DE CANCHAS : EVENTOS PASADOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(TITULOtxt1)))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(TITULOtxt1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ATRASBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATRASBTNActionPerformed
        Pantalla newframe = new Pantalla();
        newframe.setVisible(true);
        newframe.setLocationRelativeTo(null);
        this.dispose();    
    }//GEN-LAST:event_ATRASBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ATRASBTN;
    private javax.swing.JLabel TITULOtxt1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb1Registros;
    // End of variables declaration//GEN-END:variables
}
