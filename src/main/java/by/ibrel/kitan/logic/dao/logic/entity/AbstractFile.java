package by.ibrel.kitan.logic.dao.logic.entity;

import by.ibrel.kitan.logic.exception.HashGenerationException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static by.ibrel.kitan.constants.Const.ENCODING;
import static by.ibrel.kitan.constants.Const.HASH_STRATEGY;


/**
 * Created by ibrel on 12/07/16.
 *
 * Abstract class for file
 */
@MappedSuperclass
abstract class AbstractFile implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    @Column(name = "FILE_NAME")
    private String fileName;

    @Getter @Setter
    private String path;

    AbstractFile(){
    }

    AbstractFile(String fileName, String path) {
        this.fileName=fileName;
        this.path = path;
    }

    AbstractFile(String path, MultipartFile fileUpload){
        this.fileName = createFile(path,fileUpload);
        this.path = path;
    }

    private String createFile(String path, MultipartFile fileUpload) {

        String originalFilename = String.valueOf(fileUpload.getOriginalFilename());
        String nameFile = null;

        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_STRATEGY);
            byte[] hashedBytes = digest.digest(originalFilename.getBytes(ENCODING));

            nameFile = convertByteArrayToHexString(hashedBytes);

            Files.copy(fileUpload.getInputStream(), Paths.get(createPath(path).getPath(),nameFile));

        } catch (NoSuchAlgorithmException ex) {
            throw new HashGenerationException("Could not generate hash from String", ex);
        } catch (IOException e){
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

    public String getCreateFile(String path, MultipartFile fileUpload){
        return createFile(path,fileUpload);
    }

    @Override
    public String toString() {
        return path + "/" +fileName;
    }

    private static String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuilder stringBuffer = new StringBuilder();
        for (byte arrayByte : arrayBytes) {
            stringBuffer.append(Integer.toString((arrayByte & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
    }
}