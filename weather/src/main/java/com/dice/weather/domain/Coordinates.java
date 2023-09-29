
package com.dice.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <code>Coordinates</code> is pojo to represent geographic coordinates
 * consisting of latitude and longitude.
 * 
 * @author Dattatray Tamke
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coordinates {
    private Double latitude;

    private Double longitude;
}
