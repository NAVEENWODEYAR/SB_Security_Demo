package com.security.asfalea.dao;
/*
 * @author Naveen K Wodeyar
 * @date 25-08-2024
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentsDao {

    private Long stId;

    private String firstName;;

    private int stMarks;

    private String lastName;

    private String mail;

    private String gender;
}
