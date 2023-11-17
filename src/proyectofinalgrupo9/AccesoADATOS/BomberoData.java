package proyectofinalgrupo9.AccesoADATOS;

import java.sql.*;
import proyectofinalgrupo9.ClasesEntidades.Bombero;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyectofinalgrupo9.ClasesEntidades.Brigada;

public class BomberoData {
    
    private Connection con = null;

    public BomberoData() {
        
        con = Conexion.getConexion();
    }
    
//------------------------------------GUARDAR BOMBERO--------------------------------------------
    
    public void guardarBombero(Bombero bombero) {
        String sql = "INSERT INTO bombero (dni, nombre, apellido, fecha_nac, celular, codBrigada, estado)"
                + " VALUES (?, ?, ?, ?, ?, ? , ?)";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, bombero.getDni());
            ps.setString(2, bombero.getNombre());
            ps.setString(3, bombero.getApellido());
            ps.setDate(4, Date.valueOf(bombero.getFecha_nac()));
            ps.setString(5, bombero.getCelular());
            ps.setInt(6, bombero.getCodBrigada().getCodBrigada());
            ps.setBoolean(7, bombero.isEstado());
            
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
    
//------------------------------------MODIFICAR BOMBERO--------------------------------------------
    
    public void modificarBombero(Bombero bombero) {

        String sql = "UPDATE bombero SET  nombre=?, apellido=?, fecha_nac=?, celular=?, codBrigada=? "
                + " WHERE dni=? AND estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);



            ps.setString(1, bombero.getNombre());
            ps.setString(2, bombero.getApellido());
            ps.setDate(3, Date.valueOf(bombero.getFecha_nac()));
            ps.setString(4, bombero.getCelular());
            ps.setInt(5, bombero.getCodBrigada().getCodBrigada());
            ps.setString(6, bombero.getDni());

            int modificar = ps.executeUpdate();

            if (modificar == 1) {

                JOptionPane.showMessageDialog(null, "Bombero modificado");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero"+ex);
        }
    }
    
//------------------------------------DAR DE BAJA--------------------------------------------
    
    public void darBajaPorInactividad(String dni) {
        
        String sql = "UPDATE bombero SET estado=0 WHERE dni = ? ";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, dni);
            
            int eliminar = ps.executeUpdate();
            
            if (eliminar == 1) {
                JOptionPane.showMessageDialog(null, "Bombero dado de baja por inactividad");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
        }
    }

    public Bombero buscarBombero(int id_Bombero) {

        String sql = "SELECT dni, nombre, apellido, fecha_nac, celular, codBrigada FROM bombero "
                + " WHERE dni = ? AND estado = 1";

        Bombero bombero = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id_Bombero);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bombero = new Bombero();

                bombero.setId_Bombero(id_Bombero);
                bombero.setDni(rs.getString("dni"));
                bombero.setNombre(rs.getString("nombre"));
                bombero.setApellido(rs.getString("apellido"));
                bombero.setFecha_nac(rs.getDate("fecha_nac").toLocalDate());
                bombero.setCelular(rs.getString("celular"));

                Brigada brigada = new Brigada();
                brigada.setCodBrigada(rs.getInt("codBrigada"));
                bombero.setCodBrigada(brigada);
                bombero.setEstado(true);

            } else {

                JOptionPane.showMessageDialog(null, "No existe el bombero con ese ID");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
        }

        return bombero;
    }
    
    // -------- LISTAR BOMBEROS --------

    public List<Bombero> listarBomberos() {
        String sql = "SELECT id_Bombero, dni, nombre, apellido, fecha_nac, celular, codBrigada FROM bombero "
                + " WHERE estado = 1";
        
        ArrayList<Bombero> bomberos = new ArrayList<>();
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Bombero bombero = new Bombero();
                
                bombero.setId_Bombero(rs.getInt("id_Bombero"));
                bombero.setDni(rs.getString("dni"));
                bombero.setNombre(rs.getString("nombre"));
                bombero.setApellido(rs.getString("apellido"));
                bombero.setFecha_nac(rs.getDate("fecha_nac").toLocalDate());
                bombero.setCelular(rs.getString("celular"));
                Brigada brigada = new Brigada();
                brigada.setCodBrigada(rs.getInt("codBrigada"));
                bombero.setCodBrigada(brigada);
                bombero.setEstado(true);
                
                bomberos.add(bombero);
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
        }
        
        return bomberos;
    }
    
    
    
}
    
