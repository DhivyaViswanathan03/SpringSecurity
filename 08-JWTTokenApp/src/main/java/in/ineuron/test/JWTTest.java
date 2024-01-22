package in.ineuron.test;

import in.ineuron.utility.JWTUtil;
import io.jsonwebtoken.Claims;

public class JWTTest {
	
	public static void main(String args[]) {
		String token=JWTUtil.generateToken("75258", "nitin", "ineuron");
		System.out.println(token);
		
		Claims claims=JWTUtil.claims("ineuron", token);
		System.out.println(claims.getSubject());
		System.out.println(claims.getExpiration());
		System.out.println(claims.getIssuedAt());
		System.out.println(claims.getId());
		System.out.println(claims.getIssuer());
	}

}
