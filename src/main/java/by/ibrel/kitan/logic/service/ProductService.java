package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.repository.ProductRepository;
import by.ibrel.kitan.logic.dao.entity.Client;
import by.ibrel.kitan.logic.dao.entity.Product;
import by.ibrel.kitan.logic.dao.repository.ClientRepository;
import by.ibrel.kitan.logic.service.dto.ProductDto;
import by.ibrel.kitan.logic.service.impl.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService implements IProductService {

    /**
     * synchronized methods to access the product!!!
     * if isState == true, product available
     * if isSales == true, product sales and unavailable
     */

    @Autowired
    private ProductRepository productRepository;

    //API

    @Override
    public Product addProduct(ProductDto productDto){

        Product product = new Product();

        product.setNameProduct(productDto.getNameProduct());
        product.setModel(productDto.getModel());
        product.setColor(productDto.getColor());
        product.setCountryProduct(productDto.getCountryProduct());
        product.setBarcode(productDto.getBarcode());
        product.setCategory(productDto.getCategory());

        //TODO check entering data !!!!
        product.setCount(Integer.parseInt(productDto.getCount()));

        product.setState(true);
        product.setSales(false);

        return productRepository.save(product);
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
            entity.setPrice(product.getPrice());
            product.setState(true);
        }
        saveProduct(entity);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.delete(id);
    }

    @Override
    public synchronized void sellProduct(Long id) {
        Product e = productRepository.findOne(id);
        if (e!=null && e.isState()){
           e.setSales(true);
        }
        saveProduct(e);
    }

    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public boolean checkStatus(Long id) {
        Product product = productRepository.findOne(id);
        return product.isState();
    }

    @Override
    public synchronized Product getProduct(Long id) {
        Product product = productRepository.getOne(id);
        if (checkStatus(product.getId())){

        }
        return product;
    }

    @Override
    public synchronized Product addClient(Client client) {
        return null;
    }
}
