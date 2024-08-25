package com.security.asfalea.controller;
/*
 * @author Naveen K Wodeyar
 * @date 23-08-2024
 */

import com.security.asfalea.dao.StudentsDao;
import com.security.asfalea.entity.Student;
import com.security.asfalea.entity.Students;
import com.security.asfalea.service.StudentsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Tag(name = "Students_Controller",description = "Students entity related CRUD operations,")
@RestController
@RequestMapping("/api/v1/students")
public class StudentsController {

   @Autowired
   private StudentsService studentsService;

    @Operation(
            summary = "Get_Students",
            description = "Displays the available Student list,",
            parameters = {
                    @Parameter(name = "message", description = "The message to be returned", required = false, example = "Hello")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "Internal Sever Error")
    })
    @GetMapping("/list")
    public ResponseEntity<List<Students>> getStudents() {
        log.info("Fetching student list");
        List<Students> students = studentsService.getStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @Operation(
            summary = "Add_Student",
            description = "Creates/Adds new student,",
            parameters = {
                    @Parameter(name = "message", description = "The message to be returned", required = false, example = "Hello")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "Internal Sever Error")
    })
    @PostMapping("/add")
    public ResponseEntity<Students> addStudents(@RequestBody StudentsDao request) {
        Students students = studentsService.addStudent(request);
        log.error("Inserted new student,");
        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }


    @GetMapping("/getStudent/{studentId}")
    public ResponseEntity<Students> getStudent(@RequestParam Long studentId) {
        Students student = studentsService.getStudent(studentId);
        log.error("Student found {}",student);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }
}
