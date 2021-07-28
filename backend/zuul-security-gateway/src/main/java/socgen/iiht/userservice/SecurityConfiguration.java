package socgen.iiht.userservice;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import socgen.iiht.userservice.util.JwtRequestFilter;


@EnableWebSecurity
@Configuration
@CrossOrigin
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtRequestFilter jwtRequestfilter;
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    @Override
    @LoadBalanced
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable()
                .cors().and()
                .authorizeRequests()

                .antMatchers("/company/get_companies").hasAnyAuthority("ROLE_ADMIN","ROLE_USER")
                .antMatchers("/company/add_company").hasAuthority("ROLE_ADMIN")
                .antMatchers("/company/deleteCompanyById/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/company/update_company/**").hasAuthority("ROLE_ADMIN")

                .antMatchers("/stock_exchange/get_all").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
                .antMatchers("/stock_exchange/**").hasAuthority("ROLE_ADMIN")

                .antMatchers("/sector/get_all_sectors").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
                .antMatchers("/sector/**").hasAuthority("ROLE_ADMIN")

                .antMatchers("/ipodetails/get_all_ipo_details").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
                .antMatchers("/ipodetails/**").hasAuthority("ROLE_ADMIN")

                .antMatchers("/ipodetails/get_all_ipo_details").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
                .antMatchers("/ipodetails/**").hasAuthority("ROLE_ADMIN")

                .antMatchers("/er_maps/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")

                .antMatchers("/api/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")

                .antMatchers("/jwt-request").permitAll()
                .antMatchers("/post_cred").permitAll()

                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestfilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(ImmutableList.of("*"));
        configuration.setAllowedMethods(ImmutableList.of("HEAD",
                "GET", "POST", "PUT", "DELETE", "PATCH"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(ImmutableList.of("Authorization", "Cache-Control", "Content-Type"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
