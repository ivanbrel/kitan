package by.ibrel.kitan.logic.exception.auth;

/**
 * Created by ibrel on 12.04.2016.
 */
public final class LoginExistsException extends Throwable{

    public LoginExistsException() {
    }

    public LoginExistsException(final String message) {
        super(message);
    }

    public LoginExistsException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public LoginExistsException(final Throwable cause) {
        super(cause);
    }

    public LoginExistsException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
