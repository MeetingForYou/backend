package backend.service.impl;

import backend.model.entity.User;
import backend.service.FileService;
import backend.util.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private StorageService storageService;

    @Override
    public void upload(MultipartFile file) {
        storageService.uploadFile(file, User.builder().build());
    }

    @Override
    public void delete(String name) {
        storageService.deleteFile(name);
    }
}
