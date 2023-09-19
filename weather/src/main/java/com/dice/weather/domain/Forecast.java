
package com.dice.weather.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <code>Forecast</code> is pojo to represent forcast details
 * 
 * @author Dattatray Tamke
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Forecast {
    private List<ForecastItem> items;
}
