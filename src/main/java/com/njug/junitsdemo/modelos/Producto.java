package com.njug.junitsdemo.modelos;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Producto {

    private int id;
    private String descripcion;
    private BigDecimal precioUnitario;
    private CategoriaDeProductos categoria;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Column
    @Enumerated(EnumType.STRING)
    public CategoriaDeProductos getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDeProductos categoria) {
        this.categoria = categoria;
    }
}
