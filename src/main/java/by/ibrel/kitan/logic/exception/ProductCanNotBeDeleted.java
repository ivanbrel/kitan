package by.ibrel.kitan.logic.exception;

/**
 * @author ibrel
 * @version ${version} (26.08.2016)
 */
public class ProductCanNotBeDeleted extends Throwable {

    public ProductCanNotBeDeleted() {
    }

    public ProductCanNotBeDeleted(String message) {
        super(message);
    }
}
