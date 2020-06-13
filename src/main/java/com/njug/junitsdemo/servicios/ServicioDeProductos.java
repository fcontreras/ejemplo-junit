package com.njug.junitsdemo.servicios;

import com.njug.junitsdemo.modelos.CategoriaDeProductos;
import com.njug.junitsdemo.modelos.Impuesto;
import com.njug.junitsdemo.modelos.Localidad;
import com.njug.junitsdemo.modelos.Producto;
import com.njug.junitsdemo.repositorios.RepositorioDeImpuestos;
import com.njug.junitsdemo.repositorios.RepositorioDeProductos;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ServicioDeProductos {

    private final RepositorioDeImpuestos repositorioDeImpuestos;
    private final RepositorioDeProductos repositorioDeProductos;

    public ServicioDeProductos(RepositorioDeImpuestos repositorioDeImpuestos, RepositorioDeProductos repositorioDeProductos) {
        this.repositorioDeImpuestos = repositorioDeImpuestos;
        this.repositorioDeProductos = repositorioDeProductos;
    }

    /**
     * Calcula el precio final de un producto sumando el precio unitario mas el importe por el impuesto de la
     * localidad especificada en la categoria especificada.
     *
     * @param idDeProducto
     * @param lugarDeCompra
     * @return el precio final del producto
     * @throws Exception si no se encuentra el producto o el impuesto en la base de datos
     */
    public BigDecimal calcularMontoAPagarPorProducto(final int idDeProducto,
                                                     final Localidad lugarDeCompra) throws Exception {
        Optional<Producto> producto = repositorioDeProductos.findById(idDeProducto);
        if (producto.isPresent()) {
            Optional<Impuesto> impuesto = repositorioDeImpuestos.findByLocalidadAndCategoria(lugarDeCompra,
                    producto.get().getCategoria());

            if (impuesto.isPresent()) {

                //Regresar el precio del producto mas el importe del impuesto
                return producto.get().getPrecioUnitario().add(
                        impuesto.get().getImporte().multiply(producto.get().getPrecioUnitario()));

            } else {

                //Regresar el precio del producto unicamente
                return producto.get().getPrecioUnitario();
            }
        } else {
            throw new Exception(String.format("El producto con id [%d] no existe", idDeProducto));
        }
    }
}
