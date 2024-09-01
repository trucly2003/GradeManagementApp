/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.repository.impl;

import com.nttl.pojo.Course;
import com.nttl.pojo.Enrollment;
import com.nttl.pojo.Semester;
import com.nttl.repository.CourseRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class CourseRepositoryImpl implements CourseRepository {

    @Autowired
    private static final int PAGE_SIZE = 4;

    @Autowired
    private LocalSessionFactoryBean factory;

    public List<Course> getCourses(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Course> q = b.createQuery(Course.class);
        Root root = q.from(Course.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            //tìm kiếm theo từ khóa theo tên
            String kw = params.get("q");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = b.like(root.get("name"), String.format("%%%s%%", kw));
                predicates.add(p1);
            }

            String semesterId = params.get("semesterId");
            if (semesterId != null && !semesterId.isEmpty()) {
                Predicate p2 = b.equal(root.get("semesterId"), Integer.parseInt(semesterId));
                predicates.add(p2);
            }

            //những đối tượng rời rạc nên sẽ parse 1 predicates
            q.where(predicates.toArray(Predicate[]::new));

        }

        Query query = s.createQuery(q);

        //phân trang
        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int start = (p - 1) * PAGE_SIZE;
                query.setFirstResult(start);
                query.setMaxResults(PAGE_SIZE);
            }
        }

        return query.getResultList();
    }

    @Override
    public List<Course> getListCourse() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Course");
        return q.getResultList();
    }

    @Override
    public void addOrUpdate(Course c) {
        Session s = this.factory.getObject().getCurrentSession();
        if (c.getCourseId() != null) {
            s.update(c);
        } else {
            s.save(c);
        }
    }

    @Override
    public Course getCourseById(int Id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Course.class, Id);
    }

    @Override
    public List<Course> getCoursesBySemesterId(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Course> q = b.createQuery(Course.class);
        Root root = q.from(Course.class);
        q.select(root).where(b.equal(root.get("semesterId").get("semesterId"), id));
        return s.createQuery(q).getResultList();

    }

    @Override
    public void deleteCourse(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Course c = this.getCourseById(id);
        s.delete(c);
    }

    @Override
    public List<Enrollment> getEnrollmentsByCourseId(int courseId) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Enrollment> query = builder.createQuery(Enrollment.class);
        Root<Enrollment> root = query.from(Enrollment.class);

        query.select(root).where(builder.equal(root.get("courseId").get("courseId"), courseId));

        return session.createQuery(query).getResultList();
    }

    @Override
    public List<Enrollment> getEnrollmentsByStudentId(int studentId) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Enrollment> query = builder.createQuery(Enrollment.class);
        Root<Enrollment> root = query.from(Enrollment.class);

        query.select(root).where(builder.equal(root.get("studentId").get("userId"), studentId));

        return session.createQuery(query).getResultList();
    }

}
