package ar.edu.unq.desapp.grupoi.backenddesappapl.security;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

    @Autowired
    private SecurityProperties securityProperties;

    private String secret;

    @PostConstruct
    protected void init() {
        secret = Base64.getEncoder().encodeToString(securityProperties.jwtSecret.getBytes());
    }

    public String createToken(String subject) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + 3600000);

        return Jwts.builder()
                .setClaims(new HashMap<>())
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Boolean validate(String token, UserDetails userDetails) {
        return !isTokenExpired(token) && extractUserName(token).equals(userDetails.getUsername());
    }

    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

}
