package com.cristian.restaurantegarcia.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
public class PlatoInsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlatoInsumo;

    @ManyToOne
    @JoinColumn(name = "idPlato")
    private Plato plato;

    @ManyToOne
    @JoinColumn(name = "idInsumo")
    private Insumo insumo;

    private double cantidadUsada;
    public Long getIdPlatoInsumo() {
        return idPlatoInsumo;
    }
    public void setIdPlatoInsumo(Long idPlatoInsumo) {
        this.idPlatoInsumo = idPlatoInsumo;
    }
    public Plato getPlato() {
        return plato;
    }
    public void setPlato(Plato plato) {
        this.plato = plato;
    }
    public Insumo getInsumo() {
        return insumo;
    }
    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }
    public double getCantidadUsada() {
        return cantidadUsada;
    }
    public void setCantidadUsada(double cantidadUsada) {
        this.cantidadUsada = cantidadUsada;
    }
}