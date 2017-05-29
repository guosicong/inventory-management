package inventory.springservice.configuration;

import inventory.springservice.domain.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        
                .authorizeRequests()
                .antMatchers("/", "/home", "/greeting").permitAll()                
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .and()
                .logout()
                .permitAll()
                .and().csrf().disable();
        /*
		        .authorizeRequests()
		        .antMatchers("/", "/home", "/greeting").permitAll()
		        .anyRequest().authenticated()
		        .and()
		        .formLogin()
		        .loginPage("/login")
		        .permitAll()
		        .and()
		        .logout()
		        .permitAll()
		        .and().csrf().disable();
		        */
    }
/*
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("pas").roles("USER");
    }
  */  
    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

}