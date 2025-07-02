package br.edu.icomp.ufam.lab_heranca;

public class Quadrado extends Retangulo {

    public Quadrado(int posX, int posY, double lado) {
        super(posX, posY, lado, lado);
    }

    @Override
    public String toString() {
        return "Quadrado na posição (" + this.posX + ", " + this.posY + ") com lado de " +
               this.largura + "cm (área=" + getArea() + "cm2, perímetro=" + getPerimetro() + "cm)";
    }
}