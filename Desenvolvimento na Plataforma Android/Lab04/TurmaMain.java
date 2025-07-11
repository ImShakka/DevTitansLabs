
public class TurmaMain {
    public static void main(String[] args) {

        Professor professor1 = new Professor ("Dr.", "Hubert J. Farnsworth", 2208);

        Aluno aluno1 = new Aluno ("Emmett L.Brown", 7714, 2003);
        Aluno aluno2 = new Aluno ("Egon Spengler", 5907, 2002);
        Aluno aluno3 = new Aluno ("Peter Weyland", 7734, 2006);

        Aluno alunoJaExiste = new Aluno ("Aluno já existe", 0, 0);

        Turma turma = new Turma("Inicialização Tecnológica e Cientifíca", 2016, 1, professor1);

        turma.addAluno(aluno1);
        turma.addAluno(aluno2);
        turma.addAluno(aluno3);
        
        System.out.println("--- teste com aluno duplicado --- ");
        System.out.println("Quantidade de alunos antes de add o aluno que ja existe: " + turma.alunos.size());
        turma.addAluno(alunoJaExiste);
        System.out.println("Quantidade de alunos depois de add o aluno que ja existe: " + turma.alunos.size());
        System.out.println("\n");

        System.out.println("--- teste media --- ");
        System.out.printf("Média de idade: %.2f anos\n", turma.getMediaIdade());
        System.out.println("\n");

        System.out.println("--- teste descricao turma --- ");
        System.out.println(turma.getDescricao());
    }
}
