
public class Conexao {

    String tipoPorta;
    int idProtocolo;
    int taxaTransmissao;

    public Conexao() {
    }

    public Conexao(String tipoPorta, int idProtocolo, int taxaTransmissao) {
        this.tipoPorta = tipoPorta;
        this.idProtocolo = idProtocolo;
        this.taxaTransmissao = taxaTransmissao;
    }

    public double getTaxaMBps() {
        return this.taxaTransmissao / 1024.0;
    }

    public String getProtocoloString() {
        switch (this.idProtocolo) {
            case 1:
                return "Rotoscope";
            case 2:
                return "Acustico";
            case 3:
                return "Radio";
            default:
                return "Outros";
        }
    }

    public String getDescricao() {
        return "Conexao: tipoPorta=" + this.tipoPorta +
               ", protocolo=" + this.getProtocoloString() +
               ", taxaTransmissao=" + this.getTaxaMBps() + "Mbps.";
    }
}