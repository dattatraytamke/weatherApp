package com.dice.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/** 
 * <code>WeatherApplication</code> is the main entry point for the Weather Application.
 *
 * @author Dattatray Tamke
 */
@SpringBootApplication
@EnableFeignClients
public class WeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherApplication.class, args);
    }

}
