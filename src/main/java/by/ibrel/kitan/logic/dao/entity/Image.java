package by.ibrel.kitan.logic.dao.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;;


/**
 *
 *
 * @author ibrel
 * @version 1.3 (12.07.2016)
 */

@Entity
@Table(name = "image")
public class Image extends AbstractFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public Image(){
    }

    public Image(String imageName){
        super(imageName);
    }

    public Image(String path, MultipartFile fileUpload){
        super(path,fileUpload);
    }
}
