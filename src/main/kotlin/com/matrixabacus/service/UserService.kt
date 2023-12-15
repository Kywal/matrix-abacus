package com.matrixabacus.service

import com.matrixabacus.controller.request.PutUserRequest
import com.matrixabacus.model.User
import com.matrixabacus.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(val userRepository: UserRepository) {

    fun create(user: User) {
        userRepository.save(user);
    }

    fun getUser(id: Int): User {
        return userRepository.findById(id).orElseThrow();
    }

    fun update(id: Int, user: User) {
        val optionUser = userRepository.findById(id);
        if (optionUser.isPresent) {
            var currUser = optionUser.get();
            currUser.username = user.username;
            currUser.email = user.email;
            currUser.password = user.password;
        }
    }

    fun delete(id: Int) {
        return userRepository.deleteById(id);
    }

}