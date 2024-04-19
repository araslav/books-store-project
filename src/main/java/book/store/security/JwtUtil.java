package book.store.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwe;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {
    private final SecretKey secret;
//    private final Key secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    public JwtUtil(@Value("${jwt.secret}") String secretString) {
        this.secret = Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String email) {
//        return Jwts.builder()
//                .subject(email)
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis() + expiration))
//                .signWith(secret)
//                .compact();
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(secret)
                .compact();
    }

    public boolean isValidToken(String token) {
//        try {
//            Jwt<JweHeader, Claims> claimsJwt = Jwts.parser()
//                    .decryptWith(secret)
//                    .build()
//                    .parseEncryptedClaims(token);
//            return !claimsJwt.getPayload().getExpiration().before(new Date());
//        } catch (JwtException | IllegalArgumentException e) {
//            throw new JwtException("Invalid JWT token");
//        }
        try {
//            Jwe<Claims> claimsJws = Jwts.parser()
//                    .setSigningKey(secret)
//                    .build()
//                    .parseEncryptedClaims(token);
            final JwtParserBuilder parser = Jwts.parser();
            final JwtParserBuilder jwtParserBuilder = parser.setSigningKey(secret);
            final JwtParser build = jwtParserBuilder.build();
//            build.
            final Jwt<?, ?> claimsJws = build.parse(token);
//            final Jwe<Claims> claimsJws = build.parseEncryptedClaims(token);


//            return !claimsJws.getBody().getExpiration().before(new Date());
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new JwtException("Expired or invalid JWT token");
        }
    }

    public String getUsername(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parser()
                .decryptWith(secret)
                .build()
                .parseEncryptedClaims(token)
                .getPayload();
        return claimsResolver.apply(claims);
    }
}
