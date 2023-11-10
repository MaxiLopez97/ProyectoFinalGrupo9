/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalgrupo9.AccesoADATOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Maxi
 */
public class Conexion {
    
    
    
    private static final String URL = "jdbc:mariadb://localhost/";
    
    private static final String DB = "bomberos";
    private static final String usuario = "root";
    private static final String password = "";
    private static Connection connection;
    
    private Conexion(){}
    
    public static Connection getConexion(){
    
        if(connection == null){
        
            try {
                
                Class.forName("org.mariadb.jdbc.Driver");
                
                connection = DriverManager.getConnection(URL + DB, usuario, password);
                
                JOptionPane.showMessageDialog(null, "Conectado");
                
            } catch (ClassNotFoundException ex) {
                
                JOptionPane.showMessageDialog(null, "Error en los Drivers" + ex);
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en conectarse a la SQL");
            }
        
        }
        
        return connection;
    
    }
    
}
