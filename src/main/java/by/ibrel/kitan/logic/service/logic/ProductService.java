package by.ibrel.kitan.logic.service.logic;

import by.ibrel.kitan.logic.dao.logic.entity.Image;
import by.ibrel.kitan.logic.dao.logic.entity.Product;
import by.ibrel.kitan.logic.dao.logic.entity.ShoppingCart;
import by.ibrel.kitan.logic.dao.logic.repository.ProductRepository;
import by.ibrel.kitan.logic.service.AbstractService;
import by.ibrel.kitan.logic.service.logic.dto.ProductDto;
import by.ibrel.kitan.logic.service.logic.impl.IColorProductService;
import by.ibrel.kitan.logic.service.logic.impl.IImageService;
import by.ibrel.kitan.logic.service.logic.impl.IProductCategoryService;
import by.ibrel.kitan.logic.service.logic.impl.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.math.BigDecimal;
import java.util.Collection;

import static by.ibrel.kitan.Const.PRODUCT_PATH;

//TODO избавиться от контескта

/**
 * @author ibrel
 * @version 1.2 (12.07.2016)
 *
 */

@Service
public class ProductService extends AbstractService<Product> implements IProductService {

    private ProductRepository productRepository;
    private IImageService iImageService;
    private IProductCategoryService productCategoryService;
    private IColorProductService colorProductService;
    private ServletContext servletContext;

    //API

    @Autowired
    public ProductService(final ProductRepository productRepository, final IImageService iImageService,
                          final IProductCategoryService productCategoryService, final ServletContext servletContext,
                          final IColorProductService colorProductService) {
        super(productRepository);
        this.productRepository = productRepository;
        this.iImageService = iImageService;
        this.productCategoryService = productCategoryService;
        this.servletContext = servletContext;
        this.colorProductService = colorProductService;
    }


    @Override
    @Transactional
    public synchronized Product create(final ProductDto productDto, final Long idImage){

        Image image;

        if (idImage==null){
            image = new Image();
            iImageService.save(image);
        }else {
            image = iImageService.findOne(idImage);
        }

        Product product = new Product(productDto.getNameProduct(), productDto.getModel(), colorProductService.findByName(productDto.getColor()),
                productDto.getCountryProduct(), new BigDecimal(productDto.getPriceByn()), productDto.getBrand(),
                productCategoryService.findByName(productDto.getCategory()), productDto.quantityConvert(productDto.getQuantity()), image);

        save(product);
        return product;
    }

    @Override
    @Transactional
    public synchronized void delete(Long id, Collection<ShoppingCart> shoppingCarts){

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
    @Transactional
    public synchronized void update(Product product) {

        Product entity = findOne(product.getId());

        if (entity!=null){
            entity.setNameProduct(product.getNameProduct());
            entity.setModel(product.getModel());
            entity.setColor(product.getColor());
            entity.setCountryProduct(product.getCountryProduct());
            entity.setBrand(product.getBrand());
            entity.setCategory(product.getCategory());
            entity.setPrice(product.getPrice());
            entity.setQuantity(product.getQuantity());
        }

        save(entity);
    }

    @Override
    @Transactional
    public synchronized void update(Product product, MultipartFile fileUpload){
        Product entity = findOne(product.getId());

        update(product);
        iImageService.updateImage(entity.getImage(),fileUpload, PRODUCT_PATH);

        save(entity);

    }

    //temp
    @Transactional
    private void deleteProductAndImage(Long id){
        findOne(id).getImage().deleteFile(servletContext.getRealPath(PRODUCT_PATH),findOne(id).getImage().getFileName());
        productRepository.delete(id);
    }

}