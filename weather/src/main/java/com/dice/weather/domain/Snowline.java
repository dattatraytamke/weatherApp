
package com.dice.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <code>Snowline</code> is pojo to represent snowline details
 * 
 * @author Dattatray Tamke
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Snowline {

    private Integer avg;

    private Integer min;

    private Integer max;

    private String unit;
}
