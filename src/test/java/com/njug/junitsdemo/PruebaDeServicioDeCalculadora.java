package com.njug.junitsdemo;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

@RunWith(BlockJUnit4ClassRunner.class)
public class PruebaDeServicioDeCalculadora {

    ServicioDeCalculadora objetoDePrueba = new ServicioDeCalculadora();

    @Before
    public void antesDeCadaPrueba() {
        System.out.println("Antes de cada prueba");
    }

    @Test
    public void pruebaDeSuma() {
        //Dado que tenemos dos enteros
        int a = 3;
        int b = 4;

        //Cuando ejecutamos la suma
        int resultado = objetoDePrueba.sumar(a, b);

        //Verificamos
        assertEquals(7, resultado);
    }

    @After
    public void despuesDeLasPruebas() {
        System.out.println("Despues de cada prueba");
    }
}
