package com.security.asfalea.controller;/*
 * @author LENOVO
 * @date 23-08-2024
 */

import com.security.asfalea.entity.Users;
import com.security.asfalea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Users register(@RequestBody Users request){
        return userService.registerUser(request);
    }
}
