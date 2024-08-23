package com.security.asfalea.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "Test_Controller", description = "Dummy controller")
@RestController
@RequestMapping("/api/v1")
public class TestController {

    /**
     * @return
     */
    @Operation(summary = "Test endPoint,", description = "Returns the string message.")
    @GetMapping
    public ResponseEntity<?> test(){
        return ResponseEntity
                .status(HttpStatus.EARLY_HINTS)
                .header("String","Test-Endpoint")
                .body("Welcome to Test_Controller!,");
    }
}
