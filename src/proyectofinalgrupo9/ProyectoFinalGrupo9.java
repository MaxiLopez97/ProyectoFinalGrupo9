
package proyectofinalgrupo9;

import proyectofinalgrupo9.AccesoADATOS.Conexion;
import proyectofinalgrupo9.ClasesEntidades.Bombero;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import proyectofinalgrupo9.AccesoADATOS.BomberoData;
import proyectofinalgrupo9.AccesoADATOS.BrigadaData;
import proyectofinalgrupo9.AccesoADATOS.CuartelData;
import proyectofinalgrupo9.AccesoADATOS.Especialidades;
import static proyectofinalgrupo9.AccesoADATOS.Especialidades.INCENDIO;
import proyectofinalgrupo9.AccesoADATOS.SiniestrosData;
import proyectofinalgrupo9.ClasesEntidades.Brigada;
import proyectofinalgrupo9.ClasesEntidades.CuartelDeBomberos;
import proyectofinalgrupo9.ClasesEntidades.Siniestros;

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
       
       /*-----------------CUARTEL------------------------------*/
//       CuartelDeBomberos cuartel = new CuartelDeBomberos("Sureste", "Lafinur 471", 1532, 1745, "265712548", "sur@gmail.com", true );
////       
//       CuartelData cuartel1= new CuartelData();
//       cuartel1.guardarCuartel(cuartel);
       
       /*-----------------------------------------------*/
       
       /*-----------------BRIGADA------------------------------*/
       
//       CuartelData dataCuartel= new CuartelData();
//       CuartelDeBomberos cuartel2 = dataCuartel.consultarCuartel(2);
//       
//       Brigada brigada = new Brigada("Ala Norte", Especialidades.INCENDIO, cuartel2 ,true);
       BrigadaData brig= new BrigadaData();
//       
//       brig.guardarBrigada(brigada);
//       
//        System.out.println( brig.consultarBrigada(13) );
//        

        Brigada brigada = brig.consultarBrigada(13);
       Bombero jose = new Bombero("12345678", "Dario", "Menendez", LocalDate.of(1980, 4, 25), "35447686", brigada , true);
       
       BomberoData bombero = new BomberoData();
       bombero.guardarBombero(jose);
       
       
       
       
       SiniestrosData sin= new SiniestrosData();
       Siniestros bs= sin.consultarBrigadaID(13);
       
       Siniestros A = new Siniestros ("Incendio", LocalDate.of(2023, 11, 10), 1574,1234, "Localizado en barrio Juarez", LocalDate.of(2023, 11, 11), 7, bs.getCodBrigada(), true );
       
    }
  
    
}
