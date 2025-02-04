package backend.controller;


import backend.service.FileService;
import backend.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private FileService fileService;

    @PostMapping("/file/upload")
    public ResponseEntity<ResultEntity<Object>> uploadFile(@RequestParam("file") MultipartFile file) {
        fileService.upload(file);

        return ResultEntity.success(
                HttpStatus.OK.value(),
                "Upload file successfully",
                null
        );
    }

    @DeleteMapping("/file/delete")
    public ResponseEntity<ResultEntity<Object>> deleteFile(@RequestParam("name") String name) {
        fileService.delete(name);

        return ResultEntity.success(
                HttpStatus.OK.value(),
                "Delete file successfully",
                null
        );
    }

}
