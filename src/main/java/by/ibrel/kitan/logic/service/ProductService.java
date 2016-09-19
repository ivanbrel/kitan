package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.Image;
import by.ibrel.kitan.logic.dao.entity.ShoppingCart;
import by.ibrel.kitan.logic.dao.repository.ProductRepository;
import by.ibrel.kitan.logic.dao.entity.Product;
import by.ibrel.kitan.logic.service.dto.ProductDto;
import by.ibrel.kitan.logic.service.impl.IImageService;
import by.ibrel.kitan.logic.service.impl.IProductService;
import by.ibrel.kitan.logic.service.impl.IShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import static by.ibrel.kitan.logic.Const.PRODUCT_PATH;
import static by.ibrel.kitan.logic.Const.USER_PATH;

//TODO избавиться от контескта

/**
 * @author ibrel
 * @version 1.2 (12.07.2016)
 *
 */

@Service
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IShoppingCartService cartService;

    @Autowired
    private IImageService iImageService;

    @Autowired
    private ServletContext servletContext;

    //API

    @Override
    public synchronized Product addProduct(final ProductDto productDto, final Long idImage){

        Image image;

        if (idImage==null){
            image = new Image();
            iImageService.save(image);
        }else {
            image = iImageService.findOne(idImage);
        }

        Product product = new Product(productDto.getNameProduct(), productDto.getModel(), productDto.getColor(),
                productDto.getCountryProduct(), new BigDecimal(productDto.getPrice()), productDto.getBarcode(),
                productDto.getCategory(), productDto.quantityConvert(productDto.getQuantity()), image);

        save(product);
        return product;
    }

    @Override
    public synchronized void save(Product entity) {
        productRepository.saveAndFlush(entity);
    }

    @Override
    public synchronized void delete(Long id){

        Collection<ShoppingCart> shoppingCarts = cartService.findAll();

        if (shoppingCarts.size()!=0) {

            for (ShoppingCart shoppingCart : shoppingCarts) {
                Collection<Product> products = shoppingCart.getProducts();
                if (products.size()!=0) {
                    for (Product product : products) {
                        if (product.getId().equals(findOne(id).getId())) {
                            deleteProductAndImage(id);
                        } else {
                            deleteProductAndImage(id);
                        }
                    }
                }else {
                    deleteProductAndImage(id);
                }
            }
        }else {
            deleteProductAndImage(id);
        }
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
    }

    public synchronized void update(Product product, MultipartFile fileUpload){
        Product entity = findOne(product.getId());

        update(product);
        iImageService.updateImage(entity.getImage(),fileUpload, PRODUCT_PATH);

        save(entity);

    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findOne(Long id) {
        return productRepository.findOne(id);
    }

    //temp
    private void deleteProductAndImage(Long id){
        findOne(id).getImage().deleteFile(servletContext.getRealPath(PRODUCT_PATH),findOne(id).getImage().getFileName());
        productRepository.delete(id);
    }
}