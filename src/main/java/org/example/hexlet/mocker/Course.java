package org.example.hexlet.mocker;

import net.datafaker.Faker;
import org.example.hexlet.dto.course.CourseDto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Course {
    private static final int COURSE_COUNT = 30;

    public static List<CourseDto> getCourses() {
        Random random = new Random(123);
        Faker faker = new Faker(new Locale("en"), random);

        List<Long> ids = IntStream
                .range(1, COURSE_COUNT + 1)
                .mapToObj(id -> (long) id)
                .collect(Collectors.toList());
        Collections.shuffle(ids, random);

        List<CourseDto> courses = new ArrayList<>();

        for (int i = 0; i < COURSE_COUNT; i++) {
            var course = new CourseDto(
                    ids.get(i),
                    faker.programmingLanguage().name(),
                    faker.text().text(100));
            courses.add(course);
        }

        return courses;
    }

    public static CourseDto getRandomCourse() {
        Random random = new Random(123);
        var idx = random.nextInt(30);

        return getCourses().get(idx);
    }

    public static Optional<CourseDto> getCourseById(Long id) {
        return getCourses().stream()
                .filter(course -> course.getId().equals(id))
                .findFirst();
    }

}