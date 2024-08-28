/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.repository.impl;

/**
 *
 * @author Ly Nguyen
 */
import com.nttl.pojo.Forum;
import com.nttl.repository.ForumRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ForumRepositoryImpl implements ForumRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Forum> getAllForums() {
        Session session = this.factory.getObject().getCurrentSession();
        Query<Forum> query = session.createQuery("FROM Forum", Forum.class);
        return query.getResultList();
    }

    @Override
    public Forum getForumById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Forum.class, id);
    }

    @Override
    public void addOrUpdate(Forum forum) {
        Session session = this.factory.getObject().getCurrentSession();
        if (forum.getForumId() != null) {
            session.update(forum);
        } else {
            session.save(forum);
        }
    }

    @Override
    public void deleteForum(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Forum forum = session.get(Forum.class, id);
        if (forum != null) {
            session.delete(forum);
        }
    }

    

    @Override
    public boolean existsByCourseId(int courseId) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);

        Root<Forum> root = query.from(Forum.class);
        query.select(builder.count(root));
        query.where(builder.equal(root.get("courseId"), courseId));

        Query<Long> q = session.createQuery(query);
        return q.getSingleResult() > 0;
    }

}
