package com.eregistrar.miueregistrar.controller;

import com.eregistrar.miueregistrar.model.Student;
import com.eregistrar.miueregistrar.repository.UserRepository;
import com.eregistrar.miueregistrar.service.StudentService;
import com.eregistrar.miueregistrar.service.TranscriptService;
import com.eregistrar.miueregistrar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TranscriptController {
    @Autowired
    private  TranscriptService transcriptService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/transcipt/list"})
    public ModelAndView listStudents() {
        var modelAndView = new ModelAndView();
        var student = findStudentUser();
        var transcripts = student.getTranscript();
        modelAndView.addObject("student", student);
        modelAndView.addObject("transcripts", transcripts);
        modelAndView.addObject("transcriptCount", ((List)transcripts).size());
        modelAndView.setViewName("public/transcript");
        return modelAndView;

    }
    public Student findStudentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        var user = userService.getAllUsers().stream()
                .filter((a)-> a.getUsername().equals(username))
                .collect(Collectors.toList()).get(0);
        var students = studentService.getAllStudents();
        students.stream().filter((a)-> a.getUser().getUserId() == user.getUserId() )
                .collect(Collectors.toList());
        return students.get(0);
    }
}
