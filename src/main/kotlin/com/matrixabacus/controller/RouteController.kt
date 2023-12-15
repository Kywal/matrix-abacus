package com.matrixabacus.controller

import com.matrixabacus.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class RouteController(val userService: UserService) {

    @RequestMapping("/")
    fun welcome() : String {
        return "index.html";
    }

    @RequestMapping("playground")
    fun toPlayground() : String {
        return "playground.html";
    }
    
    @RequestMapping("login")
    fun toLogin() : String {
        return "perfil.html";
    }

}