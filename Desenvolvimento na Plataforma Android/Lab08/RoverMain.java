package br.edu.ufam.icomp.lab_excecoes;

public class RoverMain {

    public static void main(String[] args) {

        Caminho caminhoDoRover = new Caminho(5);

        try {
            caminhoDoRover.addCoordenada(new Coordenada(10, 20, 0));
            System.out.println("...Coordenada recebida e aceita.");

            caminhoDoRover.addCoordenada(new Coordenada(20, 30, 0));
            System.out.println("...Coordenada recebida e aceita.");

            System.out.println("\n[Comando 3] Adicionando coordenada (5, -10)...");
            caminhoDoRover.addCoordenada(new Coordenada(5, -10, 5));
            
            System.out.println("\n[Comando 4] Adicionando coordenada (60, 60)...");
            caminhoDoRover.addCoordenada(new Coordenada(60, 60, 2));


        } catch (RoverException e) {

            System.err.println("Erro: " + e.getMessage());

            caminhoDoRover.reset();
            System.out.println("\n-> o caminho do rover foi completamente limpo.");

        } finally {

            System.out.println("\n relatorio final");
            System.out.println(caminhoDoRover);
        }

    }
}