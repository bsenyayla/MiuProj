package com.eregistrar.miueregistrar.repository;

import com.eregistrar.miueregistrar.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 * The interface Course repository.
 */
public interface CourseRepository extends JpaRepository<Course, Integer> {
    /**
     * Find course by id course.
     *
     * @param courseID the course id
     * @return the course
     */
    Course findCourseById(Integer courseID);

    /**
     * Find course by name course.
     *
     * @param blockName the block name
     * @return the course
     */
    Course findCourseByName(String blockName);
}
