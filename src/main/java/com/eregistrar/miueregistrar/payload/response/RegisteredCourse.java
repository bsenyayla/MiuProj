package com.eregistrar.miueregistrar.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Registered course.
 */
@Data
@AllArgsConstructor
public class RegisteredCourse {
    private Integer id;
    private String blockName;
    private String courseCode;
    private String courseName;
    private String facultyName;
    private String startDate;
}
