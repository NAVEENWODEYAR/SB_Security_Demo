package com.security.asfalea.controller;/*
 * @author LENOVO
 * @date 23-08-2024
 */

import com.security.asfalea.entity.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@Slf4j
@Tag(name = "Student_Controller",description = "Student entity related CRUD operations,")
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final List<Student> studentList = new ArrayList<>(
            List.of(
                    new Student(1,"Gowri",90),
                    new Student(2,"Nandi",80))
            );

    @Operation(
            summary = "Get_Students",
            description = "Displays the available student list,",
            parameters = {
                    @Parameter(name = "message", description = "The message to be returned", required = true, example = "Hello")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "Internal Sever Error")
    })
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Student> getStudents(){
        log.info("Student list found,");
        return studentList;
    }

    @Operation(
            summary = "Add_Student",
            description = "Creates/Adds new student,",
            parameters = {
                    @Parameter(name = "message", description = "The message to be returned", required = true, example = "Hello")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "Internal Sever Error")
    })
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudents(@RequestBody Student request){
         studentList.add(request);
         log.error("Added new student,");
         return request;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest httpServletRequest){
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }
}