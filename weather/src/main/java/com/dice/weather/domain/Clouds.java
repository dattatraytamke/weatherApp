
package com.dice.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <code>Clouds</code> is pojo to represent cloud details
 * 
 * @author Dattatray Tamke
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clouds {

    private Integer high;

    private Integer low;

    private Integer middle;
}
