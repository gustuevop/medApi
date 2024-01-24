package med.voll.api.domain.exceptions;

public class PacienteInexistenteException extends RuntimeException {
    public PacienteInexistenteException(String mensagem) {
        super(mensagem);
    }
}
