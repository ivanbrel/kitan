package by.ibrel.kitan.logic.exception.logic;

/**
 * @author ibrel
 * @version 1.0 (23/11/16)
 */
public final class ColorProductExceptions extends RuntimeException{

    public ColorProductExceptions() {
    }

    public ColorProductExceptions(String s) {
        super(s);
    }

    public ColorProductExceptions(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ColorProductExceptions(Throwable throwable) {
        super(throwable);
    }

    public ColorProductExceptions(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
