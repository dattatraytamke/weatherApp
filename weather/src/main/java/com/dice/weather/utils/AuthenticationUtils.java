
package com.dice.weather.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.dice.weather.controller.WeatherController;
import com.dice.weather.security.JwtHelper;

/**
 * <code>AuthenticationUtils</code> is class which have the method for the
 * authentication.
 * 
 * @author Dattatray Tamke
 */
@Component
public class AuthenticationUtils {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtHelper helper;

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationUtils.class);

    /**
     * 
     * If clientId and client secret starts with letter a then this method
     * returns true otherwise false
     * 
     * @param clientId
     * @param clientSceret
     * 
     * @return Returns {True} or {False}
     */
    public Boolean isValid(String clientId, String clientSceret) {

        return clientId.startsWith("a") && clientSceret.startsWith("a");
    }

    /**
     * 
     * This method returns authentication token (jwt token) to authenticate user, using clientId and clientSecret
     * 
     * @param clientId
     * @param clientSceret
     * 
     * @return Bearer token {String}
     */
    public String login(String clientId, String clientSceret) {

        this.doAuthenticate(clientId, clientSceret);

        UserDetails userDetails = userDetailsService.loadUserByUsername(clientId);
        String token = this.helper.generateToken(userDetails);

        token = "Bearer " + token;
        return token;
    }

    /**
     * @param clientId
     * @param clientSceret
     */
    private void doAuthenticate(String clientId, String clientSceret) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(clientId, clientSceret);
        try {
            manager.authenticate(authentication);

        } catch (BadCredentialsException e) {
            logger.error("doAuthenticate(): Invalid Username or Password !!");

            throw new BadCredentialsException("Invalid Username or Password !!");
        }
    }
}
