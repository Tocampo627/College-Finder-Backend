package com.collegeFinder.CollegeFinderAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.time.Duration;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class OAuth2ResourceServerSecurityConfig extends WebSecurityConfigurerAdapter {

    //baseURL/user pool id
    private String issuerUri = "https://cognito-idp.us-west-2.amazonaws.com/us-west-2_NdwHLSGr1";

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .configurationSource(corsConfigurationSource())
                .and()
                .authorizeRequests()
                .antMatchers("/studentProfiles/save").permitAll()
                .antMatchers("/studentProfiles/all").anonymous()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer().jwt();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200","http://959929-collegefinder.s3-website-us-west-2.amazonaws.com"));
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH"));
        configuration.setAllowCredentials(true);
        //the below three lines will add the relevant CORS response headers
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public JwtDecoder jwtDecoder(){
        NimbusJwtDecoder jwtDecoder =  JwtDecoders.fromIssuerLocation(issuerUri);

        OAuth2TokenValidator<Jwt> withClockSkew = new DelegatingOAuth2TokenValidator<>(
                new JwtTimestampValidator(Duration.ofSeconds(60)), new JwtIssuerValidator(issuerUri));

        jwtDecoder.setJwtValidator(withClockSkew);
        jwtDecoder.setClaimSetConverter(new UsernameSubClaimAdapter());

        return jwtDecoder;
    }

}
