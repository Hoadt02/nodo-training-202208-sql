package edu.hanoi.controller;

import edu.hanoi.DAO.GroupDAO;
import edu.hanoi.DAO.UserDAO;
import edu.hanoi.model.Group;
import edu.hanoi.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tai-khoan")
public class UserController {
    private final static Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    GroupDAO groupDAO;

    @Autowired
    UserDAO userDAO;

    @GetMapping("/them")
    public ModelAndView addForm(){
        ModelAndView mv = new ModelAndView("user/form","command", new User());
        mv.addObject("groups", toGroupMap(groupDAO.list(null)));
        return mv;
    }

    private Map<Integer, String> toGroupMap(List<Group> groups){
        Map<Integer, String> map = new HashMap<>();
        groups.forEach(group -> map.put(group.getId(), group.getName()));
        return map;
    }

    @PostMapping("/luu")
    public ModelAndView addNew(@Valid @ModelAttribute("command") User user, BindingResult result){
        if (result.hasErrors()){
            ModelAndView mv = new ModelAndView("user/form","command", new User());
            mv.addObject("groups",toGroupMap(groupDAO.list(null)));
            return mv;
        }
        userDAO.insert(user);
        LOGGER.info("add new user ------> "+ user);
        return new ModelAndView("redirect:/tai-khoan/danh-sach");
    }

    @GetMapping("/danh-sach")
    public ModelAndView list(@RequestParam(value = "group", required = false) Integer group){
        ModelAndView mv = new ModelAndView("user/list");
        mv.addObject("users", userDAO.list(group));
        return mv;
    }

    @GetMapping("/chi-tiet/{username}")
    public ModelAndView list(@PathVariable("username") String username){
        ModelAndView mv = new ModelAndView("user/detail");
        mv.addObject("user", userDAO.get(username));
        return mv;
    }

    @GetMapping("/xoa/{name}")
    public String delete(@PathVariable("name") String name){
        userDAO.delete(name);
        return "redirect:/tai-khoan/danh-sach";
    }
}
