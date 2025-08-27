package com.fullness.ec.security;

import java.io.IOException;
import java.util.Locale;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Spring Security用例外ハンドラ
 */
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final MessageSource messageSource;
    public CustomAuthenticationFailureHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void onAuthenticationFailure(
        HttpServletRequest request, 
        HttpServletResponse response,
        AuthenticationException exception) throws IOException, ServletException {
        
        Locale locale = LocaleContextHolder.getLocale();
        String code = "AbstractUserDetailsAuthenticationProvider.badCredentials";
        
        if (exception instanceof BadCredentialsException) {
            code = "AbstractUserDetailsAuthenticationProvider.badCredentials";
        } else if (exception instanceof LockedException) {
            code = "AbstractUserDetailsAuthenticationProvider.locked";
        } else if (exception instanceof DisabledException) {
            code = "AbstractUserDetailsAuthenticationProvider.disabled";
        } else if (exception instanceof CredentialsExpiredException) {
            code = "AbstractUserDetailsAuthenticationProvider.credentialsExpired";
        } else if (exception instanceof AccountExpiredException) {
            code = "AbstractUserDetailsAuthenticationProvider.expired";
        }
        String msg = messageSource.getMessage(code, null, locale);
        AuthenticationException wrapped =
                new BadCredentialsException(msg, exception);
        request.getSession().setAttribute(
                WebAttributes.AUTHENTICATION_EXCEPTION,
                wrapped);
        response.sendRedirect("/admin/login?error");
    }
}