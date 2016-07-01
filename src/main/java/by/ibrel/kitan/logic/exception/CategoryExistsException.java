package by.ibrel.kitan.logic.exception;

/**
 * Created by ibrel on 13/05/16.
 */
public final class CategoryExistsException extends RuntimeException {

    public CategoryExistsException() {
    }

    public CategoryExistsException(String s) {
        super(s);
    }

    public CategoryExistsException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CategoryExistsException(Throwable throwable) {
        super(throwable);
    }

    public CategoryExistsException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
