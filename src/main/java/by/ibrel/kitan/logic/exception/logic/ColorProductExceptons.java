package by.ibrel.kitan.logic.exception.logic;

/**
 * @author ibrel
 * @version 1.0 (23/11/16)
 */
public final class ColorProductExceptons extends RuntimeException{

    public ColorProductExceptons() {
    }

    public ColorProductExceptons(String s) {
        super(s);
    }

    public ColorProductExceptons(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ColorProductExceptons(Throwable throwable) {
        super(throwable);
    }

    public ColorProductExceptons(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
