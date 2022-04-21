package com.eregistrar.miueregistrar.controller;

import com.eregistrar.miueregistrar.exceptions.CourseRegisterException;
import com.eregistrar.miueregistrar.payload.response.MessageResponse;
import com.eregistrar.miueregistrar.payload.response.RegisteredCourse;
import com.eregistrar.miueregistrar.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * The type Student controller.
 */
@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentServiceImpl studentServiceImpl;

    /**
     * Instantiates a new Student controller.
     *
     * @param studentServiceImpl the student service
     */
    @Autowired
    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    /**
     * Register course.
     *
     * @param id the course id
     */
    @GetMapping(value = "/register/{id}")
    public void addCourse(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        try {
            studentServiceImpl.registerForCourse(3, id);
            response.sendRedirect("/registration.html");
        } catch (CourseRegisterException | IOException exc) {
            response.sendRedirect("/registration.html");
        }
    }

    @GetMapping(value = "/drop/{id}")
    public void dropCourse(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        try {
            studentServiceImpl.dropForCourse(3, id);
            response.sendRedirect("/schedule.html");
        } catch (CourseRegisterException exc) {
            response.sendRedirect("/schedule.html");
        }
    }

    @GetMapping(value = "/schedule")
    public ResponseEntity<List<RegisteredCourse>> getSchedule(@RequestParam Integer studentId) {
        try {
            List<RegisteredCourse> courses = studentServiceImpl.getCoursesByStudentId(studentId);
            return ResponseEntity.ok(courses);
        } catch (CourseRegisterException exc) {
            return ResponseEntity
                    .badRequest()
                    .body(null);
        }
    }
}
