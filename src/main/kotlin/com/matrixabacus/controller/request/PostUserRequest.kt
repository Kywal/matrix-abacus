package com.matrixabacus.controller.request

import com.matrixabacus.model.User

class PostUserRequest {
    var name: String = "";
    var email: String = "";
    var password: String = "";

    fun toUser(): User {
        return User(name, email, password);
    }
}