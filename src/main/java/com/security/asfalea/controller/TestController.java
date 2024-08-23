package com.security.asfalea.controller;

import io.swagger.v3.oas.annotations.Operation;
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
@Tag(name = "Test_Controller", description = "Dummy controller")
@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    /**
     * @return
     */
    @Operation(summary = "Test endPoint,", description = "Returns the string message.")
    @GetMapping("/greet/{name}")
    public ResponseEntity<?> greet(@PathParam("name") String name){
        log.info("Greet Endpoint,");
        return ResponseEntity
                .status(HttpStatus.EARLY_HINTS)
                .header("String","Test-Endpoint")
                .body(name+" Welcome to Test_Controller!,");
    }

    @Operation(summary = "Test endPoint,", description = "Returns the string message.")
    @GetMapping
    public ResponseEntity<?> test(HttpServletRequest httpServletRequest){
        log.info("Test endPoint");
        return ResponseEntity.ok("Session-Id\n "+httpServletRequest.getSession().getId());
    }
}
