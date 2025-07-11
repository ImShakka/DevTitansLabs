import java.util.ArrayList;
import java.util.Collections;
import java.util.StringJoiner;

public class Turma {

    public String nome;
    public String professor;
    public int numAlunos;
    public boolean acessivel;
    public ArrayList<Integer> horarios;

    public Turma() {
        this.nome = "";
        this.professor = "";
        this.numAlunos = 0;
        this.acessivel = false;
        this.horarios = new ArrayList<>();
    }

    public Turma(String nome, String professor, int numAlunos, boolean acessivel) {
        this.nome = nome;
        this.professor = professor;
        this.numAlunos = numAlunos;
        this.acessivel = acessivel;
        this.horarios = new ArrayList<>();
    }

    public void addHorario(int horario) {
        this.horarios.add(horario);
    }

    public String getHorariosString() {
        if (horarios.isEmpty()) {
            return "";
        }
        
        Collections.sort(this.horarios);

        StringJoiner joiner = new StringJoiner(", ");
        
        for (Integer codigo : this.horarios) {
            String descricaoHorario;
            
            switch (codigo) {
                case 1: descricaoHorario = "segunda 8hs"; break;
                case 2: descricaoHorario = "segunda 10hs"; break;
                case 3: descricaoHorario = "segunda 12hs"; break;
                case 4: descricaoHorario = "segunda 14hs"; break;
                case 5: descricaoHorario = "segunda 16hs"; break;
                case 6: descricaoHorario = "segunda 18hs"; break;
                case 7: descricaoHorario = "segunda 20hs"; break;
                case 8: descricaoHorario = "terça 8hs"; break;
                case 9: descricaoHorario = "terça 10hs"; break;
                case 10: descricaoHorario = "terça 12hs"; break;
                case 11: descricaoHorario = "terça 14hs"; break;
                case 12: descricaoHorario = "terça 16hs"; break;
                case 13: descricaoHorario = "terça 18hs"; break;
                case 14: descricaoHorario = "terça 20hs"; break;
                case 15: descricaoHorario = "quarta 8hs"; break;
                case 16: descricaoHorario = "quarta 10hs"; break;
                case 17: descricaoHorario = "quarta 12hs"; break;
                case 18: descricaoHorario = "quarta 14hs"; break;
                case 19: descricaoHorario = "quarta 16hs"; break;
                case 20: descricaoHorario = "quarta 18hs"; break;
                case 21: descricaoHorario = "quarta 20hs"; break;
                case 22: descricaoHorario = "quinta 8hs"; break;
                case 23: descricaoHorario = "quinta 10hs"; break;
                case 24: descricaoHorario = "quinta 12hs"; break;
                case 25: descricaoHorario = "quinta 14hs"; break;
                case 26: descricaoHorario = "quinta 16hs"; break;
                case 27: descricaoHorario = "quinta 18hs"; break;
                case 28: descricaoHorario = "quinta 20hs"; break;
                case 29: descricaoHorario = "sexta 8hs"; break;
                case 30: descricaoHorario = "sexta 10hs"; break;
                case 31: descricaoHorario = "sexta 12hs"; break;
                case 32: descricaoHorario = "sexta 14hs"; break;
                case 33: descricaoHorario = "sexta 16hs"; break;
                case 34: descricaoHorario = "sexta 18hs"; break;
                case 35: descricaoHorario = "sexta 20hs"; break;
                default: descricaoHorario = "horário invalido"; break;
            }
            joiner.add(descricaoHorario);
        }

        return joiner.toString();
    }

    public String getDescricao() {
        String textoAcessivel = this.acessivel ? "sim" : "não";

        return "Turma: " + this.nome + "\n" +
               "Professor: " + this.professor + "\n" +
               "Número de Alunos: " + this.numAlunos + "\n" +
               "Horário: " + getHorariosString() + "\n" +
               "Acessível: " + textoAcessivel;
    }
    
}