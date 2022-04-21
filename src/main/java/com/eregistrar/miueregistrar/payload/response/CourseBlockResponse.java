package com.eregistrar.miueregistrar.payload.response;

import com.eregistrar.miueregistrar.model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CourseBlockResponse {
    private String blockName;
    private List<Course> courses;
}
