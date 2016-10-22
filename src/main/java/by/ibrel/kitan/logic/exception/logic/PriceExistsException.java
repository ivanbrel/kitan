package by.ibrel.kitan.logic.exception.logic;

/**
 * Created by ibrel on 28/06/16.
 */
public final class PriceExistsException extends RuntimeException{

    public PriceExistsException() {
    }

    public PriceExistsException(String s) {
        super(s);
    }

    public PriceExistsException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public PriceExistsException(Throwable throwable) {
        super(throwable);
    }

    public PriceExistsException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
