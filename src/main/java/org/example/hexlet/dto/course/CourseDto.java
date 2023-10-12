package org.example.hexlet.dto.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public class CourseDto {
    private Long id;

    @ToString.Include
    private String name;
    private String description;

    public Map<String, Object> toMap() {
        Map<String, Object> course = new HashMap<>();
        course.put("id", id);
        course.put("name", name);
        course.put("description", description);

        return course;
    }
}
