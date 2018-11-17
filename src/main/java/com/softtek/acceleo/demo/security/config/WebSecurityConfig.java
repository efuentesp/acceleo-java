package com.softtek.acceleo.demo.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.softtek.acceleo.demo.security.JwtAuthenticationEntryPoint;
import com.softtek.acceleo.demo.security.JwtAuthorizationTokenFilter;
import com.softtek.acceleo.demo.security.JwtTokenUtil;
import com.softtek.acceleo.demo.security.service.JwtUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@PropertySource("application.properties")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

                private final Logger logger = LoggerFactory.getLogger(this.getClass());

                // @Autowired
                private JwtAuthenticationEntryPoint unauthorizedHandler = new JwtAuthenticationEntryPoint();

                @Autowired
                private JwtTokenUtil jwtTokenUtil;

                @Autowired
                private JwtUserDetailsService jwtUserDetailsService;

                @Value("${jwt.header}")
                private String tokenHeader;

                @Value("${jwt.route.authentication.path}")
                private String authenticationPath;

                @Autowired
                public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                               auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoderBean());

                               logger.info("configureGlobal: tokenHeader" + tokenHeader);
                }

               
                public void addCorsMappings(CorsRegistry registry) {
                               logger.info("Ingresando addCorsMApping...");
                               //registry.addMapping("/**");
                               //registry.addMapping("/**").allowedOrigins("http://172.16.69.4:4200").allowCredentials(true).allowedMethods("*").allowedHeaders(
                               registry.addMapping("/**").allowedOrigins("http://172.16.70.220:4200").allowCredentials(true).allowedMethods("*").allowedHeaders(
                                                               "Content-Type, Access-Control-Allow-Origin, Access-Control-Allow-Headers, Authorization, X-Requested-With, requestId, Correlation-Id");
                }

                @Bean
                public PasswordEncoder passwordEncoderBean() {
                               return new BCryptPasswordEncoder();
                }

                @Bean
                @Override
                public AuthenticationManager authenticationManagerBean() throws Exception {
                               logger.info("authenticationManagerBean");

                               return super.authenticationManagerBean();
                }

                @Override
                protected void configure(HttpSecurity httpSecurity) throws Exception {

                               logger.info("configure");

                               httpSecurity
                               
                                                               // we don't need CSRF because our token is invulnerable
                                                               .csrf().disable()

                                                               .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()

                                                               // No se crea ninguna sesion
                                                               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                                                               .authorizeRequests()
                                                               //.antMatchers(HttpMethod.OPTIONS,"**").permitAll()
                                                               .antMatchers("/auth/**").permitAll()

                                                               // Revisar para quitar
                                                               //.antMatchers("/**").permitAll()
                                                               .anyRequest().authenticated();

                               // Custom JWT based security filter
                               JwtAuthorizationTokenFilter authenticationTokenFilter = new JwtAuthorizationTokenFilter(userDetailsService(),
                                                               jwtTokenUtil, tokenHeader);
                               httpSecurity.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

                }

                @Override
                public void configure(WebSecurity web) throws Exception {
                               // El filtro AuthenticationTokenFilter ignora las rutas de abajo
                               // La peticion inicial post se ignora y envia al controller
                               // es decir 
                               web.ignoring().antMatchers(HttpMethod.POST, authenticationPath)
                               //.and().ignoring().antMatchers(HttpMethod.POST, "/auth")
                                      // .and().ignoring().antMatchers(HttpMethod.GET,"/user")
                                      // .and().ignoring().antMatchers(HttpMethod.POST,"/user")                      
                                                               // allow anonymous resource requests
                                               .and().ignoring()
                                                               .antMatchers(HttpMethod.GET, "/*.html", "/*.jsp", "/favicon.ico", "/**/*.html",
                                                                                              "/**/*.css", "/**/*.js");
                }
}
