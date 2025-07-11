
import java.util.Random;

public class Celular implements Localizavel {

    private int codPais;
    private int codArea;
    private int numero;

    public Celular(int codPais, int codArea, int numero) {
        this.setCodPais(codPais);
        this.setCodArea(codArea);
        this.setNumero(numero);
    }

    public int getCodPais() {
        return codPais;
    }

    public int getCodArea() {
        return codArea;
    }

    public int getNumero() {
        return numero;
    }

    public final void setCodPais(int codPais) {
        if (codPais >= 1 && codPais <= 1999) {
            this.codPais = codPais;
        } else {
            this.codPais = -1;
        }
    }

    public final void setCodArea(int codArea) {
        if (codArea >= 10 && codArea <= 99) {
            this.codArea = codArea;
        } else {
            this.codArea = -1;
        }
    }

    public final void setNumero(int numero) {
        if (numero >= 10000000 && numero <= 999999999) {
            this.numero = numero;
        } else {
            this.numero = -1;
        }
    }

    @Override
    public Posicao getPosicao() {
        Random random = new Random();

        double latMin = -3.160000;
        double latMax = -2.960000;
        double lonMin = -60.120000;
        double lonMax = -59.820000;
        double altMin = 15.0;
        double altMax = 100.0;

        double latitude = latMin + (latMax - latMin) * random.nextDouble();
        double longitude = lonMin + (lonMax - lonMin) * random.nextDouble();
        double altitude = altMin + (altMax - altMin) * random.nextDouble();

        return new Posicao(latitude, longitude, altitude);
    }

    @Override
    public double getErroLocalizacao() {
        return 50.0;
    }
}