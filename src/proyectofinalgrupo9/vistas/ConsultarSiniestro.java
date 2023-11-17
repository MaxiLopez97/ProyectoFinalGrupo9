/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalgrupo9.vistas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import proyectofinalgrupo9.AccesoADATOS.SiniestrosData;
import proyectofinalgrupo9.ClasesEntidades.Siniestros;

public class ConsultarSiniestro extends javax.swing.JInternalFrame {
    
    private ArrayList<Siniestros> siniestros;
    private SiniestrosData siniestroD = new SiniestrosData();
    private DefaultTableModel modelo;
    private Siniestros sin = null;

    public ConsultarSiniestro() {
        
        initComponents();
        
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int f, int c) {
                
                if (c == 0) {
                    
                    return false;
                }
                
                if (f == 1){
                
                    return false;
                
                }
                
                if (f == 2){
                
                    return false;
                
                }
                
                if (f == 3){
                
                    return false;
                
                }
                
                if (f == 4){
                
                    return false;
                
                }
                
                if (f == 5){
                
                    return false;
                
                }
                
                if (f == 6){
                
                    return false;
                
                }

                if (c == 7) {

                    return false;
                }
                return true;
            }
        };
        
        siniestros = (ArrayList<Siniestros>) siniestroD.listarSiniestros();
        
        armarCabecera();
        llenarTabla();
  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jSiniestros = new javax.swing.JTable();
        jSalir = new javax.swing.JButton();

        setClosable(true);

        escritorio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("SINIESTROS OCURRIDOS ENTRE AYER Y HOY");
        escritorio.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        jSiniestros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jSiniestros);

        escritorio.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1290, 560));

        jSalir.setText("Salir");
        jSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalirActionPerformed(evt);
            }
        });
        escritorio.add(jSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 650, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1358, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalirActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_jSalirActionPerformed
    
    private void armarCabecera(){
    
        ArrayList<Object> filacabecera = new ArrayList<>();
        
        filacabecera.add(" CODIGO: ");
        filacabecera.add(" TIPO: ");
        filacabecera.add(" FECHA: ");
        filacabecera.add(" COORDENADA X: ");
        filacabecera.add(" COORDENADA Y: ");
        filacabecera.add(" DETALLES: ");
        filacabecera.add(" BRIGADA: ");
        filacabecera.add(" ESTADO: ");
        
        for(Object it : filacabecera){
        
            modelo.addColumn(it);
        
        }
        
        jSiniestros.setModel(modelo);
        
    }
    
    private void llenarTabla(){
    
        List<Siniestros> listas = siniestroD.listarTodosLosSiniestros();
        
        LocalDate fechaActual = LocalDate.now();
        
        LocalDate fechaAyer = fechaActual.minusDays(1);
        
        for(Siniestros s : listas){
            
            LocalDate fecha = s.getFecha_siniestro().toLocalDate();
            
            if(fechaActual.isEqual(fecha) || fechaAyer.isEqual(fecha)){
            
                modelo.addRow(new Object[] {s.getCodigo(), s.getTipo(), s.getFecha_siniestro(), s.getCoord_X(), s.getCoord_Y(), s.getDetalles(), s.getCodBrigada().getCodBrigada(), s.isEstado()});
            
            }
        
        }
        
        
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jSiniestros;
    // End of variables declaration//GEN-END:variables
}
