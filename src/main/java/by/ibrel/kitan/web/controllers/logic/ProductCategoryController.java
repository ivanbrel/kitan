package by.ibrel.kitan.web.controllers.logic;

import by.ibrel.kitan.logic.dao.logic.entity.ProductCategory;
import by.ibrel.kitan.logic.service.logic.dto.ProductCategoryDto;
import by.ibrel.kitan.logic.service.logic.impl.IProductCategoryService;
import by.ibrel.kitan.web.controllers.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import static by.ibrel.kitan.Const.PRODUCT_CATEGORY_EDIT_PAGE;
import static by.ibrel.kitan.Const.PRODUCT_CATEGORY_LIST_PAGE;

/**
 * @author ibrel
 * @version 1.0 (22/09/16)
 */
@Controller
@RequestMapping("/configuration/product-category")
public class ProductCategoryController extends AbstractController<ProductCategory>{

    @Autowired
    public ProductCategoryController(final IProductCategoryService productCategoryService) {
        super(productCategoryService);
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listProductCategory(ModelMap modelMap){
        return listEntity(modelMap,PRODUCT_CATEGORY_LIST_PAGE);
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String createProductCategory(@Valid final ProductCategoryDto productCategoryDto, final ModelMap modelMap){
        return create(productCategoryDto,modelMap,listProductCategory(modelMap));
    }

    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
    public String deleteProductCategory(@PathVariable Long id, ModelMap modelMap){
        return deleteEntity(id,modelMap,listProductCategory(modelMap));
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public String initFormProductCategory(@PathVariable Long id, ModelMap modelMap){
        return initForm(id,modelMap,null,PRODUCT_CATEGORY_EDIT_PAGE);
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.POST)
    public String updateProductCategory(ModelMap modelMap, @Valid ProductCategory productCategory, BindingResult result){
        return update(productCategory,result,modelMap,listProductCategory(modelMap));
    }
}
