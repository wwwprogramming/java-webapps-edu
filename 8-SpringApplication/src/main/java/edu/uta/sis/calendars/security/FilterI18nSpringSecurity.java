package edu.uta.sis.calendars.security;

import org.apache.log4j.Logger;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;


/**
 * Transfert the value of user Locale into LocaleContextHolder which is used by spring-security
 */
public class FilterI18nSpringSecurity implements Filter {

    Logger logger = Logger.getLogger(FilterI18nSpringSecurity.class);


    private WebApplicationContext springContext;

    /**
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest pRequest, ServletResponse pResponse, FilterChain pFilterChain) throws IOException, ServletException {
        if (!(pRequest instanceof HttpServletRequest)) {
            pFilterChain.doFilter(pRequest, pResponse);
            return;
        }

        LocaleResolver bean = springContext.getBean(LocaleResolver.class);
        Locale locale = bean.resolveLocale((HttpServletRequest) pRequest);
        logger.info("Locale -> " + locale);
        LocaleContextHolder.setLocale(locale, true);

        pFilterChain.doFilter(pRequest, pResponse);
    }

    /**
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        springContext = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
    }

    /**
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
    }

}
