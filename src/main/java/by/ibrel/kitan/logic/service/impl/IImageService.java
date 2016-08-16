package by.ibrel.kitan.logic.service.impl;

import by.ibrel.kitan.auth.service.impl.ICommonService;
import by.ibrel.kitan.logic.dao.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author ibrel
 * @version 1.1 (12.07.2016)
 */
public interface IImageService extends ICommonService<Image>{

    void createImage(MultipartFile fileUpload, Long id) throws IOException;

}
