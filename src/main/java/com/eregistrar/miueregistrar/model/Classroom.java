package com.eregistrar.miueregistrar.model;

import javax.persistence.*;

@Entity
@Table(name="classrooms")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="classroom_id")
    private int classroomId;

    @Column(nullable = false)
    private String buildingName;

    @Column(nullable = false)
    private String roomNumber;

//    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
//    private List<Student> students = new ArrayList<>();

    public Classroom() {
    }

    public Classroom(String buildingName, String roomNumber) {
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
    }

    public Classroom(int classroomId, String buildingName, String roomNumber) {
        this.classroomId = classroomId;
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "buildingName='" + buildingName + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}
