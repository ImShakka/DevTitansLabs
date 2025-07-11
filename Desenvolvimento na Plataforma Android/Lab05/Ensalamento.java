import java.util.ArrayList;
import java.util.Comparator;

public class Ensalamento {

    public ArrayList<Sala> salas;
    public ArrayList<Turma> turmas;
    public ArrayList<TurmaEmSala> ensalamento;

    public Ensalamento() {
        this.salas = new ArrayList<>();
        this.turmas = new ArrayList<>();
        this.ensalamento = new ArrayList<>();
    }

    public void addSala(Sala sala) {
        this.salas.add(sala);
    }

    public void addTurma(Turma turma) {
        this.turmas.add(turma);
    }

    public Sala getSala(Turma turma) {
        for (TurmaEmSala tes : this.ensalamento) {
            if (tes.turma == turma) { // compara as refs dos objetos
                return tes.sala;
            }
        }
        return null;
    }

    public boolean salaDisponivel(Sala sala, int horario) {
        for (TurmaEmSala tes : this.ensalamento) {
            // Se a sala ja ta em uso por alguma alocacao
            if (tes.sala == sala) {
                // veifica se o horario conflita com os horarios da turma ja alocada
                if (tes.turma.horarios.contains(horario)) {
                    return false; // conflito encontrado, sala não esta livre
                }
            }
        }
        return true; // nenhum conflito encontrado
    }

    public boolean salaDisponivel(Sala sala, ArrayList<Integer> horarios) {
        for (Integer horario : horarios) {
            if (!this.salaDisponivel(sala, horario)) {
                return false; // se falhar para qualquer um dos horarios, retoran false
            }
        }
        return true;
    }

    public boolean alocar(Turma turma, Sala sala) {
        if (turma.acessivel && !sala.acessivel) {
            return false;
        }
        if (turma.numAlunos > sala.capacidade) {
            return false;
        }
        if (!this.salaDisponivel(sala, turma.horarios)) {
            return false;
        }

        // se tudo tiver ok cria e adiciona alocacao
        TurmaEmSala novaAlocacao = new TurmaEmSala(turma, sala);
        this.ensalamento.add(novaAlocacao);
        return true;
    }

    public void alocarTodas() { // arrumando o metodo para tentar melhorar a otimizacao do codigo
        // criacao de copias pra nao alterar a ordem da lista original
        ArrayList<Turma> turmasOrdenadas = new ArrayList<>(this.turmas);
        ArrayList<Sala> salasOrdenadas = new ArrayList<>(this.salas);

        // ordenacao das turmas em ordem descrescente do num de alunos
        turmasOrdenadas.sort(Comparator.comparingInt(t -> ((Turma)t).numAlunos).reversed());

        // ordenacao das salas em ordem crescente da capacidade
        salasOrdenadas.sort(Comparator.comparingInt(s -> ((Sala)s).capacidade));

        // iteracao, turmas maiores primeiro e tenta encontrar a menor sala
        for (Turma turma : turmasOrdenadas) {
            // se a turma ja foi alocada ele pula pra proxima
            if (this.getSala(turma) != null) {
                continue;
            }

            // iteracao, salas menores primeiro
            for (Sala sala : salasOrdenadas) {
                if (this.alocar(turma, sala)) {
                    // se ele aloca, entao foi encontrada a melhor sala, que no caso eh a menor possivel.
                    // entao ele para de procurar sala pra essa turma e vai pra proxima
                    break; // desculpa professor :(
                }
            }
        }
    }

    public int getTotalTurmasAlocadas() {
        return this.ensalamento.size();
    }

    public int getTotalEspacoLivre() {
        int espacoLivreTotal = 0;
        for (TurmaEmSala tes : this.ensalamento) {
            espacoLivreTotal += (tes.sala.capacidade - tes.turma.numAlunos);
        }
        return espacoLivreTotal;
    }

    public String relatorioResumoEnsalamento() {
        return String.format(
            "Total de Salas: %d\n" +
            "Total de Turmas: %d\n" +
            "Turmas Alocadas: %d\n" +
            "Espaços Livres: %d",
            this.salas.size(),
            this.turmas.size(),
            this.getTotalTurmasAlocadas(),
            this.getTotalEspacoLivre()
        );
    }
    
    public String relatorioTurmasPorSala() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append(relatorioResumoEnsalamento()).append("\n");

        for (Sala s : this.salas) {
            relatorio.append("\n--- ").append(s.getDescricao()).append(" ---\n\n");
            boolean salaTemTurma = false;
            for (TurmaEmSala tes : this.ensalamento) {
                if (tes.sala == s) {
                    relatorio.append(tes.turma.getDescricao()).append("\n\n");
                    salaTemTurma = true;
                }
            }
            if (!salaTemTurma) {

            }
        }
        return relatorio.toString();
    }

    public String relatorioSalasPorTurma() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append(relatorioResumoEnsalamento()).append("\n");

        for (Turma t : this.turmas) {
            relatorio.append("\n").append(t.getDescricao()).append("\n");
            Sala salaAlocada = this.getSala(t);

            if (salaAlocada != null) {
                relatorio.append("Sala: ").append(salaAlocada.getDescricao()).append("\n");
            } else {
                relatorio.append("Sala: SEM SALA\n");
            }
        }
        return relatorio.toString();
    }
}
