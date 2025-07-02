package br.edu.ufam.icomp.lab_excecoes;

import java.lang.Math;

public class Coordenada {

    private int posX;
    private int posY;
    private int digito;

    public Coordenada(int posX, int posY, int digito)
            throws CoordenadaNegativaException, CoordenadaForaDosLimitesException, DigitoInvalidoException {

        if (posX < 0 || posY < 0) {
            throw new CoordenadaNegativaException();
        }
        if (posX > 30000 || posY > 30000) {
            throw new CoordenadaForaDosLimitesException();
        }
        int soma = posX + posY;
        if (soma % 10 != digito) {
            throw new DigitoInvalidoException();
        }

        this.posX = posX;
        this.posY = posY;
        this.digito = digito;
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public double distancia(Coordenada outraCoordenada) {
        double deltaX = outraCoordenada.getPosX() - this.posX;
        double deltaY = outraCoordenada.getPosY() - this.posY;

        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    @Override
    public String toString() {
        return this.posX + ", " + this.posY;
    }
}