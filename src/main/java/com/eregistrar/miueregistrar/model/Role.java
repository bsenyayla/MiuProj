package com.eregistrar.miueregistrar.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * The type Role.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {
    @Id
    private String id;
    private ERole name;

    /**
     * Instantiates a new Role.
     *
     * @param name the name
     */
    public Role(ERole name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return name == role.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}