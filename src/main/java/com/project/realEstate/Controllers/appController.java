package com.project.realEstate.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class appController {

    @RequestMapping("/")
    public String index(){

        return "index";
    }
}
