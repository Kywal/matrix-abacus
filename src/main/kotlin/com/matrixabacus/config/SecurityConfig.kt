package com.matrixabacus.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val authenticationProvider: AuthenticationProvider
) {

    @Bean
    fun filterChain(
        http : HttpSecurity,
        jwtAuthenticationFilter: JwtAuthenticationFilter
    ) : SecurityFilterChain {
        http {

            csrf {
                disable()
            }

            authorizeRequests {
                authorize("/home", permitAll)
                authorize("/playground", authenticated)
//                authorize("/", permitAll)
            }

            formLogin {
                loginPage = "/login"
                permitAll()
            }
            httpBasic {  }

            sessionManagement {
                sessionCreationPolicy = SessionCreationPolicy.STATELESS
            }

//            authenticationManager = providerManager(authenticationProvider)
            addFilterBefore<UsernamePasswordAuthenticationFilter>(filter = jwtAuthenticationFilter)

        }

        return http.build();
    }

    @Bean
    fun userDetailsService(): UserDetailsService {
        val user = User.withDefaultPasswordEncoder()
            .username("username")
            .password("password")
            .build();

        return InMemoryUserDetailsManager(user);
    }

    @Bean
    fun bCryptPasswordEncoder() : BCryptPasswordEncoder {
        return BCryptPasswordEncoder();
    }



}