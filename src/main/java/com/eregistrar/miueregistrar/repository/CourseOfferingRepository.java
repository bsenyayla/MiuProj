package com.eregistrar.miueregistrar.repository;

import com.eregistrar.miueregistrar.model.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseOfferingRepository extends JpaRepository<CourseOffering, Integer> {
}
