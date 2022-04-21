package com.eregistrar.miueregistrar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the Course class which every student take during each block.
 */
@Getter
@Setter
@Entity
public class Course {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    private String code;
    private int capacity;

    protected Course() {}

    @OneToOne
    @JoinColumn(name = "block_id", referencedColumnName = "id")
    private Block block;

    @OneToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "id")
    private User faculty;

    /**
     * The User list.
     */
    @ManyToMany
    @JoinTable(name = "course_users",
            joinColumns = { @JoinColumn(name = "course_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    List<User> userList = new ArrayList<>();

    public Course(String name, String code, int capacity, Block block, User faculty) {
        this.name = name;
        this.code = code;
        this.capacity = capacity;
        this.block = block;
        this.faculty = faculty;
    }

    /**
     * Add user.
     *
     * @param user the user
     */
    public void addUser(User user){
        userList.add(user);
    }

}
