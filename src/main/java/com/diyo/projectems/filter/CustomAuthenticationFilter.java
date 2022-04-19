//package com.diyo.projectems.filter;
//
//
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//	
//	private AuthenticationManager authenticationManager;
//	
//	public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
//		this.authenticationManager = authenticationManager;
//	}
//	
//	
//	@Override
//	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
//			throws AuthenticationException {
//	String username = request.getParameter("username");
//	String password = request.getParameter("parameter");
//	
//	log.info("authntication attempt", username, password);
//	UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
//	return authenticationManager.authenticate(authToken);
//	
//	}
//
//	@Override
//	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
//			Authentication authResult) throws IOException, ServletException {
//	
//		User user = (User) authResult.getPrincipal();
//		Algorithm algorithm  = Algorithm.HMAC256("secret".getBytes());
//		String access_token = JWT.create().
//				withSubject(user.getUsername())
//				.withExpiresAt(new Date(System.currentTimeMillis()+ 10*60*1000))
//				.withIssuer(request.getRequestURL().toString())
//				.withClaim("roles", new ArrayList<>()).sign(algorithm);
//		
//		String refresh_token = JWT.create().
//				withSubject(user.getUsername())
//				.withExpiresAt(new Date(System.currentTimeMillis()+ 30*60*1000))
//				.withIssuer(request.getRequestURL().toString())
//				.sign(algorithm);
//		
//		response.setHeader("access_token", access_token);
//		response.setHeader("refresj_token", refresh_token);
//		
//		
//	}
//	
//	
//	
//	
//
//}
