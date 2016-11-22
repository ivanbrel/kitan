package by.ibrel.kitan.web.controllers.logic;

import by.ibrel.kitan.logic.dao.logic.entity.ColorProduct;
import by.ibrel.kitan.logic.service.ICommonService;
import by.ibrel.kitan.logic.service.logic.impl.IColorProductService;
import by.ibrel.kitan.web.controllers.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ibrel
 * @version 1.0 (23/11/16)
 */
@Controller
@RequestMapping("/configuration")
public class ColorProductController extends AbstractController<ColorProduct>{

    @Autowired
    public ColorProductController(IColorProductService service) {
        super(service);
    }


}
