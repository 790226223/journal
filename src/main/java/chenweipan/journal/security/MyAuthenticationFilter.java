package chenweipan.journal.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import chenweipan.journal.web.request.UserLoginRequest;

public class MyAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private static final Logger logger = LoggerFactory.getLogger(MyAuthenticationFilter.class);
	
	@Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    	if (!request.getMethod().equals("POST")||!request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        ObjectMapper mapper = new ObjectMapper();
        UsernamePasswordAuthenticationToken authRequest = null;
        try{
	    	InputStream is = request.getInputStream();
	    	UserLoginRequest authenticationBean = mapper.readValue(is,UserLoginRequest.class);
	        logger.info("request is:{}",authenticationBean);
	        authRequest = new UsernamePasswordAuthenticationToken(
	                authenticationBean.getUser(), authenticationBean.getPwd());
        }catch (IOException e) {
        	logger.error("io expection:{}",e);
            authRequest = new UsernamePasswordAuthenticationToken(
                    "", "");
        }
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}