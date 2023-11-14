/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalgrupo9.vistas;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectofinalgrupo9.AccesoADATOS.CuartelData;
import proyectofinalgrupo9.ClasesEntidades.CuartelDeBomberos;

/**
 *
 * @author Maxi
 */
public class GestionarCuartel extends javax.swing.JInternalFrame {

    private CuartelData cuartel = new CuartelData();
    private CuartelDeBomberos cuartelActual = null;
    private DefaultTableModel modelo;
    private ArrayList<CuartelData> lista;
    private CuartelData cuartel1;

    public GestionarCuartel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTTelefono = new javax.swing.JTextField();
        jTCoord_Y = new javax.swing.JTextField();
        jTCoor_X = new javax.swing.JTextField();
        jTDireccion = new javax.swing.JTextField();
        jTNombreDelCuartel = new javax.swing.JTextField();
        jCEstado = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jBGuardar = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();
        jBBorrar = new javax.swing.JButton();
        jTCorreo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCuarteles = new javax.swing.JTable();
        jBSalirCuarteles = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCSeleccionarCuartel = new javax.swing.JComboBox<>();

        setClosable(true);

        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INCORPORACIÓN DE CUARTELES");
        jDesktopPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 0, -1, 30));

        jLabel2.setText("Nombre del Cuartel:");
        jDesktopPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 80, -1, -1));

        jLabel3.setText("Direccion:");
        jDesktopPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 122, 75, -1));

        jLabel4.setText("Coordenada X:");
        jDesktopPane1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 164, 99, -1));

        jLabel5.setText("Coordenada Y:");
        jDesktopPane1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 206, 99, -1));

        jLabel6.setText("Telefono:");
        jDesktopPane1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 248, 75, -1));

        jLabel8.setText("Correo:");
        jDesktopPane1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 290, 99, -1));
        jDesktopPane1.add(jTTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 244, 274, -1));
        jDesktopPane1.add(jTCoord_Y, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 202, 274, -1));
        jDesktopPane1.add(jTCoor_X, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 160, 274, -1));
        jDesktopPane1.add(jTDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 118, 274, -1));
        jDesktopPane1.add(jTNombreDelCuartel, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 76, 274, -1));

        jCEstado.setText("Activo");
        jCEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCEstadoActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jCEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 328, -1, -1));

        jLabel7.setText("Estado");
        jDesktopPane1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 328, -1, -1));

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 370, -1, -1));

        jBModificar.setText("Modificar");
        jDesktopPane1.add(jBModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 370, -1, -1));

        jBBorrar.setText("Borrar");
        jBBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBorrarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 370, -1, -1));
        jDesktopPane1.add(jTCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 286, 274, -1));

        jTCuarteles.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTCuarteles);

        jDesktopPane1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 506, 390, 265));

        jBSalirCuarteles.setText("Salir");
        jBSalirCuarteles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirCuartelesActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBSalirCuarteles, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 777, 65, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CUARTELES");
        jDesktopPane1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, -1, -1));

        jLabel9.setText("Seleccionar Cuartel:");
        jDesktopPane1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 120, -1));

        jCSeleccionarCuartel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCSeleccionarCuartelItemStateChanged(evt);
            }
        });
        jCSeleccionarCuartel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCSeleccionarCuartelActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jCSeleccionarCuartel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCEstadoActionPerformed

    // GUARDAR CUARTEL
    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed

        try {
            String nombre = jTNombreDelCuartel.getText();
            String direccion = jTDireccion.getText();
            Integer coor_x = Integer.parseInt(jTCoor_X.getText());
            Integer coor_y = Integer.parseInt(jTCoord_Y.getText());
            String numero = jTTelefono.getText();
            String correo = jTCorreo.getText();
            Boolean estado = jCEstado.isSelected();

            if (nombre.isEmpty() || direccion.isEmpty() || coor_x == null || coor_y == null || correo.isEmpty() || numero.isEmpty() || estado == true) {

                JOptionPane.showMessageDialog(this, "No puede haber campos vacios");

                return;
            }

            if (cuartelActual == null) {
                cuartelActual = new CuartelDeBomberos(nombre, direccion, coor_x, coor_y, numero, correo, estado);
                cuartel.guardarCuartel(cuartelActual);
                limpiarCampos();
            }

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacios");
        }

    }//GEN-LAST:event_jBGuardarActionPerformed

    //BORRAR
    private void jBBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorrarActionPerformed

        if (cuartelActual != null) {
            cuartel.eliminarCuartel(cuartelActual.getCodCuartel());
            cuartelActual = null;
            limpiarCampos();

        } else {

            JOptionPane.showMessageDialog(this, "No hay un alumno seleccionado");
        }

    }//GEN-LAST:event_jBBorrarActionPerformed

    //SALIR
    private void jBSalirCuartelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirCuartelesActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirCuartelesActionPerformed

    //SELECCIONAR CUARTEL
    private void jCSeleccionarCuartelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCSeleccionarCuartelItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            limpiarTabla();
            llenar();
        }

    }//GEN-LAST:event_jCSeleccionarCuartelItemStateChanged

    private void jCSeleccionarCuartelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCSeleccionarCuartelActionPerformed



    }//GEN-LAST:event_jCSeleccionarCuartelActionPerformed

    //LLENAR TABLA
    private void llenar() {
        jCSeleccionarCuartel.getSelectedItem();
        List<CuartelData> listarCuarteles = lista;

        for (CuartelData item : listarCuarteles) {
            jCSeleccionarCuartel.addItem(item);

        }

    }

    // LIMPIAR TABLA
    private void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jTCuarteles.getModel();
        modelo.setRowCount(0);
    }

    //--------------Cabecera de la Tabla-----------------------------------
    private void cabecera() {

        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add(" Nombre: ");
        filaCabecera.add(" Direccion: ");
        filaCabecera.add(" Coordenada X: ");
        filaCabecera.add("Coordenada Y: ");
        filaCabecera.add("Telefono: ");
        filaCabecera.add("Correo: ");
        filaCabecera.add("Estado: ");

        for (Object it : filaCabecera) {

            modelo.addColumn(it);

        }
        jTCuarteles.setModel(modelo);

    }

    //--------------Cargar -----------------------------------
    private void carga() {

        List<CuartelData> todo = lista;
        for (CuartelData item : todo) {
            jCSeleccionarCuartel.addItem(item);
        }
    }

    //--------------Limpiar Campos-----------------------------------
    public void limpiarCampos() {

        jTNombreDelCuartel.setText("");
        jTDireccion.setText("");
        jTCoor_X.setText("");
        jTCoord_Y.setText("");
        jTTelefono.setText("");
        jTCorreo.setText("");
        jCEstado.setSelected(false);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBorrar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JButton jBSalirCuarteles;
    private javax.swing.JCheckBox jCEstado;
    private javax.swing.JComboBox<CuartelData> jCSeleccionarCuartel;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTCoor_X;
    private javax.swing.JTextField jTCoord_Y;
    private javax.swing.JTextField jTCorreo;
    private javax.swing.JTable jTCuarteles;
    private javax.swing.JTextField jTDireccion;
    private javax.swing.JTextField jTNombreDelCuartel;
    private javax.swing.JTextField jTTelefono;
    // End of variables declaration//GEN-END:variables
}
