package by.ibrel.kitan.logic.exception.auth;

/**
 * Created by ibrel on 05/07/16.
 */
public final class RoleExistsException extends Throwable {

    public RoleExistsException() {
    }

    public RoleExistsException(String s) {
        super(s);
    }

    public RoleExistsException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public RoleExistsException(Throwable throwable) {
        super(throwable);
    }

    public RoleExistsException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
