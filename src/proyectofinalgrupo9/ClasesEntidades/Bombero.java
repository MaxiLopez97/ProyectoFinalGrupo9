
package proyectofinalgrupo9.ClasesEntidades;

import java.time.LocalDate;


public class Bombero {

    private int id_Bombero;
    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fecha_nac;
    private String celular;
    private Brigada codBrigada;
    private boolean estado;

    public Bombero(int id_Bombero, String dni, String nombre, String apellido, LocalDate fecha_nac, String celular, Brigada codBrigada, boolean estado) {
        this.id_Bombero = id_Bombero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nac = fecha_nac;
        this.celular = celular;
        this.codBrigada = codBrigada;
        this.estado = estado;
    }

    public Bombero(String dni, String nombre, String apellido, LocalDate fecha_nac, String celular, Brigada codBrigada, boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nac = fecha_nac;
        this.celular = celular;
        this.codBrigada = codBrigada;
        this.estado = estado;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
        return codBrigada;
    }

    public void setCodBrigada(Brigada codBrigada) {
        this.codBrigada = codBrigada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    @Override
    public String toString() {
        return   "Bombero: " +
                 "DNI: " + dni + 
                 "Nombre: " + nombre + 
                 "Apellido: " + apellido +
                 "Fecha Nacimiento: " + fecha_nac + 
                 "Numero de Celular: " + celular +
                 "Codigo de Brigada:" + codBrigada +
                 "Estado: " + estado;
    }

    
    
}
