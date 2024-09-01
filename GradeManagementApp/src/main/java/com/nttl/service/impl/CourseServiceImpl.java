/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.service.impl;

import com.nttl.pojo.Course;
import com.nttl.pojo.Enrollment;
import com.nttl.repository.CourseRepository;
import com.nttl.repository.EnrollmentRepository;
import com.nttl.repository.ForumRepository;
import com.nttl.service.CourseService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ly Nguyen
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepo;
    
    @Autowired
    private EnrollmentRepository enrollRepo;
    
    @Autowired
    private ForumRepository forumRepo;

    @Override
    public List<Course> getCourses(Map<String, String> params) {
        return this.courseRepo.getCourses(params);
    }

    @Override
    public void addOrUpdate(Course c) {
        this.courseRepo.addOrUpdate(c);
    }

    @Override
    public Course getCourseById(int Id) {
        return this.courseRepo.getCourseById(Id);
    }

    @Override
    public List<Course> getCoursesBySemesterId(int id) {
        return this.courseRepo.getCoursesBySemesterId(id);
    }

    @Override
    public List<Course> getListCourse() {
        return this.courseRepo.getListCourse();
    }

    private boolean isCourseEnrolled(Integer courseId) {
        return enrollRepo.existsByCourseId(courseId);
    }

    private boolean isCourseInForum(Integer courseId) {
        return forumRepo.existsByCourseId(courseId);
    }

    @Override
    public boolean deleteCourse(int id) {
       
        if (isCourseEnrolled(id)) {
            return false;
        }

        if (isCourseInForum(id)) {
            return false; 
        }

        this.courseRepo.deleteCourse(id);
        return true;
    }

    @Override
    public List<Enrollment> getEnrollmentsByCourseId(int courseId) {
        return courseRepo.getEnrollmentsByCourseId(courseId);
    }

    @Override
    public List<Enrollment> getEnrollmentsByStudentId(int studentId) {
        return courseRepo.getEnrollmentsByStudentId(studentId);
    }
}
