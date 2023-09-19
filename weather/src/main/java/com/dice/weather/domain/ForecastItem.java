
package com.dice.weather.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <code>ForecastItem</code> is pojo to represent forcast item details
 * 
 * @author Dattatray Tamke
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class ForecastItem {
    private String date;
    
    private Integer period;
    
    private String freshSnow;
    
    private Weather weather;
    
    private Double sunHours;
    
    private Double rainHours;
    
    private Precipitation prec;
    
    private Temperature temperature;
    
    private Integer pressure;
    
    private Integer relativeHumidity;
    
    private Clouds clouds;
    
    private Wind wind;
    
    private Windchill windchill;
    
    private Snowline snowline;
    
    private Boolean isNight;
}
