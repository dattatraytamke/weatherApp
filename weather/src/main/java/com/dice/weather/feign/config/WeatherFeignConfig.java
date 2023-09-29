
package com.dice.weather.feign.config;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.HttpStatus;

import com.dice.weather.exception.WeatherFeignException;
import com.dice.weather.feign.exception.ExceptionMessage;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;

/**
 * <code>WeatherFeignConfig</code> is used to throw the weather feign exception
 * for feign call based error.
 * 
 * @author Dattatray Tamke
 */
public class WeatherFeignConfig implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        ExceptionMessage message = null;

        try (InputStream bodyIs = response.body().asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();

            message = mapper.readValue(bodyIs, ExceptionMessage.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }

        String exceptionMessage = null;
        exceptionMessage = message.getMessage() != null ? message.getMessage() : null;

        if (exceptionMessage == null && message.getError() != null) {
            exceptionMessage = message.getError().getMessage();
        }

        if (response.status() >= 400 && response.status() <= 499) {

            return new WeatherFeignException(HttpStatus.valueOf(response.status()),
                    exceptionMessage != null ? exceptionMessage : "Client Error: " + response.status());
        } else if (response.status() >= 500 && response.status() <= 599) {

            return new WeatherFeignException(HttpStatus.valueOf(response.status()),
                    exceptionMessage != null ? exceptionMessage : "Server Error: " + response.status());
        }

        return errorDecoder.decode(methodKey, response);
    }

}
