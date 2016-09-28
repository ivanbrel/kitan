package by.ibrel.kitan.web.controllers;

import by.ibrel.kitan.logic.dao.entity.Price;
import by.ibrel.kitan.logic.dao.entity.Product;
import by.ibrel.kitan.logic.dao.entity.ProductCategory;
import by.ibrel.kitan.logic.service.impl.IImageService;
import by.ibrel.kitan.logic.service.impl.IPriceService;
import by.ibrel.kitan.logic.service.impl.IProductCategoryService;
import by.ibrel.kitan.logic.service.impl.IProductService;
import by.ibrel.kitan.logic.service.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

import static by.ibrel.kitan.logic.Const.PRODUCT_PATH;

/**
 * @author ibrel
 * @version 1.1 (26.06.2016)
 */

@Controller
@RequestMapping("/")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private IProductService service;
    private IImageService imageService;
    private IPriceService priceService;
    private ServletContext servletContext;
    private IProductCategoryService productCategoryService;

    public ProductController() {
    }

    @Autowired
    public ProductController(IProductService service, IImageService imageService, IPriceService priceService,
                             ServletContext servletContext, IProductCategoryService productCategoryService) {
        this.service = service;
        this.imageService = imageService;
        this.priceService = priceService;
        this.servletContext = servletContext;
        this.productCategoryService = productCategoryService;
    }

    @RequestMapping(value = {"/product/list"}, method = RequestMethod.GET)
    public String listProduct(ModelMap model) {
        List<Product> productList = service.findAll();
        model.addAttribute("product", productList);

        List<Price> priceList = priceService.findAll();
        model.addAttribute("price", priceList);
        return "product.list";
    }

    @RequestMapping(value = {"/product/add"}, method = RequestMethod.POST)
    public String createProduct(@Valid final ProductDto productDto, @RequestParam MultipartFile fileUpload, final ModelMap model) throws IOException {

        createProduct(productDto, fileUpload, servletContext.getRealPath(PRODUCT_PATH));
        LOGGER.debug("Create new product with name:" + productDto);
        return listProduct(model);
    }

    @RequestMapping(value = {"/product/delete/{id}"}, method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Long id, ModelMap model) throws IOException {

        try {
            service.delete(id);
        }catch (Exception e){
            model.addAttribute("fail", true);
            listProduct(model);
            return listProduct(model);
        }
        return listProduct(model);
    }

    @RequestMapping(value = { "/product/edit/{id}" }, method = RequestMethod.POST)
    public String updateProduct(@Valid Product product, final BindingResult result, final ModelMap model,
                                @ModelAttribute("fileUpload") MultipartFile fileUpload, @PathVariable("id") Long id){

        if (result.hasErrors()){return "product.edit";}
        if (fileUpload.getSize()==0){
            service.update(product);
        }else {
            service.update(product, fileUpload);
        }
        return initFormProduct(id,model);
    }

    @RequestMapping(value = { "/product/edit/{id}" }, method = RequestMethod.GET)
    public String initFormProduct(@PathVariable Long id, ModelMap model) {

        final Product product = service.findOne(id);
        model.addAttribute("product", product);
        model.addAttribute("listCategory", productCategoryService.findAll());
        return "product.edit";
    }

    private void createProduct(ProductDto productDto, MultipartFile fileUpload, String path) throws IOException {
        try{
            service.addProduct(productDto, imageService.createImage(fileUpload, path));
        }catch (final IOException e){
            throw new IOException(e);
        }
    }

}