
package com.dice.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <code>Wind</code> is pojo to represent wind details
 * 
 * @author Dattatray Tamke
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wind {

    private String unit;

    private String direction;

    private Integer avg;

    private Integer min;

    private Integer max;

    private String text;

    private Boolean significationWind;

    private Gusts gusts;
}
