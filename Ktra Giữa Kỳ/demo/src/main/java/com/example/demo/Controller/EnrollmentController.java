package com.example.demo.Controller;

import com.example.demo.entity.Enrollment;
import com.example.demo.entity.Student;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;

@Controller
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/enroll/{courseId}")
    public String enroll(@PathVariable Long courseId,
                         Principal principal){

        Student student =
                studentRepository
                .findByUsername(principal.getName())
                .get();

        Enrollment e = new Enrollment();

        e.setStudentId(student.getId());
        e.setCourseId(courseId);
        e.setEnrollDate(new Date());

        enrollmentRepository.save(e);

        return "redirect:/my-courses";
    }

}
