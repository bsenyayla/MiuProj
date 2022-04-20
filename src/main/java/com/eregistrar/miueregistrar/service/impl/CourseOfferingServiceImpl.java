package com.eregistrar.miueregistrar.service.impl;

import com.eregistrar.miueregistrar.model.CourseOffering;
import com.eregistrar.miueregistrar.repository.CourseOfferingRepository;
import com.eregistrar.miueregistrar.service.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseOfferingServiceImpl implements CourseOfferingService {
    @Autowired
    private CourseOfferingRepository courseOfferingRepository;

    @Override
    public CourseOffering saveCourseOffering(CourseOffering courseOffering) {
        return  courseOfferingRepository.save(courseOffering);
    }

    @Override
    public List<CourseOffering> getCourseOfferings() {
        return courseOfferingRepository.findAll();
    }

    @Override
    public CourseOffering getCourseOfferingById(int id) {
        return courseOfferingRepository.findById(id).orElse(null);
    }

    @Override
    public void removeCourseOffering(int id) {
        courseOfferingRepository.deleteById(id);
    }

}
