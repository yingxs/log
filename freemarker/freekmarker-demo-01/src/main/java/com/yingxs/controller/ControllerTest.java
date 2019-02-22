package com.yingxs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerTest {

    @RequestMapping("/hello")
    public String hello(Model model){

        model.addAttribute("name","hello");
        System.out.println("hello");
        return "hello";
    }
    @RequestMapping("/hi")
    public String hi(Model model){

        model.addAttribute("name","hi");
        System.out.println("hi");
        return "hi";
    }

}
