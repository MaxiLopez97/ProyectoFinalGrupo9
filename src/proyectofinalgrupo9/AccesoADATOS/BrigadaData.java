/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalgrupo9.AccesoADATOS;

import java.sql.*;
import proyectofinalgrupo9.ClasesEntidades.Brigada;
import java.util.List;
import javax.swing.JOptionPane;
import proyectofinalgrupo9.ClasesEntidades.CuartelDeBomberos;

/**
 *
 * @author Maxi
 */
public class BrigadaData {

    private Connection con = null;

    public BrigadaData() {

        con = Conexion.getConexion();
    }

    public void guardarBrigada(Brigada brigada) {
        String sql = "INSERT INTO brigada (nombre_br, especialidad, libre, nro_cuartel)"
                + " VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, brigada.getNombre_br());
            ps.setString(2, (Especialidades.valueOf(brigada.getEspecialidad().toString()))); //VERIFICAR
            ps.setBoolean(3, brigada.getLibre());
            ps.setInt(4, brigada.getNro_cuartel().getCodCuartel());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                brigada.setCodBrigada(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se agregó exitósamente la brigada");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");
        }

    }
    
    
    public Brigada consultarBrigada() {

        String sql = "SELECT nombre_br, especialidad, libre, nro_cuartel FROM brigada"
                + " WHERE codBrigada = ? ";

        Brigada consultarBrigada = null;

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, consultarBrigada.getCodBrigada());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                consultarBrigada = new Brigada();

                consultarBrigada.setCodBrigada(consultarBrigada.getCodBrigada());
                consultarBrigada.setNombre_br("nombre_br");
                consultarBrigada.setEspecialidad(Especialidades.valueOf(consultarBrigada.getEspecialidad().toString()));
                consultarBrigada.setLibre(Boolean.TRUE);
                consultarBrigada.setNro_cuartel(consultarBrigada.getNro_cuartel());
                
                
                
                

            } else {

                JOptionPane.showMessageDialog(null, "No existe el ID de la brigada ingresada.");

            }
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");

        }
        return consultarBrigada;

    }
    
    
    
     public Brigada brigadasLibres(Boolean libre) {

        String sql = "SELECT codBrigada, nombre_br, especialidad,  nro_cuartel FROM brigada"
                + " WHERE libre = 1 ";

      
        Brigada brigadasLibres = null;

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setBoolean(1, libre);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                brigadasLibres = new Brigada();

                brigadasLibres.setCodBrigada(0);
                brigadasLibres.setNombre_br(sql);
                brigadasLibres.setEspecialidad(brigadasLibres.getEspecialidad());
                brigadasLibres.setNro_cuartel(brigadasLibres.getNro_cuartel());              
                
            } else {

                JOptionPane.showMessageDialog(null, "No hay brigadas libres para atender el siniestro.");

            }
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");

        }
        return brigadasLibres;

    }
     
     public Brigada modificarEstado (Brigada brigada){
     
     String sql = "UPDATE brigada SET nombre_br, especialidad,  nro_cuartel FROM brigada"
                + " WHERE libre = 1 ";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setBoolean(1, brigada.getLibre());
            
            
            Boolean brigada = ps.executeUpdate();
            
            if(brigada == true){
            
                JOptionPane.showMessageDialog(null, "Brigada Liberada");
                
            }
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "");
       
        }
        
     
     
     
     }
    
    
    

}
