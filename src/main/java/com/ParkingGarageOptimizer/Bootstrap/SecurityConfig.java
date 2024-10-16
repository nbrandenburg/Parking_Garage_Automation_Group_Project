/*
    Written By: Oakley Cardwell
    Reviewed By: Gene Holt, Nicole Brandenburg
*/

package com.ParkingGarageOptimizer.Bootstrap;


import org.springframework.context.annotation.Configuration;


@Configuration
//@EnableWebSecurity
public class SecurityConfig {

    /*@Autowired
    private CustomUserService userDetailsService;

    @SuppressWarnings("deprecation")
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    // Using MvcRequestMatcher for Spring MVC endpoints
                    auth.requestMatchers(new MvcRequestMatcher(null, "/userlogin"))
                            .permitAll();
                    auth.requestMatchers(new MvcRequestMatcher(null, "/adminlogin"))
                            .permitAll();
                    // ... add more MvcRequestMatcher if needed ...

                    // Using AntPathRequestMatcher for non-Spring MVC endpoints
                    auth.requestMatchers(new AntPathRequestMatcher("/h2-console/**"))
                            .permitAll();
                    auth.requestMatchers(new AntPathRequestMatcher("/files/**"))
                            .permitAll();
                    auth.requestMatchers(new AntPathRequestMatcher("/resources/**"))
                            .permitAll();
                    auth.requestMatchers(new AntPathRequestMatcher("/static/**"))
                            .permitAll();
                    auth.requestMatchers(new AntPathRequestMatcher("/js/**"))
                            .permitAll();
                    auth.requestMatchers(new AntPathRequestMatcher("/styles.css"))
                            .permitAll();
                    auth.requestMatchers(new AntPathRequestMatcher("/templates/**"))
                            .permitAll();
                    auth.requestMatchers(new AntPathRequestMatcher("/user-panel"))
                            .permitAll();
                    auth.requestMatchers(new AntPathRequestMatcher("/admin-panel"))
                            .permitAll();
                    auth.anyRequest().authenticated();
                })
                //Configuration to enable /h2-console endpoint
                .csrf()
                .ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"))
                .and()
                .headers()
                .frameOptions()
                .sameOrigin()
                .and()
                //Disable default spring security login
                .formLogin().disable()
                .build();
    }

    @SuppressWarnings("deprecation")
    @Bean
    public NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }*/
}
