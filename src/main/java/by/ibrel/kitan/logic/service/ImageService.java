package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.Image;
import by.ibrel.kitan.logic.dao.repository.ImageRepository;
import by.ibrel.kitan.logic.service.impl.IImageService;
import by.ibrel.kitan.logic.service.impl.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import static by.ibrel.kitan.logic.Const.ROOT;

/**
 * Created by ibrel on 12/07/16.
 *
 */
@Service
@Transactional
public class ImageService implements IImageService {

    @Autowired
    private ImageRepository repository;

    @Autowired
    private IProductService productService;

    @Override
    public Image getImage(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void deleteImage(Long id) throws IOException {
        if (getImage(id)!=null) {
            Files.delete(Paths.get(ROOT, getImage(id).getFileName()));
            repository.delete(id);
        }
    }

    @Override
    public void updateImage(Long id) {
        //TODO
    }

    @Override
    public void saveImage(Image image) {
        repository.saveAndFlush(image);
    }

    @Override
    public void createImage(MultipartFile fileUpload, Long id) throws IOException {

        if (!Objects.equals(fileUpload.getOriginalFilename(), "") && fileUpload != null) {

            Image image = new Image();
            image.setFileName(id+"_"+fileUpload.getOriginalFilename());
            image.setProduct(productService.getProduct(id));
            Files.copy(fileUpload.getInputStream(), Paths.get(ROOT, id+"_"+fileUpload.getOriginalFilename()));
            saveImage(image);
        }
    }

}
