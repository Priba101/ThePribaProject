package com.thepribaproject.webworld.service;

import com.thepribaproject.webworld.model.Entry;
import com.thepribaproject.webworld.repo.EntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntryService {
    private final EntryRepo entryRepo;

    @Autowired
    public EntryService(EntryRepo entryRepo) {
        this.entryRepo = entryRepo;
    }

    public Entry addEntry(Entry entry){
        return entryRepo.save(entry);
    }

    public List<String> getAllEntryNames(Entry entry){
        List<Entry> entries = entryRepo.findAllById(entry.getUserId());
        return entries.stream().map(it->it.getEntryName()).collect(Collectors.toList());
    }
}
