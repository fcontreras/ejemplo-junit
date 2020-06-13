package com.njug.junitsdemo.modelos;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Impuesto {

    private int id;
    private Localidad localidad;
    private BigDecimal importe;
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
    @Enumerated(EnumType.STRING)
    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    @Column
    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
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
