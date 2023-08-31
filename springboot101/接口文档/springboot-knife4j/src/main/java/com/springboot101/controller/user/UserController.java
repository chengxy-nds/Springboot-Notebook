package com.springboot101.controller.user;


import com.springboot101.po.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@Api(tags = "用户管理")
@RestController
public class UserController {

    @ApiOperation("创建用户")
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(user);
    }

    @ApiOperation("更新用户")
    @PostMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@ApiParam(value = "用户主键ID", required = true) @PathVariable("id") String id,
                                           @RequestHeader("token") String token,
                                           @RequestParam("name") String name,
                                           @RequestBody User user) {
        return ResponseEntity.ok(user);
    }
}
