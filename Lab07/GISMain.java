
public class GISMain {

    public static void main(String[] args) {

        Localizavel[] objetosLocalizaveis = new Localizavel[4];

        objetosLocalizaveis[0] = new Celular(55, 92, 912345678);
        objetosLocalizaveis[1] = new CarroLuxuoso("MFO-2025");
        objetosLocalizaveis[2] = new Celular(55, 92, 987654321);
        objetosLocalizaveis[3] = new CarroLuxuoso("FMA-0064");

        for (Localizavel item : objetosLocalizaveis) {
            System.out.println(item.getPosicao());
        }
    }
}