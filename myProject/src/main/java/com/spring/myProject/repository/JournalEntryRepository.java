package com.spring.myProject.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.myProject.entity.JournalEntry;

public interface JournalEntryRepository extends MongoRepository<JournalEntry,ObjectId>{
    
}
