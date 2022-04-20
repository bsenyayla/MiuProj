package com.eregistrar.miueregistrar.service;

import com.eregistrar.miueregistrar.model.CourseOffering;
import com.eregistrar.miueregistrar.model.Student;

import java.util.List;

public interface CourseOfferingService {
    public abstract CourseOffering saveCourseOffering(CourseOffering courseOffering);
    public abstract List<CourseOffering> getCourseOfferings();
    public abstract CourseOffering getCourseOfferingById(int id);
    public abstract void removeCourseOffering(int id);
    public abstract Student updateCourseOffering(int id, CourseOffering courseOffering);
}
