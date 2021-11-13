package com.seen.api.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Configuration of {@link WebSecurity}.
 * 
 * @author Sabin Theodor
 *
 */
@Configuration
public class ConfigurerAdapter extends WebSecurityConfigurerAdapter {
	
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/home", "/api/**", "/api/movie/**").permitAll().anyRequest().authenticated().and().csrf().disable();
  }
}
