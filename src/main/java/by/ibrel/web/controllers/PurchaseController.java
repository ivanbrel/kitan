package by.ibrel.web.controllers;

import by.ibrel.logic.entity.Purchase;
import by.ibrel.logic.service.IPurchaseService;
import by.ibrel.logic.service.PurchaseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/")
public class PurchaseController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private IPurchaseService service;

    //API

    @RequestMapping(value = {"/purchase/list"}, method = RequestMethod.GET)
    public String listPurchases(ModelMap model) {

        Collection<Purchase> purchases = service.allPurchase();
        model.addAttribute("purchases", purchases);
        return "purchase.list";
    }

    //add new purchase
    @RequestMapping(value = {"/purchase/add"}, method = RequestMethod.POST)
    public String addPurchase(@Valid final PurchaseDto purchaseDto, final ModelMap model){
        LOGGER.debug("Add new client with name:" + purchaseDto);

        service.createPurchase(purchaseDto);
        model.addAttribute("success");
        return "redirect:/purchase/list";
    }

}
