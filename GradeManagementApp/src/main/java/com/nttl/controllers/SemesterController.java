/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.controllers;

import com.nttl.pojo.Course;
import com.nttl.pojo.Semester;
import com.nttl.service.CourseService;
import com.nttl.service.SemesterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Ly Nguyen
 */
@Controller
public class SemesterController {

    @Autowired
    private SemesterService semesterService;
    
    @Autowired
    private CourseService courseService;

    @GetMapping("/semester")
    public String semesterView(Model model) {
        List<Semester> semesters = this.semesterService.getSemester();

        model.addAttribute("semesters", semesters);
        model.addAttribute("semester", new Semester());
        return "semester";
    }
   @GetMapping("/{id}")
    public String viewCoursesBySemester(@PathVariable("id") int id, Model model) {
        Semester semester = this.semesterService.getSemesterById(id);
        List<Course> courses = this.courseService.getCoursesBySemesterId(id);

        model.addAttribute("semester", semester);
        model.addAttribute("courses", courses);
        return "semesterCourses";
    }

}
