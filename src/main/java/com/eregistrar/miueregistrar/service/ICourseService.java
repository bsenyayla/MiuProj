package com.eregistrar.miueregistrar.service;

import com.eregistrar.miueregistrar.exceptions.CourseRegisterException;
import com.eregistrar.miueregistrar.model.Course;
import com.eregistrar.miueregistrar.payload.request.CourseRequest;
import com.eregistrar.miueregistrar.payload.response.CourseBlockResponse;

import java.util.List;

/**
 * The interface Course service.
 */
public interface ICourseService {
    /**
     * send course to repository.
     *
     * @param course the course
     * @throws CourseRegisterException the course register exception
     */
    void saveCourse(CourseRequest course) throws CourseRegisterException;

    /**
     * Gets all courses.
     *
     * @return the courses
     */
    List<Course> getCourses();

    /**
     * Gets courses group by block.
     *
     * @return the courses group by block
     */
    List<CourseBlockResponse> getCoursesGroupByBlock();

    /**
     * Gets course by ID.
     *
     * @param courseID the course id
     * @return the course by id
     */
    Course getCourseByID(String courseID);

    /**
     * Delete course by ID.
     *
     * @param courseID the course id
     */
    void deleteCourseByID(String courseID);

    /**
     * Update course.
     *
     * @param course the course
     */
    void updateCourse(Course course);

    //List<Course> getCoursesByFid(String Fid);

}

