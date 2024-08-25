package com.security.asfalea.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@Tag(name = "Test_Controller", description = "Test controller")
@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    /**
     * @return
     */
    @Operation(
            summary = "Greet Message",
            description = "EndPoint to greet the user,",
            parameters = {
                    @Parameter(name = "message", description = "The message to be returned", required = false, example = "Hello")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "Internal Sever Error")
    })
    @GetMapping("/greet/{name}")
    public ResponseEntity<?> greet(@PathParam("name") String name){
        log.info("Greet Endpoint,");
        return ResponseEntity
                .status(HttpStatus.EARLY_HINTS)
                .header("String","Test-Endpoint")
                .body(name+" Welcome to Test_Controller!,");
    }

    @Operation(
            summary = "Test endPoint",
            description = "Displays the session-id,",
            parameters = {
                    @Parameter(name = "message", description = "The message to be returned", required = false, example = "Hello")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "Internal Sever Error")
    })
    @GetMapping
    public ResponseEntity<?> test(HttpServletRequest httpServletRequest){
        log.info("Test endPoint");
        return ResponseEntity.ok("Session-Id\n "+httpServletRequest.getSession().getId());
    }
}
