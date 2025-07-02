
import java.util.Random;

public class CarroLuxuoso extends Carro implements Localizavel {

    public CarroLuxuoso(String placa) {
        super(placa);
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
        return 15.0;
    }
}