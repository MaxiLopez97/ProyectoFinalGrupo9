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

/**
 *
 * @author NAHUEL
 */
public class SiniestrosData {

    private Connection con = null;
    private CuartelData cd= new CuartelData();      
    public SiniestrosData() {

        con = Conexion.getConexion();
        
    }

    //MODIFICAR LA FECHA DE RESOLUCION REGISTRAR SINIESTROS
    public void registrarSiniestros(Siniestros siniestro) {
        String sql = "INSERT INTO siniestro (tipo, fecha_siniestro, coord_X, coord_Y, detalles, fecha_resol, puntuacion, codBrigada, estado)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, siniestro.getTipo());
            ps.setTimestamp(2, Timestamp.valueOf(siniestro.getFecha_siniestro()));
            ps.setInt(3, siniestro.getCoord_X());
            ps.setInt(4, siniestro.getCoord_Y());
            ps.setString(5, siniestro.getDetalles());
            ps.setDate(6, Date.valueOf(siniestro.getFecha_resol()));
            ps.setInt(7, siniestro.getPuntuacion());
            ps.setInt(8, siniestro.getCodBrigada().getCodBrigada());
            ps.setBoolean(9, siniestro.isEstado());

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

    public void resolverSiniestros(Siniestros siniestro, LocalDate fechaResolucion, int puntuacion) {
        try {
            if (siniestro.getCodBrigada() != null) {
                // Actualizar el registro del siniestro con fecha de resolución y puntuación
                String sql = "UPDATE siniestro SET fecha_resol = ?, puntuacion = ? WHERE codigo = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setDate(1, Date.valueOf(fechaResolucion));
                ps.setInt(2, puntuacion);
                ps.setInt(3, siniestro.getCodigo());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Siniestro resuelto exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se puede resolver un siniestro sin asignar una brigada.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al resolver el siniestro.");
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
    //--------------------LISTAR SINIESTROS-----------------------------------------------

    public List<Siniestros> listarSiniestros() {
        String sql = "SELECT * FROM siniestro";

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
                siniestros.add(siniestro);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla siniestro");
        }

        return siniestros;
    }
    
    public void modificarSiniestro(Siniestros siniestro){
        
        String sql = "UPDATE siniestro SET tipo = ?, fecha_siniestro = ?, coord_X = ?, coord_Y = ?, detalles = ?, fecha_resol = ?, puntuacion = ?, codBrigada = ? "
                + "WHERE codigo = ? AND estado = 1";
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, siniestro.getTipo());
            ps.setTimestamp(2, Timestamp.valueOf(siniestro.getFecha_siniestro()));
            ps.setInt(3, siniestro.getCoord_X());
            ps.setInt(4, siniestro.getCoord_Y());
            ps.setString(5, siniestro.getDetalles());
            ps.setDate(6, Date.valueOf(siniestro.getFecha_resol()));
            ps.setInt(7, siniestro.getPuntuacion());
            ps.setInt(8, siniestro.getCodBrigada().getCodBrigada());
            ps.setBoolean(9, siniestro.isEstado());
            ps.setInt(10, siniestro.getCodigo());
            
            int modificar = ps.executeUpdate();
            
            if(modificar == 1){
                
                JOptionPane.showMessageDialog(null, "Siniestro Modificado");
                
            }   
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Siniestro");
        }
        
    }

    
    //--------------------------------BUSCAR BRIGADA POR CODIGO-----------------------------------
    
//    public List<Brigada> buscarBrigadaPorCodigo(int codBrigada) {
//        String sql = "SELECT* FROM brigada WHERE codBrigada =?";
//        List<Brigada> brigadas = new ArrayList<>();
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, codBrigada);
//            ResultSet rs = ps.executeQuery();
//
//            String especialidadString = rs.getString("especialidad");
//            Especialidades especialidad = Especialidades.valueOf(especialidadString);
//
//            String numeroCuartel = rs.getString("nro_cuartel");
//
//            CuartelData cuartelD = new CuartelData();
//
//            while (rs.next()) {
//
//                Brigada brigada = new Brigada();
//
//                brigada.setCodBrigada(rs.getInt("codBrigada"));
//                brigada.setNombre_br("nombre_br");
//                brigada.setEspecialidad(especialidad);
//                
//                CuartelDeBomberos cuartel = cuartelD.consultarCuartel(rs.getInt("nro_cuartel"));
//                brigada.setNro_cuartel(cuartel);
//                brigada.setEstado(true);
//
//            }
//
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Brigada" + ex);
//        }
//
//        return brigadas;
//    }
    //Eliminé buscar brigada por código porque estaba mal
    
    
    public Siniestros consultarBrigadaID(int id){
    
        String sql = "SELECT codBrigada, nombre_br, especialidad, nro_cuartel, estado FROM brigada"
                + " WHERE codBrigada = ? AND estado = 1";
        
        Brigada consultarBrigadaID = null;

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {

                consultarBrigadaID = new Brigada();

                consultarBrigadaID.setCodBrigada(id);
                consultarBrigadaID.setNombre_br(rs.getString("nombre_br"));
                consultarBrigadaID.setEspecialidad(Especialidades.valueOf(rs.getString("especialidad"))); 
                int codCuartel1=rs.getInt("nro_cuartel");
                CuartelDeBomberos cuartel= cd.consultarCuartel(codCuartel1);
                consultarBrigadaID.setNro_cuartel(cuartel);
                consultarBrigadaID.setEstado(true);

            } else {

                JOptionPane.showMessageDialog(null, "No existe el ID de la brigada ingresada.");

            }
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada"+ ex);

        }
        return null;
    }
    
    public void eliminarSiniestro(int codigo){
        
        String sql = "DELETE FROM siniestro WHERE codigo = ?";
        
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