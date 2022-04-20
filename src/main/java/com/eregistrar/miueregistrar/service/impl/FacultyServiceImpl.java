package com.eregistrar.miueregistrar.service.impl;

import com.eregistrar.miueregistrar.repository.FacultyRepository;
import com.eregistrar.miueregistrar.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;
}
