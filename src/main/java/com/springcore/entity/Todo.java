package com.springcore.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "todos")
public class Todo {
    @Column(name = "id")
    @Id()
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "isDeleted")
    private boolean isDeleted = false;

    @Column(name = "createdAt")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt = LocalDateTime.now();

    public Todo(String title) {
        this.title = title;
    }

    public Todo() {super();}

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isDeleted=" + isDeleted +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
