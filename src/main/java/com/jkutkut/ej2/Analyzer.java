package com.jkutkut.ej2;

import java.text.Normalizer;
import java.util.Locale;

public class Analyzer extends Thread {

    Contador contador;
    char c;
    String txt;

    public Analyzer(Contador contador, char c, String txt) {
        this.contador = contador;
        this.c = Character.toLowerCase(c);
        this.txt = normalizeText(txt);
    }

    /**
     * Normalizes the given text, removing accents and converting to lower case.
     * @param txt The text to normalize.
     * @return The normalized text.
     */
    private static String normalizeText(String txt) {
        txt = Normalizer.normalize(txt, Normalizer.Form.NFD);
        return txt.replaceAll("\\p{InCombiningDiacriticalMarks}", "").toLowerCase(Locale.ROOT);
    }

    @Override
    public void run() {
        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) == c)
                contador.incrementar();
        }
    }
}
