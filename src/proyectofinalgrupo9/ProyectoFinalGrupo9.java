
package proyectofinalgrupo9;

import proyectofinalgrupo9.AccesoADATOS.Conexion;
import proyectofinalgrupo9.ClasesEntidades.Bombero;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import proyectofinalgrupo9.AccesoADATOS.BomberoData;


public class ProyectoFinalGrupo9 {

   
    public static void main(String[] args) {
     
        /*----------------Conexion----------------------*/
       Connection con= Conexion.getConexion();
     
       /*-----------------------------------------------*/
       
       //Bombero jose = new Bombero("12345678","Luna jose", LocalDate.of(1980, 4, 25), "35447686", 0);
       
       //BomberoData bombero = new BomberoData();
       //bombero.guardarBombero(jose);
       
    }
  
    
}
