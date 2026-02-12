package com.spring.JournalApp.service;

import com.spring.JournalApp.entity.journalEntry;
import com.spring.JournalApp.entity.user;
import com.spring.JournalApp.repository.journalEntryRepository;
import com.spring.JournalApp.repository.userRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class userService {

    @Autowired
    private userRepository repository;

    public void saveEntry(user user) {
            repository.save(user);
    }

     public List<user> getAll(){
        return repository.findAll();
     }

     public Optional<user> findById(ObjectId id) {

        return repository.findById(id);
     }

     public void deleteById(ObjectId id) {
         repository.deleteById(id);
     }

     public user findByUserName(String userName) {
        return repository.findByUserName(userName);
     }
}
