package by.ibrel.kitan.web.controllers;

import by.ibrel.kitan.logic.dao.entity.PriceConvert;
import by.ibrel.kitan.logic.dao.entity.Product;
import by.ibrel.kitan.logic.exception.ClientExistsException;
import by.ibrel.kitan.logic.service.impl.IImageService;
import by.ibrel.kitan.logic.service.impl.IPriceService;
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

import javax.validation.Valid;
import java.io.IOException;;
import java.util.*;


@Controller
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private IProductService service;

    @Autowired
    private IImageService imageService;

    @Autowired
    private IPriceService priceService;

    @RequestMapping(value = {"/product/list"}, method = RequestMethod.GET)
    public String listProduct(ModelMap model) {
        List<Product> productList = service.listAllProduct();
        model.addAttribute("product", productList);

        List<PriceConvert> priceList = priceService.findAll();
        model.addAttribute("price", priceList);
        return "product.list";
    }

    //add new product
    @RequestMapping(value = {"/product/add"}, method = RequestMethod.POST)
    public String addProduct(@Valid final ProductDto productDto, @RequestParam MultipartFile fileUpload, final ModelMap model) {
        LOGGER.debug("Add new client with name:" + productDto);

        createProduct(productDto, fileUpload);

        model.addAttribute("success");
        return "redirect:/product/list";
    }

    @RequestMapping(value = {"/product/delete/{id}"}, method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Long id) throws IOException {
        service.deleteProduct(id);
        return "redirect:/product/list";
    }

    @RequestMapping(value = { "/product/edit/{id}" }, method = RequestMethod.POST)
    public String updateProduct(@Valid Product product, final BindingResult result, final ModelMap model){
        if (result.hasErrors()){return "product.edit";}
        service.editProduct(product);
        model.addAttribute("success", "Данные продукта " + product.getId() + " изменены");
        return "redirect:/product/list";
    }

    @RequestMapping(value = { "/product/edit/{id}" }, method = RequestMethod.GET)
    public String editProduct(@PathVariable Long id, ModelMap model) {

        final Product product = service.getProduct(id);
        model.addAttribute("product", product);
        return "product.edit";
    }

//    @RequestMapping(value = "/product/add/atrr", method = RequestMethod.POST)
//    public @ResponseBody ArrayList<String> handlerRequest(@RequestParam ("json") String json) throws Exception {
//
//        ArrayList<String> list = new ArrayList<String>(Arrays.asList(json.split("\\s*,\\s*")));
//
//        if (listAtrr.isEmpty())
//            listAtrr.clear();
//        listAtrr.addAll(list);
//
//        return listAtrr;
//    }

//    private void addNewColumn(final List<String> listAtrr, final Long ProductId){
//
//        Product product = service.getProduct(ProductId);
//
//        for (String s:listAtrr){
//            if (!Objects.equals(s, "")){
//                product.getNewColumn().add(s);
//            }
//        }
//
//        service.saveProduct(product);
//    }

    private void createProduct(ProductDto productDto, MultipartFile fileUpload) {
        try{
            Product product = service.addProduct(productDto);
//            addNewColumn(listAtrr,product.getId());
            imageService.createImage(fileUpload,product.getId());
        }catch (final ClientExistsException | IOException e){
            throw new ClientExistsException(e);
        }
    }

}