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
