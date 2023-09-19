
package com.dice.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <code>WeatherSummary</code> is pojo to represent weather summary details
 * 
 * @author Dattatray Tamke
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherSummary {
    private Location location;

    private Forecast forecast;
}
