package by.ibrel.kitan.web.controllers;

import by.ibrel.kitan.logic.dao.entity.Price;
import by.ibrel.kitan.logic.dao.entity.Product;
import by.ibrel.kitan.logic.dao.repository.PriceRepository;
import by.ibrel.kitan.logic.exception.PriceExistsException;
import by.ibrel.kitan.logic.service.impl.IPriceService;
import by.ibrel.kitan.logic.service.dto.PriceDto;

import by.ibrel.kitan.logic.service.impl.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ibrel on 28/06/16.
 */
@Controller
public class PriceController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private IPriceService service;

    @Autowired
    private PriceRepository repository;

    @Autowired
    private IProductService productService;

    @RequestMapping(value = {"/price/list"}, method = RequestMethod.GET)
    public String listPrice(ModelMap model) {
        List<Price> priceList = service.allPrice();
        model.addAttribute("price", priceList);
        return "price.list";
    }

    //add new product
    @RequestMapping(value = {"/price/add"}, method = RequestMethod.POST)
    public String addPrice(@Valid final PriceDto priceDto, final ModelMap model) {

        LOGGER.debug("Add new client with name:" + priceDto);

        final Price add = createPrice(priceDto);
        if (add==null){
            throw new PriceExistsException();
        }
        model.addAttribute("success");
        return "redirect:/price/list";
    }

    private Price createPrice(PriceDto priceDto) {
        Price add;
        try{
            add = service.addPrice(priceDto);
        }catch (final PriceExistsException e){
            return null;
        }
        return add;
    }

    @RequestMapping(value = {"/price/delete/{id}"}, method = RequestMethod.GET)
    public String deletePrice(@PathVariable Long id) {

        service.deletePrice(id);

        return "redirect:/price/list";
    }

    //TODO edit controller

    //add price in product
    @RequestMapping(value = {"/price/add/{id}"}, method = RequestMethod.POST)
    public String addPrice(@Valid  Price price, BindingResult result, ModelMap modelMap){

        if (result.hasErrors()){
            LOGGER.debug("FAIL! Data is not correct!");
            return "redirect:/price/list";
        }

        service.addToProduct(price);

        modelMap.addAttribute("success", "price success add");
        LOGGER.debug("!Price add successfuly!");

        return "redirect:/price/list";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(List.class,"price", new CustomCollectionEditor(List.class){

            @Override
            protected Object convertElement(Object element) {
                Long id = Long.parseLong(element.toString());
                Price price = repository.findOne(id);
                return price;
            }
        });

    }

    @RequestMapping(value = {"/price/add/{id}"}, method = RequestMethod.GET)
    public String addPrice(@PathVariable("id") final Long id, ModelMap modelMap){

        final Price price = repository.findOne(id);

        modelMap.addAttribute("price", price);

        List<Product> productsList = productService.listAllProduct();

        modelMap.addAttribute("productsList", productsList);
        return "price.add.product";
    }
}
