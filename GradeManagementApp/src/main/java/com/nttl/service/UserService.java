/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nttl.service;

import com.nttl.pojo.User;
import java.util.List;

/**
 *
 * @author Ly Nguyen
 */
public interface UserService {

    List<User> getLecturer();

    List<User> getStudent();
    void addOrUpdate(User u);
     User getUserById(int id);
}
