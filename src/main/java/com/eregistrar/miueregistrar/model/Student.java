package com.eregistrar.miueregistrar.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
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

    @NotNull(message = "Student Number must not be null")
    @Column(nullable = false)
    private String studentNumber;

    @Column(nullable = false)
    private String firstName;
    private String middleName;

    @Column(nullable = false)
    private String lastName;
    private double cgpa;

    private String dateOfEnrollment;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "transcript_fk",unique = true)
    private Transcript transcript;

    @ManyToOne()
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name="students_courses",
            joinColumns={@JoinColumn(name="student_id", referencedColumnName="student_id")},
            inverseJoinColumns={@JoinColumn(name="course_id", referencedColumnName="course_id")})
    private List<Course> courses;

    public List<CourseOffering> getCourseOffering() {
        return courseOffering;
    }

    public Student(Integer studentId, String studentNumber, String firstName, String middleName, String lastName, double cgpa, String dateOfEnrollment, Transcript transcript) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.transcript = transcript;
    }

    public Student(Integer studentId, String studentNumber, String firstName, String middleName, String lastName, double cgpa, String dateOfEnrollment) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Student(String studentNumber, String firstName, String middleName, String lastName, double cgpa, String dateOfEnrollment, Transcript transcript) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.transcript = transcript;
    }

    public Student(String studentNumber, String firstName, String middleName, String lastName, double cgpa, String dateOfEnrollment) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Student() {
    }

    public Student(String studentNumber, String firstName, String middleName, String lastName, double cgpa, String dateOfEnrollment, Transcript transcript, Classroom classroom) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.transcript = transcript;
        this.classroom = classroom;
    }


    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(String dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
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
                ", cgpa=" + cgpa +
                ", dateOfEnrollment=" + dateOfEnrollment +
                ", transcript=" + transcript +
                ", classroom=" + classroom +
                ", courses=" + courses +
                '}';
    }
}
