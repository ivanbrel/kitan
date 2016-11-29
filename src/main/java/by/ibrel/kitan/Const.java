package by.ibrel.kitan;

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
    public static final String PATH_IMG = "/resources/img/";

    //start number for purchase
    public static final int START_NUMBER = 1;

    public static final double INIT_DOUBLE = 0.0;

    public static final int INIT_INT = 0;

    public static final int RANDOM_SEGMENT = 100_000;

    public final static String DEFAULT_PASS = "password";

    public final static String DEFAULT_ROLE = "ROLE_USER";

    public final static String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";

    public final static String CLIENT_LIST_PAGE = "client.list";
    public final static String CLIENT_EDIT_PAGE = "client.edit";
    public final static String PRICE_LIST_PAGE = "price.list";
    public final static String PRICE_EDIT_PAGE = "price.edit";
    public final static String USER_LIST_PAGE = "auth.user.list";
    public final static String USER_EDIT_PAGE = "auth.user.edit";
    public final static String PRODUCT_CATEGORY_LIST_PAGE = "product.category.list";
    public final static String PRODUCT_CATEGORY_EDIT_PAGE = "product.category.edit";
    public final static String PRODUCT_LIST_PAGE = "product.list";
    public final static String PRODUCT_EDIT_PAGE = "product.edit";

    public final static String PRODUCT_COLOR_LIST_PAGE = "product.color.list";
    public final static String PRODUCT_COLOR_EDIT_PAGE = "product.color.edit";

    public final static String REGISTRATION_URL = "/registration";
    public final static String LOGIN_EXISTS_CHECK = "/checkLogin";
    public final static String USER_EDIT_URL = "/user/edit";
    public final static String USER_DELETE_URL = "/user/delete";
    public final static String UPDATE_PASSWORD_URL = "/update/password";
    public final static String CHANGE_PASSWORD_URL = "/user/change-password";
}
