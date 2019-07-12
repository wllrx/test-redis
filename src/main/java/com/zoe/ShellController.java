package com.zoe;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @ClassName : ShellController
 * @Author : zoe
 * @Date : 2019/6/25 23:23
 */
@RestController
public class ShellController {

    @Resource
    private Shell shell;

    @GetMapping("/test")
    public void testLock(){
        shell.test();
    }
}
