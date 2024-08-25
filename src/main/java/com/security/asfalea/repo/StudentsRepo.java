package com.security.asfalea.repo;
/*
 * @author Naveen K Wodeyar
 * @date 25-08-2024
 */

import com.security.asfalea.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepo extends JpaRepository<Students,Long> {
}
