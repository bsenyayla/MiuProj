package com.eregistrar.miueregistrar.controller;

import com.eregistrar.miueregistrar.model.Course;
import com.eregistrar.miueregistrar.model.CourseOffering;
import com.eregistrar.miueregistrar.model.Student;
import com.eregistrar.miueregistrar.service.CourseOfferingService;
import com.eregistrar.miueregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class CourseOfferingController {


    private CourseOfferingService srv;

    @Autowired
    private StudentService srvStu;

    public CourseOfferingController(CourseOfferingService publisherService) {
        this.srv = publisherService;
    }

    @GetMapping(value = {"/courseoffering/mainpage","/elibrary/courseoffering/mainpage"})
    public ModelAndView aTT() {

        ModelAndView modelAndView = new ModelAndView();
        List<CourseOffering> dataList = srv.getCourseOfferings();

        modelAndView.addObject("data", dataList);
        modelAndView.addObject("count", dataList.size());
        modelAndView.setViewName("/courseoffering/mainpage");
        return modelAndView;
    }

    @GetMapping(value = {"/courseoffering/mainpage/addcourse/{id}"})
    public ModelAndView addcourse(@PathVariable Integer id) {
        /*
        var data = service.getById(id);
        if(data != null) {
            model.addAttribute("vehicle", data);
            return "public/vehicle/edit";
        }
        */

        CourseOffering dd=srv.getCourseOfferingById(1);


        Student student =srvStu.getStudentById(2);
        student.addCourseOffering(dd);
        srvStu.saveStudent(student);
        //srv.saveCourseOffering()

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/courseoffering/mainpage");
        return modelAndView;
    }



}
