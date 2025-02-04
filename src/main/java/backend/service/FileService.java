package backend.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    void upload(MultipartFile file);

    void delete(String name);
}
