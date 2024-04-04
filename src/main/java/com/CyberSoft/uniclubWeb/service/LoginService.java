package com.CyberSoft.uniclubWeb.service;

import com.CyberSoft.uniclubWeb.entity.UsersEntity;
import com.CyberSoft.uniclubWeb.payload.resoponse.RoleResponse;
import com.CyberSoft.uniclubWeb.repository.UserRepository;
import com.CyberSoft.uniclubWeb.service.imp.LoginServiceImp;
import com.CyberSoft.uniclubWeb.util.JwtUltils;
import com.google.gson.Gson;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;

@Service
public class LoginService implements LoginServiceImp {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
//    Giúp lấy giá trị khai báo bên application.properties.
    @Value("${key.token.jwt}")
    private String strKeyToken;

    @Autowired
    private JwtUltils jwtUltils;

    private Gson gson = new Gson();

    @Override
    public String checkLogin(String username, String password) {
        UsersEntity userEntity = userRepository.findByEmail(username);
        String token = "";
        if (passwordEncoder.matches(password,userEntity.getPassword())){

//            TODO: Token (Tạo Token)
//            Tạo từ key đã sinh ra và lưu trữ.
//            SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(strKeyToken));
//            token = Jwts.builder().subject("Hello JWT").signWith(secretKey).compact();
//                String roles =gson.toJson(userEntity.getRoles());

            // khuc nay phai truyen vao role
            RoleResponse roleResponse = new RoleResponse();
            roleResponse.setName(userEntity.getRoles().getName());
            String roles = gson.toJson(roleResponse);
                token = jwtUltils.createToken(roles);
        }
        return token;
    }
}
