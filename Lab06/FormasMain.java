package br.edu.icomp.ufam.lab_heranca;

import java.util.ArrayList;
import java.util.List;

public class FormasMain {

    public static void main(String[] args) {

        List<FormaGeometrica> formas = new ArrayList<>();
        formas.add(new Circulo(36, 93, 9.0));
        formas.add(new Circulo(120, 250, 20.0));
        formas.add(new Retangulo(10, 80, 3.0, 5.0));
        formas.add(new Retangulo(18, 70, 5.0, 10.0)); 
        formas.add(new Quadrado(48, 59, 13.0));

        for (FormaGeometrica forma : formas) {
            System.out.println(forma);
        }
    }
}