package com.matrixabacus.controller.request

import com.matrixabacus.model.User

class PutUserRequest {
    var name: String = "";
    var email: String = "";
    var password: String = "";
    var exercisesCompleted: Int = 0;
    var level: Int = 1;
    var xp: Int = 0;

    fun toUser(): User {
        return User(null, name, email, password, exercisesCompleted, level, xp);
    }
}