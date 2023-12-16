package com.matrixabacus.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "users")
class User() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null;

    @Column(name = "name")
    lateinit var username: String;

    @Column
    lateinit var password: String;

    @Column
    lateinit var email: String;

    @Column(name = "exercisesCompleted")
    var exercisesCompleted: Int = 0;

    @Column
    var level: Int = 1;

    @Column
    var xp: Int = 0

    fun copy(id: Int? = null,
             name: String = this.username,
             email: String = this.email,
             password: String = this.password,
             exercisesCompleted: Int = this.exercisesCompleted,
             level: Int = this.level,
             xp: Int = this.xp) : User {

        return User(id, name, email, password, exercisesCompleted, level, xp);
    }

    constructor(id: Int? = null,name: String = "", email: String = "", password: String = "", exercisesCompleted: Int = 0, level: Int = 1, xp: Int = 0) : this() {
        this.id = id;
        this.username = name;
        this.email = email;
        this.password = password;
        this.exercisesCompleted = exercisesCompleted;
        this.level = level;
        this.xp = xp;
    }

}