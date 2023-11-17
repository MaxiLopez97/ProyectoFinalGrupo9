package proyectofinalgrupo9.vistas;

import java.awt.Point;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectofinalgrupo9.AccesoADATOS.BrigadaData;
import proyectofinalgrupo9.AccesoADATOS.CuartelData;
import proyectofinalgrupo9.AccesoADATOS.SiniestrosData;
import proyectofinalgrupo9.ClasesEntidades.Brigada;
import proyectofinalgrupo9.ClasesEntidades.CuartelDeBomberos;
import proyectofinalgrupo9.ClasesEntidades.Siniestros;

public class GestionarSiniestros extends javax.swing.JInternalFrame {

    private CuartelData cuartel = new CuartelData();
    private CuartelData cuartel1;
    private CuartelDeBomberos cuartelActual = null;
    private List<CuartelDeBomberos> lista;
    private Siniestros siniestro = null;
    private Brigada brigada = null;
    private SiniestrosData sin = new SiniestrosData();
    private BrigadaData brig = new BrigadaData();
    private DefaultTableModel modelo;
    
    
    public GestionarSiniestros() {
        
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
        
        llenarBrigada();
        llenarSiniestros();
        llenarRegistroS();
        cabecera();
        cargarTabla();
        
        jCAsignarBrigada.setSelectedIndex(-1);
        jCSeleccionarSiniestro.setSelectedIndex(-1);
        jCSiniestros.setSelectedIndex(-1);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField6 = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jTTipoDeSiniestro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTCoord_X = new javax.swing.JTextField();
        jTCoord_Y = new javax.swing.JTextField();
        jBGuardar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jCRealizado = new javax.swing.JCheckBox();
        jBBuscar = new javax.swing.JButton();
        jBBorrar = new javax.swing.JButton();
        jCAsignarBrigada = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jBSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jCSeleccionarSiniestro = new javax.swing.JComboBox<>();
        jDFecha = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jbGuardarSiniestroResuelto = new javax.swing.JButton();
        jCSiniestros = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jDFresolucionS = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jSPuntaje = new javax.swing.JSpinner();
        jCEstadoSiniestro1 = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jtCodigoSiniestro = new javax.swing.JTextField();
        jBuscarr = new javax.swing.JButton();
        jModificar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTID = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTCuartelCercano = new javax.swing.JTable();
        jBValidar = new javax.swing.JButton();

        setClosable(true);

        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 204));
        jLabel1.setText("REGISTRAR UN SINIESTRO");
        jDesktopPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, -1, -1));
        jDesktopPane1.add(jTTipoDeSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 260, -1));

        jLabel2.setText("Seleccionar Siniestro:");
        jDesktopPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel3.setText("Tipo de Siniestro:");
        jDesktopPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel4.setText("Fecha del Siniestro:");
        jDesktopPane1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel5.setText("Coordenadas X:");
        jDesktopPane1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel6.setText("Coordenadas Y:");
        jDesktopPane1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel7.setText("Detalles:");
        jDesktopPane1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));
        jDesktopPane1.add(jTCoord_X, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 260, -1));
        jDesktopPane1.add(jTCoord_Y, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 260, -1));

        jBGuardar.setText("Guardar");
        jBGuardar.setEnabled(false);
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, -1, -1));

        jLabel12.setText("Estado:");
        jDesktopPane1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, -1));
        jDesktopPane1.add(jCRealizado, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 660, -1, -1));

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, 40));

        jBBorrar.setText("Borrar");
        jBBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBorrarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, -1, -1));

        jDesktopPane1.add(jCAsignarBrigada, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 340, -1));

        jLabel14.setText("Brigada:");
        jDesktopPane1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 450, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jDesktopPane1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 260, -1));

        jDesktopPane1.add(jCSeleccionarSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 260, -1));
        jDesktopPane1.add(jDFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 176, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 255, 204));
        jLabel8.setText("REGISTRAR SINIESTROS RESUELTOS");
        jDesktopPane1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, -1, -1));

        jbGuardarSiniestroResuelto.setText("Guardar");
        jbGuardarSiniestroResuelto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarSiniestroResueltoActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jbGuardarSiniestroResuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 740, -1, -1));

        jDesktopPane1.add(jCSiniestros, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, 310, -1));

        jLabel9.setText("Seleccionar Siniestro");
        jDesktopPane1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        jLabel10.setText("Fecha  de Resolución del Siniestro");
        jDesktopPane1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 670, -1, -1));
        jDesktopPane1.add(jDFresolucionS, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 700, 190, -1));

        jLabel11.setText("Puntuación");
        jDesktopPane1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 620, -1, -1));
        jDesktopPane1.add(jSPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 620, 50, -1));

        jCEstadoSiniestro1.setText("Activo");
        jDesktopPane1.add(jCEstadoSiniestro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, -1, -1));

        jLabel15.setText("Realizado");
        jDesktopPane1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 660, -1, -1));

        jLabel16.setText("Codigo del siniestro");
        jDesktopPane1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, -1, -1));
        jDesktopPane1.add(jtCodigoSiniestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 620, 60, -1));

        jBuscarr.setText("Buscar");
        jBuscarr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarrActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBuscarr, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 540, -1, 40));

        jModificar.setText("Modificar");
        jModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModificarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, -1, -1));

        jLabel13.setText("ID");
        jDesktopPane1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 120, 20, 30));
        jDesktopPane1.add(jTID, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 40, 30));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 255, 204));
        jLabel17.setText("CUARTELES MÁS CERCANOS");
        jDesktopPane1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, -1, -1));

        jTCuartelCercano.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTCuartelCercano);

        jDesktopPane1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 630, -1));

        jBValidar.setText("Validar ");
        jBValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBValidarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jBValidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1258, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // -------- GUARDAR --------
    
    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        
        try{
            
            String tipo = jTTipoDeSiniestro.getText();
            
            java.util.Date fecha_nacimiento = jDFecha.getDate();

            Instant instant = fecha_nacimiento.toInstant();
            LocalDateTime fecha_nac = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fecha_nacString = fecha_nac.format(formatter);
            
            LocalDateTime fecha_nacim = LocalDateTime.parse(fecha_nacString, formatter);
            
            Integer coord_X = Integer.parseInt(jTCoord_X.getText());
            Integer coord_Y = Integer.parseInt(jTCoord_Y.getText());
            
            String detalles = jTextArea1.getText();
            
            Brigada brigada = (Brigada)jCAsignarBrigada.getSelectedItem();
            
            Boolean estado = jCEstadoSiniestro1.isSelected();
            
            if(tipo.isEmpty() || fecha_nacim == null || coord_X == null || coord_Y == null || detalles.isEmpty() || jCAsignarBrigada.getSelectedIndex() == -1 || estado == false){
                
                JOptionPane.showMessageDialog(null, "No puede haber campos vacíos");
                return;
                
            }
            
            if(siniestro == null){
            
                siniestro = new Siniestros(tipo, fecha_nacim, coord_X, coord_Y, detalles, brigada, estado);
                
                sin.registrarSiniestros(siniestro);
                
                jCSeleccionarSiniestro.addItem(siniestro);
                
                jCSiniestros.addItem(siniestro);
                
                limpiarCampos();
                
                siniestro = null;
            
            }
        
        }catch(NumberFormatException nfe){
        
            JOptionPane.showMessageDialog(null, "No puede haber campos vacíos");
        
        }
        
    }//GEN-LAST:event_jBGuardarActionPerformed

    // ------------ SALIR ------------ 
    
    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_jBSalirActionPerformed

    // ------------ BORRAR ------------ 
    
    private void jBBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorrarActionPerformed
        
        try{
        
            int selec = jCSeleccionarSiniestro.getSelectedIndex();
            
            if(selec != -1 ){
                
                Siniestros siniestro = (Siniestros) jCSeleccionarSiniestro.getSelectedItem();
                
                int codigo = siniestro.getCodigo();
                
                sin.eliminarSiniestro(codigo);
                
                actualizarCombo();

            }else{

                JOptionPane.showMessageDialog(null, "No seleccionó ningun Siniestro");
            
            }
        
        }catch(NullPointerException ex){
        
            JOptionPane.showMessageDialog(null, "No se puede eliminar el Siniestro " + ex);
            
        }
        
    }//GEN-LAST:event_jBBorrarActionPerformed

    // ------------ BUSCAR ------------ 
    
    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        
        try{
            
            int indice = jCSeleccionarSiniestro.getSelectedIndex();
            
            if(indice > -1){
            
                Siniestros siniestros = (Siniestros) jCSeleccionarSiniestro.getSelectedItem();
                
                jTTipoDeSiniestro.setText(siniestros.getTipo());

                Date fecha = Date.from(siniestros.getFecha_siniestro().atZone(ZoneId.systemDefault()).toInstant());

                jDFecha.setDate(fecha);

                jTCoord_X.setText(String.valueOf(siniestros.getCoord_X()));
                jTCoord_Y.setText(String.valueOf(siniestros.getCoord_Y()));

                jTextArea1.setText(siniestros.getDetalles());
                
                jTID.setText(String.valueOf(siniestros.getCodigo()));
                
                jCEstadoSiniestro1.setSelected(siniestros.isEstado());
                
                siniestro = null;
                
            }else{
            
                JOptionPane.showMessageDialog(null, "Seleccione un Siniestro por favor");
            
            }

        }catch(NullPointerException ex){
        
            JOptionPane.showMessageDialog(null, "El siniestro no existe" + ex);
        
        }
        
    }//GEN-LAST:event_jBBuscarActionPerformed

    // ------------ BUSCAR ------------ 
    
    private void jBuscarrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarrActionPerformed
        
        try{
            
            int indice = jCSiniestros.getSelectedIndex();
            
            if(indice > -1){
            
                Siniestros siniestro = (Siniestros) jCSiniestros.getSelectedItem();
            
                jtCodigoSiniestro.setText(String.valueOf(siniestro.getCodigo())); 
            
            }else{
            
                JOptionPane.showMessageDialog(null, "Seleccione un siniestro por favor");
            
            }
            
        }catch(NullPointerException ex){
        
            JOptionPane.showMessageDialog(null, "Seleccione un Siniestro");
        
        }
        
    }//GEN-LAST:event_jBuscarrActionPerformed

    // ------------ GUARDAR SINIESTRO RESUELTO ------------ 
    
    private void jbGuardarSiniestroResueltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarSiniestroResueltoActionPerformed
        
        try{
            
            Integer codigo = Integer.parseInt(jtCodigoSiniestro.getText());
            
            java.util.Date fecha_nacimiento = jDFresolucionS.getDate();
            LocalDate fecha_nac = fecha_nacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            
            int puntaje = (int) jSPuntaje.getValue();
            boolean realizado = jCRealizado.isSelected();
            
            if(codigo == 0 || jDFresolucionS == null || puntaje == 0 || realizado == false){
            
                JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
                return;
            
            }
            
            if(puntaje < 1){
            
                JOptionPane.showMessageDialog(null, "Ingrese un numero mayor a 0");
                return;
            
            }
            
            if(puntaje > 10){
            
                JOptionPane.showMessageDialog(null, "Ingrese un número menor o igual a 10");
                
                return;
                
            }
            
            if(siniestro == null){
            
                siniestro = new Siniestros(codigo, fecha_nac, puntaje, false);
                
                sin.eliminarSiniestro(codigo);
                
                sin.resolverSiniestro(siniestro);
                
                limpiarCamposRegistrados();
                
                actualizarComboResuelto();
                
                siniestro = null;
            
            }
            
        }catch (NullPointerException ex) {
            
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos");
            
        }
        
    }//GEN-LAST:event_jbGuardarSiniestroResueltoActionPerformed

    // ------------ MODIFICAR ------------
    
    private void jModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModificarActionPerformed
    
        try{
        
            String tipo = jTTipoDeSiniestro.getText();
            
            java.util.Date fecha = jDFecha.getDate();
            Instant instant = fecha.toInstant();
            LocalDateTime fecha_a = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
            DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechh = fecha_a.format(form);
            LocalDateTime fecha_nacim = LocalDateTime.parse(fechh, form);
            
            int codigo = Integer.parseInt(jTID.getText());
            
            Integer coord_X = Integer.parseInt(jTCoord_X.getText());
            Integer coord_Y = Integer.parseInt(jTCoord_Y.getText());
            
            String detalles = jTextArea1.getText();
            
            Brigada brigada = (Brigada) jCAsignarBrigada.getSelectedItem();
            
            Boolean estado = jCEstadoSiniestro1.isSelected();
            
            if(tipo.isEmpty() || fecha_nacim == null || coord_X == null || coord_Y == null || detalles.isEmpty() || jCAsignarBrigada.getSelectedIndex() == -1 || estado == false){
            
                JOptionPane.showMessageDialog(null, "No puede haber campos vacíos");
                
                return;
            }
            
            if(siniestro == null){
            
                siniestro = new Siniestros(codigo, tipo, fecha_nacim, coord_X, coord_Y, detalles, brigada, estado);
                
                sin.modificarSiniestro(siniestro);
                
                limpiarCampos();
                
                siniestro = null;
            
            }
        
        }catch(NullPointerException ex){
        
            JOptionPane.showMessageDialog(null, "El siniestro no existe");
        
        }
        
        
    }//GEN-LAST:event_jModificarActionPerformed

    private void jBValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBValidarActionPerformed
        
        if (modelo.getColumnCount() != 8) {
            modelo.setColumnCount(8);
        }

        ArrayList<CuartelDeBomberos> cuarteles = (ArrayList<CuartelDeBomberos>) cuartel.listarCuarteles();

        Double[] distancias = new Double[cuarteles.size()];

        ArrayList<CuartelDeBomberos> cuartelesCercanos = new ArrayList<>();

        int coordX1 = Integer.parseInt(jTCoord_X.getText());
        int coordY1 = Integer.parseInt(jTCoord_Y.getText());

        for(int i = 0; i < cuarteles.size() + cuartelesCercanos.size(); i++){

            double menor = Double.MAX_VALUE;

            CuartelDeBomberos cuartelCercano = null;

            for(CuartelDeBomberos c : cuarteles){

                int coordX2 = c.getCoord_X();
                int coordY2 = c.getCoord_Y();

                double resultado = Math.sqrt(Math.pow(coordX2 - coordX1, 2) + Math.pow(coordY2 - coordY1, 2));

                if(resultado < menor){
                    distancias[i] = resultado;
                    menor = resultado;
                    cuartelCercano = c;
                }
            }

            cuartelesCercanos.add(cuartelCercano);

            cuarteles.remove(cuartelCercano);

        }

        modelo.setRowCount(0);
        modelo.addColumn("Distancia");
        int i = 0;
        for(CuartelDeBomberos c : cuartelesCercanos){

            modelo.addRow(new Object[]{c.getCodCuartel(), c.getNombre_cuartel(), c.getDireccion(), c.getCoord_X(), c.getCoord_Y(), c.getTelefono(), c.getCorreo(), true, Math.round(distancias[i])});
            i++;
        }

        jBGuardar.setEnabled(true);
        
    }//GEN-LAST:event_jBValidarActionPerformed
 
    // ------------ LIMPIAR CAMPOS ------------
    
    public void limpiarCampos() {
        
        jTID.setText("");
        jTTipoDeSiniestro.setText("");
        jDFecha.setDate(null);
        jTCoord_X.setText("");
        jTCoord_Y.setText("");
        jTextArea1.setText("");
        jCAsignarBrigada.setSelectedIndex(-1);
        jCEstadoSiniestro1.setSelected(false);
        jCSeleccionarSiniestro.setSelectedIndex(-1);
        
    }
    
    // ------------  LIMPIAR CAMPOS REGISTRADOS ------------ 
    
    public void limpiarCamposRegistrados(){
        
        jCSiniestros.setSelectedIndex(-1);
        jtCodigoSiniestro.setText("");
        jDFresolucionS.setDate(null);
        jSPuntaje.setValue(0);
        jCRealizado.setSelected(false);
    
    }
    
    // ------------ LLENAR BRIGADA ------------
    
    private void llenarBrigada(){
        
        
        ArrayList<Brigada> listaBrigadas = (ArrayList<Brigada>) brig.listarBrigada();
    
        for(Brigada b : listaBrigadas){
        
            jCAsignarBrigada.addItem(b);
        
        }
    
    }

    // ------------  LLENAR SINIESTROS ------------ 
    
    private void llenarSiniestros(){
        
        ArrayList<Siniestros> listaSiniestro = (ArrayList<Siniestros>) sin.listarSiniestros();
    
        for(Siniestros s : listaSiniestro){
        
            jCSeleccionarSiniestro.addItem(s);
            
        }
    
    }
    
    // ------------ LLENAR SINIESTROS REGISTRADOS ------------ 
    
    private void llenarRegistroS(){
    
        ArrayList<Siniestros> listaSiniestro = (ArrayList<Siniestros>) sin.listarSiniestros();
        
        for(Siniestros s : listaSiniestro){
        
            jCSiniestros.addItem(s);
        
        }
    
    }
    
    // ------------  ACTUALIZAR COMBOBOX ------------ 
    
    private void actualizarCombo(){
    
        jCSeleccionarSiniestro.removeAllItems();
        
        llenarSiniestros();
    
    }
    
    // ------------  ACTUALIZAR COMOBOX RESUELTO ------------ 
    
    private void actualizarComboResuelto(){
    
        jCSiniestros.removeAllItems();
        
        llenarRegistroS();
    
    }
    
    // ------------ LIMPIAR TABLA ------------
    
    private void limpiarTabla() {

        modelo.setRowCount(0);
    }
    
    private void cabecera() {

        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add(" ID:");
        filaCabecera.add(" Nombre: ");
        filaCabecera.add(" Direccion: ");
        filaCabecera.add(" Coordenada X: ");
        filaCabecera.add(" Coordenada Y: ");
        filaCabecera.add(" Telefono: ");
        filaCabecera.add(" Correo: ");
        filaCabecera.add(" Estado: ");

        for (Object it : filaCabecera) {

            modelo.addColumn(it);

        }
        jTCuartelCercano.setModel(modelo);

    }
    
    // ------------ CARGAR TABLA ------------
    
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBorrar;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JButton jBValidar;
    private javax.swing.JButton jBuscarr;
    private javax.swing.JComboBox<Brigada> jCAsignarBrigada;
    private javax.swing.JCheckBox jCEstadoSiniestro1;
    private javax.swing.JCheckBox jCRealizado;
    private javax.swing.JComboBox<Siniestros> jCSeleccionarSiniestro;
    private javax.swing.JComboBox<Siniestros> jCSiniestros;
    private com.toedter.calendar.JDateChooser jDFecha;
    private com.toedter.calendar.JDateChooser jDFresolucionS;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jModificar;
    private javax.swing.JSpinner jSPuntaje;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTCoord_X;
    private javax.swing.JTextField jTCoord_Y;
    private javax.swing.JTable jTCuartelCercano;
    private javax.swing.JTextField jTID;
    private javax.swing.JTextField jTTipoDeSiniestro;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JButton jbGuardarSiniestroResuelto;
    private javax.swing.JTextField jtCodigoSiniestro;
    // End of variables declaration//GEN-END:variables
}
