
package com.dice.weather.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <code>ForecastDetails</code> is pojo to represent forcast details
 * 
 * @author Dattatray Tamke
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForecastDetails {

    private List<ForecastItem> items;

    private String forecastDate;

    private String nextUpdate;

    private String source;

    private String point;
}
