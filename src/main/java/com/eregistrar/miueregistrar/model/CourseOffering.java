package com.eregistrar.miueregistrar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courseofferings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_offering_id")
    private Integer courseOfferingId;
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "block_block_id")
    @Autowired
    private Block block;

    @ManyToOne
    @JoinColumn(name = "course_course_id")
    @Autowired
    private Course course;

    @ManyToOne
    @JoinColumn(name = "faculty_faculty_id")
    @Autowired
    private Faculty faculty;

    @ManyToMany(mappedBy = "courseOffering")
    private List<Student> students;
}
