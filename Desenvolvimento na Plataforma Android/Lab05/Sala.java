
public class Sala {

    public int bloco;
    public int sala;
    public int capacidade;
    public boolean acessivel;

    public Sala() {
        this(0, 0, 0, false);
    }

    public Sala(int bloco, int sala, int capacidade, boolean acessivel) {
        this.bloco = bloco;
        this.sala = sala;
        this.capacidade = capacidade;
        this.acessivel = acessivel;
    }

    public String getDescricao() {
        
        String statusAcessibilidade = this.acessivel ? "acessível" : "não acessível";

        return "Bloco " + this.bloco + ", Sala " + this.sala + " (" + this.capacidade + " lugares, " + statusAcessibilidade + ")";
    }
}