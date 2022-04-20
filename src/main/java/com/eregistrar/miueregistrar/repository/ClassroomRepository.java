package com.eregistrar.miueregistrar.repository;

import com.eregistrar.miueregistrar.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {


}
