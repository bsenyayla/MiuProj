package com.eregistrar.miueregistrar.service.impl;

import com.eregistrar.miueregistrar.exceptions.CourseRegisterException;
import com.eregistrar.miueregistrar.model.Course;
import com.eregistrar.miueregistrar.model.ERole;
import com.eregistrar.miueregistrar.model.User;
import com.eregistrar.miueregistrar.payload.response.UserResponse;
import com.eregistrar.miueregistrar.repository.CourseRepository;
import com.eregistrar.miueregistrar.repository.UserRepository;
import com.eregistrar.miueregistrar.service.IFacultyService;
import com.eregistrar.miueregistrar.util.ScheduleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Faculty service.
 */
@Service
public class FacultyServiceImpl implements IFacultyService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    /**
     * Instantiates a new Student service.
     *
     * @param courseRepository the course repository
     * @param userRepository   the user repository
     */
    @Autowired
    public FacultyServiceImpl(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Course> getCoursesByFacultyId(Integer facultyId) throws CourseRegisterException {
        User faculty = userRepository.findUserById(facultyId);
        List<Course> allCourses = courseRepository.findAll();
        List<Course> courses = new ArrayList<>();
        if(ScheduleUtil.isFaculty(faculty) ) {
            for(Course course : allCourses) {
                if(course.getFaculty().getId().equals(facultyId)) {
                    courses.add(course);
                }
            }
        }
        return courses;
    }

    @Override
    public List<User> getFaculties() {
        List<User> users = userRepository.findAll();
        List<User> faculties = users.stream().filter(user -> user.getRoles().stream()
                .anyMatch(role -> role.getName().equals(ERole.ROLE_FACULTY))).toList();

        return faculties;
    }
}
