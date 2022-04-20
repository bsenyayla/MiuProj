package com.eregistrar.miueregistrar.service.impl;

import com.eregistrar.miueregistrar.model.Course;
import com.eregistrar.miueregistrar.repository.CourseRepository;
import com.eregistrar.miueregistrar.service.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
}
