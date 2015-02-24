package com.springapp.config;

import com.springapp.web.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

/**
 * The @EnableWebSecurity annotation and WebSecurityConfigurerAdapter work together to provide web based interceptor.
 * By extending WebSecurityConfigurerAdapter and only a few lines of code we are able to do the following:
 * - Require the user to be authenticated prior to accessing any URL within our application
 * - Create a user with the username “user”, password “password”, and role of “ROLE_USER”
 * - Enables HTTP Basic and Form based authentication
 * - Spring Security will automatically render a login page and logout success page for you
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Get dataSource bean from dao config
    @Autowired
    private DataSource dataSource;
    
    /**
     * Handle global interceptor configuration
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // to customize with your own authentication provider
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .withDefaultSchema()
//                .withUser("user").password("password").roles("USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**");
    }

    /**
     * Handle the HTTP interceptor configuration.
     * Define what is accessible over HTTP.
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .anyRequest().permitAll()
//                    .antMatchers("/index", "/register").permitAll()
//                    .antMatchers("/**").hasRole("USER")
//                    .anyRequest().authenticated() // 7
                    .and()
//                .httpBasic()
//                    .and()
                .formLogin()
//                    .loginPage(Route.login)
//                    .failureUrl("/login?error")
//                    .usernameParameter("username")
//                    .passwordParameter("password")
//                    .permitAll()
                    .and()
                .logout().logoutSuccessUrl("/login?logout")
                    .and()
                .csrf()
                    .and()
                .exceptionHandling().accessDeniedPage("/403");
    }


    /**
     * Authenticated user information available as a proxified Spring bean.
     *
     * <p>Could be inject into beans of scope singleton (ie. @Service or @Controller)
     */
//    @Bean
//    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
//    public UserDetails authenticatedUserDetails() {
//        SecurityContextHolder.getContext().getAuthentication();
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            if (authentication instanceof UsernamePasswordAuthenticationToken) {
//                return (UserDetails) ((UsernamePasswordAuthenticationToken) authentication).getPrincipal();
//            }
//            if (authentication instanceof RememberMeAuthenticationToken) {
//                return (UserDetails) ((RememberMeAuthenticationToken) authentication).getPrincipal();
//            }
//        }
//        return null;
//    }
}
