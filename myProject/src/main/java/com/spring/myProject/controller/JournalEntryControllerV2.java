// package com.spring.myProject.controller;

// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.spring.myProject.entity.JournalEntry;

// import java.util.*;
// @RestController
// @RequestMapping("/journal")
// public class JournalEntryControllerV2 {

//     private Map<Long,JournalEntry> journalEntries = new HashMap<>();

//     @GetMapping
//     public List<JournalEntry> getAll(){
//         return null;
//     }

//     @PostMapping
//     public boolean createEntry(@RequestBody JournalEntry myEntry){
//         return true;
//     }

//     @GetMapping("/id/{myId}")
//     public JournalEntry getJournalEntryById(@PathVariable Long myId){
//         return null;
//     }


//     @DeleteMapping("/id/{myId}")
//     public JournalEntry deleteJournalEntryById(@PathVariable Long myId){
//         return null;
//     }

//     @PutMapping("/id/{myId}")
//     public JournalEntry updateJournalEntryById(@PathVariable Long myId, @RequestBody JournalEntry myEntry){
//         return null;
//     }
// }
