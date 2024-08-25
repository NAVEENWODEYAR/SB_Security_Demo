package com.security.asfalea.entity;
/*
 * @author Naveen K Wodeyar
 * @date 23-08-2024
 */

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Tag(name = "Students_Entity", description = "Students_Entity for the persisting the Students information")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "JWT_STUDENT")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stId;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;;

    @Column(name = "st_marks", length = 50, nullable = false)
    private int stMarks;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "mail", length = 50, nullable = false)
    private String mail;

    @Column(name = "gender", length = 50, nullable = false)
    private String gender;

}
