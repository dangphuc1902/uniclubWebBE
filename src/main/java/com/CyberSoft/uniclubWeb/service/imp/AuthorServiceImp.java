package com.CyberSoft.uniclubWeb.service.imp;

import com.CyberSoft.uniclubWeb.entity.UserEntity;
import com.CyberSoft.uniclubWeb.payload.request.AuthorRequest;
import com.CyberSoft.uniclubWeb.payload.request.UserRequest;
import jakarta.servlet.http.HttpServletResponse;


public interface AuthorServiceImp {

    String checkLogin(AuthorRequest authorRequest, HttpServletResponse response);
    UserEntity registerUser(UserRequest user);
    
}
