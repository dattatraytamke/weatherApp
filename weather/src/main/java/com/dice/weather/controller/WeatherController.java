
package com.dice.weather.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dice.weather.domain.HourlyForecast;
import com.dice.weather.domain.WeatherSummary;
import com.dice.weather.exception.WeatherAuthenticationException;
import com.dice.weather.service.WeatherService;
import com.dice.weather.utils.AuthenticationUtils;

/** 
 * <code>WeatherController</code> is class for handling weather-related endpoints.
 * This class provides RESTful APIs for retrieving weather information. 
 * 
 * @author Dattatray Tamke
 */
@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private AuthenticationUtils authenticationUtils;

    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

    /**
     * This API is used to fetch weather summary for a specific city
     * 
     * @param locationName
     * @param rapidKey
     * @param clientId 
     * @param clientSecret 
     * 
     * @return Returns {WeatherSummary} which include weather summary details
     */
    @GetMapping(value = "/weather/summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public WeatherSummary getWeatherSummary(@RequestParam String locationName, 
                                            @RequestHeader(value = "X-RapidAPI-Key") String rapidKey,
                                            @RequestHeader(value = "clientId") String clientId,
                                            @RequestHeader(value = "clientSecret") String clientSecret) {
        logger.info("getWeatherSummary(): Request received to get the weather summary for location: [{}]", locationName);

        if (Boolean.FALSE.equals(authenticationUtils.isValid(clientId, clientSecret))) {
            logger.error("getWeatherSummary(): Request declined due to incorrect credentials for clientId: [{}]", clientId);

            throw new WeatherAuthenticationException(HttpStatus.UNAUTHORIZED, "You have no access");
        }

        return weatherService.getWeatherSummaryByLocationName(locationName, rapidKey);
    }

    /**
     * This API is used to fetch weather hourly forecast for a specific city
     * 
     * @param locationName
     * @param rapidKey
     * @param clientId 
     * @param clientSecret 
     * 
     * @return Returns {HourlyForecast} which include weather hourly forecast
     *         details for a specific city
     */
    @GetMapping(value = "/weather/hourly-forecast", produces = MediaType.APPLICATION_JSON_VALUE)
    public HourlyForecast getHourlyForecast(@RequestParam String locationName, 
                                            @RequestHeader(value = "X-RapidAPI-Key") String rapidKey,
                                            @RequestHeader(value = "clientId") String clientId,
                                            @RequestHeader(value = "clientSecret") String clientSecret) {
        logger.info("getHourlyForecast(): Request received to get the weather hourly forecast for location: [{}]", locationName);

        if (Boolean.FALSE.equals(authenticationUtils.isValid(clientId, clientSecret))) {
            logger.error("getHourlyForecast(): Request declined due to incorrect credentials for clientId: [{}]", clientId);

            throw new WeatherAuthenticationException(HttpStatus.UNAUTHORIZED, "You have no access");
        }

        return weatherService.getHourlyForecastByLocationName(locationName, rapidKey);
    }
}
