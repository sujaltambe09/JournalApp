package com.spring.JournalApp.service;

import com.spring.JournalApp.entity.journalEntry;
import com.spring.JournalApp.repository.journalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class journalEntryService {

    @Autowired
    private journalEntryRepository journalEntryRepository;

    public void saveEntry(journalEntry journalEntry) {
        try {
            journalEntry.setDate(LocalDateTime.now());
            journalEntryRepository.save(journalEntry);
        } catch (Exception e) {
            log.error("Exception", e);
        }
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
