package by.ibrel.kitan.logic.service.logic;

import by.ibrel.kitan.logic.dao.logic.entity.ColorProduct;
import by.ibrel.kitan.logic.dao.logic.repository.ColorProductRepository;
import by.ibrel.kitan.logic.exception.logic.ColorProductExceptions;
import by.ibrel.kitan.logic.service.AbstractService;
import by.ibrel.kitan.logic.dao.logic.entity.dto.ColorProductDto;
import by.ibrel.kitan.logic.service.logic.impl.IColorProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ibrel
 * @version 1.0 (23/11/16)
 */
@Service
public class ColorProductService extends AbstractService<ColorProduct> implements IColorProductService{

    private ColorProductRepository repository;

    @Autowired
    public ColorProductService(final ColorProductRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public ColorProduct create(Object o) {

        final ColorProductDto colorProductDto = (ColorProductDto) o;

        if (exists(colorProductDto.getNameColorProduct())) {
            throw new ColorProductExceptions("Color exists");
        }

        ColorProduct colorProduct = new ColorProduct(colorProductDto);
        save(colorProduct);
        return colorProduct;
    }

    public ColorProduct findByName(String name){
        return repository.findByName(name);
    }

    private boolean exists(String nameColorProduct) {
        return findByName(nameColorProduct) != null;
    }
}