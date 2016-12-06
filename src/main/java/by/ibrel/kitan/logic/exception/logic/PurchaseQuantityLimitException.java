package by.ibrel.kitan.logic.exception.logic;

/**
 * @author ibrel
 * @version 1.0 (25.08.2016)
 */
public final class PurchaseQuantityLimitException extends RuntimeException {
    public PurchaseQuantityLimitException() {
    }

    public PurchaseQuantityLimitException(String message) {
        super(message);
    }
}
