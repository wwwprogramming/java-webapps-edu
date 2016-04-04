package edu.uta.courses.security;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by me on 10.2.2015.
 */

public class AuthenticationSuccessHandlerImpl extends SimpleUrlAuthenticationSuccessHandler {

    Logger logger = Logger.getLogger(AuthenticationSuccessHandlerImpl.class.getName());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        if (authentication != null) {
            if (logger.isInfoEnabled()) logger.info("Logged In user: ["+ authentication.getPrincipal() +"]");
            super.onAuthenticationSuccess(request, response, authentication);
        }

    }
}
