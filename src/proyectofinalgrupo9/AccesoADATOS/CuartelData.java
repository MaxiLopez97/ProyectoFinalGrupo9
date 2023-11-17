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
                + " WHERE codCuartel = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, cuartel.getNombre_cuartel());
            ps.setString(2, cuartel.getDireccion());
            ps.setInt(3, cuartel.getCoord_X());
            ps.setInt(4, cuartel.getCoord_Y());
            ps.setString(5, cuartel.getTelefono());
            ps.setString(6, cuartel.getCorreo());
            ps.setInt(7, cuartel.getCodCuartel());

            int modificar = ps.executeUpdate();

            if (modificar == 1) {
                JOptionPane.showMessageDialog(null, "Cuartel modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cuartel");
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
                mostrarCuartel.setNombre_cuartel(rs.getString("nombre_cuartel"));
                mostrarCuartel.setDireccion(rs.getString("direccion"));
                mostrarCuartel.setCoord_X(rs.getInt("coord_X"));
                mostrarCuartel.setCoord_Y(rs.getInt("coord_Y"));
                mostrarCuartel.setTelefono(rs.getString("telefono"));
                mostrarCuartel.setCorreo(rs.getString("correo"));
                mostrarCuartel.setEstado(true);

            } 
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cuartel");

        }
        return mostrarCuartel;

    }
    
    public CuartelDeBomberos cCuartel(int codCuartel){
    
        String sql = "SELECT nombre_cuartel, direccion, coord_X, coord_Y, telefono, correo, estado FROM cuartel"
                + " WHERE codCuartel = ?";

        CuartelDeBomberos mostrarCuartel = null;

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, codCuartel);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                mostrarCuartel = new CuartelDeBomberos();

                mostrarCuartel.setCodCuartel(codCuartel);
                mostrarCuartel.setNombre_cuartel(rs.getString("nombre_cuartel"));
                mostrarCuartel.setDireccion(rs.getString("direccion"));
                mostrarCuartel.setCoord_X(rs.getInt("coord_X"));
                mostrarCuartel.setCoord_Y(rs.getInt("coord_Y"));
                mostrarCuartel.setTelefono(rs.getString("telefono"));
                mostrarCuartel.setCorreo(rs.getString("correo"));
                mostrarCuartel.setEstado(true);

            } 
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cuartel");

        }
        return mostrarCuartel;
    
    }
    
    public void eliminarCuartel(int codCuartel){
    
        String sql = "UPDATE cuartel SET estado=0 WHERE codCuartel=?";
        
        try{
        
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, codCuartel);
            
            int eliminar = ps.executeUpdate();
            
            if(eliminar == 1){
                
                JOptionPane.showMessageDialog(null, "Cuartel eliminado");
                
            }
        
        } catch(SQLException ex){
        
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cuartel"+ex);
        
        }
    
    }

    //MÉTODO MOSTRAR CUARTEL CERCA DE SINIESTRO O INCIDENTE
    
    //FALTA MOSTRAR LAS BRIGADAS DE CADA CUARTEL
   
    public List<CuartelDeBomberos> listarCuarteles(){
        
        String sql =  "SELECT * FROM cuartel WHERE estado=1";
        
        List<CuartelDeBomberos> cuarteles = new ArrayList();
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            
                CuartelDeBomberos cuartel = new CuartelDeBomberos();
                
                cuartel.setCodCuartel(rs.getInt("codCuartel"));
                cuartel.setNombre_cuartel(rs.getString("nombre_cuartel"));
                cuartel.setDireccion(rs.getString("direccion"));
                cuartel.setCoord_X(rs.getInt("coord_X"));
                cuartel.setCoord_Y(rs.getInt("coord_Y"));
                cuartel.setTelefono(rs.getString("telefono"));
                cuartel.setCorreo(rs.getString("correo"));
                cuartel.setEstado(true);
               
                cuarteles.add(cuartel);
            
            }
            
            ps.close();
            
        }catch(SQLException ex){
        
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cuartel");
        
        }
        
        return cuarteles;
        
    }
    
    public List<CuartelDeBomberos> mostrarCuartelCBX(){
    
        String sql = "SELECT codCuartel, nombre_cuartel, estado FROM cuartel";
        
        List<CuartelDeBomberos> cuarteles = new ArrayList();
        
        try{
        
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            
                CuartelDeBomberos cuartel = new CuartelDeBomberos();
                
                cuartel.setCodCuartel(rs.getInt("codCuartel"));
                cuartel.setNombre_cuartel(rs.getString("nombre_cuartel"));
                cuartel.setEstado(true);
                
                cuarteles.add(cuartel);
            
            }
            
            ps.close();
        
        }catch(SQLException ex){
        
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cuartel");
            
        }
        
        return cuarteles;
    
    }  
    
}