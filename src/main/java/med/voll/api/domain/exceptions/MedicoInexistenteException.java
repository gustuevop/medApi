package med.voll.api.domain.exceptions;

public class MedicoInexistenteException extends RuntimeException {
    public MedicoInexistenteException(String mensagem) {
        super(mensagem);
    }
}
