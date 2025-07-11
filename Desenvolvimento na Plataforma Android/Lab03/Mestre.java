import java.lang.Math;

public class Mestre {

    String nome;
    int anoNascimento;
    String afiliacao;
    String posto;

    public Mestre() {

    }

    public Mestre(String nome, int anoNascimento, String afiliacao, String posto) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.afiliacao = afiliacao;
        this.posto = posto;
    }

    public int getIdade(int anoReferencia) {
        return anoReferencia - this.anoNascimento;
    }

    public String getAnoNascimentoString() {
        if (this.anoNascimento < 0) {
            return Math.abs(this.anoNascimento) + "ABY";
        } else {
            return this.anoNascimento + "DBY";
        }
    }

    public boolean possuiForca() {
        return "Jedi".equals(this.posto) || "Sith".equals(this.posto);
    }

    public String getDescricao() {
        return "Mestre: nome=" + this.nome +
               ", anoNascimento=" + getAnoNascimentoString() +
               ", afiliacao=" + this.afiliacao +
               ", posto=" + this.posto +
               ", possuiForca=" + possuiForca() + ".";
    }
}