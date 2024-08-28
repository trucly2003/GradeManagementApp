/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.service.impl;

import com.nttl.pojo.Score;
import com.nttl.repository.ScoreRepository;
import com.nttl.service.ScoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ly Nguyen
 */
@Service
public class ScoreServiceImpl implements ScoreService{

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public boolean existsByEnrollmentId(int enrollmentId) {
        return scoreRepository.existsByEnrollmentId(enrollmentId);
    }

    @Override
    public List<Score> getAllScores() {
        return scoreRepository.getAllScores();
    }

    @Override
    public void addOrUpdate(Score score) {
        scoreRepository.addOrUpdate(score);
    }

    @Override
    public Score getScoreById(int id) {
        return scoreRepository.getScoreById(id);
    }

    @Override
    public void deleteScore(int id) {
        scoreRepository.deleteScore(id);
    }
}