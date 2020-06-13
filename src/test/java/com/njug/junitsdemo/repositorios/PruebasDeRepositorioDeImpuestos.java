package com.njug.junitsdemo.repositorios;

import com.njug.junitsdemo.modelos.CategoriaDeProductos;
import com.njug.junitsdemo.modelos.Impuesto;
import com.njug.junitsdemo.modelos.Localidad;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
// Esta anotacion ayuda con:
// - Configurar H2 como origin de datos en memoria.
// - Configurar Hibernate, Spring data y demas.
// - Realizar el @EntityScan
// - Encender los logs de SQL
@DataJpaTest
public class PruebasDeRepositorioDeImpuestos {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    RepositorioDeImpuestos repositorioDeImpuestos;

    @Test
    public void pruebaDeBusquedaPorCategoriaYLocalidad() {
        //Dado que
        Impuesto impuesto = new Impuesto();
        impuesto.setImporte(BigDecimal.ONE);
        impuesto.setCategoria(CategoriaDeProductos.ELECTRONICOS);
        impuesto.setLocalidad(Localidad.COLOMBIA);

        entityManager.persist(impuesto);
        entityManager.flush();

        //Cuando
        Optional<Impuesto> impuestoOptional = repositorioDeImpuestos.findByLocalidadAndCategoria(
                Localidad.COLOMBIA, CategoriaDeProductos.ELECTRONICOS);

        //Entonces
        assertTrue(impuestoOptional.isPresent());
    }

}
