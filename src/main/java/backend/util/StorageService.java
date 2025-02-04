package backend.util;

import backend.model.entity.User;
import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class StorageService {

    @Value("${spring.aws.s3.bucket}")
    private String bucketName;

    @Autowired
    private AmazonS3 storageClient;

    private static final long MAX_FILE_SIZE = 1024 * 1024 * 100; // 5MB

    private static final long MAX_IMAGE_SIZE = 1024 * 1024 * 3; // 3MB

    private final Logger logger = LoggerFactory.getLogger(StorageService.class);

    public String uploadBase64Image(String base64Image, User user){
        String[] parts = base64Image.split(",");
        String metadata = parts[0];

        String[] metadataParts = metadata.split(";");
        String fileType = metadataParts[0].split(":")[1].split("/")[1];

        if (!fileType.equals("png") && !fileType.equals("jpg") && !fileType.equals("jpeg")) {
            throw new RuntimeException(HttpStatus.BAD_REQUEST.value() + " Invalid file type");
        }

        byte[] data = DatatypeConverter.parseBase64Binary(parts[1]);

        if (data.length > MAX_IMAGE_SIZE) {
            throw new RuntimeException(HttpStatus.BAD_REQUEST.value() + " file size exceeds the limit");
        }

        InputStream targetStream = new ByteArrayInputStream(data);

        try {
            ObjectMetadata metadataStream = new ObjectMetadata();
            metadataStream.setContentLength(data.length);
            metadataStream.setContentType(fileType);

            final String fileName = UUID.randomUUID().toString();

            storageClient.putObject(bucketName, fileName, targetStream, metadataStream);

            return fileName;
        } catch (AmazonClientException e) {
            throw new RuntimeException("Error uploading file");
        }
    }

    public String uploadFile(MultipartFile file, User user) {
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());

            if(file.getBytes().length > MAX_FILE_SIZE){
                throw new RuntimeException(HttpStatus.BAD_REQUEST.value() + " file size exceeds the limit");
            }

            final String fileName = UUID.randomUUID().toString();

            storageClient.putObject(bucketName, fileName, file.getInputStream(), metadata);

            return fileName;
        } catch (AmazonClientException | IOException e) {
            throw new RuntimeException("Error uploading file");
        }
    }

    public void deleteFile(String fileName){
        try {
            storageClient.deleteObject(bucketName, fileName);
        }catch (Exception e){
            throw new RuntimeException("Error deleting file");
        }
    }

}
