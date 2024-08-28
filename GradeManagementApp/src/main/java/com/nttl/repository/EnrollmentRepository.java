/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nttl.repository;

import com.nttl.pojo.Course;
import com.nttl.pojo.Enrollment;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author Ly Nguyen
 */
public interface EnrollmentRepository {
    boolean existsByCourseId(int courseId);
    List<Enrollment> getAllEnrollments();
    void addOrUpdate(Enrollment enrollment);
    Enrollment getEnrollmentById(int id);
    void deleteEnrollment(int id);
}
