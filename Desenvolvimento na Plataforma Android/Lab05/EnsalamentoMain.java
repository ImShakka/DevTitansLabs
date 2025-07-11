public class EnsalamentoMain {

    public static void main(String[] args) {

        Ensalamento ensalamento = new Ensalamento();

        Sala sala1 = new Sala(6, 101, 50, true);
        Sala sala2 = new Sala(6, 102, 100, true);
        Sala sala3 = new Sala(6, 203, 50, false);
        Sala sala4 = new Sala(6, 204, 100, false);

        ensalamento.addSala(sala1);
        ensalamento.addSala(sala2);
        ensalamento.addSala(sala3);
        ensalamento.addSala(sala4);

        Turma turma1 = new Turma("Algoritmos e Estrutura de Dados I", "Edleno Silva", 60, false);
        turma1.addHorario(1);  // segunda 8hs
        turma1.addHorario(15); // quarta 8hs
        turma1.addHorario(29); // sexta 8hs
        
        Turma turma2 = new Turma("Técnicas de Programação", "Horácio Fernandes", 50, false);
        turma2.addHorario(11); // terca 14hs
        turma2.addHorario(25); // quinta 14hs
        turma2.addHorario(32); // sexta 14hs
        
        Turma turma3 = new Turma("Laboratório de Programação C", "Edson Nascimento", 25, true);
        turma3.addHorario(1);  // segunda 8hs
        turma3.addHorario(15); // quarta 8hs
        turma3.addHorario(29); // sexta 8hs
        
        Turma turma4 = new Turma("Redes de Computadores", "Edjair Souza", 70, true);
        turma4.addHorario(2);  // segunda 10hs
        turma4.addHorario(16); // quarta 10hs
        
        ensalamento.addTurma(turma1);
        ensalamento.addTurma(turma2);
        ensalamento.addTurma(turma3);
        ensalamento.addTurma(turma4);
        System.out.println("Turmas cadastradas: " + ensalamento.turmas.size());
        
        ensalamento.alocar(turma1, sala2);
        ensalamento.alocar(turma2, sala1);
        ensalamento.alocar(turma3, sala1);

        ensalamento.alocarTodas();

        System.out.println(ensalamento.relatorioResumoEnsalamento());
        System.out.println(ensalamento.relatorioTurmasPorSala());
        System.out.println(ensalamento.relatorioSalasPorTurma());
    }
}