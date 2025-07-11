public class AstromechMain {

    public static void main(String[] args) {
        
        System.out.println("--- Testando Classe Mestre ---");
        Mestre mestreLuke = new Mestre("Luke Skywalker", -19, "Alianca para Restauracao da Republica", "Jedi");
        System.out.println(mestreLuke.getDescricao());

        System.out.println("\n--- Testando Classe Sensor ---");
        Sensor sensorPrincipal = new Sensor("azul", 512.0, 24);
        System.out.println(sensorPrincipal.getDescricao());

        System.out.println("\n--- Testando Classe Conexao ---");
        Conexao conexaoScomp = new Conexao("SCOMP Link", 1, 524288000);
        System.out.println(conexaoScomp.getDescricao());
        Conexao conexaoAcustica = new Conexao("Hydrophone", 2, 13107200);
        System.out.println(conexaoAcustica.getDescricao());
          
        System.out.println("--- Criando componentes para o Droid Astromech ---");

        Mestre mestre = new Mestre("Luke Skywalker", -19, "Alianca para Restauracao da Republica", "Jedi");
        Sensor sensor = new Sensor("azul", 512.0, 24);
        Conexao conexao = new Conexao("SCOMP Link", 1, 4096000);

        System.out.println("\n--- Testando a Classe Astromech ---");

        Astromech r2d2 = new Astromech("R2-D2", mestre, sensor, conexao); 
        System.out.println(r2d2.getDescricao());

        Mestre mestreObiWan = new Mestre("Obi-Wan Kenobi", -57, "Ordem Jedi", "Jedi");
        Sensor sensorSecundario = new Sensor("vermelho", 120.0, 30);
        Conexao conexaoRadio = new Conexao("Antena de longo alcance", 3, 102400);
        Astromech r4p17 = new Astromech("R4-P17", mestreObiWan, sensorSecundario, conexaoRadio);
        System.out.println(r4p17.getDescricao());
    }
}