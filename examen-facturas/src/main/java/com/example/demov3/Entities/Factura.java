package com.example.demov3.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String cliente;
    private Double total;
    private LocalDate fecha;

    public Factura() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}
