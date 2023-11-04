/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalgrupo9.ClasesEntidades;

import proyectofinalgrupo9.AccesoADATOS.Especialidades;

/**
 *
 * @author Maxi
 */
public class Brigada {
   
    private int codBrigada;
    private String nombre_br;
    private Especialidades especialidad;
    private Boolean libre;
    //Cuartel ( cambiar)
    private CuartelDeBomberos nro_cuartel;

    public Brigada(int codBrigada, String nombre_br, Especialidades especialidad, Boolean libre, CuartelDeBomberos nro_cuartel) {
        this.codBrigada = codBrigada;
        this.nombre_br = nombre_br;
        this.especialidad = especialidad;
        this.libre = libre;
        this.nro_cuartel = nro_cuartel;
    }

    public Brigada(String nombre_br, Especialidades especialidad, Boolean libre, CuartelDeBomberos nro_cuartel) {
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

    public Especialidades getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidades especialidad) {
        this.especialidad = especialidad;
    }

    public Boolean getLibre() {
        return libre;
    }

    public void setLibre(Boolean libre) {
        this.libre = libre;
    }

    public CuartelDeBomberos getNro_cuartel() {
        return nro_cuartel;
    }

    public void setNro_cuartel(CuartelDeBomberos nro_cuartel) {
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
