
package com.dice.weather.feign.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dattatray Tamke
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionMessage {

    private String timestamp;

    private Integer status;

    private Error error;

    private String message;

    private String path;
}
