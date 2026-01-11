package com.spring.JournalApp.controller;

import com.spring.JournalApp.service.journalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.JournalApp.entity.journalEntry;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class journalEntryControllerV2 {


    @Autowired
    private journalEntryService journalEntryService;

    @GetMapping
    public List<journalEntry> getAll() {

        return journalEntryService.getAll();
    }

    @PostMapping
    public journalEntry createEntry(@RequestBody journalEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("/id/{myId}")
    public journalEntry getJournalEntryById(@PathVariable String myId) {
        ObjectId objectId = new ObjectId(myId);
        return journalEntryService.findById(objectId).orElse(null);
    }


    @DeleteMapping("/id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable String myId) {
        journalEntryService.deleteById(new ObjectId(myId));
        return true;
    }


    @PutMapping("/id/{id}")
    public journalEntry updateJournalEntry(
            @PathVariable String id,
            @RequestBody journalEntry newEntry) {

        ObjectId objectId = new ObjectId(id);
        journalEntry old = journalEntryService.findById(objectId).orElse(null);

        if (old != null) {
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().isBlank()
                    ? newEntry.getTitle()
                    : old.getTitle());

            old.setContent(newEntry.getContent() != null && !newEntry.getContent().isBlank()
                    ? newEntry.getContent()
                    : old.getContent());

            journalEntryService.saveEntry(old);
        }
        return old;
    }


}

