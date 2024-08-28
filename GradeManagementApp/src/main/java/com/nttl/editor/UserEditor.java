/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.editor;

/**
 *
 * @author Ly Nguyen
 */
import com.nttl.pojo.Semester;
import com.nttl.service.UserService;
import com.nttl.pojo.User;
import com.nttl.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.beans.PropertyEditorSupport;

@Component
public class UserEditor extends PropertyEditorSupport {

    @Autowired
    private UserService userService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text != null && !text.isEmpty()) {
            Integer userId = Integer.parseInt(text);
            User user = userService.getUserById(userId);
            setValue(user);
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
