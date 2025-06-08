package com.deepanshu.MindTrack.controller;


import com.deepanshu.MindTrack.Service.UserService;
import com.deepanshu.MindTrack.Service.WeatherService;
import com.deepanshu.MindTrack.api.response.WeatherResponse;
import com.deepanshu.MindTrack.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService usrService;

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public List<User> getAllUsers() {
        return usrService.getAll();
    }


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User usr) {
        Authentication authent = SecurityContextHolder.getContext().getAuthentication();
        String userName = authent.getName();
        User usrInDB = usrService.findByUserName(userName);
        usrInDB.setUserName(usr.getUserName());
        usrInDB.setPassword(usr.getPassword());
        usrService.saveNewUser(usrInDB);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById() {
        Authentication authent = SecurityContextHolder.getContext().getAuthentication();
        String usrName = authent.getName();
        usrService.deleteByUserName(usrName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/greet")
    public ResponseEntity<?> greeting() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("Chandigarh");
        String greeting = "";
        if(weatherResponse != null) {
            greeting = ", Weather feels like " + weatherResponse.getCurrent().getFeelsLike();
        }
        return new ResponseEntity<>("Hi " + auth.getName() + greeting , HttpStatus.OK);
    }



}
