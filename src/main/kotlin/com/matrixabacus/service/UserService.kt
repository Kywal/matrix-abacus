package com.matrixabacus.service

import com.matrixabacus.controller.request.PutUserRequest
import com.matrixabacus.model.User
import com.matrixabacus.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*
import kotlin.NoSuchElementException
import kotlin.jvm.optionals.toSet

@Service
class UserService(
    private val userRepository : UserRepository,
    private val bCrypt : BCryptPasswordEncoder
) {

    fun create(user: User) {
        val userCopy = user.copy(
            password = bCrypt.encode(user.password)
        );
        userRepository.save(userCopy);
    }

    fun getAll(): MutableIterable<User> {
        return userRepository.findAll();
    }

    fun getUser(id: Int): User {
        return userRepository.findById(id).orElseThrow();
    }

    fun update(id: Int?, putUser: PutUserRequest) {

        var user = userRepository.findById(id!!).orElseThrow()
        user.username = putUser.name;
        user.email = putUser.email;

        userRepository.save(user);
    }

    fun delete(id: Int) {
        return userRepository.deleteById(id);
    }

}