
package com.dice.weather.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

/**
 * <code>WeatherAuthenticationException</code> is a custom authentication
 * exception class.
 * 
 * @author Dattatray Tamke
 */
@Data
public class WeatherAuthenticationException extends RuntimeException {

    private HttpStatus status;

    /**
     * @param msg
     */
    public WeatherAuthenticationException(String msg) {
        super(msg);
    }

    /**
     * @param status
     * @param msg
     */
    public WeatherAuthenticationException(HttpStatus status, String msg) {
        super(msg);
        this.status = status;
    }
}
