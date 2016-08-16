package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.ShoppingCart;
import by.ibrel.kitan.logic.dao.repository.ProductRepository;
import by.ibrel.kitan.logic.dao.entity.Product;
import by.ibrel.kitan.logic.service.dto.ProductDto;
import by.ibrel.kitan.logic.service.impl.IProductService;
import by.ibrel.kitan.logic.service.impl.IShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import static by.ibrel.kitan.logic.Const.ROOT;

/**
 * @author ibrel
 * @version 1.2 (12.07.2016)
 */

@Service
@Transactional
public class ProductService implements IProductService {

    private boolean flag;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IShoppingCartService cartService;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    //API

    @Override
    public synchronized Product addProduct(final ProductDto productDto){

        Product product = new Product();

        product.setNameProduct(productDto.getNameProduct());
        product.setModel(productDto.getModel());
        product.setColor(productDto.getColor());
        product.setCountryProduct(productDto.getCountryProduct());
        product.setBarcode(productDto.getBarcode());
        product.setCategory(productDto.getCategory());
        product.setPrice(Double.parseDouble(productDto.getPrice()));

        //TODO check entering data !!!!
        product.setQuantity(Integer.parseInt(productDto.getQuantity()));

        save(product);
        return product;
    }

    @Override
    public synchronized void save(Product entity) {
        productRepository.saveAndFlush(entity);
    }

    @Override
    public synchronized void delete(Long id) {

        Collection<ShoppingCart> shoppingCarts = cartService.findAll();

        if (shoppingCarts.size()==0){
            deleteProductAndImage(id);
        }else {
            for (ShoppingCart shoppingCart:shoppingCarts){
                Collection<Product> products = shoppingCart.getProducts();

                if (products.size() == 0) {
                    deleteProductAndImage(id);
                } else {
                    for (Product product:products) {
                        if (product.getId().equals(findOne(id))) {
                            deleteProductAndImage(id);
                        } else {
                            setEventDelListener(false);
                        }
                    }
                }

            }
        }

    }

    private void setEventDelListener(boolean flag) {
        this.flag=flag;
    }

    @Override
    public boolean getEventDelListener() {
        return flag;
    }

    @Override
    public synchronized void update(Product product) {

        Product entity = findOne(product.getId());

        if (entity!=null){
            entity.setNameProduct(product.getNameProduct());
            entity.setModel(product.getModel());
            entity.setColor(product.getColor());
            entity.setCountryProduct(product.getCountryProduct());
            entity.setBarcode(product.getBarcode());
            entity.setCategory(product.getCategory());
            entity.setPrice(product.getPrice());
            entity.setQuantity(product.getQuantity());
        }

        save(entity);

        LOGGER.debug("Product " +product.getId() +" is update");
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findOne(Long id) {
        return productRepository.findOne(id);
    }

    private synchronized void deleteProductAndImage(Long id){
        if (findOne(id).getImage() != null) {
            try {
                Files.delete(Paths.get(ROOT, findOne(id).getImage().getFileName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            findOne(id).getImage().setProduct(null);
        }
        productRepository.delete(id);
        setEventDelListener(true);
    }
}