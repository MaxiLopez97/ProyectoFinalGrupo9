/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalgrupo9.ClasesEntidades;

/**
 *
 * @author Maxi
 */
public class Brigada {
   
    private int codBrigada;
    private String nombre_br;
    private String especialidad;
    private Boolean libre;
    //Cuartel ( cambiar)
    private int nro_cuartel;

    public Brigada(int codBrigada, String nombre_br, String especialidad, Boolean libre, int nro_cuartel) {
        this.codBrigada = codBrigada;
        this.nombre_br = nombre_br;
        this.especialidad = especialidad;
        this.libre = libre;
        this.nro_cuartel = nro_cuartel;
    }

    public Brigada(String nombre_br, String especialidad, Boolean libre, int nro_cuartel) {
        this.nombre_br = nombre_br;
        this.especialidad = especialidad;
        this.libre = libre;
        this.nro_cuartel = nro_cuartel;
    }

    public Brigada() {
    }

    public int getCodBrigada() {
        return codBrigada;
    }

    public void setCodBrigada(int codBrigada) {
        this.codBrigada = codBrigada;
    }

    public String getNombre_br() {
        return nombre_br;
    }

    public void setNombre_br(String nombre_br) {
        this.nombre_br = nombre_br;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Boolean getLibre() {
        return libre;
    }

    public void setLibre(Boolean libre) {
        this.libre = libre;
    }

    public int getNro_cuartel() {
        return nro_cuartel;
    }

    public void setNro_cuartel(int nro_cuartel) {
        this.nro_cuartel = nro_cuartel;
    }

    @Override
    public String toString() {
        return  "Brigada: " + 
                "Codigo de Brigada: " + codBrigada +
                "Nombre de Brigada: " + nombre_br + 
                "Especialidad: " + especialidad + 
                "Numero de Cuartel: " + nro_cuartel ;
    }
    
    
    
    
    
}
