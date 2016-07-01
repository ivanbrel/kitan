package by.ibrel.kitan.logic.exception;

/**
 * Created by ibrel on 13/05/16.
 */
public final class ClientExistsException extends RuntimeException {

    public ClientExistsException() {
    }

    public ClientExistsException(String s) {
        super(s);
    }

    public ClientExistsException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ClientExistsException(Throwable throwable) {
        super(throwable);
    }

    public ClientExistsException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
