package com.eregistrar.miueregistrar.service;


import com.eregistrar.miueregistrar.model.Classroom;

public interface ClassroomService {

    Classroom addClassroom(Classroom classroom);
    Classroom getClassroomById(int id);
}
