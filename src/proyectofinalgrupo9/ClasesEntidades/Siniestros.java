package proyectofinalgrupo9.ClasesEntidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Siniestros {
    private int codigo;
    private String tipo;
    private LocalDateTime fecha_siniestro;
    private int coord_X;
    private int coord_Y;
    private String detalles;
    private LocalDate fecha_resol;
    private int puntuacion;
    private Brigada codBrigada;
    private boolean estado;

    public Siniestros(int codigo, String tipo, LocalDateTime fecha_siniestro, int coord_X, int coord_Y, String detalles, Brigada codBrigada, boolean estado) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.fecha_siniestro = fecha_siniestro;
        this.coord_X = coord_X;
        this.coord_Y = coord_Y;
        this.detalles = detalles;
        this.codBrigada = codBrigada;
        this.estado = estado;
    }

    public Siniestros(String tipo, LocalDateTime fecha_siniestro, int coord_X, int coord_Y, String detalles, Brigada codBrigada, boolean estado) {
        this.tipo = tipo;
        this.fecha_siniestro = fecha_siniestro;
        this.coord_X = coord_X;
        this.coord_Y = coord_Y;
        this.detalles = detalles;
        this.codBrigada = codBrigada;
        this.estado = estado;
    }

    public Siniestros(int codigo, LocalDate fecha_resol, int puntuacion, boolean estado) {
        this.codigo=codigo;
        this.fecha_resol = fecha_resol;
        this.puntuacion = puntuacion;
        this.estado = estado;
    }
    

    public Siniestros() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFecha_siniestro() {
        return fecha_siniestro;
    }

    public void setFecha_siniestro(LocalDateTime fecha_siniestro) {
        this.fecha_siniestro = fecha_siniestro;
    }

    public int getCoord_X() {
        return coord_X;
    }

    public void setCoord_X(int coord_X) {
        this.coord_X = coord_X;
    }

    public int getCoord_Y() {
        return coord_Y;
    }

    public void setCoord_Y(int coord_Y) {
        this.coord_Y = coord_Y;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public LocalDate getFecha_resol() {
        return fecha_resol;
    }

    public void setFecha_resol(LocalDate fecha_resol) {
        this.fecha_resol = fecha_resol;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
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
        return  "Siniestros: " + 
                " Codigo: " + codigo + 
                " Tipo: " + tipo;
    }
    
    public String listar(){
    
        return  "Siniestros: " + 
                " Codigo: " + codigo + 
                " Tipo: " + tipo +
                " Fecha de Siniestro: " + fecha_siniestro + 
                " Coordenada X: " + coord_X + 
                " Coordenada Y: " + coord_Y + 
                " Detalles: " + detalles + 
                " Codigo de Brigada: " + codBrigada.getCodBrigada() +
                " Estado: " + estado;
    
    }
    
    public String resuelto(){
    
        return "Siniestro resuelto: " +
               "Codigo: " + codigo +
               "Tipo: " + tipo +
               "Fecha de resolución: " + fecha_resol +
               "Puntuación: " + puntuacion;
        
    }
    
    
    
}