/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.controllers;

import com.nttl.pojo.Course;
import com.nttl.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Ly Nguyen
 */
@Controller
public class CourseController {
    
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String courseView(Model model) {
        model.addAttribute("courses", this.courseService.getListCourse());
        return "course";
    } 

}
