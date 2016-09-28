package by.ibrel.kitan.web.controllers;

import by.ibrel.kitan.logic.dao.entity.ProductCategory;
import by.ibrel.kitan.logic.service.dto.ProductCategoryDto;
import by.ibrel.kitan.logic.service.impl.IProductCategoryService;
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
 * @version 1.0 (22/09/16)
 */
@Controller
@RequestMapping("/")
public class ProductCategoryController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private IProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryController(final IProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @RequestMapping(value = {"/product/category/list"}, method = RequestMethod.GET)
    public String listProductCategory(ModelMap modelMap){
        modelMap.addAttribute("list", productCategoryService.findAll());
        return "product.category.list";
    }

    //TODO this is shit !!!!
    @RequestMapping(value = {"product/add-page"}, method = RequestMethod.GET)
    public String listProductCategoryForAddProduct(ModelMap modelMap){
        modelMap.addAttribute("list", productCategoryService.findAll());
        return "product.add";
    }

    @RequestMapping(value = {"/product/category/add"}, method = RequestMethod.POST)
    public String createProductCategory(@Valid final ProductCategoryDto productCategoryDto, final ModelMap modelMap){
        createProductCategory(productCategoryDto);
        LOGGER.debug("Create product category with name = ["+productCategoryDto.getNameCategory()+"]");
        return listProductCategory(modelMap);
    }

    @RequestMapping(value = {"/product/category/delete/{id}"}, method = RequestMethod.GET)
    public String deleteProductCategory(@PathVariable Long id, ModelMap modelMap){
        productCategoryService.delete(id);
        LOGGER.debug("Delete product category with id = ["+id+"]");
        return listProductCategory(modelMap);
    }

    @RequestMapping(value = {"/product/category/edit/{id}"}, method = RequestMethod.GET)
    public String initFormProductCategory(@PathVariable Long id, ModelMap modelMap){
        modelMap.addAttribute("category",productCategoryService.findOne(id));
        return "product.category.edit";
    }

    @RequestMapping(value = {"/product/category/edit/{id}"}, method = RequestMethod.POST)
    public String updateProductCategory(ModelMap modelMap, @Valid ProductCategory productCategory, final BindingResult result){

        if (result.hasErrors())
            return "product.category.edit";

        productCategoryService.update(productCategory);
        LOGGER.debug("Product category with id = ["+productCategory.getId()+"] update");

        return listProductCategory(modelMap);
    }

    private void createProductCategory(ProductCategoryDto productCategoryDto){
        try {
            productCategoryService.addProductCategory(productCategoryDto);
        }catch (Exception e){

        }
    }
}
