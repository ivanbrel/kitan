package by.ibrel.kitan.logic.exception;

/**
 * @author ibrel
 * @version 1.0 (25.08.2016)
 */
public class PurchaseQuantityLimitException extends Throwable {
    public PurchaseQuantityLimitException() {
    }

    public PurchaseQuantityLimitException(String message) {
        super(message);
    }
}
