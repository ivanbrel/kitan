package by.ibrel.kitan.web.controllers;

import by.ibrel.kitan.logic.dao.entity.Product;
import by.ibrel.kitan.logic.exception.ClientExistsException;
import by.ibrel.kitan.logic.service.impl.IProductService;
import by.ibrel.kitan.logic.service.dto.ProductDto;
import by.ibrel.kitan.web.util.GenericResponse;
import org.apache.commons.digester.SetTopRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private IProductService service;

    @RequestMapping(value = {"/product/list"}, method = RequestMethod.GET)
    public String listProduct(ModelMap model) {
        List<Product> productList = service.listAllProduct();
        model.addAttribute("product", productList);
        return "product.list";
    }

    //add new product
    @RequestMapping(value = {"/product/add"}, method = RequestMethod.POST)
    public String addProduct(@Valid final ProductDto productDto, final ModelMap model) {
        LOGGER.debug("Add new client with name:" + productDto);

        final Product add = createProduct(productDto);
        if (add==null){
            throw new ClientExistsException();
        }
        model.addAttribute("success");
        return "redirect:/product/list";
    }

    private Product createProduct(ProductDto productDto) {
        Product add;
        try{
            add = service.addProduct(productDto);
        }catch (final ClientExistsException e){
            return null;
        }
        return add;
    }

    @RequestMapping(value = {"/product/delete/{id}"}, method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return "redirect:/product/list";
    }

    @RequestMapping(value = { "/product/edit/{id}" }, method = RequestMethod.POST)
    public String updateProduct(@Valid Product product, final BindingResult result, final ModelMap model){
        if (result.hasErrors()){return "product.edit";}

        service.editProduct(product);

        model.addAttribute("success", "Данные продукта " + product.getId() + " изменены");

        return "product.edit";
    }

    @RequestMapping(value = { "/product/edit/{id}" }, method = RequestMethod.GET)
    public String editProduct(@PathVariable Long id, ModelMap model) {

        final Product product = service.getProduct(id);

        model.addAttribute("product", product);

        model.addAttribute("edit", true);

        return "product.edit";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public @ResponseBody String handlerRequest( @RequestParam ("json") String json, @RequestParam ("name") String name) throws Exception {

        List<String> items = Arrays.asList(json.split("\\s*,\\s*"));

        System.out.println(json);
        System.out.println(name);
        System.out.println(items);

        return json;
    }
}
