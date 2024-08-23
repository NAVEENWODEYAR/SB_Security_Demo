package com.security.asfalea.entity;/*
 * @author Naveen K Wodeyar
 * @date 23-08-2024
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class Users {

    @Id
    private int userId;

    private String userName;

    private String userPassword;

}
