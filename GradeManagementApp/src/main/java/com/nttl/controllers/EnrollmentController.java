///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.nttl.controllers;
//
///**
// *
// * @author Ly Nguyen
// */
//
//import com.nttl.pojo.Enrollment;
//import com.nttl.service.EnrollmentService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.web.bind.annotation.*;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//
//@Controller
//public class EnrollmentController {
//
//    @Autowired
//    private EnrollmentService enrollmentService;
//
//   @RequestMapping("/enrollmemt")
//    public String EnrollmentView(Model model) {
//        model.addAttribute("courses", this.enrollmentService.getAllEnrollments());
//        return "enrollment";
//    }
//
//    @GetMapping("/enrollment/{enrollmentId}")
//    public String detailsView(Model model, @PathVariable(value = "enrollmentId") int id) {
//        model.addAttribute("enrollment", this.enrollmentService.getEnrollmentById(id));
//        return "enrollment";
//    }
//    
//    
//   
//}
