/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nttl.service;

import com.nttl.pojo.Course;
import com.nttl.pojo.Enrollment;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ly Nguyen
 */
public interface CourseService {
    List<Course> getCourses(Map<String, String> params);
    void addOrUpdate(Course c);
    Course getCourseById(int Id);
    List<Course> getCoursesBySemesterId(int id);
    List<Course> getListCourse();
   boolean deleteCourse(int id);
   List<Enrollment> getEnrollmentsByCourseId(int courseId);
   List<Enrollment> getEnrollmentsByStudentId(int studentId);
}
