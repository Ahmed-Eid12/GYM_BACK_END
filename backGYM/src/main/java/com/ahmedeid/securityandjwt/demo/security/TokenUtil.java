package com.ahmedeid.securityandjwt.demo.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenUtil {
	
	private final String TOKEN_SUBJECT = "sub";
	private final String TOKEN_CREATED = "created";
	
	@Value("${auth.expiration}")
	private long EXPIRATION_TIME = 684800L;
	
	@Value("${auth.secret.key}")
	private String SECRET_KEY;
	
	public String generateToken(UserDetails userDetails) {
		
		Map<String,Object> claims = new HashMap<String,Object>();
		claims.put(TOKEN_SUBJECT, userDetails.getUsername());
		claims.put(TOKEN_CREATED, new Date());
		String newToken = Jwts.builder()
				.setClaims(claims)
				.setExpiration(generateExpirationDate())
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY)
				.compact();
		
		System.out.println("token from generate token : " + newToken);
		
		return newToken;
	}
	
	public String getUserNameFromToken(String token) {
		Claims claims;
		try {
			claims = getClaims(token);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return claims.getSubject();
	}

	private Date generateExpirationDate() {
		
		return new Date(System.currentTimeMillis() + EXPIRATION_TIME * 1000);
	}
	
	public boolean isTokenValid(String token,UserDetails userDetails) {
		String userName = getUserNameFromToken(token);
		
		return (userName.equals(userDetails.getUsername()) && !isExpirationDate(token));
	}

	private boolean isExpirationDate(String token) {
		Date expired = getClaims(token).getExpiration();
		return expired.before(new Date());
	}
	
	private Claims getClaims(String token) {
		System.out.println("token : " + token);
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(SECRET_KEY)
					.parseClaimsJws(token)
					.getBody();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return claims;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
