package com.springboot101.controller;


import com.springboot101.dto.UserDto;
import com.springboot101.po.User;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Api(value = "用户管理接口描述",
        description = "用户管理接口描述",
        hidden = false,
        produces = "application/json",
        consumes = "application/json",
        protocols = "https",
        tags = {"用户管理"},
        authorizations = {
                @Authorization(value = "apiKey", scopes = {
                        @AuthorizationScope(scope = "read:user", description = "读权限"),
                        @AuthorizationScope(scope = "write:user", description = "写权限")
                }),
                @Authorization(value = "basicAuth")
        })
@RestController
public class UserController {

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "@ApiResponse注解测试通过", response = String.class),
            @ApiResponse(code = 401, message = "可能参数填的有问题", response = String.class),
            @ApiResponse(code = 404, message = "可能请求路径写的有问题", response = String.class)
    })
    @GetMapping("/user4")
    public String user4(@ApiParam(name = "主键ID", value = "@ApiParam注解测试", required = true) String id) {
        return id;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "用户名", value = "用户名称信息", required = true, dataType = "String", paramType = "query")
    })
    @GetMapping("/user")
    public String user(String name) {
        return name;
    }

    @ApiOperation(
            value = "获取用户信息",
            notes = "通过用户ID获取用户的详细信息",
            hidden = false,
            response = UserDto.class,
            tags = {"用户管理"},
            produces = "application/json",
            consumes = "application/json",
            protocols = "https",
            authorizations = {
                    @Authorization(value = "apiKey", scopes = {@AuthorizationScope(scope = "read:user", description = "Read user information")}),
                    @Authorization(value = "Basic")
            },
            responseHeaders = {@ResponseHeader(name = "X-Custom-Header", description = "Custom header", response = String.class)},
            code = 200
    )
    @GetMapping("/user1")
    public UserDto user1(@RequestBody User user) {
        return new UserDto();
    }

    @ApiIgnore
    @GetMapping("/user2/{id}")
    public User test2(@PathVariable Integer id, @RequestBody User user) {
        return user;
    }
}
