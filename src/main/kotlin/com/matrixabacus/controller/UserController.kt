package com.matrixabacus.controller

import com.matrixabacus.controller.request.PostUserRequest
import com.matrixabacus.controller.request.PutUserRequest
import com.matrixabacus.model.User
import com.matrixabacus.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class UserController(val userService: UserService) {

    @PostMapping("login/signUp")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody postUser : PostUserRequest): User {
        val user = postUser.toUser();
        userService.create(user);
        return user;
    }

    @GetMapping("user/{id}")
    fun getUser(@PathVariable id: Int) : User {
        return userService.getUser(id);
    }

    @PutMapping("user/{id}/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody user : PutUserRequest) {
        userService.update(id, user.toUser());
    }

    @DeleteMapping("user/{id}/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        userService.delete(id);
    }
}