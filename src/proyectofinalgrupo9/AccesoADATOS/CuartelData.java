/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalgrupo9.AccesoADATOS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyectofinalgrupo9.ClasesEntidades.CuartelDeBomberos;

/**
 *
 * @author Maxi
 */
public class CuartelData {

    private Connection con = null;

    public CuartelData() {

        con = Conexion.getConexion();
    }

    public void guardarCuartel(CuartelDeBomberos cuartel) {
        String sql = "INSERT INTO cuartel (nombre_cuartel, direccion, coord_X, coord_Y, telefono, correo, estado)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, cuartel.getNombre_cuartel());
            ps.setString(2, cuartel.getDireccion());
            ps.setInt(3, cuartel.getCoord_X());
            ps.setInt(4, cuartel.getCoord_Y());
            ps.setString(5, cuartel.getTelefono());
            ps.setString(6, cuartel.getCorreo());
            ps.setBoolean(7, cuartel.isEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                cuartel.setCodCuartel(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se agregó exitósamente el cuartel");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cuartel");
        }

    }

    public void modificarCuartel(CuartelDeBomberos cuartel) {
        String sql = "UPDATE cuartel SET nombre_cuartel = ?, direccion = ?, coord_X = ?, coord_Y = ?, telefono = ?, correo = ?"
                + " WHERE codCuartel = ? and estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, cuartel.getNombre_cuartel());
            ps.setString(2, cuartel.getDireccion());
            ps.setInt(3, cuartel.getCoord_X());
            ps.setInt(4, cuartel.getCoord_Y());
            ps.setString(5, cuartel.getTelefono());
            ps.setString(6, cuartel.getCorreo());
            ps.setBoolean(7, cuartel.isEstado());

            int modificar = ps.executeUpdate();

            if (modificar == 1) {
                JOptionPane.showMessageDialog(null, "Cuartel modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
        }
    }

    
    
    public CuartelDeBomberos consultarCuartel(int codCuartel) {

        String sql = "SELECT nombre_cuartel, direccion, coord_X, coord_Y, telefono, correo FROM cuartel"
                + " WHERE codCuartel = ? AND estado = 1";

        CuartelDeBomberos mostrarCuartel = null;

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, codCuartel);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                mostrarCuartel = new CuartelDeBomberos();

                mostrarCuartel.setCodCuartel(codCuartel);
                mostrarCuartel.setNombre_cuartel("nombre_cuartel");
                mostrarCuartel.setDireccion("direccion");
                mostrarCuartel.setCoord_X(rs.getInt("coord_X"));
                mostrarCuartel.setCoord_Y(rs.getInt("coord_Y"));
                mostrarCuartel.setTelefono("telefono");
                mostrarCuartel.setCorreo("correo");
                mostrarCuartel.setEstado(true);

            } else {

                JOptionPane.showMessageDialog(null, "No existe el ID del cuartel ingresado.");

            }
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cuartel");

        }
        return mostrarCuartel;

    }

    //MÉTODO MOSTRAR CUARTEL CERCA DE SINIESTRO O INCIDENTE
    
    //FALTA MOSTRAR LAS BRIGADAS DE CADA CUARTEL
   
    
    
    
    
    
    
}
