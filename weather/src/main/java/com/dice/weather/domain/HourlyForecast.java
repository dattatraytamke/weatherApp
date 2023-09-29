
package com.dice.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <code>HourlyForecast</code> is pojo to represent forecast details
 * 
 * @author Dattatray Tamke
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HourlyForecast {

    private Location location;

    private ForecastDetails forecast;

}
