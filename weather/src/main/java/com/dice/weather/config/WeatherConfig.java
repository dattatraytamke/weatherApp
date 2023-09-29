
package com.dice.weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * <code>WeatherConfig</code>
 * 
 * @author Dattatray Tamke
 */
@Configuration
public class WeatherConfig {

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user = User.builder().username("datta").password(passwordEncoder().encode("abc@dice")).roles("ADMIN").build();
        UserDetails user1 = User.builder().username("datta1").password(passwordEncoder().encode("abc@dice1")).roles("ADMIN").build();
        UserDetails user2 = User.builder().username("datta2").password(passwordEncoder().encode("abc@dice2")).roles("ADMIN").build();
        UserDetails user3 = User.builder().username("datta3").password(passwordEncoder().encode("abc@dice3")).roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user, user1, user2, user3);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
