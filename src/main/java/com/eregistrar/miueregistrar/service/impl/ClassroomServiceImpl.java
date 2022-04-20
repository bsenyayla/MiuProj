package com.eregistrar.miueregistrar.service.impl;


import com.eregistrar.miueregistrar.model.Classroom;
import com.eregistrar.miueregistrar.repository.ClassroomRepository;
import com.eregistrar.miueregistrar.service.ClassroomService;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private ClassroomRepository classroomRepository;

    ClassroomServiceImpl(ClassroomRepository classroomRepository){
        this.classroomRepository = classroomRepository;
    }

    @Override
    public Classroom addClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public Classroom getClassroomById(int id) {
        return classroomRepository.findById(id).orElse(null);
    }
}
