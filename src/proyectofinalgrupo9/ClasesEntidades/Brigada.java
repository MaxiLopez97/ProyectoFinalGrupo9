
package proyectofinalgrupo9.ClasesEntidades;

import proyectofinalgrupo9.AccesoADATOS.Especialidades;

public class Brigada {
   
    private int codBrigada;
    private String nombre_br;
    private Especialidades especialidad;
    private CuartelDeBomberos nro_cuartel;
    private boolean disponible;
    private boolean estado;

    public Brigada(int codBrigada, String nombre_br, Especialidades especialidad, CuartelDeBomberos nro_cuartel, boolean estado) {
        this.codBrigada = codBrigada;
        this.nombre_br = nombre_br;
        this.especialidad = especialidad;
        this.nro_cuartel = nro_cuartel;
        this.estado = estado;
    }

    public Brigada(String nombre_br, Especialidades especialidad, CuartelDeBomberos nro_cuartel, boolean disponible, boolean estado) {
        this.nombre_br = nombre_br;
        this.especialidad = especialidad;
        this.nro_cuartel = nro_cuartel;
        this.disponible = disponible;
        this.estado = estado;
    }

    public Brigada(boolean disponible) {
        this.disponible = disponible;
    }
    
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
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

    public CuartelDeBomberos getNro_cuartel() {
        return nro_cuartel;
    }

    public void setNro_cuartel(CuartelDeBomberos nro_cuartel) {
        this.nro_cuartel = nro_cuartel;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    @Override
    public String toString() {
        return  
                codBrigada + " " +
                nombre_br + 
                " - " + especialidad + 
                " - " +
                " Cuartel: " + nro_cuartel.getCodCuartel();
                
             
                
    }
    
    public String listar(){
    
    return  "Brigada: " + 
                " Codigo de Brigada: " + codBrigada +
                " Nombre de Brigada: " + nombre_br + 
                " Especialidad: " + especialidad + 
                " Numero de Cuartel: " + nro_cuartel.getCodCuartel() +
                " Estado: " + estado;
    }
  
}