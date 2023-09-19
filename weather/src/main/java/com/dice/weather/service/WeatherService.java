
package com.dice.weather.service;

import com.dice.weather.domain.HourlyForecast;
import com.dice.weather.domain.WeatherSummary;

/** 
 * @author Dattatray Tamke
 */
public interface WeatherService {

    /**
     * 
     * This method is used to fetch weather summary for a specific city
     * 
     * @param locationName
     * @param rapidKey
     * 
     * @return Returns {WeatherSummary} which include weather summary details
     */
    WeatherSummary getWeatherSummaryByLocationName(String locationName, String rapidKey);

    /**
     * This API is used to fetch weather hourly forecast for a specific city
     * 
     * @param locationName
     * @param rapidKey
     * 
     * @return Returns {HourlyForecast} which include weather hourly forecast
     *         details for a specific city
     */
    HourlyForecast getHourlyForecastByLocationName(String locationName, String rapidKey);

}
