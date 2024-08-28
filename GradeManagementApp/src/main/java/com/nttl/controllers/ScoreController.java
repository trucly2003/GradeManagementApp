///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.nttl.controllers;
//
///**
// *
// * @author Ly Nguyen
// */
//
//import com.nttl.pojo.Score;
//import com.nttl.service.ScoreService;
//import com.nttl.service.EnrollmentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/score")
//public class ScoreController {
//
//    @Autowired
//    private ScoreService scoreService;
//
//    @Autowired
//    private EnrollmentService enrollmentService;
//
//    @GetMapping("/enrollment/{enrollmentId}")
//    public String getScoresByEnrollmentId(@PathVariable("enrollmentId") int enrollmentId, Model model) {
//        List<Score> scores = scoreService.getScoresByEnrollmentId(enrollmentId);
//        model.addAttribute("scores", scores);
//        model.addAttribute("enrollmentId", enrollmentId);
//        return "scoreList"; // Tên của JSP file
//    }
//    
////    @GetMapping("/details/{scoreId}")
////    public String getScoreDetails(@PathVariable("scoreId") int scoreId, Model model) {
////        Score score = scoreService.getScoreById(scoreId);
////        model.addAttribute("score", score);
////        return "score_details"; // Tên của JSP file
////    }
//}
//
