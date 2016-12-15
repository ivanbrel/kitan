package by.ibrel.kitan.web.controllers.logic;

import by.ibrel.kitan.logic.dao.auth.entity.User;
import by.ibrel.kitan.logic.dao.logic.entity.Price;
import by.ibrel.kitan.logic.dao.logic.entity.Product;
import by.ibrel.kitan.logic.dao.logic.entity.ShoppingCart;
import by.ibrel.kitan.logic.exception.logic.PurchaseQuantityLimitException;
import by.ibrel.kitan.logic.service.auth.impl.IUserService;
import by.ibrel.kitan.logic.service.logic.impl.IPriceService;
import by.ibrel.kitan.logic.service.logic.impl.IProductService;
import by.ibrel.kitan.logic.service.logic.impl.IPurchaseHistoryService;
import by.ibrel.kitan.logic.service.logic.impl.IShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

/**
 * @author ibrel
 * @version 1.2 (26.06.2016)
 */

@Controller
@RequestMapping("/")
public class ShoppingCartController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private IShoppingCartService service;
    private IUserService userService;
    private IProductService productService;
    private IPurchaseHistoryService purchaseHistoryService;
    private IPriceService priceService;
    private MessageSource message;

    @Autowired
    public ShoppingCartController(IShoppingCartService service, IUserService userService, IProductService productService,
                                  IPurchaseHistoryService purchaseHistoryService, IPriceService priceService, MessageSource message) {
        this.service = service;
        this.userService = userService;
        this.productService = productService;
        this.purchaseHistoryService = purchaseHistoryService;
        this.priceService = priceService;
        this.message = message;
    }

    //API

    @RequestMapping(value = {"/cart/list"}, method = RequestMethod.GET)
    public String listPurchases(ModelMap model) {
        LOGGER.debug("List all purchases");
        Collection<ShoppingCart> orderDetailses = service.findAll();
        model.addAttribute("cart", orderDetailses);
        Collection<Price> priceList = priceService.findAll();
        model.addAttribute("price", priceList);
        return "cart.list";
    }

    //add new purchase
    @RequestMapping(value = {"/cart/create/{clientId}"}, method = RequestMethod.GET)
    public String createPurchase(@PathVariable Long clientId, final ModelMap model){

        final User user = userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        ShoppingCart shoppingCart = service.create(clientId, user);

        model.addAttribute("cart", shoppingCart);
        model.addAttribute("history", purchaseHistoryService.listHistory(shoppingCart.getId()));
        LOGGER.debug("Add new purchase for client with ID - " + clientId);
        return "cart.show";
    }

    //add product
    @RequestMapping(value = {"/cart/sell/{id}"}, method = RequestMethod.POST)
    public String sellProduct(@Valid ShoppingCart shoppingCart, @Valid Integer count, BindingResult result, ModelMap model) throws Exception {

        final User user = userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());

        if (result.hasErrors()){
            LOGGER.debug(message.getMessage("error.incorrectdata",null,Locale.getDefault()));
            return "redirect:/cart/list";
        }
        try {
            service.sellProduct(shoppingCart, count, user.getLastName());
        }catch (PurchaseQuantityLimitException e) {
            model.addAttribute("fail",true);

            ShoppingCart p = service.findOne(shoppingCart.getId());
            model.addAttribute("cart", p);
            model.addAttribute("history", purchaseHistoryService.listHistory(shoppingCart.getId()));
            LOGGER.debug(message.getMessage("exception.message.limitquantity",null, Locale.getDefault()));
            return "cart.show";
        }

        model.addAttribute("success", "Product success sell");

        ShoppingCart p = service.findOne(shoppingCart.getId());
        model.addAttribute("cart", p);

        LOGGER.debug("Product sell successfully!");
        model.addAttribute("history", purchaseHistoryService.listHistory(shoppingCart.getId()));

        return "cart.show";
    }

    @RequestMapping(value = {"/cart/sell/{id}"}, method = RequestMethod.GET)
    public String addProductToPurchase(@PathVariable final Long id, ModelMap modelMap){

        final ShoppingCart shoppingCart = service.findOne(id);

        modelMap.addAttribute("cart", shoppingCart);

        List<Product> productsList = productService.findAll();
        modelMap.addAttribute("productsList", productsList);

        return "cart.add.product";
    }

    @RequestMapping(value = {"/cart/delete/{id}"}, method = RequestMethod.GET)
    public String deletePurchase(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/cart/list";
    }

    @RequestMapping(value = {"/cart/status/{idCart}"}, method = RequestMethod.GET)
    public String changeStatus(@PathVariable("idCart") Long idCart, ModelMap model){

        final ShoppingCart shoppingCart = service.findOne(idCart);
        shoppingCart.changeStatusFormed(shoppingCart);

        model.addAttribute("cart", shoppingCart);
        model.addAttribute("history", purchaseHistoryService.listHistory(shoppingCart.getId()));

        return cartReport(idCart,model);
    }

    @RequestMapping(value = { "/cart/edit/{id}" }, method = RequestMethod.POST)
    public String updateProduct(@Valid ShoppingCart shoppingCart, final BindingResult result, final ModelMap model){
        if (result.hasErrors()){
            model.addAttribute("fail", "");
            return "cart.edit";
        }

        service.update(shoppingCart);

        model.addAttribute("success", "Данные " + shoppingCart.getId() + " изменены");
        return "redirect:/cart/list";
    }

    @RequestMapping(value = { "/cart/edit/{id}" }, method = RequestMethod.GET)
    public String editProduct(@PathVariable Long id, ModelMap model) {

        final ShoppingCart shoppingCart = service.findOne(id);
        model.addAttribute("cart", shoppingCart);
        return "cart.edit";
    }

    @RequestMapping(value = {"/cart/{idCart}"}, method = RequestMethod.GET)
    public String cart(@PathVariable("idCart") Long idCart, ModelMap model){

        final ShoppingCart shoppingCart = service.findOne(idCart);

        model.addAttribute("cart", shoppingCart);
        model.addAttribute("history", purchaseHistoryService.listHistory(shoppingCart.getId()));

        return "cart.show";
    }

    @RequestMapping(value = {"/cart/delete/product/{cartId}/{historyId}/{productId}"}, method = RequestMethod.GET)
    public String deleteProductFromCart(@PathVariable("cartId") Long cartId,
                                        @PathVariable("historyId") Long historyId,
                                        @PathVariable("productId") Long productId, ModelMap model){

        service.deleteProductFromCart(cartId, historyId, productId);

        final ShoppingCart shoppingCart = service.findOne(cartId);

        model.addAttribute("cart", shoppingCart);
        model.addAttribute("history", purchaseHistoryService.listHistory(shoppingCart.getId()));

        return "cart.show";
    }

    @RequestMapping(value = {"/cart/report/{idCart}"}, method = RequestMethod.GET)
    public String cartReport(@PathVariable("idCart") Long idCart, ModelMap model){
        ShoppingCart shoppingCart = service.findOne(idCart);
        model.addAttribute("cart", shoppingCart);
        model.addAttribute("history", purchaseHistoryService.listHistory(shoppingCart.getId()));
        return "cart.report";
    }
}
