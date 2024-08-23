package com.security.asfalea.service;/*
 * @author LENOVO
 * @date 23-08-2024
 */

import com.security.asfalea.entity.Users;
import com.security.asfalea.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Users registerUser(Users request){
        return userRepo.save(request);
    }
}
