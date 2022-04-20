package com.eregistrar.miueregistrar.controller;

import com.eregistrar.miueregistrar.model.Course;
import com.eregistrar.miueregistrar.model.CourseOffering;
import com.eregistrar.miueregistrar.service.CourseOfferingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class CourseOfferingController {


    private CourseOfferingService srv;

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



}
