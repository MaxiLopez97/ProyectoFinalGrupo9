package proyectofinalgrupo9.AccesoADATOS;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectofinalgrupo9.ClasesEntidades.Brigada;
import proyectofinalgrupo9.ClasesEntidades.CuartelDeBomberos;
import proyectofinalgrupo9.ClasesEntidades.Siniestros;

public class SiniestrosData {

    private Connection con = null;
    private BrigadaData brig = new BrigadaData();
    private CuartelData cd= new CuartelData();      
    public SiniestrosData() {

        con = Conexion.getConexion();
        
    }

    //MODIFICAR LA FECHA DE RESOLUCION REGISTRAR SINIESTROS
    public void registrarSiniestros(Siniestros siniestro) {
        String sql = "INSERT INTO siniestro (tipo, fecha_siniestro, coord_X, coord_Y, detalles, codBrigada, estado)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, siniestro.getTipo());
            ps.setTimestamp(2, Timestamp.valueOf(siniestro.getFecha_siniestro()));
            ps.setInt(3, siniestro.getCoord_X());
            ps.setInt(4, siniestro.getCoord_Y());
            ps.setString(5, siniestro.getDetalles());
//            ps.setDate(6, Date.valueOf(siniestro.getFecha_resol()));
//            ps.setInt(7, siniestro.getPuntuacion());
            ps.setInt(6, siniestro.getCodBrigada().getCodBrigada());
            ps.setBoolean(7, siniestro.isEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                siniestro.setCodigo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Siniestro registrado exitosamente");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla siniestro" + ex);
        }
    }
    
    //Actualizar Estado
    
    public void resolverSiniestro (Siniestros siniestro){
    String sql= "UPDATE siniestro SET fecha_resol= ?, puntuacion=?, estado=? WHERE codigo=?";
    
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setDate(1, Date.valueOf(siniestro.getFecha_resol()));
            ps.setInt(2, siniestro.getPuntuacion());
            ps.setBoolean(3, siniestro.isEstado());
            ps.setInt(4, siniestro.getCodigo());
            
              int exito = ps.executeUpdate();
            
            if (exito == 1) {
                
                JOptionPane.showMessageDialog(null, "Siniestro resuelto");
            }
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al actualizar el estado del siniestro."+ex);
        }
    
    }
    
    // Asignar Brigada

    public void asignarBrigada(Siniestros siniestro) {
        try {
            // Obtener coordenadas del siniestro
            int coordX = siniestro.getCoord_X();
            int coordY = siniestro.getCoord_Y();
            String tipoEmergencia = siniestro.getTipo();

            // Consultar brigadas disponibles
            String sql = "SELECT codBrigada, especialidad, nro_cuartel, SQRT(POW(? - coord_X, 2) + POW(? - coord_Y, 2)) AS distancia "
                    + //Fórmula para calcular la distancia entre dos puntos
                    "FROM brigada "
                    + "WHERE estado = 1 "
                    + "ORDER BY distancia";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, coordX);
            ps.setInt(2, coordY);
            ResultSet rs = ps.executeQuery();

            // Evaluar brigadas disponibles y seleccionar la más cercana y adecuada
            int codBrigadaAsignada = -1;
            double distanciaMinima = Double.MAX_VALUE;

            while (rs.next()) {
                int codBrigada = rs.getInt("codBrigada");
                String especialidad = rs.getString("especialidad");

                // Verificar si la especialidad coincide
                if (tipoEmergencia.equals(especialidad)) {
                    codBrigadaAsignada = codBrigada;
                    break;
                }

                if (codBrigadaAsignada == -1) {
                    codBrigadaAsignada = codBrigada;
                    distanciaMinima = rs.getDouble("distancia");
                } else {
                    double distanciaActual = rs.getDouble("distancia");
                    if (distanciaActual < distanciaMinima) {
                        codBrigadaAsignada = codBrigada;
                        distanciaMinima = distanciaActual;
                    }
                }
            }

            // Asignar la brigada al siniestro
            if (codBrigadaAsignada != -1) {
                sql = "UPDATE siniestro SET codBrigada = ? WHERE codigo = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, codBrigadaAsignada);
                ps.setInt(2, siniestro.getCodigo());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Brigada asignada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró una brigada disponible para el siniestro.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al asignar brigada al siniestro.");
        }
    }
   
    
    public Siniestros buscarSiniestros(int codigo) {
        String sql = "SELECT * FROM siniestro WHERE codigo = ?";
        
        Siniestros siniestro = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                
                siniestro = new Siniestros();

                siniestro.setCodigo(codigo);
                siniestro.setTipo(rs.getString("tipo"));
                siniestro.setFecha_siniestro(rs.getTimestamp("fecha_siniestro").toLocalDateTime());
                siniestro.setCoord_X(rs.getInt("coord_X"));
                siniestro.setCoord_Y(rs.getInt("coord_Y"));
                siniestro.setDetalles(rs.getString("detalles"));
                siniestro.setFecha_resol(rs.getDate("fecha_resol").toLocalDate());
                siniestro.setPuntuacion(rs.getInt("puntuacion"));
                
                Brigada brigada = new Brigada();
                brigada.setCodBrigada(rs.getInt("codBrigada"));
                siniestro.setCodBrigada(brigada);
                siniestro.setEstado(true);

            } else {
                
                JOptionPane.showMessageDialog(null, "No se encontró el siniestro con ese código");
            
            }

            ps.close();
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla siniestro" + ex);
            
        }

        return siniestro;
    }
    //--------------------LISTAR SINIESTROS----------------------------------------------

    public List<Siniestros> listarSiniestrosResueltos() {
        
        String sql = "SELECT * FROM siniestro WHERE estado = 0";

        List<Siniestros> siniestros = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Siniestros siniestro = new Siniestros();

                siniestro.setCodigo(rs.getInt("codigo"));
                siniestro.setTipo(rs.getString("tipo"));
                siniestro.setFecha_siniestro(rs.getTimestamp("fecha_siniestro").toLocalDateTime());
                siniestro.setCoord_X(rs.getInt("coord_X"));
                siniestro.setCoord_Y(rs.getInt("coord_Y"));
                siniestro.setDetalles(rs.getString("detalles"));
                siniestro.setFecha_resol(rs.getDate("fecha_resol").toLocalDate());
                siniestro.setPuntuacion(rs.getInt("puntuacion"));
                
                BrigadaData brigadaD = new BrigadaData();
                
                Brigada brig = brigadaD.consultarBrigada(rs.getInt("codBrigada"));
                
                siniestro.setCodBrigada(brig);
                
                siniestro.setEstado(true);
                
                siniestros.add(siniestro);
            }

            ps.close();
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla siniestro");
            
        }

        return siniestros;
    }
    
    public List<Siniestros> listarSiniestros() {
        
        String sql = "SELECT codigo, tipo, fecha_siniestro, coord_X, coord_Y, detalles, codBrigada FROM siniestro WHERE estado = 1 ";

        List<Siniestros> siniestros = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Siniestros siniestro = new Siniestros();

                siniestro.setCodigo(rs.getInt("codigo"));
                siniestro.setTipo(rs.getString("tipo"));
                siniestro.setFecha_siniestro(rs.getTimestamp("fecha_siniestro").toLocalDateTime());
                siniestro.setCoord_X(rs.getInt("coord_X"));
                siniestro.setCoord_Y(rs.getInt("coord_Y"));
                siniestro.setDetalles(rs.getString("detalles"));
                
                int codBrigada = rs.getInt("codBrigada");
                Brigada brigada = brig.consultarBrigada(codBrigada);
                siniestro.setCodBrigada(brigada);
                
                siniestro.setEstado(true);
                
                siniestros.add(siniestro);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla siniestro " + ex);
        }

        return siniestros;
    }
    
    public List<Siniestros> listarTodosLosSiniestros(){
    
        String sql = "SELECT codigo, tipo, fecha_siniestro, coord_X, coord_Y, detalles, codBrigada, estado FROM siniestro ";

        List<Siniestros> siniestros = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Siniestros siniestro = new Siniestros();

                siniestro.setCodigo(rs.getInt("codigo"));
                siniestro.setTipo(rs.getString("tipo"));
                siniestro.setFecha_siniestro(rs.getTimestamp("fecha_siniestro").toLocalDateTime());
                siniestro.setCoord_X(rs.getInt("coord_X"));
                siniestro.setCoord_Y(rs.getInt("coord_Y"));
                siniestro.setDetalles(rs.getString("detalles"));
                
                int codBrigada = rs.getInt("codBrigada");
                Brigada brigada = brig.consultarTodasLasBrigadas(codBrigada);
                siniestro.setCodBrigada(brigada);
                
                siniestro.setEstado(rs.getBoolean("estado"));
                
                siniestros.add(siniestro);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla siniestro " + ex);
        }

        return siniestros;
    
    }
    
    public void modificarSiniestro(Siniestros siniestro){
        
        String sql = "UPDATE siniestro SET tipo = ?, fecha_siniestro = ?, coord_X = ?, coord_Y = ?, detalles = ?, codBrigada = ? "
                + " WHERE codigo = ? AND estado = 1";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            
            ps.setString(1, siniestro.getTipo());
            ps.setTimestamp(2, Timestamp.valueOf(siniestro.getFecha_siniestro()));
            ps.setInt(3, siniestro.getCoord_X());
            ps.setInt(4, siniestro.getCoord_Y());
            ps.setString(5, siniestro.getDetalles());
            ps.setInt(6, siniestro.getCodBrigada().getCodBrigada());
            ps.setInt(7, siniestro.getCodigo());
            
            int modificar = ps.executeUpdate();
            
            if(modificar == 1){
                
                JOptionPane.showMessageDialog(null, "Siniestro Modificado");
                
            }   
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Siniestro");
        }
        
    }
    
    public void eliminarSiniestro(int codigo){
        
        String sql = "UPDATE siniestro SET estado = 0 WHERE codigo = ?";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, codigo);
            
            int eliminar = ps.executeUpdate();
            
            if(eliminar == 1){
                
                JOptionPane.showMessageDialog(null, "Siniestro eliminado");
                
            }
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Siniestro");
            
        }
        
    }
    
   }