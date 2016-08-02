package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.repository.ProductRepository;
import by.ibrel.kitan.logic.dao.entity.Product;
import by.ibrel.kitan.logic.service.dto.ProductDto;
import by.ibrel.kitan.logic.service.impl.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static by.ibrel.kitan.logic.Const.ROOT;

@Service
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    //API

    @Override
    public Product addProduct(final ProductDto productDto){

        Product product = new Product();

        product.setNameProduct(productDto.getNameProduct());
        product.setModel(productDto.getModel());
        product.setColor(productDto.getColor());
        product.setCountryProduct(productDto.getCountryProduct());
        product.setBarcode(productDto.getBarcode());
        product.setCategory(productDto.getCategory());
        product.setPrice(Double.parseDouble(productDto.getPrice()));
//        product.setNewColumn(null);

        //TODO check entering data !!!!
        product.setQuantity(Integer.parseInt(productDto.getQuantity()));

        return productRepository.saveAndFlush(product);
    }

    @Override
    public synchronized void editProduct(Product product) {

        Product entity = productRepository.findOne(product.getId());

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

        saveProduct(entity);

        LOGGER.debug("Product " +product.getId() +" is update");
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) throws IOException {
        if (productRepository.findOne(id).getImage()!=null) {
            Files.delete(Paths.get(ROOT, productRepository.findOne(id).getImage().getFileName()));
            productRepository.findOne(id).getImage().setProduct(null);
        }
        productRepository.delete(id);
    }

    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public synchronized Product getProduct(Long id) {
        return productRepository.findOne(id);
    }

}