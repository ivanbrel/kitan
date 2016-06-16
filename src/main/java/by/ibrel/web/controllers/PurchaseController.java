package by.ibrel.web.controllers;

import by.ibrel.logic.entity.Client;
import by.ibrel.logic.entity.Product;
import by.ibrel.logic.entity.Purchase;
import by.ibrel.logic.repository.ProductRepository;
import by.ibrel.logic.repository.PurchaseRepository;
import by.ibrel.logic.service.IClientService;
import by.ibrel.logic.service.IProductService;
import by.ibrel.logic.service.IPurchaseService;
import org.hibernate.Hibernate;
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

@Controller
@RequestMapping("/")
public class PurchaseController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private IPurchaseService service;

    @Autowired
    private IClientService clientService;

    @Autowired
    private PurchaseRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IProductService productService;

    //API

    @RequestMapping(value = {"/purchase/list"}, method = RequestMethod.GET)
    public String listPurchases(ModelMap model) {
        LOGGER.debug("!List all purchases");
        Collection<Purchase> purchases = service.allPurchase();
        model.addAttribute("purchases", purchases);
        return "purchase.list";
    }

    //add new purchase
    @RequestMapping(value = {"/purchase/add/{id}"}, method = RequestMethod.GET)
    public String addPurchase(@PathVariable Long id, final ModelMap model){

        LOGGER.debug("!Add new purchase for client with ID - " + id);

        final Client client = clientService.findById(id);

        service.createPurchase(client);

        model.addAttribute("success");
        return "redirect:/purchase/list";
    }


    //add product
    @RequestMapping(value = {"/purchase/sell/{id}"}, method = RequestMethod.POST)
    public String sellProduct(@Valid  Purchase purchase, BindingResult result,ModelMap modelMap){

        if (result.hasErrors()){
            LOGGER.debug("!ERROR! data is not correct! ");
            return "redirect:/purchase/list";
        }
        service.sellProduct(purchase);

        modelMap.addAttribute("success", "Product success sell");
        LOGGER.debug("!Product sell successfuly!");
        return "redirect:/purchase/list";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(List.class,"products", new CustomCollectionEditor(List.class){

            @Override
            protected Object convertElement(Object element) {
                Long id = Long.parseLong(element.toString());
                Product product = productRepository.findOne(id);
                return product;
            }
        });

    }

    @RequestMapping(value = {"/purchase/sell/{id}"}, method = RequestMethod.GET)
    public String addProduct(@PathVariable("id") final Long id, ModelMap modelMap){

        final Purchase purchase = repository.findOne(id);

        modelMap.addAttribute("purchase", purchase);
        modelMap.addAttribute("edit", true);

        List<Product> productsList = productService.listAllProduct();

        modelMap.addAttribute("productsList", productsList);
        return "purchase.add.product";
    }

    @RequestMapping(value = {"/purchase/delete/{id}"}, method = RequestMethod.GET)
    public String deletePurchase(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/purchase/list";
    }
}
