package com.jkutkut.ej2;

public class Contador {
    private int contador;

    public Contador() {
        contador = 0;
    }

    public synchronized void incrementar() {
        contador++;
    }

    public int total() {
        return contador;
    }
}
