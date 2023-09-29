
package com.dice.weather.feign.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Dattatray Tamke
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error {

    private String code;

    private String message;

    @JsonProperty("request_id")
    private String requestId;

    private String details;
}
