package by.ibrel.kitan.logic.service.impl;

import by.ibrel.kitan.auth.service.impl.ICommonService;
import by.ibrel.kitan.logic.dao.entity.Product;
import by.ibrel.kitan.logic.service.dto.ProductDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ibrel
 * @version 1.1 (13.05.2016)
 */
public interface IProductService extends ICommonService<Product>{

    Product addProduct(ProductDto productDto, Long idImage);

    void update(Product product, MultipartFile fileUpload);

}
