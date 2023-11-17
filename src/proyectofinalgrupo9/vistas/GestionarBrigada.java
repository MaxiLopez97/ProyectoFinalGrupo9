/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalgrupo9.vistas;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectofinalgrupo9.AccesoADATOS.BrigadaData;
import proyectofinalgrupo9.AccesoADATOS.CuartelData;
import proyectofinalgrupo9.AccesoADATOS.Especialidades;
import proyectofinalgrupo9.ClasesEntidades.Brigada;
import proyectofinalgrupo9.ClasesEntidades.CuartelDeBomberos;

/**
 *
 * @author Maxi
 */
public class GestionarBrigada extends javax.swing.JInternalFrame {

    private ArrayList<CuartelDeBomberos> cuartel;
    
    private ArrayList<Brigada> listaBrigadas;
    private BrigadaData brig= new BrigadaData();
    
    private CuartelData cuarteles = new CuartelData();
    
    private Brigada brigada= null;
    
    private DefaultTableModel modelo;
    
    public GestionarBrigada() {
        
        initComponents();
        
        modelo = new DefaultTableModel(){@Override
        
        public boolean isCellEditable(int f, int c){
        
            if(c == 0){
            
                return false;    
            }
            
            if(f == 4){
            
                return false;
            
            }
            
            return true;
        
        }};
        cuartel = (ArrayList<CuartelDeBomberos>) cuarteles.mostrarCuartelCBX();
        
        llenarEspecialidades();
        llenarCuartel();
        armarCabecera();
        llenarTabla();
        
        jCEspecialidades.setSelectedIndex(-1);
        jCSeleccionarCuartel1.setSelectedIndex(-1);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jTBuscarID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jBuscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jCEstado = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTBrigadas = new javax.swing.JTable();
        jCEspecialidades = new javax.swing.JComboBox<>();
        jBModificarBrigada = new javax.swing.JButton();
        jBBorrarBrigada = new javax.swing.JButton();
        jCSeleccionarCuartel1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jTNombreDeBrigada = new javax.swing.JTextField();
        jBGuardarBrigada1 = new javax.swing.JButton();
        jBSalirBrigadas = new javax.swing.JButton();

        setClosable(true);

        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jDesktopPane1.add(jTBuscarID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 210, -1));

        jLabel5.setText("Estado:");
        jDesktopPane1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 173, -1, -1));

        jLabel4.setText("Seleccione un cuartel:");
        jDesktopPane1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 133, -1, -1));

        jLabel3.setText("Especialidad:");
        jDesktopPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 89, 126, -1));

        jLabel2.setText("Nombre de Brigada:");
        jDesktopPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 46, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("INCORPORACIÓN DE BRIGADA");
        jDesktopPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 0, -1, -1));

        jBuscar.setText("Buscar");
        jBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 86, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("LISTA DE BRIGADAS");
        jDesktopPane1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, -1));

        jCEstado.setText("Activo");
        jDesktopPane1.add(jCEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 169, -1, -1));

        jTBrigadas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTBrigadas);

        jDesktopPane1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 480, 273));

        jDesktopPane1.add(jCEspecialidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 84, 255, -1));

        jBModificarBrigada.setText("Modificar");
        jBModificarBrigada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarBrigadaActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBModificarBrigada, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 86, -1));

        jBBorrarBrigada.setText("Eliminar");
        jBBorrarBrigada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBorrarBrigadaActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBBorrarBrigada, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 86, -1));

        jDesktopPane1.add(jCSeleccionarCuartel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 128, 255, -1));

        jLabel7.setText("ModificarPor ID");
        jDesktopPane1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 90, -1));
        jDesktopPane1.add(jTNombreDeBrigada, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 42, 255, -1));

        jBGuardarBrigada1.setText("Guardar");
        jBGuardarBrigada1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarBrigada1ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBGuardarBrigada1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 86, -1));

        jBSalirBrigadas.setText("Salir");
        jBSalirBrigadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBSalirBrigadasMouseClicked(evt);
            }
        });
        jBSalirBrigadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirBrigadasActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBSalirBrigadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 660, 93, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // ------------ SALIR ------------
    
    
    private void jBSalirBrigadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSalirBrigadasMouseClicked
        dispose();
    }//GEN-LAST:event_jBSalirBrigadasMouseClicked

    // ------------ BUSCAR ------------
    
    private void jBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarActionPerformed

        
        try{
            
            Integer id = Integer.parseInt(jTBuscarID.getText());
            
            brigada = brig.consultarBrigada(id);
            
            CuartelDeBomberos cuartel = new CuartelDeBomberos();
            
                        
            if(brigada != null){
            
                jTNombreDeBrigada.setText(brigada.getNombre_br());
                jCEspecialidades.setSelectedItem(brigada.getEspecialidad());
                jCSeleccionarCuartel1.setSelectedItem(brigada.getNombre_br());
                jCEstado.setSelected(brigada.isEstado());
                
            }

        }catch(NumberFormatException ex){
        
            JOptionPane.showMessageDialog(null, "Debe ingresar un ID válido");
        
        }

    }//GEN-LAST:event_jBuscarActionPerformed

    // ------------ LLENAR ESPECIALIDADES ------------
    
    private void llenarEspecialidades(){
        
        for(Especialidades especialidades : Especialidades.values()){
            
            jCEspecialidades.addItem(especialidades);
            
        }
        
    }
    
    // ------------ LLENAR CUARTELES ------------
    
    private void llenarCuartel(){
        
        for(CuartelDeBomberos c : cuartel){
        
            jCSeleccionarCuartel1.addItem(c);
        
        }    
    } 
    
    // ------------ SALIR ------------
    
    private void jBSalirBrigadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirBrigadasActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_jBSalirBrigadasActionPerformed


    // ------------ GUARDAR ------------
    
    private void jBGuardarBrigada1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarBrigada1ActionPerformed

        try{
            
        String nombre = jTNombreDeBrigada.getText();
        
        Especialidades especial = (Especialidades) jCEspecialidades.getSelectedItem();
        
        CuartelDeBomberos cuartel = (CuartelDeBomberos) jCSeleccionarCuartel1.getSelectedItem();
        
        Boolean estado = jCEstado.isSelected();
         
           if (nombre.isEmpty() || jCEspecialidades.getSelectedIndex() == -1 || jCSeleccionarCuartel1.getSelectedIndex() == -1 || estado == false) {

                JOptionPane.showMessageDialog(this, "No puede haber campos vacios");

                return;
            }
           
           if(brigada == null){
           
               brigada = new Brigada(nombre, especial, cuartel, estado);
               
               brig.guardarBrigada(brigada);
               
               limpiarCampos();
               borrarTabla();
               llenarTabla();  
           
           }
            
        }catch(NumberFormatException nfe){
        
            JOptionPane.showMessageDialog(null, "No puede haber campos vacíos");
            
        }


    }//GEN-LAST:event_jBGuardarBrigada1ActionPerformed

    // ------------ ELIMINAR ------------
    
    private void jBBorrarBrigadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorrarBrigadaActionPerformed
            
        try{
        
            int fila = jTBrigadas.getSelectedRow();
            int cont = jTBrigadas.getSelectedRowCount();
            
            if(cont == 1){
            
                int codBrigada = (int) modelo.getValueAt(fila, 0);
                brig.eliminarBrigada(codBrigada);
                
                borrarTabla();
                llenarTabla();
                
            }else{
            
                JOptionPane.showMessageDialog(null, "No seleccionó ninguna Brigada");
            
            }
            
        }catch(NullPointerException ex){
        
            JOptionPane.showMessageDialog(null, "No se puede eliminar la brigada");
        
        }

        
    }//GEN-LAST:event_jBBorrarBrigadaActionPerformed

    // ------------ MODIFICAR ------------
    
    private void jBModificarBrigadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarBrigadaActionPerformed

            String id = jTBuscarID.getText();
            String nombre = jTNombreDeBrigada.getText();
            Especialidades especial;
            especial = (Especialidades)jCEspecialidades.getSelectedItem();
            
            CuartelDeBomberos nro_cuartel = (CuartelDeBomberos) jCSeleccionarCuartel1.getSelectedItem();
            Boolean estado = (Boolean) jCEstado.isSelected();
            
            if(id.isEmpty() || nombre.isEmpty() || especial == null || nro_cuartel == null || estado == null){
            
                JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
            
            }else{
        
       try{

            int cod= Integer.parseInt(id);
            
            Brigada bl = new Brigada(cod, nombre, especial, nro_cuartel, estado);

           brig.modificarBrigada(bl);

           borrarTabla();
           llenarTabla();

       } catch (NullPointerException ex) {

            JOptionPane.showMessageDialog(null, "Error al modificar Brigada" + ex);

        }
      }
    }//GEN-LAST:event_jBModificarBrigadaActionPerformed

    // ------------ ARMAR CABECERA ------------
    
    private void armarCabecera(){
    
        ArrayList<Object> filaCabecera = new ArrayList<>();
        
        filaCabecera.add(" ID: ");
        filaCabecera.add(" Nombre: ");
        filaCabecera.add(" Especialidad: ");
        filaCabecera.add(" Cuartel: ");
        filaCabecera.add(" Estado: ");
        
        for(Object it : filaCabecera){
        
            modelo.addColumn(it);
        
        }
        
        jTBrigadas.setModel(modelo);
    
    }
 
    // ------------ LLENAR TABLA ------------
    
    private void llenarTabla(){
    
        List<Brigada> listab = (ArrayList) brig.listarBrigada();
        
        for(Brigada b : listab){
        
            modelo.addRow(new Object[]{b.getCodBrigada(), b.getNombre_br(), b.getEspecialidad(), b.getNro_cuartel().getNombre_cuartel(), b.isEstado()});
        
        }
    
    }
    
    // ------------ LIMPIAR CAMPOS ------------

        public void limpiarCampos() {
        
        jTNombreDeBrigada.setText("");
        
        jCEspecialidades.setSelectedIndex(-1);
        
        jCSeleccionarCuartel1.setSelectedIndex(-1);
        
        jCEstado.setSelected(false);

    }
    
    // ------------ BORRAR TABLA ------------
    
    public void borrarTabla(){
    
        int indice = modelo.getRowCount() - 1;

        for (int i = indice; i >= 0; i--) {
        
            modelo.removeRow(i);
            
        }
    }
  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBorrarBrigada;
    private javax.swing.JButton jBGuardarBrigada1;
    private javax.swing.JButton jBModificarBrigada;
    private javax.swing.JButton jBSalirBrigadas;
    private javax.swing.JButton jBuscar;
    private javax.swing.JComboBox<Especialidades> jCEspecialidades;
    private javax.swing.JCheckBox jCEstado;
    private javax.swing.JComboBox<CuartelDeBomberos> jCSeleccionarCuartel1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTBrigadas;
    private javax.swing.JTextField jTBuscarID;
    private javax.swing.JTextField jTNombreDeBrigada;
    // End of variables declaration//GEN-END:variables
}
