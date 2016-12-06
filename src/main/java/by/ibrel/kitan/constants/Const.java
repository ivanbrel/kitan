package by.ibrel.kitan.constants;

import org.springframework.stereotype.Component;


/**
 * Created by ibrel on 15/07/16.
 *
 * class containing constants
 */
@Component
public final class Const {

    //file image path
    public static final String DEFAULT_IMG = "/resources/img/logo.png";
    public static final String DEFAULT_AVATAR = "user.png";
    
    //start number for purchase
    public static final int START_NUMBER = 1;
    public static final int INIT_INT = 0;
    public final static String DEFAULT_PASS = "password";
    public final static String DEFAULT_ROLE = "ROLE_USER";
    public static final String HASH_STRATEGY = "MD5";
    public static final String ENCODING = "UTF-8";

}
