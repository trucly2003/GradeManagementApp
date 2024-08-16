/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.controllers;


import com.nttl.service.CourseService;
import com.nttl.service.SemesterService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Ly Nguyen
 */
@Controller
public class HomeController {
    
    @Autowired
    private SemesterService semesterService;
    @Autowired
    private CourseService courseService;
    
    
    
    @RequestMapping("/")
    public String index(Model model) {
        
        model.addAttribute("semesters", this.semesterService.getSemester());
        model.addAttribute("courses", this.courseService.getCourses(null));
        
        return "home";
    }
}
