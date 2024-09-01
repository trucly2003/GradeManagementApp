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


    List<Score> getScoresByEnrollmentId(int enrollmentId);

    Score getScoreById(int id);

    void addOrUpdate(Score score);

    //void deleteScore(int id);
}
