package by.ibrel.kitan.web.controllers.logic;

import by.ibrel.kitan.Const;
import by.ibrel.kitan.logic.dao.logic.entity.Price;
import by.ibrel.kitan.logic.service.logic.dto.PriceDto;
import by.ibrel.kitan.logic.service.logic.impl.IPriceService;
import by.ibrel.kitan.web.controllers.AbstractController;
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


/**
 * @author ibrel
 * @version 1.2 (28.06.2016)
 */
@Controller
@RequestMapping("/configuration/price")
public class PriceController extends AbstractController<Price> {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    public PriceController(IPriceService priceService) {
        super(priceService);
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listPrice(ModelMap model) {
        return listEntity(model,"price.list");
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String updatePrice(@Valid Price price, final BindingResult result, final ModelMap model){
        return update(price,result,model, Const.PRICE_LIST_PAGE);
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String initFormPrice(@PathVariable Long id, ModelMap model) {
        return initForm(id,model,null,Const.PRICE_EDIT_PAGE);
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String addPrice(@Valid final PriceDto priceDto, ModelMap modelMap){
        Object o = priceDto;
        return create(o,modelMap,listPrice(modelMap));
    }
}