import java.util.ArrayList;

public class Turma {
    
    String disciplina;
    int ano;
    int semestre;
    Professor professor;
    ArrayList<Aluno> alunos;

    public Turma (String disciplina, int ano, int semestre, Professor professor) {
        this.disciplina = disciplina;
        this.ano = ano;
        this.semestre = semestre;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    public Aluno getAluno(int matricula) {
        for (Aluno aluno : this.alunos) {
            if (aluno.matricula == matricula) {
                return aluno;
            }
        }
        return null;
    }

    public void addAluno(Aluno aluno) {
        if (this.getAluno(aluno.matricula) == null) {
            this.alunos.add(aluno);
        }
    }

    public double getMediaIdade() {
        if (this.alunos.isEmpty()) {
            return 0.0;
        }

        double somaDasIdades = 0;
        for (Aluno aluno : this.alunos) {
            somaDasIdades += aluno.getIdade();
        }

        return somaDasIdades / this.alunos.size();
    }

    public String getDescricao() {
        StringBuilder infos = new StringBuilder ();

        infos.append ("Turma ")
             .append(this.disciplina)
             .append(" - ")
             .append(this.ano)
             .append("/")
             .append(this.semestre)
             .append(" (")
             .append(this.professor.getDescricao())
             .append(")\n");

        for (int i = 0; i < this.alunos.size(); i++) {
            Aluno alunoAtual = this.alunos.get(i);
            infos.append("  - Aluno ")
                 .append(i + 1)
                 .append(": ")
                 .append(alunoAtual.getDescricao())
                 .append("\n");
        }

        return infos.toString();
    }
    
}
