package by.ibrel.kitan.logic.service.impl;

import by.ibrel.kitan.logic.dao.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by ibrel on 12/07/16.
 *
 */
public interface IImageService {

    Image getImage(Long id);

    void deleteImage(Long id) throws IOException;

    void updateImage(Long id);

    void saveImage(Image image);

    void createImage(MultipartFile fileUpload, Long id) throws IOException;

}
