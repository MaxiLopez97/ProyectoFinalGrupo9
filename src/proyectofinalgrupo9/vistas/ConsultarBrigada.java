package proyectofinalgrupo9.vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectofinalgrupo9.AccesoADATOS.BomberoData;
import proyectofinalgrupo9.AccesoADATOS.BrigadaData;
import proyectofinalgrupo9.ClasesEntidades.Bombero;
import proyectofinalgrupo9.ClasesEntidades.Brigada;

public class ConsultarBrigada extends javax.swing.JInternalFrame {
    
    private ArrayList<Brigada> brigada;
    private BomberoData bomberoD = new BomberoData();
    private BrigadaData brigadaD = new BrigadaData();
    private DefaultTableModel modelo;
    private Bombero bomb = null;

    public ConsultarBrigada() {

        initComponents();
        
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int f, int c) {
                if (c == 0) {
                    return false;
                }
                
                if(f == 1){
                
                    return false;
                
                }
                
                if(f == 2){
                
                    return false;
                
                }
                
                if(f == 3){
                
                    return false;
                    
                }

                if (c == 4) {

                    return false;
                }
                return true;
            }
        };
        
        brigada = (ArrayList<Brigada>) brigadaD.listarBrigada();
        
        llenarBrigada();
        armarCabecera();
        llenarTabla();
        
        jCSeleccionarBrigadas.setSelectedIndex(-1);
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCSeleccionarBrigadas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jBomberos = new javax.swing.JTable();
        jSalir = new javax.swing.JButton();
        jBuscar = new javax.swing.JButton();

        setClosable(true);

        escritorio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("CONSULTAR BOMBEROS EN BRIGADAS");
        escritorio.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        jLabel2.setText("Seleccionar Brigada :");
        escritorio.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        escritorio.add(jCSeleccionarBrigadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 380, -1));

        jBomberos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jBomberos);

        escritorio.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 720, -1));

        jSalir.setText("Salir");
        jSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalirActionPerformed(evt);
            }
        });
        escritorio.add(jSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 610, -1, -1));

        jBuscar.setText("Buscar");
        jBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarActionPerformed(evt);
            }
        });
        escritorio.add(jBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarActionPerformed
       
        try{
            
            int selec = jCSeleccionarBrigadas.getSelectedIndex();
            
            if(selec > -1){
            
                Brigada brigada = (Brigada) jCSeleccionarBrigadas.getSelectedItem();
                
                List<Bombero> listab = (ArrayList) bomberoD.listarBomberosPorBrigada(brigada);
                
                DefaultTableModel modeloTabla = (DefaultTableModel) jBomberos.getModel();
                modeloTabla.setRowCount(0);
                
                for(Bombero b : listab){
                
                    Object[] fila = {b.getId_Bombero(), b.getDni(), b.getNombre(), b.getApellido(), b.getCodBrigada().getCodBrigada()};
                    modelo.addRow(fila);
                
                }
            }else{
            
                JOptionPane.showMessageDialog(null, "Seleccione una Brigada por favor");
            
            }
        
        }catch(NumberFormatException ex){
        
            JOptionPane.showMessageDialog(null, "Debe ingresar un ID válido");
        
        }
        
    }//GEN-LAST:event_jBuscarActionPerformed

    private void jSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalirActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_jSalirActionPerformed

    private void llenarBrigada(){
    
        for(Brigada b : brigada){
        
            jCSeleccionarBrigadas.addItem(b);
        
        }
    
    }
    
    private void armarCabecera(){
    
        ArrayList<Object> filaCabecera = new ArrayList<>();
        
        filaCabecera.add(" ID: ");
        filaCabecera.add(" DNI: ");
        filaCabecera.add(" Nombre: ");
        filaCabecera.add(" Apellido: ");
        filaCabecera.add(" Brigada: ");
        
        for(Object it : filaCabecera){
        
            modelo.addColumn(it);
        
        }
        
        jBomberos.setModel(modelo);
    
    }
    
    private void llenarTabla(){
    
        List<Bombero> listab = (ArrayList) bomberoD.listarBomberos();
        
        for(Bombero b : listab){
        
            modelo.addRow(new Object[] {b.getId_Bombero(), b.getDni(), b.getNombre(), b.getApellido(), b.getCodBrigada().getCodBrigada()});
        
        }
    
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JTable jBomberos;
    private javax.swing.JButton jBuscar;
    private javax.swing.JComboBox<Brigada> jCSeleccionarBrigadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jSalir;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
