/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.service.impl;

/**
 *
 * @author Ly Nguyen
 */
import com.nttl.pojo.Forum;
import com.nttl.repository.ForumRepository;
import com.nttl.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumRepository forumRepository;

    @Override
    public List<Forum> getAllForums() {
        return forumRepository.getAllForums();
    }

    @Override
    public Forum getForumById(int id) {
        return forumRepository.getForumById(id);
    }

    @Override
    public void addOrUpdate(Forum forum) {
        forumRepository.addOrUpdate(forum);
    }

    @Override
    public void deleteForum(int id) {
        forumRepository.deleteForum(id);
    }


    @Override
    public boolean existsByCourseId(int courseId) {
        return forumRepository.existsByCourseId(courseId);
    }
}
