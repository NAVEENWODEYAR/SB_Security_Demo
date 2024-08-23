package com.security.asfalea.service;/*
 * @author Naveen K Wodeyar
 * @date 23-08-2024
 */

import com.security.asfalea.entity.UserPrinciple;
import com.security.asfalea.entity.Users;
import com.security.asfalea.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepo.findByUserName(username);
        if (user==null){
            System.out.println("User not found: " + username);
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrinciple(user);
    }
}
