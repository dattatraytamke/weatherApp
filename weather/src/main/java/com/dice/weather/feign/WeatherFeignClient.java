
package com.dice.weather.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.dice.weather.domain.HourlyForecast;
import com.dice.weather.domain.WeatherSummary;
import com.dice.weather.feign.config.WeatherFeignConfig;

/**
 * <code>WeatherFeignClient</code> is feign client to communicate with weather
 * apis from rapidapi.com
 * 
 * @author Dattatray Tamke
 */
@FeignClient(name = "rapidApiWeatherClient", url = "https://forecast9.p.rapidapi.com/rapidapi/forecast", configuration = WeatherFeignConfig.class)
public interface WeatherFeignClient {

    /**
     * 
     * @param city
     * @param rapidKey
     * 
     * @return {WeatherSummary}
     */
    @GetMapping("/{city}/summary/")
    ResponseEntity<WeatherSummary> getForecastSummaryByLocationName(@PathVariable String city, 
                                                                    @RequestHeader(value = "X-RapidAPI-Key") String rapidKey);

    /**
     * 
     * @param city
     * @param rapidKey
     * 
     * @return {HourlyForecast}
     */
    @GetMapping("/{city}/hourly/")
    ResponseEntity<HourlyForecast> getHourlyForecastByLocationName(@PathVariable String city,
                                                                   @RequestHeader(value = "X-RapidAPI-Key") String rapidKey);

}
