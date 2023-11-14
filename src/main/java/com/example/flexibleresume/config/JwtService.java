package com.example.flexibleresume.config;

import com.example.flexibleresume.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {


    private static final String SECRET_KEY = "5CDFD8C8DBD1CEA61A6A2C53A1854HGGJK5CDFD8C8DBD1CEA61A6A2C53A1854HGGJK";
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // oude variant
//    public String generateToken(UserDetails userDetails) {
//        return generateToken(new HashMap<>(), userDetails);
//    }


//    public String generateToken(User user) {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("role", user.getRole().name()); // Voeg de rol van de gebruiker toe aan de claims
//
//
//        return generateToken(claims, user.getUsername());
//    }

    public String generateToken(User user, Long cvId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole().name()); // Voeg de rol van de gebruiker toe aan de claims
        if (cvId != null) {
            claims.put("cvId", cvId); // Voeg de cvId toe als deze beschikbaar is
        }
        return generateToken(claims, user.getUsername());
    }

    private String generateToken(Map<String, Object> claims, String subject) {
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24 * 10)) // 10 dagen
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }


//    public String generateToken(User user) {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("role", user.getRole().name()); // Voeg de rol van de gebruiker toe aan de claims
//        return generateToken(claims, user.getUsername());
//    }
//
//    ) {
//        return Jwts
//                .builder()
//                .setClaims(extraClaims)
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24 * 10)) // 10 dagen
//                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
//                .compact();
//    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());

    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }


    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
