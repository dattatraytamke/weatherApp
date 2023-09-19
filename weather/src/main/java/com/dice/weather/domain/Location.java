
package com.dice.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <code>Location</code> is pojo to represent location details
 * 
 * @author Dattatray Tamke
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private String code;

    private String name;

    private String timezone;

    private Coordinates coordinates;
}
