package com.ahmedeid.securityandjwt.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmedeid.securityandjwt.demo.entities.User;
import com.ahmedeid.securityandjwt.demo.security.JwtResponse;
import com.ahmedeid.securityandjwt.demo.security.LoginRequest;
import com.ahmedeid.securityandjwt.demo.security.TokenUtil;
import com.ahmedeid.securityandjwt.demo.services.UserService;
import com.ahmedeid.securityandjwt.demo.uibean.UserUIBean;

@CrossOrigin
@RestController
@RequestMapping(value="/BackGYM/auth")
public class AuthController {

	@Autowired
	private TokenUtil tokenUtil;

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping(value = "/login")
	public JwtResponse Login(@RequestBody LoginRequest loginRequest) {
		final Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserDetails userDetails = userService.loadUserByUsername(loginRequest.getUsername());
		String token = null;
		JwtResponse jwtResponse = null;
		if(userDetails != null) {
			token = tokenUtil.generateToken(userDetails);
			jwtResponse = new JwtResponse(token , "you have a new token" , userDetails);
		} else {
			jwtResponse = new JwtResponse(null , "username or password invalid, "
					+ "try again later or you can register this login again" ,null);
		}
		
		
		return jwtResponse;
	}

}
