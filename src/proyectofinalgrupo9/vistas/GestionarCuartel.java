package proyectofinalgrupo9.vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectofinalgrupo9.AccesoADATOS.CuartelData;
import proyectofinalgrupo9.ClasesEntidades.CuartelDeBomberos;

public class GestionarCuartel extends javax.swing.JInternalFrame {

    private CuartelData cuartel = new CuartelData();
    private CuartelDeBomberos cuartelActual = null;

    private DefaultTableModel modelo;

    private List<CuartelDeBomberos> lista;
    private CuartelData cuartel1;

    public GestionarCuartel() {

        initComponents();
        cuartel1 = new CuartelData();
        lista = cuartel1.listarCuarteles();

        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int f, int c) {
                if (c == 0) {
                    return false;
                }

                if (c == 7) {

                    return false;
                }
                return true;
            }

        };

        cabecera();
        cargarTabla();

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

        setClosable(true);

        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INCORPORACIÓN DE CUARTELES");
        jDesktopPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, 30));

        jLabel2.setText("Nombre del Cuartel:");
        jDesktopPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, 20));

        jLabel3.setText("Direccion:");
        jDesktopPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 75, -1));

        jLabel4.setText("Coordenada X:");
        jDesktopPane1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 99, -1));

        jLabel5.setText("Coordenada Y:");
        jDesktopPane1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 99, -1));

        jLabel6.setText("Telefono:");
        jDesktopPane1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 75, -1));

        jLabel8.setText("Correo:");
        jDesktopPane1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 70, -1));
        jDesktopPane1.add(jTTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 274, -1));
        jDesktopPane1.add(jTCoord_Y, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 274, -1));
        jDesktopPane1.add(jTCoor_X, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 274, -1));
        jDesktopPane1.add(jTDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 274, -1));
        jDesktopPane1.add(jTNombreDelCuartel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 274, -1));

        jCEstado.setText("Activo");
        jDesktopPane1.add(jCEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 324, -1, 30));

        jLabel7.setText("Estado:");
        jDesktopPane1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, -1));

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jBModificar.setText("Modificar");
        jBModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 750, -1, -1));

        jBBorrar.setText("Borrar");
        jBBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBorrarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 750, -1, -1));
        jDesktopPane1.add(jTCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 274, -1));

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

        jDesktopPane1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 570, 265));

        jBSalirCuarteles.setText("Salir");
        jBSalirCuarteles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirCuartelesActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBSalirCuarteles, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 750, 65, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CUARTELES");
        jDesktopPane1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // GUARDAR CUARTEL (esta bien)
    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed

        try {
            String nombre = jTNombreDelCuartel.getText();
            String direccion = jTDireccion.getText();
            Integer coor_x = Integer.parseInt(jTCoor_X.getText());
            Integer coor_y = Integer.parseInt(jTCoord_Y.getText());
            String numero = jTTelefono.getText();
            String correo = jTCorreo.getText();
            Boolean estado = jCEstado.isSelected();

            if (nombre.isEmpty() || direccion.isEmpty() || coor_x == null || coor_y == null || correo.isEmpty() || numero.isEmpty() || estado == false) {

                JOptionPane.showMessageDialog(this, "No puede haber campos vacios");

                return;
            }

            if (cuartelActual == null) {
                cuartelActual = new CuartelDeBomberos(nombre, direccion, coor_x, coor_y, numero, correo, estado);
                cuartel.guardarCuartel(cuartelActual);
                limpiarCampos();
                limpiarTabla();
                cargarTabla();
            }

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacios");
        }

    }//GEN-LAST:event_jBGuardarActionPerformed

    //BORRAR (FUNCIONA)
    private void jBBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorrarActionPerformed

        try {
            int fila = jTCuarteles.getSelectedRow();
            int count = jTCuarteles.getSelectedRowCount();
            if (count == 1) {
                int idCuartel = (int) modelo.getValueAt(fila, 0);
                cuartel1.eliminarCuartel(idCuartel);
                limpiarTabla();
                cargarTabla();

            } else {
                JOptionPane.showMessageDialog(this, "No seleccionaste ningun cuartel");
            }

//         
        } catch (NullPointerException ex) {

            JOptionPane.showMessageDialog(this, "No se puede eliminar este cuartel" + ex);
        }
    }//GEN-LAST:event_jBBorrarActionPerformed

    //SALIR
    private void jBSalirCuartelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirCuartelesActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirCuartelesActionPerformed

    //MODIFICAR
    private void jBModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarActionPerformed

        try {
            int fila = jTCuarteles.getSelectedRow();

            int codCuartel = (int) modelo.getValueAt(fila, 0);
            String nombre = (String) modelo.getValueAt(fila, 1);
            String direccion = (String) modelo.getValueAt(fila, 2);

            String coord_xString = modelo.getValueAt(fila, 3).toString();
            int coord_x = Integer.parseInt(coord_xString);

            String coord_yString = modelo.getValueAt(fila, 4).toString();
            int coord_y = Integer.parseInt(coord_yString);

            String telefono = (String) modelo.getValueAt(fila, 5);
            String correo = (String) modelo.getValueAt(fila, 6);

            CuartelDeBomberos cuartelito = new CuartelDeBomberos(codCuartel, nombre, direccion, coord_x, coord_y, telefono, correo, true);

            cuartel.modificarCuartel(cuartelito);
            limpiarTabla();
            cargarTabla();
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "No se ha modificado el Cuartel" + ex);
        }
    }//GEN-LAST:event_jBModificarActionPerformed

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // LIMPIAR TABLA
    private void limpiarTabla() {

        modelo.setRowCount(0);
    }

    // CABECERA DE LA TABLA  (ESTA BIEN)
    private void cabecera() {

        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("ID:");
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

    private void cargarTabla() {

        List<CuartelDeBomberos> lista = cuartel1.listarCuarteles();
        for (CuartelDeBomberos a : lista) {
            modelo.addRow(new Object[]{
                a.getCodCuartel(),
                a.getNombre_cuartel(),
                a.getDireccion(),
                a.getCoord_X(),
                a.getCoord_Y(),
                a.getTelefono(),
                a.getCorreo(),
                a.isEstado()
            });
        }

    }

    //borrar datos de tabla
    private void borrarTabla() {

        int indice = modelo.getRowCount() - 1;

        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    //--------------Limpiar Campos (FUNCIONA BIEN)-----------------------------------
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
