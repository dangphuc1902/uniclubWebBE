package com.CyberSoft.uniclubWeb.controller;

import com.CyberSoft.uniclubWeb.payload.request.LoginRequest;
import com.CyberSoft.uniclubWeb.payload.resoponse.BaseResponse;
import com.CyberSoft.uniclubWeb.service.LoginService;
import com.CyberSoft.uniclubWeb.service.imp.LoginServiceImp;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.security.Key;

@RestController
@RequestMapping("/login")
@CrossOrigin        // Link nào vào cũng được.
// @CrossOrigin("link")     // Chỉ được một link
public class LoginController {
/*
* Do Password lưu trữ trong database là chuỗi mã hoá dạng BCrypt cho  nên không dùng password như điều kiện Where
*
* Bước 1: Viết câu truy vấn lấy dữ liệu đăng nhập dựa  trên username.
* Bước 2: Lấy dữ liệu password trả ra từ bước 1 và kiểm tra xem password lưu trữ trong database với password người dùng truyền lên.
* Bước 3: Nếu 2 mật khẩu match thì sẽ tạo ra token, nếu không giống thì đăng nhập thất bại.
*       - Tạo ra Key để mã hoá và giải mã.
* */
    @Autowired
    private LoginServiceImp loginServiceImp;

    @PostMapping("")
    public ResponseEntity<?>login( LoginRequest loginRequest){
//        TODO: Private key: Tạo ra key để mã hoá và sau đó lưu vo application.properties.
//        SecretKey secretKey = Jwts.SIG.HS256.key().build();
//        String key = Encoders.BASE64.encode(secretKey.getEncoded());
//        System.out.println("Check key :"  + key);
        String token = loginServiceImp.checkLogin(loginRequest.getUsername(), loginRequest.getPassword());
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(token.trim().length() > 0 ? 200 : 401);
        baseResponse.setData(token.trim().length() > 0 ? token : "Đăng nập thất bại");
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
