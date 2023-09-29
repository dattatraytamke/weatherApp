
package com.dice.weather.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

/**
 * <code>WeatherFeignException</code> is a custom exception class to handle feign errors.
 * 
 * @author Dattatray Tamke
 */
@Data
public class WeatherFeignException extends RuntimeException {

    protected HttpStatus status;

    /**
     * @param msg
     */
    public WeatherFeignException(String msg) {
        super(msg);
    }

    /**
     * @param status
     * @param msg
     */
    public WeatherFeignException(HttpStatus status, String msg) {
        super(msg);
        this.status = status;
    }

}
