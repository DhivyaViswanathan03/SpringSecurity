package in.ineuron.utility;

import java.sql.Date;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {
	
	public static  String generateToken(String id,String name,String secretKey) {
		return Jwts
		.builder()
		.setId(id)
		.setIssuer(name)
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(1)))
		.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(secretKey.getBytes()))
		.compact();
	}
	
	public static Claims claims(String secretKey,String token) {
		return Jwts
				.parser()
				.setSigningKey(Base64.getEncoder().encode(secretKey.getBytes()))
				.parseClaimsJws(token)
				.getBody();
	}

}
