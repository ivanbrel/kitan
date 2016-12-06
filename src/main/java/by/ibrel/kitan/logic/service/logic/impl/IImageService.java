package by.ibrel.kitan.logic.service.logic.impl;

import by.ibrel.kitan.logic.dao.logic.entity.Image;
import by.ibrel.kitan.logic.service.ICommonService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author ibrel
 * @version 1.0 (18/10/16)
 */
public interface IImageService extends ICommonService<Image> {

    Long createImage(MultipartFile fileUpload, String path) throws IOException;

    void updateImage(Image image, MultipartFile fileUpload, String path);

    /**
     * Method delete image file
     * @param id entity image
     */
    void deleteImage(Long id);

    byte[] getImage(Long idImage) throws IOException;
}
