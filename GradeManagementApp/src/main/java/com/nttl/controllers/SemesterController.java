/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttl.controllers;

import com.nttl.editor.SemesterEditor;
import com.nttl.editor.UserEditor;
import com.nttl.pojo.Course;
import com.nttl.pojo.Semester;
import com.nttl.pojo.User;
import com.nttl.service.CourseService;
import com.nttl.service.SemesterService;
import com.nttl.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Ly Nguyen
 */
@Controller
@Transactional
public class SemesterController {

    @Autowired
    private UserEditor userEditor;

    @Autowired
    private SemesterEditor semesterEditor;

    @Autowired
    private SemesterService semesterService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(User.class, userEditor);
        binder.registerCustomEditor(Semester.class, semesterEditor);
    }

    @GetMapping("/semester")
    public String semesterView(Model model) {
        List<Semester> semesters = this.semesterService.getSemester();
        model.addAttribute("semesters", semesters);
        model.addAttribute("semester", new Semester());
        return "semester";
    }

    @GetMapping("/semester/{id}")
    public String viewCoursesBySemester(@PathVariable("id") int id, Model model) {
        Semester semester = this.semesterService.getSemesterById(id);
        List<Course> courses = this.courseService.getCoursesBySemesterId(id);
        model.addAttribute("semester", semester);
        model.addAttribute("courses", courses);
        return "semesterCourse";
    }

//    @PostMapping("/semester/addCourse")
//    public String addCourse(@RequestParam("semesterId") int semesterId,
//            @ModelAttribute("course") @Valid Course course,
//            BindingResult rs, Model model) {
//        if (rs.hasErrors()) {
//            // Nếu có lỗi xảy ra, quay lại trang thêm khóa học và hiển thị lỗi
//            Semester semester = this.semesterService.getSemesterById(semesterId);
//            List<User> lecturers = this.userService.getLecturer();
//            model.addAttribute("semester", semester);
//            model.addAttribute("lecturers", lecturers);
//            return "addCourse";
//        }
//        try {
//            // Thiết lập thông tin học kỳ và lưu khóa học
//            Semester semester = this.semesterService.getSemesterById(semesterId);
//            course.setSemesterId(semester);
//            this.courseService.addOrUpdate(course);
//
//            // Chuyển hướng về trang chi tiết học kỳ sau khi thêm thành công
//            return "redirect:/semester/" + semesterId;
//        } catch (Exception ex) {
//            // Xử lý lỗi và thông báo lỗi cho người dùng
//            model.addAttribute("errMsg", ex.getMessage());
//            return "addCourse";
//        }
//    }
}
