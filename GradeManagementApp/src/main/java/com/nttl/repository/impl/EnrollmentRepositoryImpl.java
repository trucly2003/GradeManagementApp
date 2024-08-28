/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.repository.impl;



/**
 *
 * @author Ly Nguyen
 */

import com.nttl.pojo.Enrollment;
import com.nttl.repository.EnrollmentRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Repository
@Transactional
public class EnrollmentRepositoryImpl implements EnrollmentRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public boolean existsByCourseId(int courseId) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<Enrollment> root = query.from(Enrollment.class);
        query.select(cb.count(root)).where(cb.equal(root.get("courseId").get("courseId"), courseId));
        Long count = session.createQuery(query).getSingleResult();
        return count > 0;
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        Session session = this.factory.getObject().getCurrentSession();
        Query<Enrollment> query = session.createQuery("FROM Enrollment", Enrollment.class);
        return query.getResultList();
    }

    @Override
    public void addOrUpdate(Enrollment enrollment) {
        Session session = this.factory.getObject().getCurrentSession();
        if (enrollment.getEnrollmentId() != null) {
            session.update(enrollment);
        } else {
            session.save(enrollment);
        }
    }

    @Override
    public Enrollment getEnrollmentById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Enrollment.class, id);
    }

    @Override
    public void deleteEnrollment(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Enrollment enrollment = session.get(Enrollment.class, id);
        if (enrollment != null) {
            session.delete(enrollment);
        }
    }
}
