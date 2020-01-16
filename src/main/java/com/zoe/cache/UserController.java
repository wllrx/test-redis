package com.zoe.cache;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zoe
 **/
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/save")
    @ApiOperation(value = "插入数据")
    public void saveUser() {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 20; j++) {
                    userService.saveUser(j);
                }
            }).start();
        }
    }

    @GetMapping("/user")
    @ApiOperation(value = "查询列表")
    public ResponseEntity<List<User>> listUser(String userName) {
        return ResponseEntity.ok(userService.userList(11L,userName));
    }

    @GetMapping("/delete_user")
    @ApiOperation(value = "删除")
    public ResponseEntity<String> deleteUser() {
        userService.deleteUser(11L);
        return ResponseEntity.ok("111");
    }
}
