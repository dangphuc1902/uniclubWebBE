package com.CyberSoft.uniclubWeb.service.imp;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface FileServiceImp {
    void saveFile(MultipartFile file);
    Resource load(String fileName);
}
