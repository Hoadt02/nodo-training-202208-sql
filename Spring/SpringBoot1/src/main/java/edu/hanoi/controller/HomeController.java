package edu.hanoi.controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    private final static Logger logger = Logger.getLogger(HomeController.class);

    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView model = new ModelAndView("index");
        model.addObject("message","Hello Java Clazz");
        logger.info("Da truy cap vao day");
        return model;
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model){
        if (error != null) model.addAttribute("error","Sai tên hoặc mật khẩu!");
        return "login";
    }

    @GetMapping("/nguoi-dung")
    public String forUser(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("message","Hello User " + auth.getName());
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request,response, null);
        }
        return "redirect:/";
    }

    @GetMapping("/layout")
    public String layout(){
        return "layout";
    }
}
