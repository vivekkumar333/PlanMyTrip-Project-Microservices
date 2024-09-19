package planmytrip.user.service.configs;

import java.nio.file.attribute.UserPrincipal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.assessment.exception.OASExpiredJwtException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {
		@Value("${jwt.secret}")
	    private String jwtSecret;

	    @Value("${jwt.expiration}")
	    private long jwtExpiration;

	    public String generateToken(UserDetails userDetails) {
//	        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

	    	Map<String, Object> claims = new HashMap<>();
	    	claims.put("sub", userDetails.getUsername());
	    	claims.put("authorities", userDetails.getAuthorities());
	    	
	        Date now = new Date();
	        Date expiryDate = new Date(now.getTime() + jwtExpiration);

	        return Jwts.builder()
	                .setClaims(claims)
	                .setIssuedAt(now)
	                .setExpiration(expiryDate)
	                .signWith(SignatureAlgorithm.HS512, jwtSecret)
	                .compact();
	    }

	    public String getUsernameFromToken(String token) {
	        Claims claims = Jwts.parser()
	                .setSigningKey(jwtSecret)
	                .parseClaimsJws(token)
	                .getBody();

	        return claims.getSubject();
	    }

	    public boolean validateToken(String token) {
	        try {
	        	this.isTokenExpired(token);
	            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
	            return true;
	        } catch (SignatureException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
	            if(ex instanceof SignatureException) {
	            	throw new SignatureException("Invalid JWT-token signature!");
	            }else if(ex instanceof MalformedJwtException) {
	            	throw new MalformedJwtException("Malformed JWT: The jwt-token structure is invalid");
	            }else if(ex instanceof ExpiredJwtException) {
	            	throw new OASExpiredJwtException("JWT-Token has been expired, Please login try with new token");
	            }else if(ex instanceof UnsupportedJwtException) {
	            	throw new UnsupportedJwtException("Unsupported JWT-token format");
	            }else if(ex instanceof IllegalArgumentException) {
	            	throw new IllegalArgumentException("Invalid argument provided when processing the JWT");
	            }
	        	
	        	throw ex;
	        }
	    }
	    
	    
	    public boolean isTokenExpired(String token) {
	        try {
	            final Date expiration = getClaimFromToken(token, Claims::getExpiration);
	            return expiration.before(new Date());
	        } catch (ExpiredJwtException expiredJwtException) {
	            return true;
	        }
	    }

	    // Helper method to extract claims from the token
	    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = getAllClaimsFromToken(token);
	        return claimsResolver.apply(claims);
	    }

	    // Parse the token and return its claims
	    private Claims getAllClaimsFromToken(String token) {
	        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
	    }
}
