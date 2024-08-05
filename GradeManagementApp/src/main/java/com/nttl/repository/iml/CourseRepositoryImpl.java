/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.repository.iml;

import com.nttl.pojo.Course;
import com.nttl.repository.CourseRepository;
import java.util.List;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ly Nguyen
 */
@Repository
@Transactional
public class CourseRepositoryImpl implements CourseRepository{

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Course> getCourse() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Course");
        return q.getResultList();
    }
}
