package com.eregistrar.miueregistrar.service;

import com.eregistrar.miueregistrar.exceptions.CourseRegisterException;
import com.eregistrar.miueregistrar.model.Course;
import com.eregistrar.miueregistrar.payload.response.RegisteredCourse;

import java.util.List;

/**
 * The interface Student service.
 */
public interface IStudentService {
    /**
     * Add user.
     *
     * @param userID   the user id
     * @param courseID the course id
     * @throws CourseRegisterException exception
     */
    public void registerForCourse(String userID, String courseID) throws CourseRegisterException;

    /**
     * Gets courses by student id.
     *
     * @param studentId the student id
     * @return the courses by student id
     * @throws CourseRegisterException the course register exception
     */
    public List<RegisteredCourse> getCoursesByStudentId(String studentId) throws CourseRegisterException;
}
