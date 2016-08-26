package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.Image;
import by.ibrel.kitan.logic.dao.repository.ImageRepository;
import by.ibrel.kitan.logic.service.impl.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;



/**
 * @author ibrel
 * @version 1.2 (12.07.2016)
 */

@Service
@Transactional
public class ImageService implements IImageService {

    @Autowired
    private ImageRepository repository;

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
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void save(Image entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public void update(Image entity) {
        //TODO create update image
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
