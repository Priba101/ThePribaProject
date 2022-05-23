package com.thepribaproject.webworld.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Entry implements Serializable {

    @Id
    @Column(nullable = false, updatable = false)
    private Long userId;
    private String entryName;

    public Entry() {
    }

    public Entry(Long userId, String entryName) {
        this.userId = userId;
        this.entryName = entryName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "userId=" + userId +
                ", entryName='" + entryName + '\'' +
                '}';
    }
}
