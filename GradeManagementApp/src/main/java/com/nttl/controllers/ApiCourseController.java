/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.controllers;

import com.nttl.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ly Nguyen
 */
//@RestController
//@RequestMapping("/api")
//public class ApiCourseController {
//    @Autowired
//    private CourseService courseService;
//
//    @DeleteMapping("course/{courseId}")
//    public ResponseEntity<Void> destroy(@PathVariable(value = "courseId") int id) {
//        boolean isDeleted = this.courseService.deleteCourse(id);
//
//        if (isDeleted) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//}

