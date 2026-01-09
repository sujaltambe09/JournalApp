package com.spring.JournalApp.repository;

import com.spring.JournalApp.entity.journalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface journalEntryRepository extends MongoRepository<journalEntry, ObjectId> {

}
