package com.eregistrar.miueregistrar.service.impl;

import com.eregistrar.miueregistrar.exceptions.CourseRegisterException;
import com.eregistrar.miueregistrar.model.Course;
import com.eregistrar.miueregistrar.model.User;
import com.eregistrar.miueregistrar.payload.response.RegisteredCourse;
import com.eregistrar.miueregistrar.repository.CourseRepository;
import com.eregistrar.miueregistrar.repository.UserRepository;
import com.eregistrar.miueregistrar.service.IStudentService;
import com.eregistrar.miueregistrar.util.ScheduleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Student service.
 */
@Service
public class StudentServiceImpl implements IStudentService {
    private CourseRepository courseRepository;
    private UserRepository userRepository;

    /**
     * Instantiates a new Student service.
     *
     * @param courseRepository the course repository
     * @param userRepository   the user repository
     */
    @Autowired
    public StudentServiceImpl(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void registerForCourse(String userID, String courseID) throws CourseRegisterException {
        Course course = courseRepository.findCourseById(courseID);
        User user = userRepository.findUserById(userID);
        if(ScheduleUtil.isStudent(user) && ScheduleUtil.isCourseExist(course)) {
            if (course.getUserList() != null && course.getUserList().size() < course.getCapacity()) {
                courseRepository.deleteById(course.getId());
                course.addUser(user);
                courseRepository.save(course);
            } else {
                throw new CourseRegisterException("Course capacity is not enough.");
            }
        }
    }
    @Override
    public List<RegisteredCourse> getCoursesByStudentId(String studentId) throws CourseRegisterException {
        User student = userRepository.findUserById(studentId);
        List<Course> allCourses = courseRepository.findAll();
        List<RegisteredCourse> registeredCourses = new ArrayList<>();
        if(ScheduleUtil.isStudent(student) ) {
            for(Course course : allCourses) {
                if(ScheduleUtil.isCourseExist(course)
                        && course.getUserList().stream().anyMatch(userData -> userData.getId().equals(studentId))) {
                        registeredCourses.add( new RegisteredCourse(course.getBlock().getName(),
                                course.getCode(), course.getName(),
                                course.getFaculty().getUsername(),
                                course.getBlock().getStartDate()));

                }
            }
        }
        return registeredCourses;
    }
}
