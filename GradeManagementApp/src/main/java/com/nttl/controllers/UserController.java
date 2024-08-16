/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nttl.pojo.User;
import com.nttl.service.UserService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Ly Nguyen
 */
@Controller
@RequestMapping("/user")
public class UserController {

      @Autowired
    private Cloudinary cloudinary;
    
    @Autowired
    private UserService userService;

    @GetMapping
    public String UserView(@RequestParam("role") String role, Model model) {
        List<User> users = null;

        if ("lecturer".equals(role)) {
            users = this.userService.getLecturer();
        } else if ("student".equals(role)) {
            users = this.userService.getStudent();
        }

        model.addAttribute("users", users);
        model.addAttribute("role", role);
        return "user";
    }

    @GetMapping("/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

  

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public String upload(@ModelAttribute("user") User user) {
        try {
            cloudinary.uploader().upload(user.getAvatar().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return "index";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addUser";
        }
        this.userService.addOrUpdate(user);
        return "redirect:/user?role=" + user.getUserRole();
    }
}
