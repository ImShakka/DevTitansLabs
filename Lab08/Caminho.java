package br.edu.ufam.icomp.lab_excecoes;

public class Caminho {

    private Coordenada[] caminho;
    private int tamanho;
    private int pontosAtuais;

    public Caminho(int maxTam) {

        this.tamanho = maxTam; 
        this.caminho = new Coordenada[maxTam];
        this.pontosAtuais = 0;
    }

    public int tamanho() {
        return this.pontosAtuais;
    }


    public void addCoordenada(Coordenada coordenada)
            throws TamanhoMaximoExcedidoException, DistanciaEntrePontosExcedidaException {

        if (this.pontosAtuais >= this.tamanho) {
            throw new TamanhoMaximoExcedidoException();
        }

        if (this.pontosAtuais > 0) {
            Coordenada ultimoPonto = this.caminho[this.pontosAtuais - 1];
            double distancia = ultimoPonto.distancia(coordenada);
            if (distancia > 15.0) {
                throw new DistanciaEntrePontosExcedidaException();
            }
        }

        this.caminho[this.pontosAtuais] = coordenada;
        this.pontosAtuais++;
    }

    public void reset() {
        this.pontosAtuais = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dados do caminho:\n");
        sb.append("  - Quantidade de pontos: ").append(this.tamanho()).append("\n");
        sb.append("  - Pontos:\n");

        for (int i = 0; i < this.pontosAtuais; i++) {
                sb.append("-> ").append(this.caminho[i].toString()).append("\n");
        }
        
        return sb.toString();
    }
}