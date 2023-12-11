package com.cydeo.controller;

import com.cydeo.entity.ResponseWrapper;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses/api/v3")
public class CourseController_ResponseWrapper {

    // This is an example of how to modify the body of the response
    // Create a custom ResponseWrapper class and use that to interact.

    private final CourseService courseService;

    public CourseController_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCourses(){

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .header("Version","Cydeo.V3")
                .body(new ResponseWrapper("successfully retrieved",courseService.getCourses(), HttpStatus.FOUND));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper> getCourseById(@PathVariable("id") Long courseId){
        return ResponseEntity.ok(new ResponseWrapper("course:" + courseId + "retrieved",courseService.getCourseById(courseId), HttpStatus.FOUND));
    }
}
