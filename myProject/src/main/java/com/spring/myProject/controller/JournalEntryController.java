package com.spring.myProject.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.myProject.entity.JournalEntry;
import com.spring.myProject.service.JournalEntryService;

import java.time.LocalDateTime;
import java.util.*;
@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;


    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId){
        return journalEntryService.findById(myId).orElse(null);
    }

    @DeleteMapping("/id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId myId) {
        journalEntryService.deleteById(myId);
        return true;
    }

    @PutMapping("/id/{myId}")
    public JournalEntry updateJournalEntryById(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntry) {
      JournalEntry old = journalEntryService.findById(myId).orElse(null);
    if (old != null) {
        // Checking and updating the title
        if (newEntry.getTitle() != null && !newEntry.getTitle().isEmpty()) {
            old.setTitle(newEntry.getTitle());
        }
        
        // Checking and updating the content
        if (newEntry.getContent() != null && !newEntry.getContent().isEmpty()) {
            old.setContent(newEntry.getContent());
        }
        
        // Saving the updated entry
        journalEntryService.saveEntry(old);
    }
    return old;
    }
}
