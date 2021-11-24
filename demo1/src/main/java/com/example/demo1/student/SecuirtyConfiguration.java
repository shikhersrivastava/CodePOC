package com.example.demo1.student;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecuirtyConfiguration extends WebSecurityConfigurerAdapter {

    protected void configure(AuthenticationManagerBuilder auto) throws Exception {

        auto.inMemoryAuthentication()
                .withUser("blah")
                .password("blah")
                .roles("User")
                .and()
                .withUser("foo")
                .password("foo")
                .roles("Admin");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
