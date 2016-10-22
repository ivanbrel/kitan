package by.ibrel.kitan.web.controllers.logic;

import by.ibrel.kitan.logic.dao.logic.entity.Price;
import by.ibrel.kitan.logic.dao.logic.entity.Product;
import by.ibrel.kitan.logic.service.logic.impl.*;
import by.ibrel.kitan.logic.service.logic.ImageService;
import by.ibrel.kitan.logic.service.logic.PriceService;
import by.ibrel.kitan.logic.service.logic.ProductCategoryService;
import by.ibrel.kitan.logic.service.logic.ProductService;
import by.ibrel.kitan.logic.service.logic.dto.ProductDto;
import by.ibrel.kitan.web.controllers.AbstractController;
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
import java.util.Collection;


import static by.ibrel.kitan.Const.*;

/**
 * @author ibrel
 * @version 1.1 (26.06.2016)
 */

@Controller
@RequestMapping("/")
public class ProductController extends AbstractController<Product>{

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private IProductService productService;
    private IImageService imageService;
    private IPriceService priceService;
    private ServletContext servletContext;
    private IProductCategoryService productCategoryService;
    private IShoppingCartService shoppingCartService;

    @Autowired
    public ProductController(final IProductService productService, final IImageService imageService,
                             final IPriceService priceService, final ServletContext servletContext,
                             final IProductCategoryService productCategoryService, final IShoppingCartService shoppingCartService) {
        super(productService);
        this.productService = productService;
        this.imageService = imageService;
        this.priceService = priceService;
        this.servletContext = servletContext;
        this.productCategoryService = productCategoryService;
        this.shoppingCartService = shoppingCartService;
    }

    @RequestMapping(value = {PRODUCT_LIST_URL}, method = RequestMethod.GET)
    public String listProduct(ModelMap model) {
        model.addAttribute("list",priceService.findAll());
        model.addAttribute("price", priceService.findAll());
        return listEntity(model,PRODUCT_LIST_PAGE);
    }

    @RequestMapping(value = {PRODUCT_ADD_URL}, method = RequestMethod.POST)
    public String createProduct(@Valid final ProductDto productDto, @RequestParam MultipartFile fileUpload,
                                final ModelMap model) throws IOException {
        productService.create(productDto, imageService.createImage(fileUpload,servletContext.getRealPath(PRODUCT_PATH)));
        return listProduct(model);
    }

    @RequestMapping(value = {PRODUCT_DELETE_URL + "/{id}"}, method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Long id, ModelMap model) throws IOException {
        productService.delete(id,shoppingCartService.findAll());
        return listProduct(model);
    }

    @RequestMapping(value = { PRODUCT_EDIT_URL + "/{id}" }, method = RequestMethod.POST)
    public String updateProduct(@Valid Product product, final BindingResult result, final ModelMap model,
                                @ModelAttribute("fileUpload") MultipartFile fileUpload, @PathVariable("id") Long id){

        if (result.hasErrors()){return PRODUCT_EDIT_PAGE;}
        if (fileUpload.getSize()==0){
            productService.update(product);
        }else {
            productService.update(product, fileUpload);
        }
        return initFormProduct(id,model);
    }

    @RequestMapping(value = {PRODUCT_EDIT_URL + "/{id}" }, method = RequestMethod.GET)
    public String initFormProduct(@PathVariable Long id, ModelMap model) {
        return initForm(id,model, productCategoryService.findAll(),PRICE_EDIT_PAGE);
    }
}