/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalgrupo9.AccesoADATOS;

import java.sql.*;
import proyectofinalgrupo9.ClasesEntidades.Bombero;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author NAHUEL
 */
public class BomberoData {
    
    private Connection con = null;

    public BomberoData() {
        
        con = Conexion.getConexion();
    }

    public void guardarBombero(Bombero bombero) {
        String sql = "INSERT INTO bombero (dni, nombre_ape, fecha_nac, celular, codBrigada)"
                + " VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, bombero.getDni());
            ps.setString(2, bombero.getNombre_ape());
            ps.setDate(3, Date.valueOf(bombero.getFecha_nac()));
            ps.setString(4, bombero.getCelular());
            ps.setInt(5, bombero.getCodBrigada());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                bombero.setId_Bombero(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se agregó exitósamente al bombero");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
        }
    }

    public void modificarBombero(Bombero bombero) {
        String sql = "UPDATE bombero SET dni = ?, nombre_ape = ?, fecha_nac = ?, celular = ?, codBrigada = ?"
                + " WHERE id_Bombero = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, bombero.getDni());
            ps.setString(2, bombero.getNombre_ape());
            ps.setDate(3, Date.valueOf(bombero.getFecha_nac()));
            ps.setString(4, bombero.getCelular());
            ps.setInt(5, bombero.getCodBrigada());
            ps.setInt(6, bombero.getId_Bombero());
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Bombero modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
        }
    }

    public void darBajaPorInactividad(int id_Bombero) {
        String sql = "DELETE FROM bombero WHERE id_Bombero = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id_Bombero);
            
            int eliminar = ps.executeUpdate();
            
            if (eliminar == 1) {
                JOptionPane.showMessageDialog(null, "Bombero dado de baja por inactividad");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
        }
    }

    public Bombero buscarBombero(int id_Bombero) {
        String sql = "SELECT dni, nombre_ape, fecha_nac, celular, codBrigada FROM bombero "
                + " WHERE id_Bombero = ?";
        
        Bombero bombero = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id_Bombero);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                bombero = new Bombero();
                
                bombero.setId_Bombero(id_Bombero);
                bombero.setDni(rs.getString("dni"));
                bombero.setNombre_ape(rs.getString("nombre_ape"));
                bombero.setFecha_nac(rs.getDate("fecha_nac").toLocalDate());
                bombero.setCelular(rs.getString("celular"));
                bombero.setCodBrigada(rs.getInt("codBrigada"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el bombero con ese ID");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
        }
        
        return bombero;
    }

    public List<Bombero> listarBomberos() {
        String sql = "SELECT id_Bombero, dni, nombre_ape, fecha_nac, celular, codBrigada FROM bombero";
        
        ArrayList<Bombero> bomberos = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Bombero bombero = new Bombero();
                
                bombero.setId_Bombero(rs.getInt("id_Bombero"));
                bombero.setDni(rs.getString("dni"));
                bombero.setNombre_ape(rs.getString("nombre_ape"));
                bombero.setFecha_nac(rs.getDate("fecha_nac").toLocalDate());
                bombero.setCelular(rs.getString("celular"));
                bombero.setCodBrigada(rs.getInt("codBrigada"));
                
                bomberos.add(bombero);
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
        }
        
        return bomberos;
    }
    
}
