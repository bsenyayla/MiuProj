package com.eregistrar.miueregistrar.service;

import com.eregistrar.miueregistrar.exceptions.CourseRegisterException;
import com.eregistrar.miueregistrar.model.Course;
import com.eregistrar.miueregistrar.model.User;

import java.util.List;

public interface IFacultyService {
    public List<Course> getCoursesByFacultyId(Integer facultyId) throws CourseRegisterException;
    public List<User> getFaculties();
}
