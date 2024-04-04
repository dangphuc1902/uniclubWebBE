package com.CyberSoft.uniclubWeb.service;

import com.CyberSoft.uniclubWeb.service.imp.FileServiceImp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService implements FileServiceImp {
    @Value("${upload.file.path}")
    private String path;
    @Override
    public void saveFile(MultipartFile file) {
        try {
            Path root = Paths.get(path);
//            Kiem tra duong dan co ton tai khong, neu khong thi tao Directory ra.
            if (!Files.exists(root)){
                Files.createDirectory(root);
            }
            // Copy File vào đường dẫn root.
//            TODO: root.resolve: Tuỳ vào hdh nào để thêm vào .
//            root.resolve(file.getOriginalFilename()): Lấy path.
            Files.copy(file.getInputStream(),root.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception e){
            throw new RuntimeException("Loi luu file: " + e.getClass());
        }

    }

    @Override
    public Resource load(String fileName) {
        try {
            Path root = Paths.get(path);
            //      Đường dẫn file trong folder upload.
            Path file = root.resolve(fileName);
//            Chuyển về Resource trước,
            Resource resource = new UrlResource(file.toUri());
//            Kiểm tra xem Path file có  tồn tại  khong.
            if (resource.exists()) {
                return resource;
            }else {
                throw new RuntimeException("Khong tim thay file ");
            }

        }catch (Exception e){
            throw new RuntimeException("Khong tim thay file "+ e.getMessage());
        }
    }


}
