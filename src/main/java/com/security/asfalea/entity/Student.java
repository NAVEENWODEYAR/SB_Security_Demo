package com.security.asfalea.entity;/*
 * @author Naveen K Wodeyar
 * @date 23-08-2024
 */

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Tag(name = "Student_Entity", description = "Student_Entity for the persisting the student information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int stId;

    private String stName;;

    private int stMarks;

}
