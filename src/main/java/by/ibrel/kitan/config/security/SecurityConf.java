package by.ibrel.kitan.config.security;

import by.ibrel.kitan.config.CommonConfig;
import by.ibrel.kitan.config.DbConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

/**
 * @author ibrel
 * @version 1.0
 * @email ibrel7n@gmail.com
 * @datecreate (24.11.2016)
 * @datechange (24.11.2016)
 */
@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {

    @Autowired
    private  DbConf dbConf;
    @Autowired
    private  CommonConfig commonConfig;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService());
        auth.authenticationProvider(myAuthProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/resources/**", "/login_*", "/registration*", "/checkLogin").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login_")
                .successHandler(getAuthenticationSuccessHandler())
                .failureHandler(getAuthenticationFailureHandler())
                .defaultSuccessUrl("/index.jsp")
                .and()
                .csrf().disable()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login_")
                .and()
                .rememberMe()
                .key("rememberKey")
                .rememberMeServices(rememberMeServices())
                .and()
                .exceptionHandling().accessDeniedPage("/error/403");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder managerBuilder) throws Exception{
        managerBuilder.authenticationProvider(myAuthProvider());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RememberMeServices rememberMeServices(){
        PersistentTokenBasedRememberMeServices services = new PersistentTokenBasedRememberMeServices("rememberKey",
                myUserDetailsService(),jdbcTokenRepository());
        services.setAlwaysRemember(true);
        return services;
    }

    @Bean
    public PersistentTokenRepository jdbcTokenRepository(){
        MyRememberMePersistentTokenRepository jtr = new MyRememberMePersistentTokenRepository();
        jtr.setDataSource(dbConf.dataSource());
        jtr.setCreateTableOnStartup(false);
        return jtr;
    }

    @Bean
    public AuthenticationProvider myAuthProvider() throws Exception {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(myUserDetailsService());
        return authenticationProvider;
    }

    @Bean
    public UserDetailsService myUserDetailsService(){
        return new MyUserDetailsService();
    }

    @Bean
    public AuthenticationSuccessHandler getAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler getAuthenticationFailureHandler(){
        return new CustomAuthenticationFailureHandler(commonConfig.localeResolver(),commonConfig.messageSource());
    }

    @Bean
    public MySimpleUrlAuthenticationSuccessHandler handler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new MyUserDetailsService();
    }

}
