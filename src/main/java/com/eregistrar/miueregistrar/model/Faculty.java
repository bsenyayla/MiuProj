package com.eregistrar.miueregistrar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "faculty")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private Integer facultyId;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    private List<CourseOffering> courseOfferings;
    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL)
    private List<Student> advisees;
}
