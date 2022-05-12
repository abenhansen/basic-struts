package basics.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@ComponentScan("basics")
@EnableTransactionManagement
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.cors().and().csrf().disable();

        httpSecurity.authorizeRequests()
                .antMatchers("/superadmin/**").access("hasRole('ROLE_SUPER_ADMIN')")
                .antMatchers("/admin/**").access("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')")
                .antMatchers("/employee/**").access("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
                .and()
                .formLogin()
                .loginPage("/dashboard/login.html")
                .loginProcessingUrl("/dashboard/process-login.html")
                .defaultSuccessUrl("/dashboard/welcome.html")
                .failureUrl("/dashboard/login.html?error")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/dashboard/logout.html")
                .logoutSuccessUrl("/dashboard/login.html?logout").and()
                .exceptionHandling()
                .accessDeniedPage("/dashboard/accessDenied.html");
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("superadmin").password(passwordEncoder().encode("123456")).authorities("ROLE_SUPER_ADMIN", "ROLE_ADMIN", "ROLE_EMPLOYEE")
                .and()
                .withUser("admin").password(passwordEncoder().encode("123456")).authorities("ROLE_ADMIN", "ROLE_EMPLOYEE")
                .and()
                .withUser("employee").password(passwordEncoder().encode("123456")).authorities("ROLE_EMPLOYEE");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
