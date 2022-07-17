package com.porfolio.wkm.Security.jwt;

import com.porfolio.wkm.Security.Entity.UsuarioPrincipal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
    private final static Logger logger= LoggerFactory.getLogger(JwtProvider.class);
    
    private static final long EXPIRE_DURATION = 24*60*60*1000;
    
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;
    
    public String generateToken(Authentication authentication){
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+expiration*1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex){
            logger.error("JWT vencido");
        } catch (IllegalArgumentException ex){
            logger.error("Token vacio");
        } catch (MalformedJwtException ex){
            logger.error("JWT mal formado");
        } catch (UnsupportedJwtException ex){
            logger.error("JWT no soportado");
        } catch (SignatureException ex){
            logger.error("Firma no valida");
        }
        
        return false;
    }
    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser() 
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
