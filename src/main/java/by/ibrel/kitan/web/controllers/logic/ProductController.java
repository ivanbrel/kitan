package by.ibrel.kitan.web.controllers.logic;

import by.ibrel.kitan.logic.dao.logic.entity.Product;
import by.ibrel.kitan.logic.dao.logic.entity.dto.ProductDto;
import by.ibrel.kitan.logic.service.logic.impl.*;
import by.ibrel.kitan.web.controllers.AbstractController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.ibrel.kitan.constants.PageConstants.PRODUCT_EDIT_PAGE;
import static by.ibrel.kitan.constants.PageConstants.PRODUCT_LIST_PAGE;

/**
 * @author ibrel
 * @version 1.1 (26.06.2016)
 */

@Controller
@RequestMapping("/product")
@PropertySource({"classpath:app.properties"})
public class ProductController extends AbstractController<Product>{

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private IProductService productService;
    private IImageService imageService;
    private IPriceService priceService;
    private IProductCategoryService productCategoryService;
    private IColorProductService colorProductService;
    private IShoppingCartService shoppingCartService;
    private Environment environment;

    @Autowired
    public ProductController(final IProductService productService, final IImageService imageService,
                             final IPriceService priceService, final IProductCategoryService productCategoryService,
                             final IShoppingCartService shoppingCartService, final IColorProductService colorProductService,
                             Environment environment) {
        super(productService);
        this.productService = productService;
        this.imageService = imageService;
        this.priceService = priceService;
        this.productCategoryService = productCategoryService;
        this.shoppingCartService = shoppingCartService;
        this.colorProductService = colorProductService;
        this.environment = environment;
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listProduct(ModelMap model) {
        model.addAttribute("list",priceService.findAll());
        model.addAttribute("price", priceService.findAll());
        return listEntity(model,PRODUCT_LIST_PAGE);
    }

    @RequestMapping(value = {"/add-page"}, method = RequestMethod.GET)
    public String listProductCategoryForAddProduct(ModelMap modelMap){
        modelMap.addAttribute("listCategory", productCategoryService.findAll());
        modelMap.addAttribute("listColor", colorProductService.findAll());
        return "product.add";
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    public String createProduct(@Valid final ProductDto productDto, @RequestParam MultipartFile fileUpload,
                                final ModelMap model) throws IOException {
        productService.create(productDto, imageService.createImage(fileUpload,environment.getProperty("fileImageProductPath")));
        return listProduct(model);
    }

    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Long id, ModelMap model) throws IOException {
        try{
            productService.delete(id,shoppingCartService.findAll());
        }catch (Exception e){
            model.addAttribute("fail", true);
            return listProduct(model);
        }
        return listProduct(model);
    }

    @RequestMapping(value = {"/edit/{id}" }, method = RequestMethod.POST)
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

    @RequestMapping(value = {"/edit/{id}" }, method = RequestMethod.GET)
    public String initFormProduct(@PathVariable Long id, ModelMap model) {
        model.addAttribute("entity", productService.findOne(id));
        model.addAttribute("lists", productCategoryService.findAll());
        model.addAttribute("listColor", colorProductService.findAll());
        return PRODUCT_EDIT_PAGE;
    }

    @RequestMapping(value = {"/courses/converter" },  method = RequestMethod.GET, produces="application/json")
    public @ResponseBody List<String> courses() {
        List<String> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        priceService.findAll().forEach(price -> {
            try {
                list.add(mapper.writeValueAsString(price.getRubleBY()));
                list.add(mapper.writeValueAsString(price.getRubleRUS()));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        return list;
    }

    @RequestMapping(value = {"/image/{id}" },  method = RequestMethod.GET)
    public @ResponseBody byte[] courses(@PathVariable Long id) throws IOException {
        return imageService.getImage(productService.findOne(id).getImage().getId());
    }
}