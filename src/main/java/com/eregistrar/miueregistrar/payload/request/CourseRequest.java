package com.eregistrar.miueregistrar.payload.request;

import lombok.Data;

/**
 * The type Course request.
 */
@Data
public class CourseRequest {
    private String name;
    private String code;
    private int capacity;
    private Integer blockId;
    private Integer facultyId;
}
