/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.service.impl;

import com.nttl.pojo.User;
import com.nttl.repository.UserRepository;
import com.nttl.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ly Nguyen
 */
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepo;
    
    @Override
    public List<User> getLecturer() {
        return this.userRepo.getLecturer();
    }

    @Override
    public List<User> getStudent() {
        return this.userRepo.getStudent();
    }
    
    @Override
    public void addOrUpdate(User u) {
        this.userRepo.addOrUpdate(u);
    }
    
}
