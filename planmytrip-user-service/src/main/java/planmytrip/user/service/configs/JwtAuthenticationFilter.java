package planmytrip.user.service.configs;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.assessment.exception.OASExpiredJwtException;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private HandlerExceptionResolver exceptionResolver;

	@Autowired
	public JwtAuthenticationFilter(HandlerExceptionResolver handlerExceptionResolver) {
		this.exceptionResolver = handlerExceptionResolver;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String jwtToken = request.getHeader("Authorization");

		try {
			if (jwtToken != null && jwtToken.startsWith("Bearer")) {
				jwtToken = jwtToken.replaceFirst("Bearer", "");
			} else {
				// throw new OASExpiredJwtException("JWT token is null");
				jwtToken = null;
			}

			if (StringUtils.hasText(jwtToken) && jwtTokenProvider.validateToken(jwtToken)) {
				String username = jwtTokenProvider.getUsernameFromToken(jwtToken);
				UserDetails userDetails = customeUserDetailsService.loadUserByUsername(username);

				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		filterChain.doFilter(request, response);
		
		} catch (OASExpiredJwtException | SignatureException | MalformedJwtException | UnsupportedJwtException e) {
		    // Handle specific JWT exceptions
		    e.printStackTrace();
		    exceptionResolver.resolveException(request, response, null, e);

		} catch (InternalAuthenticationServiceException | BadCredentialsException e) {
		    // Handle authentication-related exceptions
		    e.printStackTrace();
		    exceptionResolver.resolveException(request, response, null, e);

		} catch (Exception ex) {
			ex.printStackTrace();
			exceptionResolver.resolveException(request, response, null, ex);
		}
	}

//	 private String getJwtFromRequest(HttpServletRequest request) {
//	        return request.getHeader("Authorization");
//	    }

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Autowired
	CustomeUserDetailsService customeUserDetailsService;
}
