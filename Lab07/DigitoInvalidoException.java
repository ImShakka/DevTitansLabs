
public class DigitoInvalidoException extends RoverCoordenadaException {
    
    public DigitoInvalidoException() {
        super("Digito da coordenada inválido");
    }
    public DigitoInvalidoException(String message) {
    super(message); 
    }
}