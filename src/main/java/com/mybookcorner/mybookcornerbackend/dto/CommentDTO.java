package com.mybookcorner.mybookcornerbackend.dto;

import java.time.LocalDateTime;

public class CommentDTO {
    public Long id;
    public String content;
    public Long userId;
    public String googleBookId;
    public LocalDateTime createdAt;

    // Constructeur vide pour la désérialisation JSON
    public CommentDTO() {}

    // Constructeur pratique pour le mapping
    public CommentDTO(Long id, String content, Long userId, String googleBookId, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.googleBookId = googleBookId;
        this.createdAt = createdAt;
    }
}



