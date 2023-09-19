
package com.dice.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <code>Windchill</code> is pojo to represent windchill details
 * 
 * @author Dattatray Tamke
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Windchill {

    private Integer avg;

    private Integer min;

    private Integer max;
}
