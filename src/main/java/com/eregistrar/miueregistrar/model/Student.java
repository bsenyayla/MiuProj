package com.eregistrar.miueregistrar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

   @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name="students_courseofferings",
            joinColumns = {@JoinColumn(name="student_id", referencedColumnName = "student_id")},
            inverseJoinColumns = {@JoinColumn(name="course_offering_id", referencedColumnName = "course_offering_id")}
    )
    private List<CourseOffering> courseOffering;

    @OneToOne
    @JoinColumn(name="student_transcript_ID")
    private Transcript transcript;

    @NotNull(message = "Student Number must not be null")
    @Column(nullable = false)
    private String studentNumber;

    @Column(nullable = false)
    private String firstName;
    private String middleName;

    @Column(nullable = false)
    private String lastName;

    private String dateOfEnrollment;

   /* @ManyToOne()
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;*/

    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name="students_courses",
            joinColumns={@JoinColumn(name="student_id", referencedColumnName="student_id")},
            inverseJoinColumns={@JoinColumn(name="course_id", referencedColumnName="course_id")})
    private List<Course> courses;

    public List<CourseOffering> getCourseOffering() {
        return courseOffering;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourses(List<Course> course) {
        if(this.courses == null){
            this.courses = new ArrayList<>();
        }
        this.courses.addAll(course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfEnrollment=" + dateOfEnrollment +
                ", transcript=" + transcript +
                ", courses=" + courses +
                '}';
    }
}
