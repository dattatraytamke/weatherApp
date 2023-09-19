
package com.dice.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <code>Precipitation</code> is pojo to represent precipitation details
 * 
 * @author Dattatray Tamke
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Precipitation {
    private Double sum;
    
    private Integer probability;
    
    private Double sumAsRain;
    
    private String precipitationClass;
}
