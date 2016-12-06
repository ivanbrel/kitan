package by.ibrel.kitan.config.tiles;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.request.Request;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static by.ibrel.kitan.constants.PageConstants.*;
import static by.ibrel.kitan.constants.PathPageConstants.*;

/**
 * @author ibrel
 * @version 1.0
 * @email ibrel7n@gmail.com
 * @datecreate (05.12.2016)
 * @datechange (05.12.2016)
 */
@Component
public class TilesDefinitionsConfig implements DefinitionsFactory {

    private static final Map<String, Definition> tilesDefinitions = new HashMap<>();
    private static final Attribute BASE_TEMPLATE = new Attribute(BASE_TEMPLATE_JSP);
    private static final Attribute ERROR_TEMPLATE = new Attribute(ERROR_TEMPLATE_JSP);
    private static final Attribute LOGIN_PAGE_JSP = new Attribute(LOGIN_JSP);


    @Override
    public Definition getDefinition(String name, Request tilesContext) {
        return tilesDefinitions.get(name);
    }

    /**
     * @param name Name of the view
     * @param title Page title
     * @param body Body JSP file path
     *
     * Adds default layout definitions (kitan.main)
     */
    private static void addDefaultLayoutDef(String name, String title, String body) {
        Map<String, Attribute> attributes = new HashMap<>();

        attributes.put("titleKey", new Attribute(title));
        attributes.put("inHeader", new Attribute(IN_HEADER_JSP));
        attributes.put("header", new Attribute(HEADER_JSP));
        attributes.put("content", new Attribute(body));
        attributes.put("footer", new Attribute(FOOTER_JSP));

        tilesDefinitions.put(name, new Definition(name, BASE_TEMPLATE, attributes));
    }

    private static void addErrorLayoutDef(String name, String body) {
        Map<String, Attribute> attributes = new HashMap<>();

        attributes.put("inHeader", new Attribute(IN_HEADER_ERROR_JSP));
        attributes.put("content", new Attribute(body));

        tilesDefinitions.put(name, new Definition(name, ERROR_TEMPLATE, attributes));
    }

    /**
     * Add Apache tiles definitions<
     */
    static void addDefinitions(MessageSource messages){

        Locale locale = Locale.getDefault();

//        login page
        tilesDefinitions.put(LOGIN_PAGE, new Definition(LOGIN_PAGE, LOGIN_PAGE_JSP, null));

        addDefaultLayoutDef(HOME_PAGE, messages.getMessage("title.name.main", null, locale), HOME_JSP);
        addDefaultLayoutDef(CONTACTS_PAGE, messages.getMessage("title.name.contacts",null,locale), CONTACTS_JSP);
        addDefaultLayoutDef(ABOUT_PAGE, messages.getMessage("title.name.about",null,locale), ABOUT_JSP);
        addDefaultLayoutDef(REF_PAGE, messages.getMessage("title.name.ref",null,locale), REF_JSP);
        addDefaultLayoutDef(HELP_PAGE, messages.getMessage("title.name.help",null,locale), HELP_JSP);

//        user page
        addDefaultLayoutDef(USER_LIST_PAGE, messages.getMessage("title.name.listUsers",null,locale), USER_LIST_JSP);
        addDefaultLayoutDef(USER_EDIT_PAGE, messages.getMessage("title.name.editUser",null,locale), USER_EDIT_JSP);

//        role page
        addDefaultLayoutDef(ROLE_LIST_PAGE, messages.getMessage("title.name.roleList",null,locale), ROLE_LIST_JSP);
        addDefaultLayoutDef(ROLE_EDIT_PAGE, messages.getMessage("title.name.roleEdit",null,locale), ROLE_EDIT_JSP);

//        client page
        addDefaultLayoutDef(CLIENT_LIST_PAGE, messages.getMessage("title.name.clientList",null,locale), CLIENT_LIST_JSP);
        addDefaultLayoutDef(CLIENT_ADD_PAGE, messages.getMessage("title.name.clientAdd",null,locale), CLIENT_ADD_JSP);
        addDefaultLayoutDef(CLIENT_EDIT_PAGE, messages.getMessage("title.name.clientEdit",null,locale), CLIENT_EDIT_JSP);

//        product pages
        addDefaultLayoutDef(PRODUCT_LIST_PAGE, messages.getMessage("title.name.productList",null,locale), PRODUCT_LIST_JSP);
        addDefaultLayoutDef(PRODUCT_ADD_PAGE, messages.getMessage("title.name.productAdd",null,locale), PRODUCT_ADD_JSP);
        addDefaultLayoutDef(PRODUCT_EDIT_PAGE, messages.getMessage("title.name.productEdit",null,locale), PRODUCT_EDIT_JSP);

//        purchase page
        addDefaultLayoutDef(CART_LIST_PAGE, messages.getMessage("title.name.cartList",null,locale), CART_LIST_JSP);
        addDefaultLayoutDef(CART_ADD_PRODUCT_PAGE, messages.getMessage("title.name.cartAdd",null,locale), CART_ADD_JSP);
        addDefaultLayoutDef(CART_SHOW_PAGE, messages.getMessage("title.name.cartShow",null,locale), CART_SHOW_JSP);
        addDefaultLayoutDef(CART_EDIT_PAGE, messages.getMessage("title.name.cartEdit",null,locale), CART_EDIT_JSP);
        addDefaultLayoutDef(CART_REPORT_PAGE, messages.getMessage("title.name.cartReport",null,locale), CART_REPORT_JSP);

//        price page
        addDefaultLayoutDef(PRICE_LIST_PAGE, messages.getMessage("title.name.priceList",null,locale), PRICE_LIST_JSP);
        addDefaultLayoutDef(PRICE_EDIT_PAGE, messages.getMessage("title.name.priceEdit",null,locale), PRICE_EDIT_JSP);


//        product catalog
        addDefaultLayoutDef(PRODUCT_CATEGORY_LIST_PAGE, messages.getMessage("title.name.productCategoryList",null,locale), PRODUCT_CATEGORY_LIST_JSP);
        addDefaultLayoutDef(PRODUCT_CATEGORY_EDIT_PAGE, messages.getMessage("title.name.productCategoryEdit",null,locale), PRODUCT_CATEGORY_EDIT_JSP);

//        product color
        addDefaultLayoutDef(PRODUCT_COLOR_LIST_PAGE, messages.getMessage("title.name.productColorList",null,locale), PRODUCT_COLOR_LIST_JSP);
        addDefaultLayoutDef(PRODUCT_COLOR_EDIT_PAGE, messages.getMessage("title.name.productColorEdit",null,locale), PRODUCT_COLOR_EDIT_JSP);

//        error page
        addErrorLayoutDef(ERROR_403_PAGE, ERROR_403_JSP);
        addErrorLayoutDef(ERROR_404_PAGE, ERROR_404_JSP);
        addErrorLayoutDef(ERROR_405_PAGE, ERROR_405_JSP);
        addErrorLayoutDef(ERROR_TRACE_PAGE, ERROR_TRACE_JSP);
    }

}
