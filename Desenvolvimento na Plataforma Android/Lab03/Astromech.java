
public class Astromech {

    String modelo;
    Mestre mestre;
    Sensor sensor;
    Conexao conexao;

    public Astromech(String modelo, Mestre mestre, Sensor sensor, Conexao conexao) {
        this.modelo = modelo;
        this.mestre = mestre;
        this.sensor = sensor;
        this.conexao = conexao;
    }

    public String getDescricao() {
        return "Astromech modelo " + this.modelo + ". " +
               this.mestre.getDescricao() + " " +
               this.sensor.getDescricao() + " " +
               this.conexao.getDescricao();
    }
}