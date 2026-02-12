package com.spring.JournalApp.repository;

import com.spring.JournalApp.entity.journalEntry;
import com.spring.JournalApp.entity.user;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface userRepository extends MongoRepository<user, ObjectId> {
    user findByUserName(String userName);
}
