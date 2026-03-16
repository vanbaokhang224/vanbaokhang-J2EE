package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

    @GetMapping("/courses")
    public String courses(){
        return "courses";
    }

    @GetMapping("/admin/courses")
    public String adminCourses(){
        return "admin_courses";
    }

}
