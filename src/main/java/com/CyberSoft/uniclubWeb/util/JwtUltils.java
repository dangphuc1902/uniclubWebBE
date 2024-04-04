package com.CyberSoft.uniclubWeb.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.swing.plaf.PanelUI;

@Component
public class JwtUltils {
    @Value("${key.token.jwt}")
    private String strKeyToken;

    public String createToken(String data){
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(strKeyToken));
        data = Jwts.builder().subject(data).signWith(secretKey).compact();
        return data;
    }
//    TODO: Giải mã token
    public String decryptToke(String token){
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(strKeyToken));
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getSubject();
    }
}
