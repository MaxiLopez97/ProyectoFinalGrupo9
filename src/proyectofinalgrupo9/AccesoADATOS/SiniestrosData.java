/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    public SiniestrosData() {

        con = Conexion.getConexion();

    }

    //MODIFICAR LA FECHA DE RESOLUCION REGISTRAR SINIESTROS
    public void registrarSiniestros(Siniestros siniestro) {
        String sql = "INSERT INTO siniestro (codigo, tipo, fecha_siniestro, coord_X, coord_Y, detalles, fecha_resol, puntuacion, codBrigada, estado)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, siniestro.getCodigo());
            ps.setString(2, siniestro.getTipo());
            ps.setDate(3, Date.valueOf(siniestro.getFecha_siniestro()));
            ps.setInt(4, siniestro.getCoord_X());
            ps.setInt(5, siniestro.getCoord_Y());
            ps.setString(6, siniestro.getDetalles());
            ps.setDate(7, Date.valueOf(siniestro.getFecha_resol()));
            ps.setInt(8, siniestro.getPuntuacion());
            ps.setInt(9, siniestro.getCodBrigada().getCodBrigada());
            ps.setBoolean(10, siniestro.isEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                siniestro.setCodigo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Siniestro registrado exitosamente");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla siniestro");
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

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Siniestros siniestro = new Siniestros();

                siniestro.setCodigo(rs.getInt("codigo"));
                siniestro.setTipo(rs.getString("tipo"));
                siniestro.setFecha_siniestro(rs.getDate("fecha_siniestro").toLocalDate());
                siniestro.setCoord_X(rs.getInt("coord_X"));
                siniestro.setCoord_Y(rs.getInt("coord_Y"));
                siniestro.setDetalles(rs.getString("detalles"));
                siniestro.setFecha_resol(rs.getDate("fecha_resol").toLocalDate());
                siniestro.setPuntuacion(rs.getInt("puntuacion"));
                // Puedes cargar la brigada asociada al siniestro si es necesario
//                siniestro.setCodBrigada(buscarBrigadaPorCodigo(rs.getInt("codBrigada")));

                return siniestro;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el siniestro con ese código");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla siniestro");
        }

        return null;
    }

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
                siniestro.setFecha_siniestro(rs.getDate("fecha_siniestro").toLocalDate());
                siniestro.setCoord_X(rs.getInt("coord_X"));
                siniestro.setCoord_Y(rs.getInt("coord_Y"));
                siniestro.setDetalles(rs.getString("detalles"));
                siniestro.setFecha_resol(rs.getDate("fecha_resol").toLocalDate());
                siniestro.setPuntuacion(rs.getInt("puntuacion"));
                // Puedes cargar la brigada asociada al siniestro si es necesario
                /*siniestro.setCodBrigada(buscarBrigadaPorCodigo(rs.getInt(codBrigada)));
                siniestro.setCodBrigada(buscarBrigadaPorCodigo(rs.getInt("codBrigada")));
*/
                siniestros.add(siniestro);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla siniestro");
        }

        return siniestros;
    }

    public List<Brigada> buscarBrigadaPorCodigo(int codBrigada) {
        String sql = "SELECT* FROM brigada WHERE codBrigada =?";
        List<Brigada> brigadas = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codBrigada);
            ResultSet rs = ps.executeQuery();

            String especialidadString = rs.getString("especialidad");
            Especialidades especialidad = Especialidades.valueOf(especialidadString);

            String numeroCuartel = rs.getString("nro_cuartel");

            CuartelData cuartelD = new CuartelData();

            while (rs.next()) {

                Brigada brigada = new Brigada();

                brigada.setCodBrigada(rs.getInt("codBrigada"));
                brigada.setNombre_br("nombre_br");
                brigada.setEspecialidad(especialidad);
                CuartelDeBomberos cuartel = cuartelD.consultarCuartel(rs.getInt("nro_cuartel"));
                brigada.setNro_cuartel(cuartel);
                brigada.setEstado(true);

            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Brigada");
        }

        return brigadas;
    }
    //Eliminé buscar brigada por código porque estaba mal
}
