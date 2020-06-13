package com.njug.junitsdemo;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PruebaDeServicioDeCalculadora {

    @Autowired
    private ServicioDeCalculadora objetoDePrueba;

    @Before
    public void antesDeCadaPrueba() {
        System.out.println(">> Antes de cada prueba");
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
        assertTrue(objetoDePrueba.historial.get(objetoDePrueba.historial.size() -1).startsWith("Suma"));
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
        assertTrue(objetoDePrueba.historial.get(objetoDePrueba.historial.size() -1).startsWith("Suma"));
    }

    @Test
    public void pruebaDeMultiplicacion() {
        System.out.println("pruebaDeMultiplicacion");
        //Dado que tenemos dos flotantes
        float a = 3.0F;
        float b = 4.99F;

        //Cuando ejecutamos la suma
        float resultado = objetoDePrueba.multiplicar(a, b);

        //Verificamos
        assertEquals(14.97F, resultado, 0.1);
        assertTrue(objetoDePrueba.historial.get(objetoDePrueba.historial.size() -1).startsWith("Multiplicar"));
    }

    @Test(expected = ServicioDeCalculadora.DivisionEntreCeroException.class)
    public void pruebaDeDivisionEntreCero() throws Exception {
        System.out.println("pruebaDeDivision");
        //Dado que tenemos dos doubles
        double a = 3.0;
        double b = 0.0;

        //Cuando ejecutamos la suma
        objetoDePrueba.dividir(a, b);
    }
}
