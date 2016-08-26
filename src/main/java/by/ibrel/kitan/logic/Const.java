package by.ibrel.kitan.logic;

import org.springframework.stereotype.Component;


/**
 * Created by ibrel on 15/07/16.
 *
 * class containing constants
 */
@Component
public final class Const {

    //file image path
    public static final String ROOT = "/resources/img/upload";

    //start number for purchase
    public static final int START_NUMBER = 1;

    public static final double INIT_DOUBLE = 0.0;

    public static final int INIT_INT = 0;

    public static final int RANDOM_SEGMENT = 100_000;

    public final static String DEFAULT_PASS = "password";

    public final static String DEFAULT_ROLE = "ROLE_USER";

    public final static String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";

}
