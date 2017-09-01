package multicert.exercicio.persistence;

public class TransactionException extends RuntimeException {

    public TransactionException(Throwable ex) {
        super(ex);
    }
}
