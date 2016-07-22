package by.ibrel.kitan.web.controllers;

import by.ibrel.kitan.logic.dao.entity.PriceConvert;
import by.ibrel.kitan.logic.service.impl.IPriceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


/**
 * Created by ibrel on 28/06/16.
 *
 */
@Controller
public class PriceController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private IPriceService service;


    @RequestMapping(value = {"/price/list"}, method = RequestMethod.GET)
    public String listPrice(ModelMap model) {
        List<PriceConvert> priceList = service.findAll();
        model.addAttribute("price", priceList);
        return "price.list";
    }


//
//    //add new product
//    @RequestMapping(value = {"/price/add"}, method = RequestMethod.POST)
//    public String addPrice(@Valid final PriceConvertDto priceDto, final ModelMap model) {
//
//        LOGGER.debug("Add new client with name:" + priceDto);
//
//        final PriceConvert add = createPrice(priceDto);
//        if (add==null){
//            throw new PriceExistsException();
//        }
//        model.addAttribute("success");
//        return "redirect:/price/list";
//    }
//
//    private PriceConvert createPrice(PriceConvertDto priceDto) {
//        PriceConvert add;
//        try{
//            add = service.addPrice(priceDto);
//        }catch (final PriceExistsException e){
//            return null;
//        }
//        return add;
//    }
//
//    @RequestMapping(value = {"/price/delete/{id}"}, method = RequestMethod.GET)
//    public String deletePrice(@PathVariable Long id) {
//
//        service.deletePrice(id);
//
//        return "redirect:/price/list";
//    }
//
//    //add price in product
//    @RequestMapping(value = {"/price/add/{id}"}, method = RequestMethod.POST)
//    public String addToProduct(@Valid  PriceConvert price, BindingResult result, ModelMap modelMap){
//
//        if (result.hasErrors()){
//            LOGGER.debug("FAIL! Data is not correct!");
//            return "redirect:/price/list";
//        }
//
//        service.addToProduct(price);
//
//        modelMap.addAttribute("success", "price success add");
//        LOGGER.debug("!Price add successfuly!");
//
//        return "redirect:/price/list";
//    }
//
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//
//        binder.registerCustomEditor(List.class,"price", new CustomCollectionEditor(List.class){
//
//            @Override
//            protected Object convertElement(Object element) {
//                Long id = Long.parseLong(element.toString());
//                PriceConvert price = repository.findOne(id);
//                return price;
//            }
//        });
//
//    }
//
//    @RequestMapping(value = {"/price/add/{id}"}, method = RequestMethod.GET)
//    public String priceToProduct(@PathVariable("id") final Long id, ModelMap modelMap){
//
//        final PriceConvert price = repository.findOne(id);
//
//        modelMap.addAttribute("price", price);
//
//        List<Product> productsList = productService.listAllProduct();
//
//        modelMap.addAttribute("productsList", productsList);
//        return "price.add.product";
//    }

    @RequestMapping(value = { "/price/edit/{id}" }, method = RequestMethod.POST)
    public String updatePrice(@Valid PriceConvert p, final BindingResult result, final ModelMap model){
        if (result.hasErrors()){return "price.edit";}
        service.updatePrice(p);
        model.addAttribute("success", "Данные " + p.getId() + " изменены");
        return "redirect:/price/list";
    }

    @RequestMapping(value = { "/price/edit/{id}" }, method = RequestMethod.GET)
    public String editPrice(@PathVariable Long id, ModelMap model) {

        final PriceConvert price = service.getPriceById(id);

        model.addAttribute("price", price);

        return "price.edit";
    }
}
