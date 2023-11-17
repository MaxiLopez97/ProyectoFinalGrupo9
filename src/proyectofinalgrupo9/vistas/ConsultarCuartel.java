
package proyectofinalgrupo9.vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectofinalgrupo9.AccesoADATOS.BrigadaData;
import proyectofinalgrupo9.AccesoADATOS.CuartelData;
import proyectofinalgrupo9.ClasesEntidades.Brigada;
import proyectofinalgrupo9.ClasesEntidades.CuartelDeBomberos;

public class ConsultarCuartel extends javax.swing.JInternalFrame {
    
    private DefaultTableModel modelo;

    private CuartelData cuartelData = new CuartelData();
    private CuartelDeBomberos cuartelNew = new CuartelDeBomberos();

    private BrigadaData brigadaData = new BrigadaData();
    private Brigada brigada = new Brigada();

    private ArrayList<Brigada> listaBrigadas;
    private ArrayList<CuartelDeBomberos> cuartel;

    public ConsultarCuartel() {
        
        initComponents();
        
        modelo= new DefaultTableModel();



        cuartel=(ArrayList<CuartelDeBomberos>) cuartelData.listarCuarteles();
        listaBrigadas = (ArrayList<Brigada>) brigadaData.listarBrigada();

        llenarCuartel();
        armarCabecera();
        llenarTabla();

        jCSeleccionarCuarteles.setSelectedIndex(-1);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCSeleccionarCuarteles = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jCuarteles = new javax.swing.JTable();
        jSalir = new javax.swing.JButton();
        jBoton = new javax.swing.JButton();

        setClosable(true);

        escritorio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("CONSULTAR CUARTEL");
        escritorio.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        jLabel2.setText("Seleccionar cuartel :");
        escritorio.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        escritorio.add(jCSeleccionarCuarteles, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 360, -1));

        jCuarteles.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jCuarteles);

        escritorio.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 170, 660, -1));

        jSalir.setText("Salir");
        escritorio.add(jSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 620, -1, -1));

        jBoton.setText("Buscar");
        jBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotonActionPerformed(evt);
            }
        });
        escritorio.add(jBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotonActionPerformed
        
        try {

            int selec = jCSeleccionarCuarteles.getSelectedIndex();

            if (selec > -1) {

                CuartelDeBomberos cuartel2 = (CuartelDeBomberos) jCSeleccionarCuarteles.getSelectedItem();

                List<Brigada> listaB = (ArrayList) brigadaData.listarBrigadaXCuartel(cuartel2);

                DefaultTableModel modeloTabla = (DefaultTableModel) jCuarteles.getModel();
                modeloTabla.setRowCount(0);

                for (Brigada b : listaB) {
                    Object[] fila = {b.getCodBrigada(), b.getNombre_br(), b.getEspecialidad(), b.getNro_cuartel().getCodCuartel()};

                    modelo.addRow(fila);

                }

            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(null, "Debe ingresar un ID válido");

        }
        
    }//GEN-LAST:event_jBotonActionPerformed

    // ------------ LLENAR CUARTELES ------------
    private void llenarCuartel() {

        for (CuartelDeBomberos c : cuartel) {

            jCSeleccionarCuarteles.addItem(c);

        }

    }

    //-------------ARMAR CABECERA.------------------------
    private void armarCabecera() {

        ArrayList<Object> filaCabecera = new ArrayList<>();

        filaCabecera.add(" Codigo de Brigada: ");
        filaCabecera.add(" Nombre Brigada: ");
        filaCabecera.add(" Especialidad: ");
        filaCabecera.add(" Numero de Cuartel: ");

        for (Object it : filaCabecera) {

            modelo.addColumn(it);

        }
        jCuarteles.setModel(modelo);

    }

    // ------------ LLENAR TABLA ------------
    private void llenarTabla() {
        ArrayList<Brigada> listaB = (ArrayList<Brigada>) brigadaData.listarBrigada();

        for (Brigada a : listaB) {

            modelo.addRow(new Object[]{a.getCodBrigada(), a.getNombre_br(), a.getEspecialidad(), a.getNro_cuartel().getCodCuartel()});

        }

    }

    //-----------------BORRAR TABLA-------------------------
    public void borrarTabla() {

        int indice = modelo.getRowCount() - 1;

        for (int i = indice; i >= 0; i--) {

            modelo.removeRow(i);

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JButton jBoton;
    private javax.swing.JComboBox<CuartelDeBomberos> jCSeleccionarCuarteles;
    private javax.swing.JTable jCuarteles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jSalir;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
