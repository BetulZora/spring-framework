package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {

    // find All course by Category
    List<Course>  findByCategory(String category);

    // find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByNameDesc(String category);

    // check if a course with given name exits
    boolean existsByName(String name);

    // returns the count of courses for the provided category
    Integer countByCategory(String category);

    // find all courses that start with the provided course name
    List<Course> findByNameStartsWith(String prefix);

    // find all course that start with a category and returns a stream
    Stream<Course> streamByCategory(String category);


}
