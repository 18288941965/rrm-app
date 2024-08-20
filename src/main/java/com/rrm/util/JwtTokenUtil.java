package com.rrm.util;

import com.rrm.cache.RrmUserCache;
import com.rrm.cache.UserCacheService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtTokenUtil {

    @Autowired
    private UserCacheService userCacheService;

    private final String secretKey = "rrm_twl_20240730085422";
    private final long expirationTime = 86400000; // 1 天

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            return getUsernameFromToken(token);
        }
        return null;
    }

    public RrmUserCache getUserInfo() {
        String username = getUsernameFromRequest();
        return userCacheService.getCachedUser(username);
    }

    public RrmUserCache getUserInfo(String username) {
        return userCacheService.getCachedUser(username);
    }

    public String getItemCode() {
        return getUserInfo().getItemCode();
    }
}
