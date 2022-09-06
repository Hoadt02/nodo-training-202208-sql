package edu.hanoi.service.springhnservice.controller;

import edu.hanoi.service.springhnservice.DAO.GroupDAO;
import edu.hanoi.service.springhnservice.DAO.UserDAO;
import edu.hanoi.service.springhnservice.DAO.impl.UserDAOImpl;
import edu.hanoi.service.springhnservice.model.Group;
import edu.hanoi.service.springhnservice.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserRestServiceController {

    private static final Logger LOGGER = Logger.getLogger(UserRestServiceController.class);
    @Autowired
    UserDAO userDAO;

    @Autowired
    GroupDAO groupDAO;

    @GetMapping("/list/users")
    @PreAuthorize("hasRole('USER')")
    @PostFilter("hasPermission(filterObject,'read')")
    public List<User> listUser(HttpServletRequest request){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LOGGER.info("\n--------------------------> " + auth.getAuthorities());
//        if (!request.isUserInRole("ROLE_ADMIN")) throw new RuntimeException("Access Denied!");
        return userDAO.list();
    }

    @GetMapping("/list/groups")
    public Group[] listGroups(){
        return groupDAO.list().toArray(new Group[0]);
    }

    @PostMapping("/add/user")
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@RequestBody User user){
        return userDAO.insert(user);
    }

    @GetMapping("/get/user/{name}")
    public User getUser(@PathVariable("name") String name){
        return userDAO.get(name);
    }

    @DeleteMapping("/delete/user/{name}")
    public void delUser(@PathVariable("name") String name){
        userDAO.delete(name);
    }

    @PutMapping("/update/user")
    public void updateUser(@RequestBody User user){
        userDAO.update(user);
    }
}
