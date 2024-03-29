package ca.sheridancollege.Assignment4.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private String Identity_Manager = "Manager";
    private String Identity_User = "User";
    private LoggingAccessDeniedHandler accessDeniedHandler;

    @Autowired
    public void setAccessDeniedHandler(LoggingAccessDeniedHandler accessDeniedHandler){
        this.accessDeniedHandler = accessDeniedHandler;
    }
    @Override
    public void configure( HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/user/**").hasAnyRole(Identity_User,Identity_Manager) //.permitAll()
                .antMatchers("/secured/**").hasAnyRole(Identity_User,Identity_Manager)
                .antMatchers("/manager/**").hasRole(Identity_Manager)
                .antMatchers("/","/**").permitAll()
                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/secured").and()
                .logout().permitAll().invalidateHttpSession(true)
                .clearAuthentication(true)
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler);

//        http.authorizeRequests()
//                .antMatchers("/manager/**").hasRole(ROLE_MANAGER)//.permitAll()
//                .antMatchers("/","/**").permitAll()
//                .and()
//                .formLogin()
//                //.loginPage("/customLogin")
//                .defaultSuccessUrl("/secured");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("bugs").password("bunny").roles(Identity_User)
                .and()
                .withUser("daffy").password("duck").roles(Identity_User,Identity_Manager);

//        auth.inMemoryAuthentication()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .withUser("Liza").password("bunny").roles(ROLE_MANAGER);
    }

}
