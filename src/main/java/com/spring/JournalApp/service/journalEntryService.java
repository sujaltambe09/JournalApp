package com.spring.JournalApp.service;

import com.spring.JournalApp.entity.journalEntry;
import com.spring.JournalApp.repository.journalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class journalEntryService {

    @Autowired
    private journalEntryRepository journalEntryRepository;

    public void saveEntry(journalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

     public List<journalEntry> getAll(){
        return journalEntryRepository.findAll();
     }

     public Optional<journalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
     }

     public void deleteById(ObjectId id) {
        journalEntryRepository.deleteById(id);
     }
}
