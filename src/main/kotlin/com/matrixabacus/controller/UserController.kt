package com.matrixabacus.controller

import com.matrixabacus.controller.request.PostUserRequest
import com.matrixabacus.controller.request.PutUserRequest
import com.matrixabacus.model.User
import com.matrixabacus.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
    private val userService: UserService
) {

    @PostMapping("login/signUp")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody postUser : PostUserRequest): User {
        val user = postUser.toUser();
        userService.create(user);
        return user;
    }

    @GetMapping("users")
    fun getAll() : MutableIterable<User> {
        return userService.getAll();
    }

    @GetMapping("user/{id}")
    fun getUser(@PathVariable id: Int) : User {
        return userService.getUser(id);
    }

    @PutMapping("user/{id}/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateName(@PathVariable id: Int?, @RequestBody putUser : PutUserRequest) {
        userService.update(id, putUser);
    }

    @DeleteMapping("user/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        userService.delete(id);
    }
}