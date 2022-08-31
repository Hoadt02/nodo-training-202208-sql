package edu.hanoi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("message","Hello Jazz Clazz");
        return mv;
    }

    @GetMapping("/nguoi-dung")
    public ModelAndView forUser(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","This is protected page!");
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("dang-nhap")
    public String login(@RequestParam(value = "error", required = false) String error, Model model){
        if (error != null) model.addAttribute("error", error);
        return "login";
    }
}
