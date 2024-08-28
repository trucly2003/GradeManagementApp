/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.service.impl;

/**
 *
 * @author Ly Nguyen
 */
import com.nttl.pojo.Enrollment;
import com.nttl.repository.EnrollmentRepository;
import com.nttl.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public boolean existsByCourseId(int courseId) {
        return enrollmentRepository.existsByCourseId(courseId);
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.getAllEnrollments();
    }

    @Override
    public void addOrUpdate(Enrollment enrollment) {
        enrollmentRepository.addOrUpdate(enrollment);
    }

    @Override
    public Enrollment getEnrollmentById(int id) {
        return enrollmentRepository.getEnrollmentById(id);
    }

//    @Override
//    public void deleteEnrollment(int id) {
//        enrollmentRepository.deleteEnrollment(id);
//    }
}