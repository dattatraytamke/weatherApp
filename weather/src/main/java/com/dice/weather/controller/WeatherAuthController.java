
package com.dice.weather.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.dice.weather.utils.AuthenticationUtils;

/** 
 * <code>WeatherAuthController</code> is class which have the endpoint that generates and returns jwt token.
 * 
 * @author Dattatray Tamke 
 */
@RestController
public class WeatherAuthController {

    @Autowired
    private AuthenticationUtils authenticationUtils;

    private Logger logger = LoggerFactory.getLogger(WeatherAuthController.class);

    /**
     * 
     * This API method is used to return jwt token based on clientId and clientSecret
     * 
     * @param clientId
     * @param clientSecret
     * 
     * @return JWT token
     */
    @PostMapping("/login")
    public String login(@RequestHeader(value = "clientId") String clientId,
            @RequestHeader(value = "clientSecret") String clientSecret) {

        logger.info("login(): Request received to login with username : [{}]", clientId);

        return authenticationUtils.login(clientId, clientSecret);
    }
}
