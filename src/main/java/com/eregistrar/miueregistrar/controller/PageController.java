package com.eregistrar.miueregistrar.controller;

import com.eregistrar.miueregistrar.exceptions.CourseRegisterException;
import com.eregistrar.miueregistrar.model.Block;
import com.eregistrar.miueregistrar.model.Course;
import com.eregistrar.miueregistrar.payload.request.CourseRequest;
import com.eregistrar.miueregistrar.service.impl.BlockServiceImpl;
import com.eregistrar.miueregistrar.service.impl.CourseServiceImpl;
import com.eregistrar.miueregistrar.service.impl.FacultyServiceImpl;
import com.eregistrar.miueregistrar.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    private BlockServiceImpl blockServiceImpl;
    private FacultyServiceImpl facultyService;
    private CourseServiceImpl courseServiceImpl;
    private StudentServiceImpl studentService;
    @Autowired
    public PageController(BlockServiceImpl blockServiceImpl,
                          FacultyServiceImpl facultyService,
                          CourseServiceImpl courseServiceImpl,
                          StudentServiceImpl studentService) {
        this.blockServiceImpl = blockServiceImpl;
        this.facultyService = facultyService;
        this.courseServiceImpl = courseServiceImpl;
        this.studentService = studentService;
    }

    @GetMapping("index.html")
    public String index() {
        return "public/index";
    }

    @GetMapping("block.html")
    public String block(Model model) {
        model.addAttribute("blockForm", new Block());
        return "public/block";
    }

    @GetMapping("course.html")
    public String course(Model model) {
        model.addAttribute("courseForm", new CourseRequest());
        model.addAttribute("blocks", blockServiceImpl.getAllBlock());
        model.addAttribute("faculties", facultyService.getFaculties());
        blockServiceImpl.getAllBlock();
        return "public/course";
    }

    @GetMapping("registration.html")
    public String registration(Model model) {
        model.addAttribute("courses", courseServiceImpl.getCourses());
        return "public/registration";
    }

    @GetMapping("schedule.html")
    public String schedule(Model model) throws CourseRegisterException {
        model.addAttribute("courses",
                studentService.getCoursesByStudentId(3));
        return "public/schedule";
    }
}
