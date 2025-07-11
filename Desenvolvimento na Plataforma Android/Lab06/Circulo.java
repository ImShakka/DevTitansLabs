package br.edu.icomp.ufam.lab_heranca;

public class Circulo extends FormaGeometrica {

    public double raio;

    public Circulo(int posX, int posY, double raio) {
        super(posX, posY);
        this.raio = raio;
    }

    @Override
    public double getArea() {
        return Math.PI * this.raio * this.raio;
    }

    @Override
    public double getPerimetro() {
        return 2 * Math.PI * this.raio;
    }

    @Override
    public String toString() {
        return "círculo na posição (" + this.posX + ", " + this.posY + ") com raio de " +
               this.raio + "cm (área=" + getArea() + "cm2, perímetro=" + getPerimetro() + "cm)";
    }
}