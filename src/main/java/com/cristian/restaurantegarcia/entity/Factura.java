package com.cristian.restaurantegarcia.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;
    @ManyToOne
    private Pedido pedido;
    private LocalDateTime fechaEmision;
    private double total;
    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;
    @Enumerated(EnumType.STRING)
    private EstadoFactura estado;
    public enum MetodoPago { EFECTIVO, TARJETA, YAPE }
    public enum EstadoFactura { PENDIENTE, PAGADO }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public EstadoFactura getEstado() {
        return estado;
    }

    public void setEstado(EstadoFactura estado) {
        this.estado = estado;
    }
}
