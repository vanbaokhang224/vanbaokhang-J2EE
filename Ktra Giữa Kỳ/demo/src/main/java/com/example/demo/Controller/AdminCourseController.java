package com.example.demo.Controller;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/courses")
public class AdminCourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public String list(Model model){

        model.addAttribute("courses", courseRepository.findAll());

        return "admin-course-list";
    }

    @GetMapping("/create")
    public String createForm(Model model){

        model.addAttribute("course", new Course());

        return "course-form";
    }

    @PostMapping("/save")
    public String save(Course course){

        courseRepository.save(course);

        return "redirect:/admin/courses";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){

        model.addAttribute("course",
                courseRepository.findById(id).get());

        return "course-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){

        courseRepository.deleteById(id);

        return "redirect:/admin/courses";
    }

}
