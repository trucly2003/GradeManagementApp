package com.nttl.controllers;

import com.nttl.pojo.Course;
import com.nttl.pojo.Enrollment;
import com.nttl.pojo.Score;
import com.nttl.service.CourseService;
import com.nttl.service.EnrollmentService;
import com.nttl.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public String listEnrollments(Model model) {
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        List<Course> courses = courseService.getListCourse();
        model.addAttribute("enrollments", enrollments);
        model.addAttribute("courses", courses);
        return "enrollment";
    }

    @GetMapping("/create")
    public String createEnrollmentForm(Model model) {
        model.addAttribute("enrollment", new Enrollment());
        return "enrollments/form";
    }

    @PostMapping("/save")
    public String saveEnrollment(@ModelAttribute Enrollment enrollment) {
        enrollmentService.addOrUpdate(enrollment);
        return "redirect:/enrollments";
    }

    @GetMapping("/edit/{id}")
    public String editEnrollmentForm(@PathVariable("id") int id, Model model) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        model.addAttribute("enrollment", enrollment);
        return "enrollments/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEnrollment(@PathVariable("id") int id) {
        enrollmentService.deleteEnrollment(id);
        return "redirect:/enrollments";
    }

    @GetMapping("/detail/{courseId}")
    public String getCourseDetails(@PathVariable("courseId") int courseId, Model model) {
        Course course = courseService.getCourseById(courseId);
        List<Enrollment> enrollments = courseService.getEnrollmentsByCourseId(courseId);
        model.addAttribute("course", course);
        model.addAttribute("enrollments", enrollments);
        return "coursesDetail"; // Đảm bảo tên view là "coursesDetail.jsp" hoặc tương ứng
    }

    @GetMapping("/{enrollmentId}/score")
    public String getScoresByEnrollmentId(@PathVariable("enrollmentId") int enrollmentId, Model model) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(enrollmentId);
        model.addAttribute("enrollment", enrollment); // Thêm thông tin học sinh vào mô hình
        List<Score> scores = scoreService.getScoresByEnrollmentId(enrollmentId);
        model.addAttribute("scores", scores);
        return "scoresDetail";
    }

}
