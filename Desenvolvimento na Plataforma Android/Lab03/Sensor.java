
public class Sensor {

    String cor;
    double resolucao;
    int framesPorSegundo;

    public Sensor() {
    }

    public Sensor(String cor, double resolucao, int framesPorSegundo) {
        this.cor = cor;
        this.resolucao = resolucao;
        this.framesPorSegundo = framesPorSegundo;
    }

    public double getMPixelsPorSegundo() {
        return this.resolucao * this.framesPorSegundo;
    }

    public String getDescricao() {
        return "Sensor: cor=" + this.cor +
               ", resolucao=" + this.resolucao + "Mp" +
               ", framesPorSegundo=" + this.framesPorSegundo + "fps" +
               ", mPixelsPorSegundo=" + this.getMPixelsPorSegundo() + "Mpps.";
    }
}