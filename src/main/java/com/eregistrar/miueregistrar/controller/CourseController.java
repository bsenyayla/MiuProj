package com.eregistrar.miueregistrar.controller;

import com.eregistrar.miueregistrar.exceptions.CourseRegisterException;
import com.eregistrar.miueregistrar.model.Course;
import com.eregistrar.miueregistrar.payload.request.CourseRequest;
import com.eregistrar.miueregistrar.payload.response.CourseBlockResponse;
import com.eregistrar.miueregistrar.payload.response.MessageResponse;
import com.eregistrar.miueregistrar.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Course controller.
 */
@RestController
@RequestMapping("course")
public class CourseController {
    private final CourseServiceImpl courseServiceImpl;

    /**
     * Instantiates a new Course controller.
     *
     * @param courseService the course service
     */
    @Autowired
    public CourseController(CourseServiceImpl courseService){
        this.courseServiceImpl = courseService;
    }

    /**
     * Save course.
     *
     * @param course the course
     */
    @PostMapping(value = "")
    public ResponseEntity<MessageResponse> saveCourse(@RequestBody CourseRequest course) {
        try {
            courseServiceImpl.saveCourse(course);
            return ResponseEntity.ok(new MessageResponse("Course save operation successful."));
        } catch (CourseRegisterException exc) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(exc.getMessage()));
        }

    }

    /**
     * Get courses list.
     *
     * @return the list
     */
    @GetMapping(value = "")
    @ResponseBody
    public List<Course> getCourses(){
        return courseServiceImpl.getCourses();
    }

    @GetMapping(value = "blockCourse")
    @ResponseBody
    public List<CourseBlockResponse> getCoursesByBlock(){
        return courseServiceImpl.getCoursesGroupByBlock();
    }

    /**
     * Gets course by id.
     *
     * @param courseID the course id
     * @return the course by id
     */
    @GetMapping(value = "/{id}")
    @ResponseBody
    public Course getCourseByID(@PathVariable("id") String courseID){
        return courseServiceImpl.getCourseByID(courseID);
    }

    /**
     * Delete course by id.
     *
     * @param courseID the course id
     */
    @DeleteMapping(value = "/{id}")
    public void deleteCourseByID(@PathVariable("id") String courseID){
        courseServiceImpl.deleteCourseByID(courseID);
    }

    /**
     * Update course.
     *
     * @param course the course
     */
    @PutMapping(value = "")
    public void updateCourse(@RequestBody Course course){
        courseServiceImpl.updateCourse(course);
    }

}
