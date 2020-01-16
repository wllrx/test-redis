package com.zoe.aop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zoe
 **/
@RestController
public class TestController {

    @GetMapping("/testLogin")
    @Login
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("OK");
    }
}
