package com.matrixabacus.repository

import com.matrixabacus.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository :  CrudRepository<User,Int> {

}