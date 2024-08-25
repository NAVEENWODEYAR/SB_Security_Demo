package com.security.asfalea.service;

import com.security.asfalea.dao.StudentsDao;
import com.security.asfalea.entity.Students;
import com.security.asfalea.repo.StudentsRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ObjectUtils;

import java.util.List;

/*
 * @author Naveen K Wodeyar
 * @date 25-08-2024
 */
@Service
public class StudentsService {

    @Autowired
    private StudentsRepo studentsRepo;

    public Students addStudent(StudentsDao studentsDao){
        Students students = new Students();
        BeanUtils.copyProperties(studentsDao,students);
        return studentsRepo.save(students);
    }

    public List<Students> getStudents(){
        return studentsRepo.findAll();
    }

    public Students getStudent(Long stId){
        return studentsRepo.findById(stId).get();
    }
}
