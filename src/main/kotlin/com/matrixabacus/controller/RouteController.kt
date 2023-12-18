package com.matrixabacus.controller

import com.matrixabacus.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class PlaygroundController(val userService: UserService) {

    @RequestMapping("/")
    fun redirectToHome() : String {
        return "redirect:/home"
    }

    @RequestMapping("/home")
    fun home() : String {
        return "index.html"
    }

    @RequestMapping("playground")
    fun toPlayground() : String {
        return "playground.html";
    }

}