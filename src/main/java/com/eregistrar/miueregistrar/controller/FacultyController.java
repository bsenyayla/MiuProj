package com.eregistrar.miueregistrar.controller;

import com.eregistrar.miueregistrar.exceptions.CourseRegisterException;
import com.eregistrar.miueregistrar.model.Course;
import com.eregistrar.miueregistrar.model.User;
import com.eregistrar.miueregistrar.payload.response.UserResponse;
import com.eregistrar.miueregistrar.service.impl.FacultyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Faculty controller.
 */
@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyServiceImpl facultyService;

    /**
     * Instantiates a new Faculty controller.
     *
     * @param facultyService the faculty service
     */
    @Autowired
    public FacultyController(FacultyServiceImpl facultyService) {
        this.facultyService = facultyService;
    }

    /**
     * Gets courses.
     *
     * @param facultyId the faculty id
     * @return the courses
     */
    @GetMapping(value = "courses")
    public ResponseEntity<List<Course>> getCourses(@RequestParam Integer facultyId) {
        try {
            List<Course> courses = facultyService.getCoursesByFacultyId(facultyId);
            return ResponseEntity.ok(courses);
        } catch (CourseRegisterException exc) {
            return ResponseEntity
                    .badRequest()
                    .body(null);
        }
    }

    /**
     * Gets faculties.
     *
     * @return the faculties
     */
    @GetMapping(value="")
    public ResponseEntity<List<User>> getFaculties() {
        List<User> faculties = facultyService.getFaculties();
        return ResponseEntity.ok(faculties);
    }
}
