package com.eregistrar.miueregistrar.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Block is duration of studying the course.
 *
 */
@Data
@Entity
public class Block {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String startDate;
    private String endDate;
}
