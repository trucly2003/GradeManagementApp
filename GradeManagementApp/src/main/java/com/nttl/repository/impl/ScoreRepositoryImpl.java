/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.repository.impl;

import com.nttl.pojo.Score;
import com.nttl.repository.ScoreRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class ScoreRepositoryImpl implements ScoreRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public boolean existsByEnrollmentId(int enrollmentId) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<Score> root = query.from(Score.class);
        query.select(cb.count(root)).where(cb.equal(root.get("enrollmentId").get("enrollmentId"), enrollmentId));
        Long count = session.createQuery(query).getSingleResult();
        return count > 0;
    }

    @Override
    public List<Score> getAllScores() {
        Session session = this.factory.getObject().getCurrentSession();
        Query<Score> query = session.createQuery("FROM Score", Score.class);
        return query.getResultList();
    }

    @Override
    public void addOrUpdate(Score score) {
        Session session = this.factory.getObject().getCurrentSession();
        if (score.getScoreId() != null) {
            session.update(score);
        } else {
            session.save(score);
        }
    }

    @Override
    public Score getScoreById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Score.class, id);
    }

    @Override
    public void deleteScore(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Score score = session.get(Score.class, id);
        if (score != null) {
            session.delete(score);
        }
    }

    @Override
    public List<Score> getScoresByEnrollmentId(int enrollmentId) {
        Session session = this.factory.getObject().getCurrentSession();
        Query query = session.createQuery("FROM Score WHERE enrollmentId.enrollmentId = :enrollmentId");
        query.setParameter("enrollmentId", enrollmentId);
        return query.getResultList();
    }
}
