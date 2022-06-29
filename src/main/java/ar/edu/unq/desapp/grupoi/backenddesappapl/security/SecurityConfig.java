package ar.edu.unq.desapp.grupoi.backenddesappapl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import ar.edu.unq.desapp.grupoi.backenddesappapl.service.UserAuthDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
    private UserAuthDetailsService userDetailsService;
	
	@Value("${security.withoutAutentication}")
    private boolean testWithoutAuthentication;
	
	@Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	if (testWithoutAuthentication) {
    		http
            .csrf().disable()
            .authorizeRequests().anyRequest().permitAll();
    	}else {
			http
	    	.csrf().disable()
	    	.authorizeRequests()
	    	.antMatchers("/user/register").permitAll()
	    	.antMatchers("/user/login").permitAll()
	    	.anyRequest().authenticated()
	    	.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    	}
        
        http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.ACCEPTED));
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}