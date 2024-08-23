package com.security.asfalea.service;/*
 * @author LENOVO
 * @date 23-08-2024
 */

import com.security.asfalea.entity.Users;
import com.security.asfalea.jwt.JwtService;
import com.security.asfalea.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public Users registerUser(Users request){
        request.setUserPassword(bCryptPasswordEncoder.encode(request.getUserPassword()));
        return userRepo.save(request);
    }

    public String generateToken(Users request){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(),request.getUserPassword()));

        if (authentication.isAuthenticated()){
            return jwtService.generateToken(request.getUserName());
        }else {
            return "FAILURE";
        }

    }
}
