
package com.dice.weather.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <code>PropertyHolder</code> is
 */
@Component
public class PropertyHolder {

    @Value("${rapid-API-key}")
    private String rapidAPIKey;

    public String getRapidKey() {
        return rapidAPIKey;
    }
}
