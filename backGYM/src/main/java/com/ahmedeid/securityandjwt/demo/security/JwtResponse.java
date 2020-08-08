package com.ahmedeid.securityandjwt.demo.security;

import org.springframework.security.core.userdetails.UserDetails;

import com.ahmedeid.securityandjwt.demo.entities.User;

public class JwtResponse {

	private String token;
	private String message;
	private UserDetails user;

	public JwtResponse(String token) {
		this.token = token;
	}

	public JwtResponse(String token, String message, UserDetails user) {
		super();
		this.token = token;
		this.message = message;
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

}
