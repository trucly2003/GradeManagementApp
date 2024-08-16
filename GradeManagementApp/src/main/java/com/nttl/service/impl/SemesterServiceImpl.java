/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.service.impl;

import com.nttl.pojo.Semester;
import com.nttl.repository.SemesterRepository;
import com.nttl.service.SemesterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ly Nguyen
 */
@Service
@Transactional
public class SemesterServiceImpl implements SemesterService{

    @Autowired
    private SemesterRepository SemesterRepo;
    
    @Override
    public List<Semester> getSemester() {
        return this.SemesterRepo.getSemester();
    }
    
    @Override
    public Semester getSemesterById(int id) {
        return this.SemesterRepo.getSemesterById(id);
    }
    
}
