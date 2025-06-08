package com.deepanshu.MindTrack.controller;

import com.deepanshu.MindTrack.Service.UserService;
import com.deepanshu.MindTrack.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService usrService;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "Ok";
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody User usr) {
        usrService.saveNewUser(usr);
    }

}
