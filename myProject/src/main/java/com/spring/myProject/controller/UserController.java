package com.spring.myProject.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.myProject.entity.JournalEntry;
import com.spring.myProject.entity.User;
import com.spring.myProject.service.JournalEntryService;
import com.spring.myProject.service.UserService;

import java.time.LocalDateTime;
import java.util.*;
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
       // try{
            userService.saveEntry(user);
        //     return new ResponseEntity<>(user,HttpStatus.CREATED);
        // }
        // catch (Exception e) {
        //     return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        // }
    }

    // @GetMapping("/id/{myId}")
    // public JournalEntry getJournalEntryById(@PathVariable ObjectId myId){
    //     return journalEntryService.findById(myId).orElse(null);
    // }

    // @DeleteMapping("/id/{myId}")
    // public boolean deleteJournalEntryById(@PathVariable ObjectId myId) {
    //     journalEntryService.deleteById(myId);
    //     return true;
    // }

    @PutMapping("/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String userName) {
        User userInDb = userService.findByUserName(userName);
        if (userInDb != null) {
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
