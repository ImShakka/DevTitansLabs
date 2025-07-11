
public class Professor {
    
    String titulacao;
    String nome;
    int matricula;

    public Professor() {
        this("sem titulo", "Professor nao encontrado", 0);
    }

    public Professor(String titulacao, String nome, int matricula) {
        this.titulacao = titulacao;
        this.nome = nome;
        this.matricula = matricula;
    }


    public String getDescricao() {
        return "Prof. " + this.titulacao + " " + this.nome + " - mat " + this.matricula;
    }
}