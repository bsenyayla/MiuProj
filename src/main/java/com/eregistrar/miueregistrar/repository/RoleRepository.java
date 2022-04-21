package com.eregistrar.miueregistrar.repository;

import com.eregistrar.miueregistrar.model.ERole;
import com.eregistrar.miueregistrar.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Role repository.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    /**
     * Find by name optional.
     *
     * @param name the name
     * @return the optional
     */
    Optional<Role> findByName(ERole name);
}