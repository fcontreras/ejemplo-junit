package com.njug.junitsdemo;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ServicioDeCalculadora {

    List<String> historial = new LinkedList<String>();

    public int sumar(final int a, final int b) {
        int resultado = a + b;
        historial.add(String.format("Suma: %d + %d = %d", a, b, resultado));
        return resultado;
    }

    public float multiplicar(final float a, final float b) {
        float resultado = a * b;
        historial.add(String.format("Multiplicar: %f x %f = %f", a, b, resultado));
        return resultado;
    }

    public double dividir(final double a, final double b) throws Exception {
        if (b == 0) throw new DivisionEntreCeroException();

        double resultado = a / b;
        historial.add(String.format("dividr: %f / %f = %f", a, b, resultado));
        return resultado;
    }

    public class DivisionEntreCeroException extends Exception {}

}
