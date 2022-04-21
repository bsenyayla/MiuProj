package com.eregistrar.miueregistrar.service;

import com.eregistrar.miueregistrar.exceptions.CourseRegisterException;
import com.eregistrar.miueregistrar.model.Course;
import com.eregistrar.miueregistrar.payload.response.UserResponse;

import java.util.List;

public interface IFacultyService {
    public List<Course> getCoursesByFacultyId(String facultyId) throws CourseRegisterException;
    public List<UserResponse> getFaculties();
}
