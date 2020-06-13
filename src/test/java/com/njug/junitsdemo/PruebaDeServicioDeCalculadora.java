package com.njug.junitsdemo;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PruebaDeServicioDeCalculadora {

    @Autowired
    private ServicioDeCalculadora objetoDePrueba;

    @Before
    public void antesDeCadaPrueba() {
        System.out.println(">> Antes de cada prueba");
        objetoDePrueba.historial = new LinkedList<String>();
    }

    @After
    public void despuesDeCadaPrueba() {
        System.out.println("<< Despues de cada prueba");
    }

    @BeforeClass
    public static void antesDeLaClase() {
        System.out.println("*** PruebaDeServicioDeCalculadora ***");
    }

    @AfterClass
    public static void despuesDeLaClase() {
        System.out.println("*** ^^^^^^ ***");
    }

    @Test
    public void pruebaDeSuma() {
        System.out.println("pruebaDeSuma");
        //Dado que tenemos dos enteros
        int a = 3;
        int b = 4;

        //Cuando ejecutamos la suma
        int resultado = objetoDePrueba.sumar(a, b);

        //Verificamos
        assertEquals(7, resultado);
        assertEquals(1, objetoDePrueba.historial.size());
    }

    @Test
    public void pruebaDeSumaDeDosNegativos() {
        System.out.println("pruebaDeSumaDeDosNegativos");
        //Dado que tenemos dos enteros
        int a = -3;
        int b = -4;

        //Cuando ejecutamos la suma
        int resultado = objetoDePrueba.sumar(a, b);

        //Verificamos
        assertEquals(-7, resultado);
        assertEquals(1, objetoDePrueba.historial.size());

    }
}
