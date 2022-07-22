package pl.javastart.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class StaticPagesController {

    @GetMapping("/")
    String home() {
        return "index";
    }

    @GetMapping("/success")
    String confirmation() {
        return "success";
    }
}
