package by.ibrel.kitan.web.controllers;

import by.ibrel.kitan.logic.dao.entity.PriceConvert;
import by.ibrel.kitan.logic.dao.entity.ShoppingCart;
import by.ibrel.kitan.logic.dao.entity.Product;
import by.ibrel.kitan.logic.service.impl.IPriceService;
import by.ibrel.kitan.logic.service.impl.IProductService;
import by.ibrel.kitan.logic.service.impl.IPurchaseHistoryService;
import by.ibrel.kitan.logic.service.impl.IShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * @author ibrel
 * @version 1.1 (26.06.2016)
 */

@Controller
@RequestMapping("/")
public class ShoppingCartController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private IShoppingCartService service;

    @Autowired
    private IProductService productService;

    @Autowired
    private IPurchaseHistoryService purchaseHistoryService;

    @Autowired
    private IPriceService priceService;

    //API

    @RequestMapping(value = {"/cart/list"}, method = RequestMethod.GET)
    public String listPurchases(ModelMap model) {
        LOGGER.debug("!List all purchases");
        Collection<ShoppingCart> orderDetailses = service.findAll();
        model.addAttribute("cart", orderDetailses);
        List<PriceConvert> priceList = priceService.findAll();
        model.addAttribute("price", priceList);
        return "cart.list";
    }

    //add new purchase
    @RequestMapping(value = {"/cart/create/{clientId}"}, method = RequestMethod.GET)
    public String createPurchase(@PathVariable Long clientId, final ModelMap model){
        LOGGER.debug("!Add new purchase for client with ID - " + clientId);

        ShoppingCart shoppingCart = service.createCart(clientId);
        model.addAttribute("cart", shoppingCart);
        model.addAttribute("history", purchaseHistoryService.listHistory(shoppingCart.getId()));
        return "cart.show";
    }

    //add product
    @RequestMapping(value = {"/cart/sell/{id}"}, method = RequestMethod.POST)
    public String sellProduct(@Valid ShoppingCart shoppingCart, @Valid Integer count, BindingResult result, ModelMap model) throws Exception {

        if (result.hasErrors()){
            LOGGER.debug("data is not correct! ");
            return "redirect:/cart/list";
        }
        service.sellProduct(shoppingCart, count);

        model.addAttribute("success", "Product success sell");

        ShoppingCart p = service.findOne(shoppingCart.getId());
        model.addAttribute("cart", p);

        LOGGER.debug("!Product sell successfuly!");

        model.addAttribute("history", purchaseHistoryService.listHistory(shoppingCart.getId()));

        return "cart.show";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(List.class,"products", new CustomCollectionEditor(List.class){

            @Override
            protected Object convertElement(Object element) {
                Long id = Long.parseLong(element.toString());
                return productService.findOne(id);
            }
        });

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

//    //check count purchase
//    @RequestMapping(value = "/checkCount", method = RequestMethod.POST)
//    public @ResponseBody boolean handlerRequest(final HttpServletRequest request) throws Exception {
//
//        Product product = null;
//        Integer count = 0;
//        try {
//            count = Integer.parseInt(request.getParameter("count"));
//            //product = productRepository.findOne(Long.getLong(request.getParameter("idProduct")));
//        }catch (Exception e){
//            throw new Exception(e);
//        }
//
//        boolean flag = true;
//
//        if (10<count) flag = false;
//
//        return flag;
//    }

    @RequestMapping(value = {"/cart/status/{idCart}"}, method = RequestMethod.GET)
    public String changeStatus(@PathVariable("idCart") Long idCart, ModelMap model){

        service.changeStatus(idCart);

        final ShoppingCart shoppingCart = service.findOne(idCart);

        model.addAttribute("cart", shoppingCart);
        model.addAttribute("history", purchaseHistoryService.listHistory(shoppingCart.getId()));

        return "cart.show";
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
}
