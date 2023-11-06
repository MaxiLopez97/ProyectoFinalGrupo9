
package proyectofinalgrupo9;

import proyectofinalgrupo9.AccesoADATOS.Conexion;
import proyectofinalgrupo9.ClasesEntidades.Bombero;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import proyectofinalgrupo9.AccesoADATOS.BomberoData;

//Comportamientos. Se necesita:
//
//➢	Listar las brigadas que se encuentran libres, o asignadas a un incidente o siniestro. -- LISTO

//➢	Medir la distancia entre dos pares de coordenadas, y devolver la cantidad de metros entre ellas 
//     (usar la fórmula matemática de distancia entre dos puntos) -- LISTO

//➢	Mostrar los cuarteles de bomberos cerca de un punto de siniestro o incidente. -- HACER

//➢	Mostrar todos los incidentes o siniestros que han ocurrido entre ayer y hoy -- LISTO

//➢	Se necesita consultar:
//o	Todos los bomberos de una misma brigada -- LISTO
//o	Todas las brigadas que existen en ese cuartel -- LISTO

//➢	Marcar un incidente como resuelto, colocando la fecha de resolución, y su calificación 1 a 10, 
//      en la medida de éxito obtenido.



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
