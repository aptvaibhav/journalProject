package com.spring.myProject.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.myProject.entity.JournalEntry;
import com.spring.myProject.entity.User;
import com.spring.myProject.repository.JournalEntryRepository;
import com.spring.myProject.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public  void saveEntry(User userEntry){
        
        try{
            userRepository.save(userEntry);

        }
        catch(Exception e){
            log.error("Exception: ", e);
        }
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id) {
        userRepository.deleteById(id);
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
    
}
