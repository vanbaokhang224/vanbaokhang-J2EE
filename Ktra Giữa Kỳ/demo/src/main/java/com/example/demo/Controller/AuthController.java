package com.example.demo.Controller;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/register")
    public String registerForm(){
        return "register";
    }

    @PostMapping("/register")
    public String register(Student student){

        studentRepository.save(student);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
