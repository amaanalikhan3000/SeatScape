package com.SeatScape.SeatScape.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/check")
    public String check(){
        return "Check successful";
    }
}
