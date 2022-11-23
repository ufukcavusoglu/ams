package com.uptempo.ams.security;

import com.uptempo.ams.model.entity.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.server.ResponseStatusException;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
@ApplicationScope
@RequiredArgsConstructor
public class JwtTokenUtility {

    private SecretKey key;

    @PostConstruct
    public void setKey(){
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    public String generateAccessToken(Account account) {
        return Jwts.builder()
                .setSubject(String.format("%s", account.getEmail()))
                .setIssuedAt(new Date())
                .signWith(key)
                .compact();
    }

    public String getEmail(String token) {
        return parser(token).getSubject();
    }

    public boolean validate(String jwt) {
        parser(jwt);
        return true;
    }

    private Claims parser(String jwt){
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }

}
