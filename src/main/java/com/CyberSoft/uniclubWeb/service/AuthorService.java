package com.CyberSoft.uniclubWeb.service;

import com.CyberSoft.uniclubWeb.entity.RoleEntity;
import com.CyberSoft.uniclubWeb.entity.UserEntity;
import com.CyberSoft.uniclubWeb.exception.UserAlreadyExistsException;
import com.CyberSoft.uniclubWeb.payload.request.AuthorRequest;
import com.CyberSoft.uniclubWeb.payload.request.UserRequest;
import com.CyberSoft.uniclubWeb.payload.response.RoleResponse;
import com.CyberSoft.uniclubWeb.repository.RoleRepository;
import com.CyberSoft.uniclubWeb.repository.UserRepository;
import com.CyberSoft.uniclubWeb.service.imp.AuthorServiceImp;
import com.CyberSoft.uniclubWeb.util.JwtUltils;
import com.google.gson.Gson;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorService implements AuthorServiceImp {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
//    Giúp lấy giá trị khai báo bên application.properties.
    @Value("${key.token.jwt}")
    private String strKeyToken;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private JwtUltils jwtUltils;

    private Gson gson = new Gson();

    @Override
    public String checkLogin(AuthorRequest authorRequest, HttpServletResponse response) {
        String token = "";
        UserEntity userEntity = userRepository.findByEmail(authorRequest.getEmail()).orElse(null);
        if (userEntity != null){
            if(passwordEncoder.matches(authorRequest.getPassword(), userEntity.getPassword()) ){

//            TODO: Token (Tạo Token)
//            Tạo từ key đã sinh ra và lưu trữ.
//            SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(strKeyToken));
//            token = Jwts.builder().subject("Hello JWT").signWith(secretKey).compact();
//                String roles =gson.toJson(userEntity.getRoles());

                // khuc nay phai truyen vao role
                RoleResponse roleResponse = new RoleResponse();
                roleResponse.setName(userEntity.getRole().getName());
                String roles = gson.toJson(roleResponse);
                token = jwtUltils.createToken(roles);
                Cookie saveEmail = new Cookie("email", authorRequest.getEmail());
                saveEmail.setHttpOnly(false);
                saveEmail.setSecure(false);
                saveEmail.setPath("/");
                saveEmail.setMaxAge(7 * 24 * 60 * 60);
                response.addCookie(saveEmail);
            }
        }
        System.out.println("checkLogin Token: " + token);
        return token;
    }

/*
* B1: Check email exists in DB if exists -> exception
* B2: Create new UserEntity and add all info of UserRequest
*       Todo: setRoles => Find roleEntity by Name role.
* B3: Save this userEntity into DB.
* */
    @Override
    public UserEntity registerUser(UserRequest user) {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new UserAlreadyExistsException(user.getEmail() + " already exists");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(user.getEmail());
        userEntity.setFullName(user.getFullName());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        RoleEntity rolesEntity= roleRepository.findByName("ROLE_USER").get();
        userEntity.setRole(rolesEntity);
        return userRepository.save(userEntity);
    }
}
