package com.CyberSoft.uniclubWeb.payload.request;

import jakarta.validation.constraints.NotBlank;

public class AuthorRequest {
    @NotBlank(message = "Email không được rỗng")
    private String email;
    private String password;
    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword(){
        return password;
    }
}
