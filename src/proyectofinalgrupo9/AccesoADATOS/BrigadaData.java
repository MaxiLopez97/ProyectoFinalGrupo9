package proyectofinalgrupo9.AccesoADATOS;

import java.sql.*;
import java.util.ArrayList;
import proyectofinalgrupo9.ClasesEntidades.Brigada;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectofinalgrupo9.ClasesEntidades.Bombero;
import proyectofinalgrupo9.ClasesEntidades.CuartelDeBomberos;

/**
 *
 * @author Maxi
 */
public class BrigadaData {

    private Connection con = null;
    private CuartelData cd= new CuartelData();

    public BrigadaData() {

        con = Conexion.getConexion();
    }

    public void guardarBrigada(Brigada brigada) {

        String sql = "INSERT INTO brigada (nombre_br, especialidad, nro_cuartel, disponible, estado)"
                + " VALUES (?, ?, ?, ?, ?)";

        try {
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, brigada.getNombre_br());
            ps.setObject(2, brigada.getEspecialidad().name());
            ps.setInt(3, brigada.getNro_cuartel().getCodCuartel());
            ps.setBoolean(4, brigada.isDisponible());
            ps.setBoolean(5, brigada.isEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                brigada.setCodBrigada(rs.getInt(1));

                JOptionPane.showMessageDialog(null, "Se agregó exitósamente la brigada");

            }

            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada" + ex.getMessage());

        }

    }

    public Brigada consultarBrigada(int id) {

        String sql = "SELECT nombre_br, especialidad, nro_cuartel, disponible, estado FROM brigada "
                + " WHERE codBrigada = ? AND disponible = 1 AND estado = 1";
        
        Brigada consultarBrigada = null;

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {

                consultarBrigada = new Brigada();

                consultarBrigada.setCodBrigada(id);
                consultarBrigada.setNombre_br(rs.getString("nombre_br"));
                consultarBrigada.setEspecialidad(Especialidades.valueOf(rs.getString("especialidad"))); 
                int codCuartel1=rs.getInt("nro_cuartel");
                CuartelDeBomberos cuartel= cd.cCuartel(codCuartel1);
                consultarBrigada.setNro_cuartel(cuartel);
                consultarBrigada.setDisponible(true);
                consultarBrigada.setEstado(true);

            } 
            
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");

        }
        return consultarBrigada;

    }
    
    public Brigada consultarTodasLasBrigadas(int id){
    
        String sql = "SELECT nombre_br, especialidad, nro_cuartel, disponible, estado FROM brigada "
                + " WHERE codBrigada = ?";
        
        Brigada consultarBrigada = null;

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {

                consultarBrigada = new Brigada();

                consultarBrigada.setCodBrigada(id);
                consultarBrigada.setNombre_br(rs.getString("nombre_br"));
                consultarBrigada.setEspecialidad(Especialidades.valueOf(rs.getString("especialidad"))); 
                int codCuartel1=rs.getInt("nro_cuartel");
                CuartelDeBomberos cuartel= cd.consultarCuartel(codCuartel1);
                consultarBrigada.setNro_cuartel(cuartel);
                consultarBrigada.setDisponible(rs.getBoolean("disponible"));
                consultarBrigada.setEstado(rs.getBoolean("estado"));

            } else {

                JOptionPane.showMessageDialog(null, "No existe el ID de la brigada ingresada.");

            }
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");

        }
        return consultarBrigada;
    
    }

    public List<Brigada> listarBrigada() {

        String sql = "SELECT codBrigada, nombre_br, especialidad, nro_cuartel, disponible FROM brigada "
                + " WHERE estado = 1";

        ArrayList<Brigada> brigada = new ArrayList<>();

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Brigada brigadas = new Brigada();

                brigadas.setCodBrigada(rs.getInt("codBrigada"));
                brigadas.setNombre_br(rs.getString("nombre_br"));
                
                String especialidadString = rs.getString("especialidad");
                Especialidades especialidad = Especialidades.valueOf(especialidadString);
                brigadas.setEspecialidad(especialidad);
                
                CuartelData cuartelD = new CuartelData();
                CuartelDeBomberos cuartel = cuartelD.cCuartel(rs.getInt("nro_cuartel"));
                
                brigadas.setNro_cuartel(cuartel);
                
                brigadas.setDisponible(rs.getBoolean("disponible"));
                brigadas.setEstado(true);
                
                brigada.add(brigadas);

            }
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada" + ex);

        }
        
        return brigada;

    }
    
    public List<Brigada> listarTodasLasBrigadas(){
    
        String sql = "SELECT codBrigada, nombre_br, especialidad, nro_cuartel, disponible, estado FROM brigada ";

        ArrayList<Brigada> brigada = new ArrayList<>();

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Brigada brigadas = new Brigada();

                brigadas.setCodBrigada(rs.getInt("codBrigada"));
                brigadas.setNombre_br(rs.getString("nombre_br"));
                
                String especialidadString = rs.getString("especialidad");
                Especialidades especialidad = Especialidades.valueOf(especialidadString);
                brigadas.setEspecialidad(especialidad);
                
                CuartelData cuartelD = new CuartelData();
                CuartelDeBomberos cuartel = cuartelD.cCuartel(rs.getInt("nro_cuartel"));
                
                brigadas.setNro_cuartel(cuartel);
                brigadas.setDisponible(rs.getBoolean("disponible"));
                brigadas.setEstado(rs.getBoolean("estado"));
                
                brigada.add(brigadas);
            }
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada" + ex);

        }
        
        return brigada;
    
    }
  
    public void eliminarBrigada(int codBrigada){
    
        String sql = "UPDATE brigada SET disponible = 0, estado = 0 WHERE codBrigada = ?";
        
        try{
        
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, codBrigada);
            
            int eliminar = ps.executeUpdate();
            
            if(eliminar == 1){
            
                JOptionPane.showMessageDialog(null, "Brigada eliminada");
            
            }
        
        } catch(SQLException ex){
        
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");
        
        }
    
    }
    
    public void brigadaOcupada(int codBrigada){
    
        String sql = "UPDATE brigada SET disponible = 0 WHERE codBrigada = ?";
        
        try{
        
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1,codBrigada);
            
            int ocupado = ps.executeUpdate();
            
            if(ocupado == 1){
            
                JOptionPane.showMessageDialog(null, "Brigada en camino al Siniestro");
            
            }
        
        }catch(SQLException ex){
        
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");
        
        }
    }
    
    public void brigadaDesocupada(int codBrigada){
    
        String sql = "UPDATE brigada set disponible = 1 WHERE codBrigada = ?";
        
        try{
        
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, codBrigada);
            
            int desocupado = ps.executeUpdate();
            
            if(desocupado == 1){
            
                JOptionPane.showMessageDialog(null, "Brigada desocupada");
            
            }
        
        }catch(SQLException ex){
        
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");
        
        }
    
    }
    
    public void modificarBrigada(Brigada brigada){
        
        String sql = "UPDATE brigada SET nombre_br = ?, especialidad = ?, nro_cuartel = ? "
                + "WHERE codBrigada = ?";
        
        try{
        
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, brigada.getNombre_br());
            ps.setString(2, brigada.getEspecialidad().name());
            ps.setInt(3, brigada.getNro_cuartel().getCodCuartel());
            ps.setInt(4, brigada.getCodBrigada());
            
            int modificar = ps.executeUpdate();
            
            if(modificar == 1){
                
                JOptionPane.showMessageDialog(null, "Brigada modificada");
                
            }
            
        }catch(SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Brigada" + ex);
            
        }
            
    }
    
    public List<Brigada> listarBrigadaXCuartel(CuartelDeBomberos cuartel) {

        String sql = "SELECT codBrigada, nombre_br, especialidad, disponible, estado FROM brigada"
                + " WHERE nro_cuartel=? ";

        ArrayList<Brigada> brigadas = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cuartel.getCodCuartel());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Brigada brig = new Brigada();

                brig.setCodBrigada(rs.getInt("codBrigada"));
                brig.setNombre_br(rs.getString("nombre_br"));

                String especialidadString = rs.getString("especialidad");
                Especialidades especialidad = Especialidades.valueOf(especialidadString);
                brig.setEspecialidad(especialidad);
                
                brig.setDisponible(rs.getBoolean("disponible"));
                brig.setEstado(rs.getBoolean("estado"));

                brig.setNro_cuartel(cuartel);

                brigadas.add(brig);
            }
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla brigada " + ex);
        }
        return brigadas;
    }
}
