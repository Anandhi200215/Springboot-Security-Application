package com.example.SpringSecurity.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@Service
//public class JwtService {
//    public static final String SECRET ="a2FuaQ==";
//    public void validateToken(String token){
//        Jwts
//                .parserBuilder()
//                .setSigningKey(getSignKey())
//                .build()
//                .parseClaimsJws(token);
//    }
//
//    public String generateToken(String userName){
//        Map<String,Object> claims=new HashMap<>();
//        return createToken(claims,userName);
//    }
//    private String createToken(Map<String,Object> claims,String username){
//        return Jwts
//                .builder()
//                .setClaims(claims) // Set claims
//                .setSubject(username) // Set the subject (username)
//                .setIssuedAt(new Date(System.currentTimeMillis())) // Set the issued date
//                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*30*30)) // Set expiration
//                .signWith(getSignKey(), SignatureAlgorithm.HS256) // Sign the token
//                .compact(); // Build the token
//    }
//
//    }
//
//}
@Service
public class JwtService {
    public static  final String  SECRET="5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
//    public void validateToken(String token){
//        Jwts
//                .parserBuilder()
//                .setSigningKey(getSignKey())
//                .build()
//                .parseClaimsJws(token);
//
//    }
public boolean validateToken(String token) {
    try {
        Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        return true;
    } catch (Exception e) {
        // Log the exception (optional)
        return false;
    }
}

    public  String  generateToken(String userName){
        Map<String,Object> claims=new HashMap<>();
        return createToken(claims,userName);
    }

    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignKey() {
        byte[] keyBytes= Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);

    }

}
