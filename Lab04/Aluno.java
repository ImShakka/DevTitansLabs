
import java.util.Calendar;

public class Aluno {
    
    String nome;
    int matricula;
    int anoNascimento;

    public Aluno() {
        this("Aluno nao encontrado", 0, 0);
    }

    public Aluno(String nome, int matricula, int anoNascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.anoNascimento = anoNascimento;
    }

    public int getIdade() {
        Calendar calendar = Calendar.getInstance();
        int anoAtual = calendar.get (Calendar.YEAR);
        
        return anoAtual - this.anoNascimento;
    }

    public String getDescricao() {
        return this.nome + " (mat=" + this.matricula + ", idade=" + this.getIdade() + ")";
    }
}