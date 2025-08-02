package com.CyberSoft.uniclubWeb.controller;

import com.CyberSoft.uniclubWeb.entity.UserEntity;
import com.CyberSoft.uniclubWeb.exception.UserAlreadyExistsException;
import com.CyberSoft.uniclubWeb.payload.request.AuthorRequest;
import com.CyberSoft.uniclubWeb.payload.request.UserRequest;
import com.CyberSoft.uniclubWeb.payload.response.BaseResponse;
import com.CyberSoft.uniclubWeb.service.imp.AuthorServiceImp;

//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Encoders;
import jakarta.servlet.http.HttpServletResponse;

//import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/author")
@CrossOrigin        // Link nào vào cũng được.
// @CrossOrigin("link")     // Chỉ được một link
public class AuthorController {
/*
* Do Password lưu trữ trong database là chuỗi mã hoá dạng BCrypt cho  nên không dùng password như điều kiện Where
*
* Bước 1: Viết câu truy vấn lấy dữ liệu đăng nhập dựa  trên username.
* Bước 2: Lấy dữ liệu password trả ra từ bước 1 và kiểm tra xem password lưu trữ trong database với password người dùng truyền lên.
* Bước 3: Nếu 2 mật khẩu match thì sẽ tạo ra token, nếu không giống thì đăng nhập thất bại.
*       - Tạo ra Key để mã hoá và giải mã.
* */
    @Autowired
    private AuthorServiceImp authorServiceImp;
    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest user){

        try{
            UserEntity usersEntity = authorServiceImp.registerUser(user);
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("Registration successful!");
            baseResponse.setData(usersEntity);
            return ResponseEntity.ok(baseResponse);
        }catch (UserAlreadyExistsException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody AuthorRequest authorRequest, HttpServletResponse response){
//        Private key: Tạo ra key để mã hoá và sau đó lưu vo application.properties.
//        SecretKey secretKey = Jwts.SIG.HS256.key().build();
//        String key = Encoders.BASE64.encode(secretKey.getEncoded());
//        System.out.println("Check key :"  + key);
        String token = authorServiceImp.checkLogin(authorRequest, response);
        System.out.println("Token: " + token);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(token.trim().length() > 0 ? 200 : 401);
        baseResponse.setData(token.trim().length() > 0 ? token : "Đăng nập thất bại");
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
