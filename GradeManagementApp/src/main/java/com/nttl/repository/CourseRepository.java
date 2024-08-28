/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nttl.repository;

import com.nttl.pojo.Course;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ly Nguyen
 */
public interface CourseRepository {
    List<Course> getCourses(Map<String, String> params);
    void addOrUpdate(Course c);
    Course getCourseById(int Id);
    List<Course> getCoursesBySemesterId(int id);
    List<Course> getListCourse();
    //void deleteCourse(int id);
}
