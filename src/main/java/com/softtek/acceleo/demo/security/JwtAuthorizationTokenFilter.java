package com.softtek.acceleo.demo.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	static final String ORIGIN = "Origin";
	private UserDetailsService userDetailsService;
	private JwtTokenUtil jwtTokenUtil;
	private String tokenHeader;

	public JwtAuthorizationTokenFilter(UserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil,
			String tokenHeader) {
		this.userDetailsService = userDetailsService;
		this.jwtTokenUtil = jwtTokenUtil;
		this.tokenHeader = tokenHeader;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		final String requestHeader = request.getHeader(this.tokenHeader);
		String username = null;
		String authToken = null;
		logger.info("SI SE ESTA EJECUTANDO ::::::::::::::::::::::::::::::::::::::");
		logger.info("Processing Authentication for '{}'", request.getRequestURL());
		logger.info("Processing Request method:", request.getMethod());
		logger.info("Processing Request" + request.toString());
		logger.info("Processing Header" + request.getHeader("Origin"));
		logger.info("Processing Protocol" + request.getProtocol());
		logger.info("Processing ContentTup" + request.getContentType());

		// Bloque de codigo para manejar peticiones OPTIONS
		// esto se utiliza al tener peticiones cruzadas de dominio CORS
		if (request.getMethod().equals("OPTIONS") && (!request.getHeader(ORIGIN).equals("null"))) {
			try {
				logger.info("RequestHeader es distinto de null and method es options");
				// Se puede configurar un origen en particular
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Credentials", "true");
				response.setHeader("Access-Control-Allow-Methods", "*");
				response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
				response.getWriter().print("OK");
				response.getWriter().flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			logger.info("RequestHeader es nulo o methodo no es options");

			logger.info("HEADER: " + requestHeader);

			if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
				logger.info("GET Token");

				authToken = requestHeader.substring(7);
				logger.info("AuthToken" + authToken);

				try {
					username = jwtTokenUtil.getUsernameFromToken(authToken);
				} catch (IllegalArgumentException e) {
					logger.error("Un error ocurrio durante la obtencion del username desde el token", e);
				} catch (ExpiredJwtException e) {
					logger.warn("The token ha expirado, ya no es valido", e);
				}
			} else {
				logger.warn("No es posible encontrar la cadena portadora(Bearer), se va a ignorar el header");
			}

			logger.debug("checking authentication for user '{}'", username);
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				logger.debug("Contexto de seguridad es nulo, revisar autenticacion de usuario");

				// No es obligatorio cargar los detalles del usuario
				// desde la base de datos. Se podria almacenar la informacion
				// en el token y leer desde el.
				UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

				logger.debug("UserDetail " + userDetails.getAuthorities().toString());

				// Se revisa la integridad del token
				if (jwtTokenUtil.validateToken(authToken, userDetails)) {
					logger.debug("In jwtTokenUtil.validateToken() ");
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					logger.info("Usuario autenticado '{}', configurando el contexto de seguridad", username);
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}

			chain.doFilter(request, response);
		}
	}
}
