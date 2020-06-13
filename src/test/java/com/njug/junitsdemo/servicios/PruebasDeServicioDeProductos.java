package com.njug.junitsdemo.servicios;

import com.njug.junitsdemo.modelos.CategoriaDeProductos;
import com.njug.junitsdemo.modelos.Impuesto;
import com.njug.junitsdemo.modelos.Localidad;
import com.njug.junitsdemo.modelos.Producto;
import com.njug.junitsdemo.repositorios.RepositorioDeImpuestos;
import com.njug.junitsdemo.repositorios.RepositorioDeProductos;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PruebasDeServicioDeProductos {

    @MockBean
    RepositorioDeImpuestos repositorioDeImpuestos;

    @MockBean
    RepositorioDeProductos repositorioDeProductos;

    @Autowired
    ServicioDeProductos servicioDeProductos;


    @Test
    public void pruebaDeCalculoDeImpuestos() throws Exception {
        //Dado que
        int idDelProducto = 1;
        Localidad localidad = Localidad.COLOMBIA;

        Producto producto = new Producto();
        producto.setPrecioUnitario(BigDecimal.TEN);
        producto.setCategoria(CategoriaDeProductos.ELECTRONICOS);
        Optional<Producto> productoOptional = Optional.of(producto);
        when(repositorioDeProductos.findById(idDelProducto)).thenReturn(productoOptional);

        Impuesto impuesto = new Impuesto();
        impuesto.setImporte(BigDecimal.valueOf(0.05));
        Optional<Impuesto> impuestoOptional = Optional.of(impuesto);
        when(repositorioDeImpuestos.findByLocalidadAndCategoria(Localidad.COLOMBIA, CategoriaDeProductos.ELECTRONICOS))
                .thenReturn(impuestoOptional);

        //Cuando
        BigDecimal resultado = servicioDeProductos.calcularMontoAPagarPorProducto(idDelProducto, localidad);

        //Entonces
        assertEquals(new BigDecimal("10.50"), resultado);
    }


}
