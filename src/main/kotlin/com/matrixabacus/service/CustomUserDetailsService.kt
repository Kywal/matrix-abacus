package com.matrixabacus.service

import com.matrixabacus.repository.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsPasswordService
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

typealias ApplicationUser = com.matrixabacus.model.User;

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
): UserDetailsService, UserDetailsPasswordService {

    override fun loadUserByUsername(username: String?): UserDetails {
        if (username != null) {
            return userRepository.findById(username.toInt())
                .getOrNull()
                ?.mapToUserDetails()
                ?: throw NoSuchElementException("Not Found!")
        };
        
        else {
            throw NoSuchElementException("Id not received!")
        }
    }

    private fun ApplicationUser.mapToUserDetails(): UserDetails =
        User.builder()
            .username(this.email)
            .password(this.password)
            .build()

    override fun updatePassword(user: UserDetails?, newPassword: String?): UserDetails {
        TODO("Not yet implemented")
    }

}