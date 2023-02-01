package com.jkutkut.ej2;

public class Main {
    public static void main(String[] args) {
        String txt = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquam nisl, nec ultricies nisl nisl nec nisl. Donec euismod, nisl nec ultricies lacinia, nisl nisl aliquam nisl, nec ultricies nisl nisl nec nisl. Donec euismod, nisl nec ultricies lacinia, nisl nisl aliquam nisl, nec ultricies nisl nisl nec nisl. Donec euismod, nisl nec ultricies lacinia, nisl nisl aliquam nisl, nec ultricies nisl nisl nec nisl. Donec euismod, nisl nec ultricies lacinia, nisl nisl aliquam nisl, nec ultricies nisl nisl nec nisl. Donec euismod, nisl nec ultricies lacinia, nisl nisl aliquam nisl, nec ultricies nisl nisl nec nisl. Donec euismod, nisl nec ultricies lacinia, nisl nisl aliquam nisl, nec ultricies nisl nisl nec nisl. Donec euismod, nisl nec ultricies lacinia, nisl nisl aliquam nisl, nec ultricies nisl nisl nec nisl. Donec euismod, nisl nec ultricies lacinia, nisl nisl aliquam nisl, nec ultricies nisl nisl nec nisl. Donec euismod, nisl nec ultricies lacinia, nisl nisl aliquam nisl, nec ultricies nisl nisl nec nisl. Donec euismod, nisl nec ultricies lacinia, nisl nisl aliquam nisl, nec ultricies nisl nisl nec nisl. Donec euismod, nisl nec ultricies lacinia, nisl nisl aliquam nisl, nec ultricies nisl nisl nec nisl. Donec euismod, nisl nec ultricies lacinia, nisl nisl aliquam nisl, nec ultricies nisl nisl nec nisl. Donec euismod, nisl nec ultricies lacinia, nisl nisl aliquam nisl, nec";
        String vocales = "aeiou";
        Thread[] threads = new Thread[vocales.length()];
        Contador contador = new Contador();

        for (int i = 0; i < vocales.length(); i++) {
            threads[i] = new Analyzer(contador, vocales.charAt(i), txt);
            threads[i].start();
        }
        for (int i = 0; i < vocales.length(); i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Vocales: " + contador.total());
    }
}
