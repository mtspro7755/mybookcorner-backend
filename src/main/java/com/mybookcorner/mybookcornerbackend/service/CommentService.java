package com.mybookcorner.mybookcornerbackend.service;


import com.mybookcorner.mybookcornerbackend.dto.CommentDTO;
import com.mybookcorner.mybookcornerbackend.entity.CommentEntity;
import com.mybookcorner.mybookcornerbackend.repository.CommentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentDTO addComment(CommentDTO dto) {
        // Transformation DTO -> Entity
        CommentEntity entity = new CommentEntity(
                dto.content,
                dto.userId,
                dto.googleBookId
        );

        CommentEntity saved = commentRepository.save(entity);

        // Retourne le DTO avec l'ID généré
        dto.id = saved.getId();
        return dto;
    }

    public List<CommentDTO> getCommentsByBook(String googleBookId) {
        return commentRepository.findByGoogleBookId(googleBookId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private CommentDTO mapToDTO(CommentEntity entity) {
        CommentDTO dto = new CommentDTO();
        dto.id = entity.getId();
        dto.content = entity.getContent();
        dto.userId = entity.getUserId();
        dto.googleBookId = entity.getGoogleBookId();
        return dto;
    }
}
