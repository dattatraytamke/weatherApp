
package com.dice.weather.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dice.weather.exception.WeatherAuthenticationException;
import com.dice.weather.exception.WeatherFeignException;

/**
 * <code>CustomExceptionHandler</code> is a global exception handler for
 * handling custom exceptions in the application.
 * 
 * @author Dattatray Tamke
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    /**
     * 
     * Method to handle {WeatherAuthenticationException}
     * 
     * @param ex
     * 
     * @return {ResponseEntity}
     */
    @ExceptionHandler(WeatherAuthenticationException.class)
    public ResponseEntity<String> handleWeatherAuthenticationException(WeatherAuthenticationException ex) {
        HttpStatus status = ex.getStatus();
        String message = ex.getMessage();

        logger.error("Authentication Exception: [{}] - {}", ex.getStatus().value(), ex.getMessage(), ex);

        return new ResponseEntity<>(message, status);
    }

    /**
     * 
     * Method to handle {WeatherFeignException}
     * 
     * @param ex
     * 
     * @return {ResponseEntity}
     */
    @ExceptionHandler(WeatherFeignException.class)
    public ResponseEntity<String> handleWeatherFeignException(WeatherFeignException ex) {
        HttpStatus status = ex.getStatus();
        String message = ex.getMessage();

        logger.error("Feign Exception: [{}] - {}", ex.getStatus().value(), ex.getMessage(), ex);

        return new ResponseEntity<>(message, status);
    }

    /**
     * 
     * Method to handle {BadCredentialsException}
     * 
     * @param ex
     * 
     * @return {ResponseEntity}
     */
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> handleBadCredentialsException(BadCredentialsException ex) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;

        String message = ex.getMessage();

        logger.error("Invalid username and password : {}", ex.getMessage(), ex);

        return new ResponseEntity<>(message, status);
    }
}
