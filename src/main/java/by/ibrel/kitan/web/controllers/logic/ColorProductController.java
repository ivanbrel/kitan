package by.ibrel.kitan.web.controllers.logic;

import by.ibrel.kitan.logic.dao.logic.entity.ColorProduct;
import by.ibrel.kitan.logic.service.logic.dto.ColorProductDto;
import by.ibrel.kitan.logic.service.logic.impl.IColorProductService;
import by.ibrel.kitan.web.controllers.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import static by.ibrel.kitan.Const.PRODUCT_COLOR_EDIT_PAGE;
import static by.ibrel.kitan.Const.PRODUCT_COLOR_LIST_PAGE;

/**
 * @author ibrel
 * @version 1.0 (23/11/16)
 */
@Controller
@RequestMapping("/configuration/product-color")
public class ColorProductController extends AbstractController<ColorProduct>{

    @Autowired
    public ColorProductController(IColorProductService service) {
        super(service);
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listColorProduct(ModelMap modelMap){
        return listEntity(modelMap,PRODUCT_COLOR_LIST_PAGE);
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String createProductColor(@Valid final ColorProductDto colorProductDto, final ModelMap modelMap){
        return create(colorProductDto,modelMap,listColorProduct(modelMap));
    }

    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
    public String deleteProductColor(@PathVariable Long id, ModelMap modelMap){
        return deleteEntity(id,modelMap,listColorProduct(modelMap));
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public String initFormProductColor(@PathVariable Long id, ModelMap modelMap){
        return initForm(id,modelMap,null,PRODUCT_COLOR_EDIT_PAGE);
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.POST)
    public String updateProductColor(ModelMap modelMap, @Valid ColorProduct colorProduct, BindingResult result,
                                     @PathVariable Long id){
        return update(colorProduct,result,modelMap,listColorProduct(modelMap));
    }
}