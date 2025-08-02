package com.CyberSoft.uniclubWeb.controller;

import com.CyberSoft.uniclubWeb.dto.ProductDto;
//import com.CyberSoft.uniclubWeb.entity.ProductEntity;
import com.CyberSoft.uniclubWeb.service.imp.FileServiceImp;
//import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.swing.text.html.Option;
//import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileServiceImp fileServiceImp;
//    imageName:.+ bat dung ten file
    @GetMapping("/{imageName:.+}")
    public ResponseEntity<?> getFile(@PathVariable("imageName") String name){
        Resource resource = fileServiceImp.load(name);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + name + "\"").body(resource);
    }
// TODO: java8
    @GetMapping("/demojava8")
    public ResponseEntity<?> demoJava8(){
        ProductDto productDto = new ProductDto();
//        ProductDto productDto = null;
        // Optional giúp xử lý phần null  dữ liệu. Giúp kiểm tra xem có null hay không. Tránh null giá trị. Muốn lấy giá trị gọi hàm null.
        Optional<ProductDto> dto = Optional.ofNullable(productDto);
//        if (dto.isPresent())
//        {
////            dto.get().getImage(): dto.get() để huỷ optional đi. sau đó mới lấy image
//            System.out.println(" Kiem tra isPresent " + dto.get().getImage());
//        }else {
//            System.out.println("Kiem tra khong co gia tri ");
//        }
        Optional<ProductDto> dto1 =  dto.map(data -> {
            data.setImages("Abc.jpg");
            return data;
        });
         if (dto1.isPresent()) {
             System.out.println("Co gia tri " + dto1.get().getImages());
         }else {
             System.out.println("loi khong co gia tri");
         }
        System.out.println("Kiem tra " );
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
