package com.matrixabacus.controller.request

import com.matrixabacus.model.User

class PutUserRequest {
    var name: String = "";
    var email: String = "";

    fun toUser(id: Int?): User {
        return User(id = id,name = name, email = email);
    }
}