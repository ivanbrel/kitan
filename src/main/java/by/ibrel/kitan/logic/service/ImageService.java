package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.Image;
import by.ibrel.kitan.logic.dao.repository.ImageRepository;
import by.ibrel.kitan.logic.service.impl.IImageService;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static by.ibrel.kitan.logic.Const.RANDOM_SEGMENT;
import static by.ibrel.kitan.logic.Const.USER_PATH;


/**
 * @author ibrel
 * @version 1.2 (12.07.2016)
 */

@Service
@Transactional
public class ImageService implements IImageService {

    @Autowired
    private ImageRepository repository;

    @Autowired
    private ServletContext servletContext;

    //API

    @Override
    public Long createImage(MultipartFile fileUpload, String path) throws IOException {

        if (!Objects.equals(fileUpload.getOriginalFilename(), "") && fileUpload != null) {
            Image image = new Image(path,fileUpload);
            save(image);
            return image.getId();
        }
        return null;
    }

    @Override
    public void updateImage(Image image, MultipartFile fileUpload, String path) {
        Image entity = findOne(image.getId());


        if (image.getFileName()!=null) {
            entity.deleteFile(servletContext.getRealPath(path), image.getFileName());
        }

        entity.setFileName(entity.getCreateFile(servletContext.getRealPath(path),fileUpload));

        save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void save(Image entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public void update(Image entity) {
    }

    @Override
    public List<Image> findAll() {
        return repository.findAll();
    }

    @Override
    public Image findOne(Long id) {
        return repository.findOne(id);
    }

}
