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

    public BrigadaData() {

        con = Conexion.getConexion();
    }

    public void guardarBrigada(Brigada brigada) {

        String sql = "INSERT INTO brigada (nombre_br, especialidad, nro_cuartel, estado)"
                + " VALUES (?, ?, ?, ?)";

        
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, brigada.getNombre_br());
            ps.setString(2, brigada.getEspecialidad().name()); 
            ps.setBoolean(3, brigada.isEstado());
            ps.setInt(4, brigada.getNro_cuartel().getCodCuartel());
            ps.setBoolean(5, brigada.isEstado());

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

        String sql = "SELECT nombre_br, especialidad, nro_cuartel, estado FROM brigada"
                + " WHERE codBrigada = ? AND estado = 1";

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
                consultarBrigada.setNro_cuartel(consultarBrigada.getNro_cuartel());
                consultarBrigada.isEstado();

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
                + " WHERE estado = 1 ";

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

    public List<Brigada> listarBrigada() {

        String sql = "SELECT codBrigada, nombre_br, especialidad, nro_cuartel FROM brigada"
                + "WHERE estado = 1";

        ArrayList<Brigada> brigada = new ArrayList();

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            String especialidadString = rs.getString("especialidad");
            Especialidades especialidad = Especialidades.valueOf(especialidadString);

            String numeroCuartel = rs.getString("nro_cuartel");

            CuartelData cuartelD = new CuartelData();

            while (rs.next()) {

                Brigada brigadas = new Brigada();

                brigadas.setCodBrigada(rs.getInt("codBrigada"));
                brigadas.setNombre_br(rs.getString("nombre_br"));
                brigadas.setEspecialidad(especialidad);

                CuartelDeBomberos cuartel = cuartelD.consultarCuartel(rs.getInt("nro_cuartel"));
                brigadas.setNro_cuartel(cuartel);

            }
            ps.close();

        } catch (SQLException ex) {

            Logger.getLogger(BrigadaData.class.getName()).log(Level.SEVERE, null, ex);

        }
        return brigada;

    }

    public List<Bombero> asignarBomberoABrigada() {

        ArrayList<Bombero> Bombero = new ArrayList<>();

        String sql = "SELECT brigada.codBrigada, dni, nombre, apellido FROM brigada, bombero"
                + "WHERE brigada.codBrigada = bombero.codBrigada"
                + "AND brigada.nombre_br = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
           

            ResultSet rs = ps.executeQuery();
            int contadorBomberos = 0;

            while (rs.next()) {

                if (contadorBomberos <=5) {
                    
                    Bombero bombero = new Bombero();
                    bombero.setNombre(rs.getString("nombre"));
                    bombero.setApellido(rs.getString("apellido"));
                    bombero.setDni(rs.getString("dni"));
                    bombero.setCelular(rs.getString("celular"));

                    Bombero.add(bombero);
                    contadorBomberos++;

                } else {
                    JOptionPane.showMessageDialog(null, "La brigada esta llena.");
                }
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Brigada");
        }

        return Bombero;
    }

    
    
    
}
