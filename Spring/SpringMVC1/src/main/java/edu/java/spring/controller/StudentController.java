package edu.java.spring.controller;

import edu.java.spring.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(){
        return new ModelAndView("student/student_form","command", new Student());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute("command") Student student, BindingResult result){
        ModelAndView mv;
        if (result.hasErrors()){
            mv = new ModelAndView("student/student_form","command",student);
            mv.setViewName("student/student_form");
            mv.addObject("errors", result);
            return mv;
        }
        mv = new ModelAndView();
        mv.setViewName("student/student_view");
        mv.addObject("student", student);
        return mv;
    }
}
