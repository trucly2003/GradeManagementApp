/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.repository.impl;

import com.nttl.pojo.Course;
import com.nttl.pojo.Semester;
import com.nttl.repository.SemesterRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ly Nguyen
 */
@Repository
@Transactional
public class SemesterRepositoryImpl implements SemesterRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    public List<Semester> getSemester() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Semester");
        return q.getResultList();
    }
    
    public Semester getSemesterById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Semester.class, id);
    }
}
