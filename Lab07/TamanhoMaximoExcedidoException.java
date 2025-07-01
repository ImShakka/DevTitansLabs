
public class TamanhoMaximoExcedidoException extends RoverCaminhoException{
    public TamanhoMaximoExcedidoException() {
        super("Quantidade máxima de coordenadas excedida");
    }
    public TamanhoMaximoExcedidoException(String message) {
    super(message); 
    }
}
