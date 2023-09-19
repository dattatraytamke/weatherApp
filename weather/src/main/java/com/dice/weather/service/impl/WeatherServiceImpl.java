
package com.dice.weather.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dice.weather.domain.HourlyForecast;
import com.dice.weather.domain.WeatherSummary;
import com.dice.weather.feign.WeatherFeignClient;
import com.dice.weather.service.WeatherService;

@Service
class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherFeignClient weatherFeignClient;

    private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

    /**
     * @see com.dice.weather.service.WeatherService#getWeatherSummaryByLocationName(java.lang.String,
     *      java.lang.String)
     */
    @Override
    public WeatherSummary getWeatherSummaryByLocationName(String locationName, String rapidKey) {
        logger.info("getWeatherSummaryByLocationName(): Request received to get the weather summary for location: [{}]", locationName);

        try {
            ResponseEntity<WeatherSummary> response = weatherFeignClient.getForecastSummaryByLocationName(locationName, rapidKey);

            return response.getBody();
        } catch (Exception e) {
            logger.error("getWeatherSummaryByLocationName(): Error occurred while executing api to fetch hourly weather forecast");

            throw e;
        }
    }

    /**
     * @see com.dice.weather.service.WeatherService#getHourlyForecastByLocationName(java.lang.String,
     *      java.lang.String)
     */
    @Override
    public HourlyForecast getHourlyForecastByLocationName(String locationName, String rapidKey) {
        logger.info("getHourlyForecastByLocationName(): Request received to get the weather hourly forecast for location: [{}]", locationName);

        try {
            ResponseEntity<HourlyForecast> response = weatherFeignClient.getHourlyForecastByLocationName(locationName, rapidKey);

            return response.getBody();
        } catch (Exception e) {
            logger.error("getHourlyForecastByLocationName(): Error occurred while executing api to fetch hourly weather forecast");

            throw e;
        }
    }

}
