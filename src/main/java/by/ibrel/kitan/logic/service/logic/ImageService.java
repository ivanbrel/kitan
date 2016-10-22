package by.ibrel.kitan.logic.service.logic;

import by.ibrel.kitan.logic.dao.logic.entity.Image;
import by.ibrel.kitan.logic.service.AbstractService;
import by.ibrel.kitan.logic.service.logic.impl.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.Objects;


/**
 * @author ibrel
 * @version 1.3 (12.07.2016)
 */

@Service
public class ImageService extends AbstractService<Image> implements IImageService {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    public ImageService(final JpaRepository<Image, Long> repository) {
        super(repository);
    }

    //API

    @Override
    @Transactional
    public Long createImage(MultipartFile fileUpload, String path) throws IOException {

        if (!Objects.equals(fileUpload.getOriginalFilename(), "") && fileUpload != null) {
            Image image = new Image(path,fileUpload);
            save(image);
            return image.getId();
        }
        return null;
    }

    @Override
    @Transactional
    public void updateImage(Image image, MultipartFile fileUpload, String path) {
        Image entity = findOne(image.getId());


        if (image.getFileName()!=null) {
            entity.deleteFile(servletContext.getRealPath(path), image.getFileName());
        }

        entity.setFileName(entity.getCreateFile(servletContext.getRealPath(path),fileUpload));

        save(entity);
    }

    @Override
    @Transactional
    public Image create(Object o) {
        Image image = (Image) o;
        save(image);
        return image;
    }

}
