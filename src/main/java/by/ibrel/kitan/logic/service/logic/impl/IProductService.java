package by.ibrel.kitan.logic.service.logic.impl;

import by.ibrel.kitan.logic.dao.logic.entity.Product;
import by.ibrel.kitan.logic.dao.logic.entity.ShoppingCart;
import by.ibrel.kitan.logic.service.ICommonService;
import by.ibrel.kitan.logic.dao.logic.entity.dto.ProductDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;


/**
 * @author ibrel
 * @version 1.0 (18/10/16)
 */
public interface IProductService extends ICommonService<Product>{

    Product create(final ProductDto productDto, final Long idImage);

    void update(Product product, MultipartFile fileUpload);

    void delete(Long id, Collection<ShoppingCart> shoppingCartList);
}
