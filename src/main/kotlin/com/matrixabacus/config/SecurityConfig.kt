package com.matrixabacus.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig() {

    @Bean
    fun filterChain(http : HttpSecurity) : SecurityFilterChain {
        http.invoke {
            csrf {
                disable()
            }

            authorizeRequests {
                authorize(anyRequest,permitAll)
            }

            formLogin {  }
            httpBasic {  }
        }

        return http.build();
    }

//    @Bean
//    fun userDetailsService(): UserDetailsService {
//        val user = User.withDefaultPasswordEncoder()
//            .username("username")
//            .password("password")
//            .build();
//
//        return InMemoryUserDetailsManager(user);
//    }

    @Bean
    fun bCryptPasswordEncoder() : BCryptPasswordEncoder {
        return BCryptPasswordEncoder();
    }
}