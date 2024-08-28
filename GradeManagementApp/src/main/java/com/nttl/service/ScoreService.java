/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nttl.service;

import com.nttl.pojo.Score;
import java.util.List;

/**
 *
 * @author Ly Nguyen
 */
public interface ScoreService {
    boolean existsByEnrollmentId(int enrollmentId);
    List<Score> getAllScores();
    void addOrUpdate(Score score);
    Score getScoreById(int id);
    void deleteScore(int id);
}
