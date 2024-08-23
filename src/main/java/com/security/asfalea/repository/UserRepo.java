package com.security.asfalea.repository;/*
 * @author Naveen K Wodeyar
 * @date 23-08-2024
 */

import com.security.asfalea.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Long> {

    Users findByUserName(String userName);
}
