package io.bramcode.movie.moviecategoryservices.security;

import io.bramcode.movie.moviecategoryservices.auth.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static io.bramcode.movie.moviecategoryservices.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    //private final ApplicationUserService applicationUserService;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }


    //Basic Auth
    @Override
    protected void configure(HttpSecurity http) throws Exception {
     //the order of antMatcher is really matter
     //if use annotations @PreAuthorize then it needs to comment out of the antMatchers and enable global method security with flag true
     //if authentication failed when using csrf then it must generate new token
        http
                .csrf().disable()
                .authorizeRequests() // wants authorize request
                .antMatchers("/","index","/css/*","/js/*").permitAll() // whitelist some urls
                .anyRequest() //any request
                .authenticated() //must be authenticated
                .and()
                .httpBasic(); // and use mechanism basic authentication
    }

    /// Using InMemoryUserDetailsManager with manual hardcode config
    @Override
    @Bean //instance
    protected UserDetailsService userDetailsService() {
        UserDetails bramarAdmin = User.builder()
                .username("Bramar")
                .password(passwordEncoder.encode("password"))
                //.roles(ADMIN.name()) // ROLE_ADMIN -> this how spring security understand
                .authorities(ADMIN.getGrantedAuthorities()) //Authentication based on permission
                .build();

        UserDetails traineeAdmin = User.builder()
                .username("Trainee")
                .password(passwordEncoder.encode("trainee"))
                //.roles(ADMINTRAINEE.name()) // ROLE_ADMIN_TRAINEE -> this how spring security understand
                .authorities(ADMIN_TRAINEE.getGrantedAuthorities())
                .build();

        UserDetails userA = User.builder()
                .username("UserA")
                .password(passwordEncoder.encode("userA123"))
               // .roles(EMPLOYEE.name()) // ROLE_EMPLOYEE -> this how spring security understand
                .authorities(STAFF.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(
                bramarAdmin,
                traineeAdmin,
                userA
        );
    }
}
