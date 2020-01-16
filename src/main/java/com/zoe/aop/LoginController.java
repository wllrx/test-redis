package com.zoe.aop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    @Login
    public ResponseEntity<String> login(){
        return ResponseEntity.ok("login success");
    }
}
