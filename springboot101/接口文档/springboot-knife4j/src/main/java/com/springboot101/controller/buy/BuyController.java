package com.springboot101.controller.buy;


import com.springboot101.po.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/buy")
@Api(tags = "商家管理")
@RestController
public class BuyController {

    @ApiOperation("创建商家")
    @PostMapping("/createBuy")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(user);
    }

    @ApiOperation("更新商家")
    @PostMapping("/updateBuy/{id}")
    public ResponseEntity<User> updateUser(@ApiParam(value = "商家主键ID", required = true) @PathVariable("id") String id,
                                           @RequestHeader("token") String token,
                                           @RequestParam("name") String name,
                                           @RequestBody User user) {
        return ResponseEntity.ok(user);
    }
}
