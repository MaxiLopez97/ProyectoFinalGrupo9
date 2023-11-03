
package proyectofinalgrupo9.ClasesEntidades;

import java.time.LocalDate;


public class Bombero {

    private int id_Bombero;
    private String dni;
    private String nombre_ape;
    private LocalDate fecha_nac;
    private String celular;
    //Brigada ( cambiar)
    private Brigada Brigada;
   

    public Bombero(int id_Bombero, String dni, String nombre_ape, LocalDate fecha_nac, String celular, Brigada codBrigada) {
        this.id_Bombero = id_Bombero;
        this.dni = dni;
        this.nombre_ape = nombre_ape;
        this.fecha_nac = fecha_nac;
        this.celular = celular;
        this.Brigada = codBrigada;
    }

    public Bombero(String dni, String nombre_ape, LocalDate fecha_nac, String celular, Brigada codBrigada) {
        this.dni = dni;
        this.nombre_ape = nombre_ape;
        this.fecha_nac = fecha_nac;
        this.celular = celular;
        this.Brigada = codBrigada;
    }

    public Bombero() {
    }

    public int getId_Bombero() {
        return id_Bombero;
    }

    public void setId_Bombero(int id_Bombero) {
        this.id_Bombero = id_Bombero;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre_ape() {
        return nombre_ape;
    }

    public void setNombre_ape(String nombre_ape) {
        this.nombre_ape = nombre_ape;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Brigada getCodBrigada() {
        return Brigada;
    }

    public void setCodBrigada(Brigada codBrigada) {
        this.Brigada = codBrigada;
    }

    
    
    @Override
    public String toString() {
        return   "Bombero: "+
                 "DNI: " + dni + 
                 "Apellido: " + nombre_ape + 
                 "Fecha Nacimiento: " + fecha_nac + 
                 "Numero de Celular: " + celular +
                 "Codigo de Brigada:" + Brigada ;
    }

    
    
}
