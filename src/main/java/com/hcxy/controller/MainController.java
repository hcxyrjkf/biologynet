package com.hcxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Sjming
 * 2017-08-31 15:19
 */
@Controller
public class MainController {

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }
}
