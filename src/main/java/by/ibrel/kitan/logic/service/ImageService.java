package by.ibrel.kitan.logic.service;

import by.ibrel.kitan.logic.dao.entity.Image;
import by.ibrel.kitan.logic.dao.repository.ImageRepository;
import by.ibrel.kitan.logic.service.impl.IImageService;
import by.ibrel.kitan.logic.service.impl.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import static by.ibrel.kitan.logic.Const.ROOT;

/**
 * @author ibrel
 * @version 1.2 (12.07.2016)
 */

@Service
@Transactional
public class ImageService implements IImageService {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private ImageRepository repository;

    @Autowired
    private IProductService productService;

    //API

    @Override
    public void createImage(MultipartFile fileUpload, Long id) throws IOException {

        if (!Objects.equals(fileUpload.getOriginalFilename(), "") && fileUpload != null) {

            // Creating the directory to store file
            String rootPath = servletContext.getRealPath(ROOT);
            File dir = new File(rootPath + File.separator);
            if (!dir.exists())
                dir.mkdir();

            Image image = new Image();
            image.setFileName(id+"_"+fileUpload.getOriginalFilename());
            image.setProduct(productService.findOne(id));
            Files.copy(fileUpload.getInputStream(), Paths.get(dir.getPath(), id+"_"+fileUpload.getOriginalFilename()));
            save(image);
        }
    }

    @Override
    public void save(Image entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        if (findOne(id)!=null) {
            try {
                Files.delete(Paths.get(ROOT, findOne(id).getFileName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            repository.delete(id);
        }
    }

    @Override
    public void update(Image entity) {
        //TODO
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
