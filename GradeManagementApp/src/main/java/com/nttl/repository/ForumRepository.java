/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nttl.repository;

import com.nttl.pojo.Forum;
import java.util.List;

/**
 *
 * @author Ly Nguyen
 */
public interface ForumRepository {

    boolean existsByCourseId(int courseId);

    List<Forum> getAllForums();

    Forum getForumById(int id);

    void addOrUpdate(Forum forum);

    void deleteForum(int id);
}
