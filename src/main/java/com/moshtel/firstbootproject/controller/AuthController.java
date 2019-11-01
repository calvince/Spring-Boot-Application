package com.moshtel.firstbootproject.controller;

import com.moshtel.firstbootproject.entities.User;
import com.moshtel.firstbootproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "register",method = RequestMethod.POST)
    @ResponseBody
    public User registerUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
