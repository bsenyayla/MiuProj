package com.eregistrar.miueregistrar.repository;

import com.eregistrar.miueregistrar.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Integer> {
}
