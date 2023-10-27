/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoFinalGrupo9.ClasesEntidades;

import java.time.LocalDate;

/**
 *
 * @author Maxi
 */
public class Siniestros {
    private int codigo;
    private String tipo;
    private LocalDate fecha_siniestro;
    private int coord_X;
    private int coord_Y;
    private String detalles;
    private LocalDate fecha_resol;
    private int puntuacion;
    private int codBrigada;

    public Siniestros(int codigo, String tipo, LocalDate fecha_siniestro, int coord_X, int coord_Y, String detalles, LocalDate fecha_resol, int puntuacion, int codBrigada) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.fecha_siniestro = fecha_siniestro;
        this.coord_X = coord_X;
        this.coord_Y = coord_Y;
        this.detalles = detalles;
        this.fecha_resol = fecha_resol;
        this.puntuacion = puntuacion;
        this.codBrigada = codBrigada;
    }

    public Siniestros(String tipo, LocalDate fecha_siniestro, int coord_X, int coord_Y, String detalles, LocalDate fecha_resol, int puntuacion, int codBrigada) {
        this.tipo = tipo;
        this.fecha_siniestro = fecha_siniestro;
        this.coord_X = coord_X;
        this.coord_Y = coord_Y;
        this.detalles = detalles;
        this.fecha_resol = fecha_resol;
        this.puntuacion = puntuacion;
        this.codBrigada = codBrigada;
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

    public LocalDate getFecha_siniestro() {
        return fecha_siniestro;
    }

    public void setFecha_siniestro(LocalDate fecha_siniestro) {
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

    public int getCodBrigada() {
        return codBrigada;
    }

    public void setCodBrigada(int codBrigada) {
        this.codBrigada = codBrigada;
    }

    @Override
    public String toString() {
        return  "Siniestros: " + 
                "Codigo: " + codigo + 
                "Tipo: " + tipo +
                "Fecha de Siniestro: " + fecha_siniestro + 
                "Coordenada X: " + coord_X + 
                "Coordenada Y: " + coord_Y + 
                "Detalles: " + detalles + 
                "Fecha de Resolucion: " + fecha_resol + 
                "Puntuacion: " + puntuacion +
                "Codigo de Brigada: " + codBrigada ;
    }
    
    
    
    
}
