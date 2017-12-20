package chenweipan.journal.config;

import chenweipan.journal.security.AuthenticationHandler;
import chenweipan.journal.security.LoginUserServiceImpl;
import chenweipan.journal.security.MyAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/user/login.json").permitAll()
                .and().authorizeRequests().anyRequest().authenticated()
                .and().csrf().disable()
                .logout().deleteCookies("JSESSIONID").invalidateHttpSession(true).logoutUrl("/user/logout.json").logoutSuccessHandler(customAuthenticationHandler())
                .and().addFilter(customAuthenticationFilter())
                .httpBasic().authenticationEntryPoint(customAuthenticationHandler());
        ;
    }

    @SuppressWarnings("deprecation")
    @Bean
    MyAuthenticationFilter customAuthenticationFilter() throws Exception {
        MyAuthenticationFilter filter = new MyAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(customAuthenticationHandler());
        filter.setAuthenticationFailureHandler(customAuthenticationHandler());
        //这句很关键，重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不然要自己组装AuthenticationManager
        filter.setAuthenticationManager(authenticationManagerBean());
        filter.setFilterProcessesUrl("/user/login.json");
        return filter;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(customUserDetailsService()).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);
    }

    @Bean
    public LoginUserServiceImpl customUserDetailsService() {
        return new LoginUserServiceImpl();
    }

    @Bean
    public AuthenticationHandler customAuthenticationHandler() {
        return new AuthenticationHandler();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }
}
