package by.ibrel.kitan.logic.dao.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import static by.ibrel.kitan.logic.Const.RANDOM_SEGMENT;
import static by.ibrel.kitan.logic.Const.ROOT;

/**
 * Created by ibrel on 12/07/16.
 *
 * Abstract class for picture
 */
@MappedSuperclass
abstract class AbstractFile implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String fileName;

    AbstractFile(){
    }

    AbstractFile(String fileName) {
        this.fileName=fileName;
    }

    AbstractFile(String path, MultipartFile fileUpload){
        this.fileName = createFile(path,fileUpload);
    }

    private String createFile(String path, MultipartFile fileUpload) {
        Random random = new Random();

        String prefix = random.nextInt(RANDOM_SEGMENT)+random.nextInt(RANDOM_SEGMENT) + "_";

        String nameFile = prefix + fileUpload.getOriginalFilename();

        try {
            Files.copy(fileUpload.getInputStream(), Paths.get(createPath(path).getPath(),nameFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nameFile;
    }

    public void deleteFile(String path, String fileName){
        try {
            Files.delete(Paths.get(path, fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File createPath(String path){
        // Creating the directory to store file
        File dir = new File(path + File.separator);
        if (!dir.exists())
            dir.mkdir();
        return dir;
    }
}
