package by.ibrel.web.controllers;

import by.ibrel.logic.entity.Product;
import by.ibrel.logic.exception.ClientExistsException;
import by.ibrel.logic.service.IProductService;
import by.ibrel.logic.service.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
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

//    @RequestMapping(value = { "/product/edit/{id}" }, method = RequestMethod.POST)
//    public String updateCategory(@Valid final Long id, final BindingResult result, final ModelMap model){
//        if (result.hasErrors()){return "category.edit";}
//        service.editProduct(id);
//        model.addAttribute("success", "Данные клиента " + c.getId() + " изменены");
//        return "category.edit";
//    }
//
//    @RequestMapping(value = { "/category/edit/{category}" }, method = RequestMethod.GET)
//    public String editClient(@PathVariable String category, ModelMap model) {
//        final Category c = service.findByNameCategory(category);
//        model.addAttribute("category", c);
//        model.addAttribute("edit", true);
//        return "category.edit";
//    }
}
