/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nttl.repository;

import com.nttl.pojo.Score;
import java.util.List;

/**
 *
 * @author Ly Nguyen
 */
public interface ScoreRepository {
    boolean existsByEnrollmentId(int enrollmentId);
    List<Score> getAllScores();
    void addOrUpdate(Score score);
    Score getScoreById(int id);
    void deleteScore(int id);
     List<Score> getScoresByEnrollmentId(int enrollmentId);

   
  
}
