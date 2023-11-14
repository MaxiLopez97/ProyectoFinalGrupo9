package proyectofinalgrupo9;

import proyectofinalgrupo9.AccesoADATOS.Conexion;
import proyectofinalgrupo9.ClasesEntidades.Bombero;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        Connection con = Conexion.getConexion();

        /*-----------------------------------------------*/
//       ------------ AGREGAR CUARTEL ------------
//       CuartelDeBomberos cuartel = new CuartelDeBomberos("Sureste", "Lafinur 471", 1532, 1745, "265712548", "sur@gmail.com", true );
////       
//       CuartelData cuartel1= new CuartelData();
//       cuartel1.guardarCuartel(cuartel);
//       ------------ AGREGAR BRIGADA ------------
//       BrigadaData brig= new BrigadaData();
//       Brigada brigada = brig.consultarBrigada(1);
//     
//       CuartelData dataCuartel= new CuartelData();
//       CuartelDeBomberos cuartel2 = dataCuartel.consultarCuartel(1);
//
//       Brigada brigada = new Brigada("Forza", Especialidades.DERRUMBES, cuartel2 ,true);
//
//       brig.guardarBrigada(brigada);
//       System.out.println( brig.consultarBrigada(13) );
        // --------------  AGREGAR BOMBERO ---------------
//        BrigadaData brig= new BrigadaData();
//        Brigada brigada = brig.consultarBrigada(14);
//        
//        Bombero jose = new Bombero("12345622", "Bautista", "Altamirano", LocalDate.of(2000, 1, 20), "12121212", brigada , true);
//     
//        BomberoData bombero = new BomberoData();
//        
////       bombero.guardarBombero(jose);
//
//         bombero.modificarBombero(jose);
        // -------------- AGREGAR SINIESTRO -------------
//       BrigadaData brig= new BrigadaData();
//       Brigada brigada = brig.consultarBrigada(13);
//       
//       SiniestrosData sin= new SiniestrosData();
//       
//       Siniestros as = new Siniestros ("Inundaciones", LocalDateTime.of(2023, Month.APRIL, 10, 12, 30, 13), 1090, 1224, "Av. Sol", LocalDate.of(2023, 5, 2), 10, brigada, true);
//       
//       sin.registrarSiniestros(as);
        // ------------ MODIFICAR BOMBERO ------------
//        BrigadaData brig = new BrigadaData();
//        
//        Brigada brigada = brig.consultarBrigada(13);
//        
//        Bombero bauti = new Bombero(1, "39212122", "Maxi", "López", LocalDate.of(1999, Month.AUGUST, 17), "31232132", brigada, true);
//        
//        BomberoData bomberito = new BomberoData();
//        
//        bomberito.modificarBombero(bauti);
        // ------------ DAR DE BAJA BOMBERO ------------
//        BomberoData bombero = new BomberoData();
//        
//        bombero.darBajaPorInactividad(7);
        // ------------ BUSCAR BOMBERO ------------ 
//        BomberoData bombero = new BomberoData();
//        
//        System.out.println(bombero.buscarBombero(1));
        // ------------ LISTAR BOMBEROS ------------ 
//        BomberoData bomb = new BomberoData();
//        
//        System.out.println("------------ Listar Bomberos ------------");
//        
//        for(Bombero bombero:bomb.listarBomberos()){
//            
//            System.out.println(" ");
//            System.out.println("DNI: " + bombero.getDni());
//            System.out.println("Nombre: " + bombero.getNombre());
//            System.out.println("Apellido: " + bombero.getApellido());
//            System.out.println("Fecha de Nacimiento: " + bombero.getFecha_nac());
//            System.out.println("Numero de Celular: " + bombero.getCelular());
//            System.out.println("Código de Brigada: " + bombero.getCodBrigada().getCodBrigada());
//            
//        }
        // ------------ MODIFICAR CUARTEL ------------
//          CuartelData cuartelData = new CuartelData();
//          
//          CuartelDeBomberos cuartel = new CuartelDeBomberos(1, "Osyris", "Av. Norte 232", 332, 1762, "12320123", "Osyris@gmail.com", true);
//          
//          cuartelData.modificarCuartel(cuartel);
        // ------------ CONSULTAR CUARTEL ------------
//          CuartelData cuartelData = new CuartelData();
//          
//          System.out.println(cuartelData.consultarCuartel(1));
        // ------------ CONSULTAR BRIGADA ------------ 
//          BrigadaData brigadaData = new BrigadaData();
//          
//          System.out.println(brigadaData.consultarBrigada(13));
        // ------------ BRIGADAS LIBRES ------------
        // FALTA HACERLE LA LISTA
        // ------------ LISTAR BRIGADAS ------------  
//        BrigadaData brigadaD = new BrigadaData();
//        
//        System.out.println("------------ Lista de Brigadas ------------");
//        
//        for(Brigada brigada:brigadaD.listarBrigada()){
//            
//               System.out.println(" ");
//               System.out.println("Nombre de la Brigada: " + brigada.getNombre_br());
//               System.out.println("Especialidad: " + brigada.getEspecialidad());
//               System.out.println(brigada.getNro_cuartel());
//            
//        }
        // ------------ ASIGNAR BOMBERO A BRIGADA ------------ CONSULTAR SI LO TERMINAMOS
        // ------------ ASIGNAR BRIGADA A SINIESTRO ------------
        // VERIFICAR
        // ------------ RESOLVER SINIESTROS ------------
        // VERIFICAR
        // ------------ BUSCAR SINIESTROS ------------
//          SiniestrosData siniestro = new SiniestrosData();
//          
//          System.out.println(siniestro.buscarSiniestros(3));
        // ------------ LISTAR SINIESTROS ------------
//          SiniestrosData siniestro = new SiniestrosData();
//          
//          System.out.println("------------ Lista de Siniestros ------------");
//          
//          for(Siniestros s : siniestro.listarSiniestros()){
//              
//              System.out.println(" ");
//              System.out.println("Codigo: " + s.getCodigo());
//              System.out.println("Tipo: " + s.getTipo());
//              System.out.println("Fecha del Suceso: " + s.getFecha_siniestro());
//              System.out.println("Coordenada X: " + s.getCoord_X());
//              System.out.println("Coordenada Y: " + s.getCoord_Y());
//              System.out.println("Detalles: " + s.getDetalles());
//              System.out.println("Fecha de Resolución: " + s.getFecha_resol());
//              System.out.println("Puntuación: " + s.getPuntuacion());
//          
//          }
        // ------------ MODIFICAR SINIESTRO ------------
//          BrigadaData brig = new BrigadaData();
//       
//          Brigada brigada = brig.consultarBrigada(14);
//          
//          Siniestros siniestro = new Siniestros(1, "Incendio", LocalDateTime.of(2023, Month.NOVEMBER, 11, 14, 12, 59), 1574, 1234, "Localizado en Barrio Juarez", LocalDate.of(2023, Month.NOVEMBER, 11), 8, brigada, true);
//          
//          SiniestrosData siniestrod = new SiniestrosData();
//          
//          siniestrod.modificarSiniestro(siniestro);
//          
        // ------------ ELIMINAR SINIESTRO ------------
//          SiniestrosData siniestro = new SiniestrosData();
//          
//          siniestro.eliminarSiniestro(3);

        // ------------ RESOLVER SINIESTRO ------------
//        SiniestrosData sin = new SiniestrosData();
//        
//           
//        Siniestros sini= new Siniestros(1, LocalDate.of(2023, Month.DECEMBER, 14), 6, false);
//        sin.resolverSiniestro(sini);
        
          


    }
    
}
