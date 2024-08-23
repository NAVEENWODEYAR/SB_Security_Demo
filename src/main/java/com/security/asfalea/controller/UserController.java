package com.security.asfalea.controller;/*
 * @author Naveen K Wodeyar
 * @date 23-08-2024
 */

import com.security.asfalea.entity.Users;
import com.security.asfalea.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@Slf4j
@Tag(name = "User_Controller",description = "User Registration and login API,")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(
            summary = "Register",
            description = "Creates user/Register the new User,",
            parameters = {
                    @Parameter(name = "message", description = "The message to be returned", required = false, example = "Hello")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "Internal Sever Error")
    })
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Users register(@RequestBody Users request){
        log.info("User Registration,");
        return userService.registerUser(request);
    }

    @Operation(
            summary = "Generate_Token",
            description = "EndPoint to generate the Json Web Token,",
            parameters = {
//                    @Parameter(name = "message", description = "The message to be returned", required = false, example = "Hello")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "Internal Sever Error")
    })
    @PostMapping("/generateToken")
    @ResponseStatus(HttpStatus.CREATED)
    public String login(@RequestBody Users request){
        log.error("User Login,");
        return userService.generateToken(request);

    }
}
