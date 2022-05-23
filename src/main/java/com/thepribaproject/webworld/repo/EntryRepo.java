package com.thepribaproject.webworld.repo;

import com.thepribaproject.webworld.model.Entry;
import com.thepribaproject.webworld.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EntryRepo extends JpaRepository<Entry,Long> {
    List<Entry> findAllById(Long id);
}
