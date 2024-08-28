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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Controller xử lý các yêu cầu liên quan đến Khóa học (Course)
 */
@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private SemesterService semesterService;

    @Autowired
    private UserService userService;

    @RequestMapping("/course")
    public String courseView(Model model) {
        model.addAttribute("courses", this.courseService.getListCourse());
        return "course";
    }

    @GetMapping("/course/{courseId}")
    public String detailsView(Model model, @PathVariable(value = "courseId") int id) {
        model.addAttribute("course", this.courseService.getCourseById(id));
        return "addCourse";
    }

    @RequestMapping("/course/edit/{courseId}")
    public String editCourseForm(@PathVariable("courseId") Integer courseId, Model model) {
        Course course = courseService.getCourseById(courseId);
        if (course == null) {
            // Xử lý nếu không tìm thấy khóa học
            return "redirect:/course"; // hoặc trang lỗi
        }
        List<Semester> semesters = semesterService.getSemester();
        List<User> lecturers = userService.getLecturer();

        model.addAttribute("course", course);
        model.addAttribute("semesters", semesters);
        model.addAttribute("lecturers", lecturers);

        return "addCourse"; // Tên của JSP hoặc HTML cho trang chỉnh sửa
    }
    

    @RequestMapping("/course/add")
    public String addCourseForm(Model model) {
        model.addAttribute("course", new Course());

        // Lấy danh sách các học kỳ và giảng viên để chọn
        List<Semester> semesters = semesterService.getSemester();
        List<User> lecturers = userService.getLecturer();

        model.addAttribute("semesters", semesters);
        model.addAttribute("lecturers", lecturers);

        return "addCourse";
    }

    @PostMapping("/course/add")
    public String addCourse(@ModelAttribute("course") @Valid Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Semester> semesters = semesterService.getSemester();
            List<User> lecturers = userService.getLecturer();
            model.addAttribute("semesters", semesters);
            model.addAttribute("lecturers", lecturers);
            return "addCourse";
        }

        courseService.addOrUpdate(course);
        return "redirect:/course";  // Chuyển hướng tới trang danh sách khóa học sau khi thêm thành công
    }
    
//    @DeleteMapping("/delete/{courseId}")
//    public ResponseEntity<?> deleteCourse(@PathVariable("courseId") Integer courseId) {
//        boolean isDeleted = courseService.deleteCourse(courseId);
//        if (isDeleted) {
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Course cannot be deleted due to existing dependencies.");
//        }
    
}
