package com.matrixabacus.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class RouteController {

    @RequestMapping("/")
    public fun welcome() : String {
        return "index.html";
    }

    @RequestMapping("playground")
    public fun toPlayground() : String {
        return "playground.html"
    }
    
    @RequestMapping("login")
    public fun toLogin() : String {
        return "perfil.html"
    }
}