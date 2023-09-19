
package com.dice.weather.utils;

import org.springframework.stereotype.Component;

/**
 * <code>AuthenticationUtils</code> is class which have the method for the
 * authentication.
 * 
 * @author Dattatray Tamke
 */
@Component
public class AuthenticationUtils {

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
}
