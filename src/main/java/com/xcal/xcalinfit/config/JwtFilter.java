package com.xcal.xcalinfit.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import com.xcal.xcalinfit.service.TokenService;

@Configuration
public class JwtFilter extends GenericFilterBean {

	@Autowired
	private TokenService tokenService;

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String token = request.getHeader("Authorization");

		if (token != null && token.startsWith("Bearer ")) {
			token = token.substring(7, token.length());
		}

		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			response.sendError(HttpServletResponse.SC_OK, "success");
			return;
		}

		if (allowRequestWithoutToken(request)) {
			response.setStatus(HttpServletResponse.SC_OK);
			filterChain.doFilter(req, res);
		} else {

			if (token == null || !tokenService.isTokenValid(token)) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			} else {
				ObjectId userId = new ObjectId(tokenService.getUserIdFromToken(token));
				request.setAttribute("userId", userId);
				filterChain.doFilter(req, res);

			}
		}

	}

	public boolean allowRequestWithoutToken(HttpServletRequest request) {
		if (request.getRequestURI().equalsIgnoreCase("/user/create")) {
			return true;
		}
		return false;
	}
}
