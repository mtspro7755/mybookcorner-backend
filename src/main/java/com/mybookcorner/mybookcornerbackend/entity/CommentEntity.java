package com.mybookcorner.mybookcornerbackend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    private LocalDateTime createdAt;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String googleBookId;



    public CommentEntity() {}

    public CommentEntity(String content, Long userId, String googleBookId) {
        this.content = content;
        this.userId = userId;
        this.googleBookId = googleBookId;
        this.createdAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getGoogleBookId() { return googleBookId; }
    public void setGoogleBookId(String googleBookId) { this.googleBookId = googleBookId; }
}