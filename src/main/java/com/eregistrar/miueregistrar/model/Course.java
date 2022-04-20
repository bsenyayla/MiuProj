package com.eregistrar.miueregistrar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id")
    private int courseId;
    @Column(nullable=false, unique=true)
    private String name;
    @Column(name="course_code")
    private String courseCode;
    @Column(name="number_of_units")
    private float numberOfUnits;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CourseOffering> courseOfferings;

   /* @ManyToMany(mappedBy="courses")
    private List<Student> students;*/

}
