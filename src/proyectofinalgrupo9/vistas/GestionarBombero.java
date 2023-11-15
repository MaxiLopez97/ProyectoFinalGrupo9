/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalgrupo9.vistas;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectofinalgrupo9.AccesoADATOS.BomberoData;
import proyectofinalgrupo9.AccesoADATOS.BrigadaData;
import proyectofinalgrupo9.ClasesEntidades.Bombero;
import proyectofinalgrupo9.ClasesEntidades.Brigada;

/**
 *
 * @author Maxi
 */
public class GestionarBombero extends javax.swing.JInternalFrame {

    private BomberoData bombero = new BomberoData();
    private Bombero bomberoNew = null;
//    private List<Brigada> lista;
    private ArrayList<Brigada> listab;

    private BrigadaData brig = new BrigadaData();
    private Brigada br = null;

    private DefaultTableModel modelo;

    public GestionarBombero() {
        initComponents();
        listab = (ArrayList<Brigada>) brig.listarBrigada();

        llenarCombo();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTDocumento = new javax.swing.JTextField();
        jTNombre = new javax.swing.JTextField();
        jTApellido = new javax.swing.JTextField();
        jBGuardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTNumeroDeCelular = new javax.swing.JTextField();
        jCActivo = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCCodigoDeBrigada = new javax.swing.JComboBox<>();
        jBModificar = new javax.swing.JButton();
        jBBorrar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jDateFecha = new com.toedter.calendar.JDateChooser();
        jBBuscarPorDni = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setClosable(true);

        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("INCORPORACIÓN DE BOMBEROS");
        jDesktopPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 0, -1, -1));

        jLabel2.setText("Documento:");
        jDesktopPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 44, 75, -1));

        jLabel3.setText("Nombre:");
        jDesktopPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 90, 75, -1));

        jLabel4.setText("Apellido:");
        jDesktopPane1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 132, 75, -1));

        jLabel5.setText("Fecha de Nac:");
        jDesktopPane1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 180, -1, -1));
        jDesktopPane1.add(jTDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 40, 220, -1));
        jDesktopPane1.add(jTNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 86, 300, -1));
        jDesktopPane1.add(jTApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 128, 300, -1));

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 345, -1, -1));

        jLabel6.setText("Celular:");
        jDesktopPane1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 221, 75, -1));
        jDesktopPane1.add(jTNumeroDeCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 217, 300, -1));

        jCActivo.setText("Activo");
        jCActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCActivoActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jCActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 303, -1, -1));

        jLabel7.setText("Estado");
        jDesktopPane1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 303, 68, -1));

        jLabel8.setText("Brigada:");
        jDesktopPane1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 264, 99, -1));

        jCCodigoDeBrigada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCCodigoDeBrigadaActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jCCodigoDeBrigada, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 259, 300, -1));

        jBModificar.setText("Modificar");
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 345, -1, -1));

        jBBorrar.setText("Borrar");
        jBBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBorrarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 345, -1, -1));

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 345, -1, -1));
        jDesktopPane1.add(jDateFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 170, 300, -1));

        jBBuscarPorDni.setText("Buscar");
        jBBuscarPorDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarPorDniActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBBuscarPorDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 32, -1, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCActivoActionPerformed

    //BUSCAR BOMBERO
    private void jBBuscarPorDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarPorDniActionPerformed

        try {

            Integer documento = Integer.parseInt(jTDocumento.getText());

            bomberoNew = bombero.buscarBombero(documento);

            if (bomberoNew != null) {
                jTNombre.setText(bomberoNew.getNombre());
                jTApellido.setText(bomberoNew.getApellido());
                LocalDate fecha = bomberoNew.getFecha_nac();
                java.util.Date date = java.util.Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
                jDateFecha.setDate(date);
                jTNumeroDeCelular.setText(bomberoNew.getCelular());
                jCActivo.setSelected(bomberoNew.isEstado());
                Brigada brigada = bomberoNew.getCodBrigada();
                jCCodigoDeBrigada.setSelectedItem(brigada);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un numero valido" + ex);

        }
    }//GEN-LAST:event_jBBuscarPorDniActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed

        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

// GUARDAR
    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed

        try {
            String dni = jTDocumento.getText();
            String nombre = jTNombre.getText();
            String apellido = jTApellido.getText();

            java.util.Date fecha_nacimiento = jDateFecha.getDate();
            LocalDate fecha_nac = fecha_nacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String celular = jTNumeroDeCelular.getText();
            Brigada brigada = (Brigada) jCCodigoDeBrigada.getSelectedItem();
            Boolean estado = jCActivo.isSelected();

            if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || fecha_nac == null || celular.isEmpty() || estado == false) {
                JOptionPane.showMessageDialog(this, "No puede haber campos vacios");
            }

            if (bomberoNew == null) {
                bomberoNew = new Bombero(dni, nombre, apellido, fecha_nac, celular, brigada, estado);
                bombero.guardarBombero(bomberoNew);
                limpiarCampos();

            } else {

                bomberoNew.setDni(dni);
                bomberoNew.setNombre(nombre);
                bomberoNew.setApellido(apellido);
                bomberoNew.setFecha_nac(fecha_nac);
                bomberoNew.setCelular(celular);
                bomberoNew.setCodBrigada(brigada);
                bomberoNew.setEstado(true);
                bombero.modificarBombero(bomberoNew);
                JOptionPane.showMessageDialog(this, "Modificacion Exitosa ");
                limpiarCampos();

            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "error: " + ex);

        }

    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jCCodigoDeBrigadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCCodigoDeBrigadaActionPerformed


    }//GEN-LAST:event_jCCodigoDeBrigadaActionPerformed

    //MODIFICAR
    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed

        try {

        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "No se ha modificado el Bombero" + ex);

        }
    }//GEN-LAST:event_jBModificarActionPerformed
    //BORRAR
    private void jBBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorrarActionPerformed
     
        
        if (bomberoNew != null) {
            bombero.darBajaPorInactividad(bomberoNew.getId_Bombero());
            
            bomberoNew = null;
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "No se puede borrar este Bombero");
        }


    }//GEN-LAST:event_jBBorrarActionPerformed

    //--------------Limpiar Campos (FUNCIONA BIEN)-----------------------------------
    public void limpiarCampos() {

        jTDocumento.setText("");
        jTNombre.setText("");
        jTApellido.setText("");
        jDateFecha.setDate(null);
        jTNumeroDeCelular.setText("");
        jCCodigoDeBrigada.setAction(null);
        jCActivo.setSelected(false);
    }

    private void llenarCombo() {

        for (Brigada bri : listab) {
            jCCodigoDeBrigada.addItem(bri);

        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBorrar;
    private javax.swing.JButton jBBuscarPorDni;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JCheckBox jCActivo;
    private javax.swing.JComboBox<Brigada> jCCodigoDeBrigada;
    private com.toedter.calendar.JDateChooser jDateFecha;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTApellido;
    private javax.swing.JTextField jTDocumento;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTNumeroDeCelular;
    // End of variables declaration//GEN-END:variables
}